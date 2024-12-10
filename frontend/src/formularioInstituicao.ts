interface Instituicao {
    nome: string;
    cnpj: string;
    cep: string;
    telefone: string;
    email: string;
    senha: string;
}

function enviarFormularioInstituicao(event: Event) {
    event.preventDefault();

    const instituicao: Instituicao = {
        nome: (document.querySelector("input[name='nome']") as HTMLInputElement).value,
        cnpj: (document.querySelector("input[name='cnpj']") as HTMLInputElement).value,
        cep: (document.querySelector("input[name='cep']") as HTMLInputElement).value,
        telefone: (document.querySelector("input[name='telefone']") as HTMLInputElement).value,
        email: (document.querySelector("input[name='email']") as HTMLInputElement).value,
        senha: (document.querySelector("input[name='senha']") as HTMLInputElement).value,
    };

    const confirmarSenha = (document.querySelector("input[placeholder='Confirme a senha']") as HTMLInputElement).value;
    if (instituicao.senha !== confirmarSenha) {
        alert("As senhas não coincidem.");
        return;
    }

    if (instituicao.senha.trim() !== instituicao.senha) {
        alert("Senha inválida");
        return;
    }

    fetch("http://localhost:8080/api/formulario/instituicao", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(instituicao),
    })
        .then((response) => {
            if (!response.ok) {
                return response.json().then(data => {
                    throw new Error(data.message);
                });
            }
            return response.json();
        })
        .then((data) => {
            alert("Usuário cadastrado com sucesso!");
            window.location.href = "../templates/login.html";
        })
        .catch((error) => {
            console.error("Erro:", error);
            alert("Erro ao cadastrar usuário: " + error.message);
        });
}

document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector(".login-form") as HTMLFormElement;
    form.addEventListener("submit", enviarFormularioInstituicao);
});