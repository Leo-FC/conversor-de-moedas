import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException, ConversaoInvalidaException {
        Scanner sc = new Scanner(System.in);
        String opcao;
        do {
            System.out.println("= Conversor de Moeda =");
            System.out.println("Escolha uma opcao.");
            System.out.println("1) Real Brasileiro para Dolar Americano.");
            System.out.println("2) Dolar Americano para Real Brasileiro.");
            System.out.println("3) Real Brasileiro para Euro.");
            System.out.println("4) Euro para Real Brasileiro.");
            System.out.println("5) Real Brasileiro para Peso Argentino.");
            System.out.println("6) Peso Argentino para Real Brasileiro.");
            System.out.println("7) Personalizado.");
            System.out.println("8) Sair.");

            opcao = sc.nextLine();

            // BRL -> USD
            if (opcao.equals("1")) {

                ExchangeApi requisicao = Requisicao.req("BRL");

                Moeda moeda = new Moeda(requisicao, "USD", Requisicao.valorInformado());
                System.out.println(moeda);
            }
            // USD -> BRL
            if (opcao.equals("2")) {

                ExchangeApi requisicao = Requisicao.req("USD");

                Moeda moeda = new Moeda(requisicao, "BRL", Requisicao.valorInformado());
                System.out.println(moeda);
            }

            // BRL -> EUR
            if (opcao.equals("3")) {

                ExchangeApi requisicao = Requisicao.req("BRL");

                Moeda moeda = new Moeda(requisicao, "EUR", Requisicao.valorInformado());
                System.out.println(moeda);
            }

            // EUR -> BRL
            if (opcao.equals("4")) {

                ExchangeApi requisicao = Requisicao.req("EUR");

                Moeda moeda = new Moeda(requisicao, "BRL", Requisicao.valorInformado());
                System.out.println(moeda);
            }

            // BRL -> ARS
            if (opcao.equals("5")) {

                ExchangeApi requisicao = Requisicao.req("BRL");

                Moeda moeda = new Moeda(requisicao, "ARS", Requisicao.valorInformado());
                System.out.println(moeda);
            }

            // ARS -> BRL
            if (opcao.equals("6")) {

                ExchangeApi requisicao = Requisicao.req("ARS");

                Moeda moeda = new Moeda(requisicao, "BRL", Requisicao.valorInformado());
                System.out.println(moeda);
            }

            if (opcao.equals("7")) {

                System.out.println("Informe uma moeda base valida (EX: BRL, JPY, CNY...):");
                String codBase = sc.nextLine();

                System.out.println("Informe para qual moeda deseja:");
                String codSolicitado = sc.nextLine();

                ExchangeApi requisicao = Requisicao.req(codBase);

                Moeda moeda = new Moeda(requisicao, codSolicitado, Requisicao.valorInformado());
                System.out.println(moeda);
            }
        } while(!opcao.equals("8"));
        System.out.println("Encerrado.");
    }
}
