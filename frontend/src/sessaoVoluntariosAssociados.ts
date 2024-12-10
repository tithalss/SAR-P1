interface VoluntarioDTO {
    nomeCompleto: string;
    dataNascimento: string;
    telefone: string;
    formacao: string;
    email: string;
}

document.addEventListener('DOMContentLoaded', async () => {
    const endpoint = 'http://localhost:8080/api/voluntariosAssociados';

    try {
        const response = await fetch(endpoint);
        const data: VoluntarioDTO[] = await response.json();

        const namesContainer = document.querySelector('.data.nome');
        const nascimentoContainer = document.querySelector('.data.data-nascimento');
        const contatoContainer = document.querySelector('.data.contato');
        const formacaoContainer = document.querySelector('.data.formacao');
        const emailContainer = document.querySelector('.data.email');
        const actionContainer = document.querySelector('.data.action');

        if (namesContainer && nascimentoContainer && contatoContainer && formacaoContainer && emailContainer && actionContainer) {
            data.forEach((item: VoluntarioDTO) => {
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
                actionButton.textContent = 'Excluir';
                actionButton.addEventListener('click', () => {
                    alert(`${item.nomeCompleto} adicionado com sucesso!`);
                });
                actionContainer.appendChild(actionButton);
            });
        } else {
            console.error('Um ou mais elementos não foram encontrados no DOM.');
        }
    } catch (error) {
        console.error('Erro ao buscar dados do backend:', error);
    }
});
