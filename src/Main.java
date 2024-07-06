import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double value;
        int conversao = 0;
        ConsultaAPI consultaAPI = new ConsultaAPI();
        ExibeMenu menu = new ExibeMenu();

        List<Integer> escolhasValidas = consultaAPI.getEscolhaMoedas();
        int paradaLoop = consultaAPI.getEscolhaMoedas().size() + 1;
        System.out.println(paradaLoop);

        while (true) {
            System.out.println(menu.menu());

            conversao = input.nextInt();
            input.nextLine();

            if (!escolhasValidas.contains(conversao) && conversao != paradaLoop) {
                while (!escolhasValidas.contains(conversao) && conversao != paradaLoop) {
                    System.out.println("Opção inválida!\nEscolha um opção válida: ");
                    conversao = input.nextInt();
                    input.nextLine();
                }
            }

            if (conversao == paradaLoop) {
                break;
            }

            System.out.println("Digite o valor que deseja converter: ");
            value = Double.parseDouble(input.nextLine());

            consultaAPI.conversao(conversao, value);
        }

    }
}