const path = require('path');

module.exports = {
  mode: 'production',  
  entry: {
    login: ['./src/login.ts'],
    formulario: ['./src/formulario.ts'],
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