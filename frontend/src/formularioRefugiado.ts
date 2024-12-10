interface Refugiado {
    nomeCompleto: string;
    pais: string;
    motivoRefugio: string;
    dataNascimento: string;
    formacao: string;
    email: string;
}

function enviarFormularioRefugiado(event: Event) {
    event.preventDefault();

    const refugiado: Refugiado = {
        nomeCompleto: (document.querySelector("input[name='nomeCompleto']") as HTMLInputElement).value,
        pais: (document.querySelector("input[name='pais']") as HTMLInputElement).value,
        motivoRefugio: (document.querySelector("input[name='motivoRefugio']") as HTMLInputElement).value,
        dataNascimento: (document.querySelector("input[name='dataNascimento']") as HTMLInputElement).value,
        formacao: (document.querySelector("input[name='formacao']") as HTMLInputElement).value,
        email: (document.querySelector("input[name='email']") as HTMLInputElement).value,
    };

    fetch("http://localhost:8080/api/formulario/refugiado", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(refugiado),
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
            window.location.href = "../templates/sessaoRefugiados.html";
        })
        .catch((error) => {
            console.error("Erro:", error);
            alert("Erro ao cadastrar usuário: " + error.message);
        });
}

document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector(".login-form") as HTMLFormElement;
    form.addEventListener("submit", enviarFormularioRefugiado);
});