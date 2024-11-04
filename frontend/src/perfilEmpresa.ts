const body = document.querySelector("body") as HTMLBodyElement;
const modeToggle = body.querySelector(".mode-toggle") as HTMLElement;
const sidebar = body.querySelector("nav") as HTMLElement;
const sidebarToggle = body.querySelector(".sidebar-toggle") as HTMLElement;

let getMode: string | null = localStorage.getItem("mode");
if (getMode && getMode === "dark") {
    body.classList.toggle("dark");
}

let getStatus: string | null = localStorage.getItem("status");
if (getStatus && getStatus === "close") {
    sidebar.classList.toggle("close");
}

modeToggle.addEventListener("click", () => {
    body.classList.toggle("dark");
    if (body.classList.contains("dark")) {
        localStorage.setItem("mode", "dark");
    } else {
        localStorage.setItem("mode", "light");
    }
});

sidebarToggle.addEventListener("click", () => {
    sidebar.classList.toggle("close");
    if (sidebar.classList.contains("close")) {
        localStorage.setItem("status", "close");
    } else {
        localStorage.setItem("status", "open");
    }
});
