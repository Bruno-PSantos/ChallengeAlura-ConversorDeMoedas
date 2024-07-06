# Conversor De Moedas
Este projeto Java é um conversor de moeda simples que permite a conversão entre oito moedas diferentes:

- Dólar Americano (USD)
- Peso Argentino (ARS)
- Real Brasileiro (BRL)
- Peso Colombiano (COP)
- Euro (EUR)
## Para utilizar o conversor, siga os passos abaixo:

- Clone este repositório
- Instale o Java Development Kit (JDK)
- Abra o projeto em uma IDE Java
- Adicione sua API Key a variável API_KEY no arquivo ConsultaAPI.java
- Execute a classe Main
## Uso

O programa exibe um menu com as opções de conversão disponíveis. O usuário deve selecionar a opção desejada e em seguida informar o valor a ser convertido. O programa acessa uma API (https://www.exchangerate-api.com/) para obter a taxa de conversão em tempo real e exibe o valor convertido.
## Note

Para adicionar outras conversões ao programa, vá no arquivo ConsultaAPI.java e no construtor da classe adicione as conversões desejadas.
- No site da API (https://www.exchangerate-api.com/) encontrarás os símbolos das moedas.
- Lembre de mudar o menu no arquivo ExibeMenu
- Deixe a última opção do menu para ser a opção de saída do programa
