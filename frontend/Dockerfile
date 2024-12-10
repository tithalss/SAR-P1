# Usando a imagem base do Node.js
FROM node:18-alpine AS build

# Definindo o diretório de trabalho
WORKDIR /frontend

# Copiar o arquivo de dependências para instalar
COPY package.json package-lock.json ./

# Instalar as dependências
RUN npm install

# Copiar os arquivos restantes do frontend
COPY . .

# Construir os arquivos para produção (gerar o dist)
RUN npm run build

# Usar o Nginx para servir o frontend
FROM nginx:alpine

# Copiar os arquivos gerados pelo build para o diretório do Nginx
COPY --from=build /frontend/public/dist /usr/share/nginx/html

# Expor a porta 80 para o Nginx
EXPOSE 80

# Iniciar o Nginx
CMD ["nginx", "-g", "daemon off;"]
