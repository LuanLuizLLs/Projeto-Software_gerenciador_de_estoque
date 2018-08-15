package Acoes;

// Todas as variaveis do banco de dados irão receber os valores atraves dessa classe
public class SGProduto {
	
	private String produto = null;
	private String imagem = null;
	private int id = 0;
	private String modelo = null;
	private String tamanho = null;
	private String cor = null;
	private Float valor_custo = null;
	private Float valor_venda = null;
	private int quantidade = 0;
	
	
	//Inserir e Buscar os dados
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Float getValor_custo() {
		return valor_custo;
	}
	public void setValor_custo(Float valor_custo) {
		this.valor_custo = valor_custo;
	}
	public Float getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(Float valor_venda) {
		this.valor_venda = valor_venda;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
	
	