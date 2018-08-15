package Acoes;

public class ModeloVenda {


	int codProd = 0;
	private int id = 0;
	private float Valordoitem;
	private String produto;
	private int quantidade;
	private int idvenda = 0;
	private int QtdItem = 0;
	private String NomeProduto = null;
	
/*id
produto
quantidade
valor_venda
imagem*/
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public int getIdprod() {
		return id;
	}
	public void setIdprod(int id) {
		this.id = id;
	}
	
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}
	public int getIdvenda() {
		return idvenda;
	}
	public void setIdvenda(int idvenda) {
		this.idvenda = idvenda;
	}
	public int getQtdItem() {
		return QtdItem;
	}
	public void setQtdItem(int qtdaItem) {
		QtdItem = qtdaItem;
	}
	public String getNomeProduto() {
		return NomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		NomeProduto = nomeProduto;
	}

	public float getValordoitem() {
		return Valordoitem;
	}
	public void setValordoitem(float valordoitem) {
		Valordoitem = valordoitem;
	}


}
