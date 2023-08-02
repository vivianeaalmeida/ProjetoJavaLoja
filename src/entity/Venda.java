package entity;
//entidade seria um objeto

//essa minha classe Venda representa uma venda SÓ.
//tem as mesmas colunas do arquivo GameStart.csv, mas ainda não contém os valores.
//crio as propriedades, para poder acessar os atributos fisicos do meu objeto VENDA.
public class Venda {
    private String idVenda;
    private int idCliente;
    private String nomeCliente;
    private String contacto;
    private String email;
    private String editora;
    private String categoria;
    private String jogo;
    private double valor;


    //Propriedade privada com get e set para seguir as boas práticas, sendo possível controlar quais campos
    // podem ser obtidos (get) e alterados (set).
    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(String valor) {
        if(valor != null){
            this.valor = Double.valueOf(valor);
        }
    }

    //
    @Override
    public String toString() {
        return "Venda{" +
                "idVenda='" + idVenda + '\'' +
                ", idCliente=" + idCliente +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", contacto='" + contacto + '\'' +
                ", email='" + email + '\'' +
                ", editora='" + editora + '\'' +
                ", categoria='" + categoria + '\'' +
                ", jogo='" + jogo + '\'' +
                ", valor=" + valor +
                "}\n";
    }
}
