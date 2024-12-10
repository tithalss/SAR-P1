# Usando a imagem base Python
FROM python:3.10-slim

# Definindo o diretório de trabalho dentro do contêiner
WORKDIR /microservice

# Copiar o arquivo de dependências (requirements.txt) para instalar as dependências
COPY requirements.txt .

# Instalar as dependências
RUN pip install --no-cache-dir -r requirements.txt

# Copiar o restante dos arquivos do microserviço
COPY . .

# Expor a porta em que o microserviço estará rodando
EXPOSE 5050

# Definir o comando para rodar o microserviço
CMD ["python", "email_service.py"]
