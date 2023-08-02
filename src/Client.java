import entity.Venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {

    private final List<Venda> listaDeVendas = new ArrayList<>();

    public Client(List<Venda> listaDeVendas){
        this.listaDeVendas.addAll(listaDeVendas); //nao é this.listaDeVendas = listaDeVendas pois é uma constante (final)
    }
    public void menuCliente(){
        Scanner input = new Scanner(System.in);
        int option = 0;
        String editora = "";

        while (!isValidOption(option)){
            System.out.println("MENU CLIENTE");
            System.out.println("1.Imprima os títulos dos jogos ");
            System.out.println("2.Imprima as categorias de jogos da editora ");


            option = input.nextInt();

            switch (option){
                case 1:
                    imprimirTitulosDeJogos();
                    break;
                case 2:
                    imprimirJogosDaEditora();
                    break;
                default:
                    System.out.println("Opção inválida");

            }
        }
    }
    //função de validação de opção do menu admin
    private boolean isValidOption(int option){
        return option >= 1 && option <=2;
    }

    public void imprimirTitulosDeJogos(){
        List<String> arrayNomeDosJogos = new ArrayList<>(); //novo array para fins de comparação (contains).
        System.out.println("##########################################");
        System.out.println("Lista de Jogos: ");
        for(int i = 0; i < listaDeVendas.size(); i++){
            String nomeDoJogo = listaDeVendas.get(i).getJogo();
            if(!arrayNomeDosJogos.contains(nomeDoJogo)){
                arrayNomeDosJogos.add(nomeDoJogo);
                System.out.println("- " + nomeDoJogo + " Preço: " + listaDeVendas.get(i).getValor());
            }
        }
        System.out.println("##########################################");
    }

    public void imprimirJogosDaEditora(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insira uma editora: ");
        String nomeDaEditora = input.next();

        List<Venda> vendasFiltradas = listaDeVendas.stream().filter(venda -> venda.getEditora().equalsIgnoreCase(nomeDaEditora)).collect(Collectors.toList());
        System.out.println("##########################################");
        System.out.println("Editora a pesquisar: " + nomeDaEditora);
        System.out.println("*** " + nomeDaEditora + " ***");
        if(vendasFiltradas.isEmpty()){
            System.out.println("Jogos não encontrados para essa editora.");
        } else {
            //agrupei as vendas filtradas pela categoria, gerando um Map com a chave String(categoria) e valor List<Venda>
            //todas as vendas que são daquela categoria (vendas já filtradas)
            Map<String, List<Venda>> vendasAgrupadas = vendasFiltradas.stream().collect(Collectors.groupingBy(venda -> venda.getCategoria()));
            //para cada String categoria obtida das chaves do Map (vendasAgrupadas) ex: [desporto, corrida, ...] -> o keyset pega as chaves e coloca na lista.
            //declaro a variavel categoria (string)
            for(String categoria: vendasAgrupadas.keySet()){
                List<Venda> vendasDaCategoria = vendasAgrupadas.get(categoria); //uma categoria por vez.
                List<String> arrayNomeDosJogos = new ArrayList<>();
                System.out.println("Categoria: " + categoria);
                for(Venda vendaCompleta: vendasDaCategoria){
                    if(!arrayNomeDosJogos.contains(vendaCompleta.getJogo())){
                        System.out.println(vendaCompleta.getJogo());
                        arrayNomeDosJogos.add(vendaCompleta.getJogo());
                    }
                }
                System.out.println("");
            }
        }
        System.out.println("##########################################");

    }

}
