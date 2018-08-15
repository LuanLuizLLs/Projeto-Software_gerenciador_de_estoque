package Acoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Acoes.ModeloVenda;
public class ControleVenda {
	int codProd;

	Factory con = new Factory();
	
	
	
	
	
	public void adicionaItem (ModeloVenda mod){
		achaCodProduto(mod.getNomeProduto());
		con.conectaBanco();
		try {
			
			PreparedStatement pst = con.con.prepareStatement("insert into itens_venda_produto (id_venda, id_produto, quantidade_produto) values(?,?,?)");            
			pst.setInt(1, mod.getIdvenda());
			pst.setInt(2, mod.codProd);
			pst.setInt(3, mod.getQtdItem());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Produto adicionado!  " );
			/*	con.desconectaBanco();*/
		} catch (SQLException e) {
			/*	con.desconectaBanco();*/
			JOptionPane.showMessageDialog(null, "Erro ao realizar venda: " + e);
		}
		
		
		
	}
	
	public void adicionaItemVenda (ModeloVenda mod){
		achaCodProduto(mod.getProduto());
		con.conectaBanco();
		try {
			PreparedStatement pst = con.con.prepareStatement("insert into itens_venda_produto (id_venda, id_produto, quantidade_produto) values(?,?,?)");            
			pst.setInt(1, mod.getIdvenda());
			pst.setInt(2, mod.codProd);
			pst.setInt(3, mod.getQtdItem());
			pst.execute();
			JOptionPane.showMessageDialog(null, "Produto adicionado!  " );
			/*	con.desconectaBanco();*/
		} catch (SQLException e) {
			/*	con.desconectaBanco();*/
			con.conectaBanco();
			JOptionPane.showMessageDialog(null, "Erro ao realizar venda: " + e);
		}
		
		
		
	}

	
	
	public void achaCodProduto(String nome){
		con.conectaBanco();
		con.executeSQL("select * from produtos where produto='"+nome+"'");
		try {
			con.rs.first();
			codProd = con.rs.getInt("id");
		/*	con.desconectaBanco();*/
		} catch (SQLException e) {
			/*	con.desconectaBanco();*/
			con.conectaBanco();
			JOptionPane.showMessageDialog(null, "erro" + e);
		}
	}
	
	
	public void addvenda(ModeloVenda modeloVenda) {
		try {
			Connection con = new Factory().conectaBanco();
			PreparedStatement pstmt = con.prepareStatement("insert into	venda_produto (produto, quantidade, valordoitem) values (?,?,?)");
			
			pstmt.setString(1, modeloVenda.getProduto());
			pstmt.setInt(2, modeloVenda.getQuantidade());
			pstmt.setFloat(3, modeloVenda.getValordoitem());
	
			pstmt.execute();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro ao adicionar venda na tabela venda");
		}
	
	}
};
