const path = require('path');

module.exports = {
  mode: 'production',  
  entry: {
    login: ['./src/login.ts'],
    formularioInstituicao: ['./src/formularioInstituicao.ts'],
    formularioVoluntario: ['./src/formularioVoluntario.ts'],
    formularioVoluntarioAssociado: ['./src/formularioVoluntarioAssociado.ts'],
    formularioRefugiado: ['./src/formularioRefugiado.ts'],
    perfilEmpresa: ['./src/perfilEmpresa.ts'],
    editarPerfil: ['./src/editarPerfil.ts'],
    homePage: ['./src/homePage.ts'],
    homePerfil: ['./src/homePage.ts'],
    sessaoRefugiados: ['./src/sessaoRefugiados.ts'],
    sessaoVoluntarios: ['./src/sessaoVoluntarios.ts'],
    sessaoVoluntariosAssociados: ['./src/sessaoVoluntariosAssociados.ts'],
  },
  module: {
    rules: [
      {
        test: /\.tsx?$/,
        use: 'ts-loader',
        exclude: /node_modules/,
      },
    ],
  },
  resolve: {
    extensions: ['.tsx', '.ts', '.js'],
  },
  output: {
    filename: '[name].js',
    path: path.resolve(__dirname, 'public', 'dist'),
  },
  devServer: {
    static: {
      directory: path.join(__dirname, 'public', 'dist'),
    },
    compress: true,
    port: 8080,
  },
};