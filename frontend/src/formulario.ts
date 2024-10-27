interface Voluntario {
    nomeCompleto: string;
    pais: string;
    documentacao: string;
    dataNascimento: string;
    telefone: string;
    escolaridade: string;
    formacao: string;
    email: string;
    senha: string;
}

function enviarFormulario(event: Event) {
    event.preventDefault();

    const voluntario: Voluntario = {
        nomeCompleto: (document.querySelector("input[name='nomeCompleto']") as HTMLInputElement).value,
        pais: (document.querySelector("input[name='pais']") as HTMLInputElement).value,
        documentacao: (document.querySelector("input[name='documentacao']") as HTMLInputElement).value,
        dataNascimento: (document.querySelector("input[name='dataNascimento']") as HTMLInputElement).value,
        telefone: (document.querySelector("input[name='telefone']") as HTMLInputElement).value,
        escolaridade: (document.querySelector("input[name='escolaridade']") as HTMLInputElement).value,
        formacao: (document.querySelector("input[name='formacao']") as HTMLInputElement).value,
        email: (document.querySelector("input[name='email']") as HTMLInputElement).value,
        senha: (document.querySelector("input[name='senha']") as HTMLInputElement).value,
    };

    const confirmarSenha = (document.querySelector("input[placeholder='Confirme a senha']") as HTMLInputElement).value;
    if (voluntario.senha !== confirmarSenha) {
        alert("As senhas não coincidem.");
        return;
    }

    fetch("http://localhost:8080/api/formulario", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(voluntario),
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
    form.addEventListener("submit", enviarFormulario);
});