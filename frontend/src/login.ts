async function login(email: string, senha: string) {
    try {
        const response = await fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, senha }),
        });

        if (response.ok) {
            const data = await response.json();
            console.log('Login bem-sucedido:', data);
            // Redirecionar para a página que exibe os dados do voluntário
            window.location.href = '../templates/posauth.html'; // Verifique o caminho correto
        } else {
            const errorData = await response.json();
            console.error('Falha no login:', errorData);
            // Exibir alerta com a mensagem de erro
            window.alert('Login falhou: ' + errorData);
        }
    } catch (error) {
        console.error('Erro:', error);
    }
}

const loginForm = document.getElementById('loginForm') as HTMLFormElement;

loginForm.addEventListener('submit', (event) => {
    event.preventDefault();
    console.log('Formulário enviado');

    const email = (document.getElementById('email') as HTMLInputElement).value;
    const senha = (document.getElementById('senha') as HTMLInputElement).value;

    console.log('Email:', email);
    console.log('Senha:', senha);

    login(email, senha);
});
