import entity.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Admin {

    private final String ADMIN_PASSWORD = "1234";
    private final List<Venda> listaDeVendas = new ArrayList<>();

    //constructor. Tem que ser sempre igual ao nome da classe.
    public Admin(List<Venda> listaDeVendas) {
        this.listaDeVendas.addAll(listaDeVendas);
    }

    public void menuAdmin(){
        Scanner input = new Scanner(System.in);
        int option = 0;

        while (!isValidOption(option)){ //enquanto a opção é inválida (false), executar o loop e tudo o que tem dentro do while.
            System.out.println("MENU ADMIN ");
            System.out.println("1.Imprima o conteúdo na consola.");
            System.out.println("2.Imprima vendas executadas e o valor total.");
            System.out.println("3.Lucro total.");
            System.out.println("4.Informaçoes dos clientes");
            System.out.println("5.Maiores vendas");
            option = input.nextInt();

            switch (option){
                case 1:
                    printarConteudo();
                    break;
                case 2:
                    printarVendasExecutadas();
                    break;
                case 3:
                    printarLucroTotal();
                    break;
                case 4:
                    printarInfosClientes();
                    break;
                case 5:
                    printarMaiorVenda();
                    break;
                default:
                    System.out.println("Opção inválida");

            }
        }
    }


    //funcao de validação de login do menu admin.
    public void validaLogin(){
        Scanner input = new Scanner(System.in);
        String pass;

        do{
            System.out.println("Insira a password: ");
            pass = input.next();
            if(!pass.equals(ADMIN_PASSWORD)){
                System.out.println("Password Inválida");
            }
        } while (!pass.equals(ADMIN_PASSWORD));
    }

    //função de validação de opção do menu admin
    private boolean isValidOption(int option){
       if(option >= 1 && option <= 5){
           return true;
       }
       return false;
    }

    //função p imprimir conteudo na consola.
    public void printarConteudo(){
        System.out.println("##########################################");
        System.out.println(listaDeVendas);
        System.out.println("##########################################");
    }

    public void printarVendasExecutadas(){
        double valorTotal = listaDeVendas.stream().mapToDouble(venda -> venda.getValor()).sum();
        System.out.println("##########################################");
        System.out.println("Número total de vendas: " + listaDeVendas.size());
        System.out.println("Valor total das vendas: " + valorTotal);
        System.out.println("##########################################");
    }

    public void printarLucroTotal(){
        double valorTotal = listaDeVendas.stream().mapToDouble(venda -> venda.getValor()).sum();
        System.out.println("##########################################");
        System.out.println("Lucro Total: " + (valorTotal * 0.1));
        System.out.println("##########################################");
    }

    public void printarInfosClientes(){

        Scanner input = new Scanner(System.in);
        System.out.println("Insira o ID do Cliente: ");
        int idCliente = input.nextInt();
        Optional<Venda> cliente = listaDeVendas.stream().filter(venda -> venda.getIdCliente() == idCliente).findFirst();
        //find first pois não importa se é a primeira ou ultima compra do cliente, só quero os dados que estão repetidos em todas as commpras(vendas).
        //present é um metodo da classe Optional. Ao inves de ser == null, é isPresent.
        if(cliente.isPresent()){
            System.out.println("##########################################");
            System.out.println("Nome: " + cliente.get().getNomeCliente());
            System.out.println("Contacto: " + cliente.get().getContacto());
            System.out.println("E-mail: " + cliente.get().getEmail());
            System.out.println("##########################################");
        } else {
            System.out.println("Cliente não localizado.");
        }

    }

    public void printarMaiorVenda(){
        double maiorVenda = 0;
        String nomeDoJogo = "";
        for(int i = 0; i < listaDeVendas.size(); i++){
            if(listaDeVendas.get(i).getValor() > maiorVenda){
                maiorVenda = listaDeVendas.get(i).getValor();
                nomeDoJogo = listaDeVendas.get(i).getJogo();
            }
        }
        System.out.println("##########################################");
        System.out.println("O jogo mais caro é " + nomeDoJogo);
        System.out.println("O valor do jogo é: " + maiorVenda);
        System.out.println("Lista dos nomes dos clientes que compraram o jogo: ");


        for(int i = 0; i < listaDeVendas.size(); i++){
            if(listaDeVendas.get(i).getJogo().equals(nomeDoJogo)){
                System.out.println("nome: " + listaDeVendas.get(i).getNomeCliente() + " | e-mail: " + listaDeVendas.get(i).getEmail());
            }
        }
        System.out.println("##########################################");
    }





}

//listaDeVendas[i].getValor()