from flask import Flask, request, jsonify
from flask_mail import Mail, Message
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

app.config['MAIL_SERVER'] = 'smtp.gmail.com'
app.config['MAIL_PORT'] = 465
app.config['MAIL_USE_TLS'] = False
app.config['MAIL_USE_SSL'] = True
app.config['MAIL_USERNAME'] = 'sistemadeassistenciaarefugiado@gmail.com'
app.config['MAIL_PASSWORD'] = 'iebj cceq gwbt jhkj '

mail = Mail(app)

@app.route('/enviar_email', methods=['POST'])
def adicionar_voluntario():
    data = request.json
    nome = data.get('nomeCompleto')
    email = data.get('email')

    if not nome or not email:
        return jsonify({'message': 'Nome e email são obrigatórios!'}), 400

    try:
        msg = Message(
            'Parabéns, você foi selecionado para ser voluntário!',
            sender='sistemadeassistenciaarefugiado@gmail.com',
            recipients=[email]
        )

        msg.body = f"Olá {nome},\n\nVocê foi selecionado para ser um dos voluntários em nosso projeto. Estamos ansiosos para tê-lo em nossa equipe!\n\nAtenciosamente,\nThales de Paula"

        mail.send(msg)
        return jsonify({'message': f'E-mail enviado para {nome} com sucesso!'}), 200
    except Exception as e:
        return jsonify({'message': 'Erro ao enviar e-mail', 'error': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True, port=5050)
