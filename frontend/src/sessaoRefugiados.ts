interface RefugiadoDTO {
    nomeCompleto: string;
    pais: string;
    dataNascimento: string;
    formacao: string;
    email: string;
}

document.addEventListener('DOMContentLoaded', async () => {
    const endpoint = 'http://localhost:8080/api/refugiados';

    try {
        // Fetch dos dados
        const response = await fetch(endpoint);
        const data = await response.json(); // Definindo o tipo de `data`

        // Seleção dos contêineres
        const namesContainer = document.querySelector('.data.nome');
        const paisContainer = document.querySelector('.data.pais');
        const nascimentoContainer = document.querySelector('.data.data-nascimento');
        const formacaoContainer = document.querySelector('.data.formacao');
        const emailContainer = document.querySelector('.data.email');

        // Verificar se os elementos existem
        if (namesContainer && paisContainer && nascimentoContainer && formacaoContainer && emailContainer) {
            // Preenchendo os dados
            data.forEach((item: RefugiadoDTO) => {  // A chave 'item' já é implicitamente do tipo `RefugiadoDTO`
                // Criar e adicionar os spans para o nome
                const nameSpan = document.createElement('span');
                nameSpan.className = 'data-list';
                nameSpan.textContent = item.nomeCompleto;
                namesContainer.appendChild(nameSpan);

                // Criar e adicionar os spans para o país
                const paisSpan = document.createElement('span');
                paisSpan.className = 'data-list';
                paisSpan.textContent = item.pais;
                paisContainer.appendChild(paisSpan);

                // Criar e adicionar os spans para a data de nascimento
                const nascimentoSpan = document.createElement('span');
                nascimentoSpan.className = 'data-list';
                nascimentoSpan.textContent = item.dataNascimento;
                nascimentoContainer.appendChild(nascimentoSpan);

                // Criar e adicionar os spans para a formação
                const formacaoSpan = document.createElement('span');
                formacaoSpan.className = 'data-list';
                formacaoSpan.textContent = item.formacao;
                formacaoContainer.appendChild(formacaoSpan);

                // Criar e adicionar os spans para o email
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
