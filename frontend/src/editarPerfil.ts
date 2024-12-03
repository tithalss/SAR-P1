interface InstituicaoDTO {
    nome: string;
    email: string;
    cnpj: string;
    cep: string;
    senha: string;
    novaSenha?: string;
}

function carregarDadosPerfil(): void {
    const userId = 2; // Substitua pelo ID dinâmico do usuário
    const apiUrl = `http://localhost:8080/api/editarPerfil?id=${userId}`;

    fetch(apiUrl, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then((response) => {
            if (!response.ok) {
                return response.json().then(data => {
                    throw new Error(data.message);
                });
            }
            return response.json();
        })
        .then((data: InstituicaoDTO) => {
            preencherFormulario(data);
        })
        .catch((error: Error) => {
            console.error("Erro ao carregar os dados do perfil: ", error);
            alert("Erro ao carregar os dados do perfil: " + error.message);
        });
}

function preencherFormulario(data: InstituicaoDTO): void {
    const nameInput = document.getElementById("name") as HTMLInputElement;
    const emailInput = document.getElementById("email") as HTMLInputElement;
    const cnpjInput = document.getElementById("cnpj") as HTMLInputElement;
    const cepInput = document.getElementById("cep") as HTMLInputElement;

    if (nameInput) nameInput.value = data.nome || "";
    if (emailInput) emailInput.value = data.email || "";
    if (cnpjInput) cnpjInput.value = data.cnpj || "";
    if (cepInput) cepInput.value = data.cep || "";
}

document.getElementById("salvarAlteracoes")?.addEventListener("click", function (event) {
    event.preventDefault();

    const nome = (document.getElementById("name") as HTMLInputElement).value;
    const email = (document.getElementById("email") as HTMLInputElement).value;
    const cnpj = (document.getElementById("cnpj") as HTMLInputElement).value;
    const cep = (document.getElementById("cep") as HTMLInputElement).value;
    const senha = (document.getElementById("password") as HTMLInputElement).value;
    const novaSenha = (document.getElementById("new-password") as HTMLInputElement).value;
    const confirmarSenha = (document.getElementById("confirm-password") as HTMLInputElement).value;

    if (!senha || senha .trim() === "") {
        alert("A senha antiga é obrigatória para atualizar qualquer informação.");
        return;
    }

    if (novaSenha && novaSenha !== confirmarSenha) {
        alert("As senhas não coincidem!");
        return;
    }

    const dadosPerfil: InstituicaoDTO = {
        nome: nome,
        email: email,
        cnpj: cnpj,
        cep: cep,
        senha: senha,
        novaSenha: novaSenha || undefined,
    };

    const usuarioId = 2;

    atualizarPerfil(usuarioId, dadosPerfil);
});

function atualizarPerfil(id: number, dadosPerfil: InstituicaoDTO): void {
    fetch(`http://localhost:8080/api/editarPerfil?id=${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(dadosPerfil),
    })
        .then((response) => {
            if (!response.ok) {
                return response.json().then(data => {
                    throw new Error(data.message);
                });
            }
            return response.json();
        })
        .then(() => {
            alert("Perfil atualizado com sucesso!");
            location.reload();
        })
        .catch((error: Error) => {
            console.error("Erro ao atualizar o perfil: ", error);
            alert("Erro ao atualizar os dados do perfil: " + error.message);
        });
}

document.addEventListener("DOMContentLoaded", carregarDadosPerfil);
