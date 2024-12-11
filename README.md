# SAR-P1 - Sistema de auxilio de Refugiados.

O SAR-P1 é um sistema desenvolvido para enfrentar um problema crescente em diversos estados e cidades: o aumento significativo de refugiados sem documentação necessária.
Nosso objetivo é oferecer suporte a essas pessoas, proporcionando ferramentas que possibilitem acesso a direitos básicos, como:

Documentação pessoal;
Matrícula de filhos em creches e escolas;
Oportunidades de emprego formal (carteira assinada);
E muitos outros recursos que são essenciais para promover inclusão e qualidade de vida.

# Tecnologias Utilizadas
O sistema SAR-P1 foi desenvolvido utilizando as seguintes tecnologias:

HTML e CSS: Para estrutura e estilização da interface do usuário.

Java: Para a lógica de negócio e implementação do backend.

Python Flask: Alternativa para a criação de APIs e aplicações web.

TypeScript: Para interatividade e funcionalidades do frontend.

PostgreSQL: Banco de dados para armazenamento e gerenciamento de informações.

Node.js: Para o gerenciamento do frontend.

Nginx: Para servir a aplicação frontend em produção.

Docker: Para containerização e portabilidade do sistema.

Webpack: Para empacotamento eficiente dos recursos do frontend.

Gradle: Para gerenciamento de dependências e construção do backend Java.

Supabase: Para funcionalidades como autenticação e bancos de dados em tempo real.


# Configuração do Backend
O backend é construído como um JAR e executado em um container utilizando Java e Spring Boot.

# Configurações do Gradle
As configurações abaixo estão presentes no arquivo build.gradle:

Plugins
plugins {
    id 'org.springframework.boot' version '3.1.0'
    id 'io.spring.dependency-management' version '1.1.0'
    id 'java'
    id 'application'
}

Configurações Gerais
group = 'org.example'
version = '1.0-SNAPSHOT'

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
# Dependências

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.postgresql:postgresql:42.7.2'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.springframework.security:spring-security-test'
}

# Dockerfile do Backend
 Usando uma imagem base com OpenJDK 17
FROM eclipse-temurin:21-jdk-alpine

 Definindo o diretório de trabalho
WORKDIR /app

Copiar o arquivo JAR do backend (depois de ter sido gerado pelo Gradle)
COPY build/libs/SAR-1.0-SNAPSHOT.jar app.jar

Expor a porta 8080 para o backend
EXPOSE 8080

 Definir o comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]

# Como Construir e Executar o Backend

1.Certifique-se de que o JAR do projeto foi gerado:
   ./gradlew build

2. Construa a imagem Docker do backend:
   docker build -t sar-backend .

3. Execute o container do backend:
   docker run -p 8080:8080 sar-backend

4. O backend estará acessível em:
   http://localhost:8080

# Configuração do Frontend
O frontend é construído com Node.js e servido utilizando o Nginx.

# Dockerfile do Frontend
#Usando a imagem base do Node.js
FROM node:18-alpine AS build

#Definindo o diretório de trabalho
WORKDIR /frontend

#Copiar o arquivo de dependências para instalar
COPY package.json package-lock.json ./

#Instalar as dependências
RUN npm install

#Copiar os arquivos restantes do frontend
COPY . .

#Construir os arquivos para produção (gerar o dist)
RUN npm run build

#Usar o Nginx para servir o frontend
FROM nginx:alpine

#Copiar os arquivos gerados pelo build para o diretório do Nginx
COPY --from=build /frontend/public/dist /usr/share/nginx/html

#Expor a porta 80 para o Nginx
EXPOSE 80

#Iniciar o Nginx
CMD ["nginx", "-g", "daemon off;"]

# Como Construir e Executar o Frontend

1. Certifique-se de que os arquivos package.json e package-lock.json estão no diretório correto.

2. Construa a imagem Docker do frontend:
   docker build -t sar-frontend .

3. Execute o container do frontend:
   docker run -p 80:80 sar-frontend

4. O frontend estará acessível em:
    http://localhost

# Pré-requisitos:
- Node.js instalado na máquina
- Banco de dados configurado

## Como Contribuir
1. Faça um fork do repositório.
2. Crie uma branch para suas alterações: `git checkout -b minha-nova-feature`.
3. Envie suas alterações: `git push origin minha-nova-feature`.
4. Abra um Pull Request.
