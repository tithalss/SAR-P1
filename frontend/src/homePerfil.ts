async function carregarNomeEmpresa(): Promise<void> {
    try {
        const userId = localStorage.getItem('id');

        if (!userId) {
            console.error('ID de usuário não encontrado');
            alert('ID de usuário não encontrado');
            return;
        }

        const response = await fetch(`http://localhost:8080/api/empresa?id=${userId}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (response.ok) {
            const data = await response.json();
            const nomeEmpresa = data.nomeEmpresa;
            document.getElementById('nomeEmpresa')!.innerText = nomeEmpresa;
        } else {
            console.error('Falha ao carregar nome da empresa');
            alert('Erro ao carregar nome da empresa');
        }
    } catch (error) {
        console.error('Erro ao fazer requisição:', error);
    }
}

document.addEventListener("DOMContentLoaded", carregarNomeEmpresa);