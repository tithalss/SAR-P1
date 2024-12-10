interface VoluntarioDTO {
    nomeCompleto: string;
    dataNascimento: string;
    telefone: string;
    formacao: string;
    email: string;
}

document.addEventListener('DOMContentLoaded', async () => {
    const endpoint = 'http://localhost:8080/api/voluntarios';
    const endpointCard1 = 'http://localhost:8080/api/countVoluntariosAssociados';
    const endpointCard2 = 'http://localhost:8080/api/countVoluntarios';

    try {
        const [responseCard1, responseCard2] = await Promise.all([
            fetch(endpointCard1),
            fetch(endpointCard2),
        ]);

        const dataCard1 = await responseCard1.json();
        const dataCard2 = await responseCard2.json();

        const cadastradosBox = document.querySelector('.box1 .number');
        const pendentesBox = document.querySelector('.box2 .number');
        const totalBox = document.querySelector('.box3 .number');

        if (cadastradosBox && pendentesBox && totalBox) {
            const cadastrados = dataCard1;
            const pendentes = dataCard2;
            cadastradosBox.textContent = cadastrados.toLocaleString();
            pendentesBox.textContent = pendentes.toLocaleString();
            totalBox.textContent = (cadastrados + pendentes).toLocaleString();
        }
    } catch (error) {
        console.error('Erro ao buscar dados dos cards:', error);
    }

    try {
        const response = await fetch(endpoint);
        const data: VoluntarioDTO[] = await response.json();

        const namesContainer = document.querySelector('.data.nome');
        const nascimentoContainer = document.querySelector('.data.data-nascimento');
        const contatoContainer = document.querySelector('.data.contato');
        const formacaoContainer = document.querySelector('.data.formacao');
        const emailContainer = document.querySelector('.data.email');
        const actionContainer = document.querySelector('.data.action');

        if (!namesContainer || !nascimentoContainer || !contatoContainer || !formacaoContainer || !emailContainer || !actionContainer) {
            console.error('Um ou mais elementos não foram encontrados no DOM.');
            return;
        }

        data.forEach((item: VoluntarioDTO) => {
            // Cria os elementos para exibir os dados
            const nameSpan = document.createElement('span');
            nameSpan.className = 'data-list';
            nameSpan.textContent = item.nomeCompleto;
            namesContainer.appendChild(nameSpan);

            const nascimentoSpan = document.createElement('span');
            nascimentoSpan.className = 'data-list';
            nascimentoSpan.textContent = item.dataNascimento;
            nascimentoContainer.appendChild(nascimentoSpan);

            const contatoSpan = document.createElement('span');
            contatoSpan.className = 'data-list';
            contatoSpan.textContent = item.telefone;
            contatoContainer.appendChild(contatoSpan);

            const formacaoSpan = document.createElement('span');
            formacaoSpan.className = 'data-list';
            formacaoSpan.textContent = item.formacao;
            formacaoContainer.appendChild(formacaoSpan);

            const emailSpan = document.createElement('span');
            emailSpan.className = 'data-list';
            emailSpan.textContent = item.email;
            emailContainer.appendChild(emailSpan);

            const actionButton = document.createElement('button');
            actionButton.className = 'action-button';
            actionButton.textContent = 'Associar';

            actionButton.addEventListener('click', async () => {
                try {
                    const associarResponse = await fetch(`http://localhost:8080/api/associar?email=${encodeURIComponent(item.email)}`, {
                        method: 'POST',
                    });

                    if (!associarResponse.ok) {
                        const errorData = await associarResponse.json();
                        alert(errorData.message || 'Erro ao associar voluntário.');
                        return;
                    }

                    const emailPayload = {
                        nomeCompleto: item.nomeCompleto,
                        email: item.email,
                    };

                    const emailResponse = await fetch('http://localhost:5050/enviar_email', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify(emailPayload),
                    });

                    if (!emailResponse.ok) {
                        const errorData = await emailResponse.json();
                        alert(errorData.message || 'Erro ao enviar e-mail.');
                        return;
                    }

                    alert(`Associação de ${item.nomeCompleto} realizada com sucesso! Email de notificação enviado.`);
                    window.location.reload();

                } catch (error) {
                    console.error('Erro ao processar a associação:', error);
                    alert('Ocorreu um erro inesperado. Tente novamente mais tarde.');
                }
            });

            actionContainer.appendChild(actionButton);
        });
    } catch (error) {
        console.error('Erro ao buscar dados dos voluntários:', error);
    }
});
