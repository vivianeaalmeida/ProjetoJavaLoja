import entity.Venda;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<Venda> leArquivoERetornaAListaDeVendas() throws IOException {
        BufferedReader in = new BufferedReader(new java.io.FileReader("./src/resources/GameStart.csv"));
        String linha = in.readLine(); //adicionado aqui para ignorar primeira linha (header)
        List<Venda> listaDeVendas = new ArrayList<>(); //
        //tipo de variável -> Lista que contem objeto Venda (o objeto Venda foi definido no arquivo Venda.java) + nome da variável = novoArray

        while ((linha = in.readLine()) != null){
            String[] splitColumns = linha.split(";");
            //criado objeto objetoVenda {idVenda, idCliente...} propriedades do objeto foram criadas no arquivo objetoVenda
            Venda objetoVenda = new Venda(); //nesse caso, é criado uma VENDA vazia, e depois é setado o valor que o obj objetoVenda terá.
            objetoVenda.setIdVenda(splitColumns[0]);
            //id cliente - nesse cenário, a conversão é feita fora do objeto srt -> int
            objetoVenda.setIdCliente(Integer.valueOf(splitColumns[1]));
            //nome cliente
            objetoVenda.setNomeCliente(splitColumns[2]);
            //contacto
            objetoVenda.setContacto(splitColumns[3]);
            //email
            objetoVenda.setEmail(splitColumns[4]);
            //editora
            objetoVenda.setEditora(splitColumns[5]);
            //categoria
            objetoVenda.setCategoria(splitColumns[6]);
            //jogo
            objetoVenda.setJogo(splitColumns[7]);
            //valor - nesse caso, a conversão é feita dentro do objeto recebendo uma string -> double. Bom uso do set.
            objetoVenda.setValor(splitColumns[8]);

            listaDeVendas.add(objetoVenda);
        }
        in.close();
        return listaDeVendas;
    }

}

/*
[
    {
        idVenda: 01,
        idCliente: 01,
        nomeCliente: Viviane,
        ....
    },

    {
        idVenda: 02,
        idCliente: 02,
        nomeCliente: Ted,
        ....
    }
]
 */