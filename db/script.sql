CREATE DATABASE sardb;

CREATE TABLE refugiado (
    id INTEGER PRIMARY KEY,
    nomeCompleto VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    motivoRefugio VARCHAR(255),
    id_instituicao INTEGER,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id)
);

CREATE TABLE instituicao (
    id INTEGER PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    numeroRegistro INTEGER NOT NULL
);
