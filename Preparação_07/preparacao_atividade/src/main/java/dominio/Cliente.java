package dominio;

public class Cliente{
    private Long Id;
    private String nome;
    private List<Venda> vendas;
    
    public Cliente(){
        this("");
    }

    public Cliente(String nome){
        this.nome = nome;
    }

    public void setId(Long Id){
    this.Id = Id;
    }

    public Long getId(){
        return this.Id;
    }

    public void setNome(String nome){
        this.nome =  nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setVendas(List<venda> vendas){
        this.vendas = vendas;
    }

    public List<venda> getVenda(){
        return this.vendas;
    }

    @Override
    public String toString(){
        return "Cliente[nome="+ nome +"]";
    }
}