CREATE DATABASE sar;

CREATE TABLE refugiado (
    id SERIAL PRIMARY KEY,
    nomeCompleto VARCHAR(100) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    motivoRefugio VARCHAR(255) NOT NULL,
    documentacao VARCHAR(255),
    dataNascimento DATE NOT NULL,
    formacao VARCHAR(255),
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    fotoPerfil BYTEA NOT NULL
);

CREATE TABLE instituicao (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    numeroRegistro INTEGER NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    nomeRepresentante VARCHAR(100) NOT NULL,
    cpfRepresentante VARCHAR(11) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE voluntario_empresa (
    id SERIAL PRIMARY KEY,
    nomeCompleto VARCHAR(100) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    documentacao VARCHAR(255) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(15),
    escolaridade VARCHAR(50) NOT NULL,
    formacao VARCHAR(255),
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    id_instituicao INTEGER,
    FOREIGN KEY (id_instituicao) REFERENCES instituicao(id)
);

CREATE TABLE voluntario (
    id SERIAL PRIMARY KEY,
    nomeCompleto VARCHAR(100) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    documentacao VARCHAR(255) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(15),
    escolaridade VARCHAR(50) NOT NULL,
    formacao VARCHAR(255),
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);
