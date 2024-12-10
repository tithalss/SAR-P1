interface RefugiadoDTO {
    nomeCompleto: string;
    pais: string;
    dataNascimento: string;
    formacao: string;
    email: string;
}

document.addEventListener('DOMContentLoaded', async () => {
    const endpoint = 'http://localhost:8080/api/refugiados';
    const endpointCard = 'http://localhost:8080/api/countRefugiados';

    try {
        const response = await fetch(endpointCard);
        const data = await response.json();

        const cadastradosBox = document.querySelector('.box1 .number');
        const pendentesBox = document.querySelector('.box2 .number');
        const totalBox = document.querySelector('.box3 .number');

        if (cadastradosBox && pendentesBox && totalBox) {
            const cadastrados = data;
            const pendentes = 144463; //https://app.powerbi.com/view?r=eyJrIjoiZTdmYzg5YmUtNGJhNS00OTI1LWFkNWYtMjZiMDcwMGY3OTI5IiwidCI6ImU1YzM3OTgxLTY2NjQtNDEzNC04YTBjLTY1NDNkMmFmODBiZSIsImMiOjh9

            cadastradosBox.textContent = cadastrados.toLocaleString();
            pendentesBox.textContent = pendentes.toLocaleString();


            const total = cadastrados + pendentes;
            totalBox.textContent = total.toLocaleString();
        }
    } catch (error) {
        console.error('Erro ao buscar dados:', error);
    }

    try {
        const response = await fetch(endpoint);
        const data = await response.json(); // Definindo o tipo de `data`

        const namesContainer = document.querySelector('.data.nome');
        const paisContainer = document.querySelector('.data.pais');
        const nascimentoContainer = document.querySelector('.data.data-nascimento');
        const formacaoContainer = document.querySelector('.data.formacao');
        const emailContainer = document.querySelector('.data.email');

        if (namesContainer && paisContainer && nascimentoContainer && formacaoContainer && emailContainer) {
            data.forEach((item: RefugiadoDTO) => {
                const nameSpan = document.createElement('span');
                nameSpan.className = 'data-list';
                nameSpan.textContent = item.nomeCompleto;
                namesContainer.appendChild(nameSpan);

                const paisSpan = document.createElement('span');
                paisSpan.className = 'data-list';
                paisSpan.textContent = item.pais;
                paisContainer.appendChild(paisSpan);

                const nascimentoSpan = document.createElement('span');
                nascimentoSpan.className = 'data-list';
                nascimentoSpan.textContent = item.dataNascimento;
                nascimentoContainer.appendChild(nascimentoSpan);

                const formacaoSpan = document.createElement('span');
                formacaoSpan.className = 'data-list';
                formacaoSpan.textContent = item.formacao;
                formacaoContainer.appendChild(formacaoSpan);

                const emailSpan = document.createElement('span');
                emailSpan.className = 'data-list';
                emailSpan.textContent = item.email;
                emailContainer.appendChild(emailSpan);
            });
        } else {
            console.error('Um ou mais elementos não foram encontrados no DOM.');
        }
    } catch (error) {
        console.error('Erro ao buscar dados do backend:', error);
    }
});
