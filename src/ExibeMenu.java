public class ExibeMenu {

    public String menu () {

        StringBuilder menu = new StringBuilder();
        menu.append("----------+*+----------\n");
        menu.append("Seja bem-vindo ao Conversor de Moeda\n\n");
        menu.append("1 - Converter Dólar para Peso Argentino\n");
        menu.append("2 - Converter Peso Argentino para Dólar\n");
        menu.append("3 - Converter Dólar para Real Brasileiro\n");
        menu.append("4 - Converter Real Brasileiro para Dolar\n");
        menu.append("5 - Converter Dólar para Peso Colombiano\n");
        menu.append("6 - Converter Peso Colombiano para Dolar\n");
        menu.append("7 - Converter Dólar para Euro\n");
        menu.append("8 - Converter Euro para Dólar\n");
        menu.append("9 - Sair\n\n");
        menu.append("----------+*+----------\n");
        menu.append("Escolha uma opção: ");

        return menu.toString();
    }

}
