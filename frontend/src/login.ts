async function login(email: string, password: string) {
    try {
        const response = await fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        });

        if (response.ok) {
            const data = await response.json();
            console.log('Login successful:', data);
            // Redirecionar ou salvar o token de autenticação, se houver
        } else {
            const errorData = await response.json();
            console.error('Login failed:', errorData);
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

const loginForm = document.getElementById('loginForm') as HTMLFormElement;

loginForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const email = (document.getElementById('email') as HTMLInputElement).value;
    const senha = (document.getElementById('senha') as HTMLInputElement).value;

    login(email, senha);
});
