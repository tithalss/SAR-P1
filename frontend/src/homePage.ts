const loginLink = document.getElementById('loginLink') as HTMLAnchorElement;

if (loginLink) {
    loginLink.addEventListener('click', () => {
        localStorage.clear();

        window.location.href = '../templates/login.html';
    });
}
