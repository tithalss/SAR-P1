// login.ts

document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm') as HTMLFormElement;

    loginForm.addEventListener('submit', async (event) => {
        event.preventDefault(); // Previne o envio padrão do formulário

        const formData = new FormData(loginForm);
        const email = formData.get('email') as string;
        const senha = formData.get('senha') as string;

        try {
            const response = await fetch('http://localhost:8080/api/login', { // Ajuste a URL conforme necessário
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ email, senha }),
            });

            if (!response.ok) {
                throw new Error('Login falhou!'); // Aqui você pode querer tratar diferentes códigos de status
            }

            const data = await response.json();
            console.log('Login bem-sucedido:', data);
            // Redirecione ou faça algo após o login bem-sucedido
        } catch (error) {
            console.error('Erro ao fazer login:', error);
            // Aqui você pode mostrar uma mensagem de erro ao usuário
        }
    });
});
