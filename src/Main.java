import entity.Venda;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader leitor = new FileReader(); //lê o arquivo GameStart e "cria" uma cópia/instancia
        List<Venda> vendas = leitor.leArquivoERetornaAListaDeVendas(); //acessa a instancia e executa a função.
        System.out.println("Bem vindo a Game Start! ");
        login(vendas); //já recebe o parametro para ler o arquivo uma vez só.

    }

    public static void login(List<Venda> listaDeVendas){
        Scanner input = new Scanner(System.in);
        int option = 0;

        do{
            System.out.println("Você é Admin (1) ou Cliente (2)? ");
            option = input.nextInt();
            switch (option){
                case 1:
                    Admin userAdmin = new Admin(listaDeVendas);
                    userAdmin.validaLogin();
                    userAdmin.menuAdmin();
                    break;
                case 2:
                    Client userClient = new Client(listaDeVendas);
                    userClient.menuCliente();
                    break;
                default:
                    System.out.println("Opção Inválida.");
            }
        } while (option != 1 && option != 2);
    }
}