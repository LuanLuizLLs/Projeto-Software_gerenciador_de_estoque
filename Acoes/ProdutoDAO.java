package Acoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO {

	private String sql;
	private Connection con;
	private PreparedStatement stmtConsultar, stmtInserir, stmtExcluir, stmtAlterar;
	private ResultSet respConsulta;
	private SGProduto retornoConsulta;
	
	public void alterar (SGProduto sgproduto) {
		
		con = new Factory().conectaBanco();
		sql = "update produtos set produto = ?, imagem = ?, modelo = ?, tamanho = ?, cor = ?, valor_custo = ?, valor_venda = ?, quantidade = ? where id = ?";
		
		try {
			
			stmtAlterar = con.prepareStatement(sql);
			stmtAlterar.setString(1, sgproduto.getProduto());
			stmtAlterar.setString(2, sgproduto.getImagem());
			stmtAlterar.setString(3, sgproduto.getModelo());
			stmtAlterar.setString(4, sgproduto.getTamanho());
			stmtAlterar.setString(5, sgproduto.getCor());
			stmtAlterar.setFloat(6, sgproduto.getValor_custo());
			stmtAlterar.setFloat(7, sgproduto.getValor_venda());
			stmtAlterar.setInt(8, sgproduto.getQuantidade());
			stmtAlterar.setInt(9, sgproduto.getId());
			stmtAlterar.execute();
			stmtAlterar.close();
			
		} catch (Exception e){
			System.out.println("Erro ao alterar " + e);
		}
	}
	
	public void excluir (SGProduto sgproduto) {
		
		con = new Factory().conectaBanco();
		sql = "delete from produtos where id = ?";
		
		try {
			
			stmtExcluir = con.prepareStatement(sql);
			stmtExcluir.setInt(1, sgproduto.getId());
			stmtExcluir.execute();
			stmtExcluir.close();
			con.close();
			
		} catch (Exception e){
			System.out.println("Erro " + e);
		}
	}
	
	public void inserir (SGProduto sgproduto) {
		
		con = new Factory().conectaBanco();
		sql = "insert into produtos (produto, imagem, modelo, tamanho, cor, valor_custo, valor_venda, quantidade) values (?,?,?,?,?,?,?,?)";
		
		try {
			
			stmtInserir = con.prepareStatement(sql);
			stmtInserir.setString(1, sgproduto.getProduto());
			stmtInserir.setString(2, sgproduto.getImagem());
			stmtInserir.setString(3, sgproduto.getModelo());
			stmtInserir.setString(4, sgproduto.getTamanho());
			stmtInserir.setString(5, sgproduto.getCor());
			stmtInserir.setFloat(6, sgproduto.getValor_custo());
			stmtInserir.setFloat(7, sgproduto.getValor_venda());
			stmtInserir.setInt(8, sgproduto.getQuantidade());
			stmtInserir.execute();
			stmtInserir.close();
			
		} 
		catch (Exception e) {
			System.out.println("Erro ao inserir " + e);
		}
	}

	public SGProduto consultar (String geral) {
		
		con = new Factory().conectaBanco();
		sql = "select * from produtos where produto = ? or id = ?";
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			stmtConsultar.setString(1, geral);
			stmtConsultar.setString(2, geral);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoConsulta = new SGProduto();
				retornoConsulta.setProduto(respConsulta.getString("produto"));
				retornoConsulta.setImagem(respConsulta.getString("imagem"));
				retornoConsulta.setId(respConsulta.getInt("id"));
				retornoConsulta.setModelo(respConsulta.getString("modelo"));
				retornoConsulta.setTamanho(respConsulta.getString("tamanho"));
				retornoConsulta.setCor(respConsulta.getString("cor"));
				retornoConsulta.setValor_custo(respConsulta.getFloat("valor_custo"));
				retornoConsulta.setValor_venda(respConsulta.getFloat("valor_venda"));
				retornoConsulta.setQuantidade(respConsulta.getInt("quantidade"));
				
			}
			stmtConsultar.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Erro " + e);
			return null;
		}
		return retornoConsulta;
	}
}
