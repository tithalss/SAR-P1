interface VoluntarioAssociado {
    nomeCompleto: string;
    cpf: string;
    dataNascimento: string;
    telefone: string;
    formacao: string;
    email: string;
}

function enviarFormularioVoluntarioAssociado(event: Event) {
    event.preventDefault();

    const voluntarioAssociado: VoluntarioAssociado = {
        nomeCompleto: (document.querySelector("input[name='nomeCompleto']") as HTMLInputElement).value,
        cpf: (document.querySelector("input[name='cpf']") as HTMLInputElement).value,
        dataNascimento: (document.querySelector("input[name='dataNascimento']") as HTMLInputElement).value,
        telefone: (document.querySelector("input[name='telefone']") as HTMLInputElement).value,
        formacao: (document.querySelector("input[name='formacao']") as HTMLInputElement).value,
        email: (document.querySelector("input[name='email']") as HTMLInputElement).value,
    };

    fetch("http://localhost:8080/api/formulario/voluntarioAssociado", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(voluntarioAssociado),
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
            window.location.href = "../templates/sessaoVoluntariosAssociados.html";
        })
        .catch((error) => {
            console.error("Erro ao cadastrar usuário:", error);
            alert("Erro ao cadastrar usuário. Tente novamente.");
        });

}

document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector(".login-form") as HTMLFormElement;
    form.addEventListener("submit", enviarFormularioVoluntario);
});