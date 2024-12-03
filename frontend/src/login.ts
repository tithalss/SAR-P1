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
            localStorage.setItem('id', data.id);
            window.location.href = '../templates/homePerfil.html';
        } else {
            const errorData = await response.json();
            console.error('Falha no login:', errorData);
            window.alert('Login falhou: ' + errorData.message);
        }

    } catch (error) {
        console.error('Erro:', error);
    }
}

const loginForm = document.getElementById('loginForm') as HTMLFormElement;

loginForm.addEventListener('submit', async (event) => {
    event.preventDefault();

    const email = (document.getElementById('email') as HTMLInputElement).value.trim();
    const senha = (document.getElementById('senha') as HTMLInputElement).value.trim();

    if (!email || !senha) {
        alert('Por favor, preencha todos os campos!');
        return;
    }

    await login(email, senha);
});
