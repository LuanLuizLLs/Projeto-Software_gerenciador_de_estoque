package Acoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

//Fazendo a localização do banco de dados e conectando
public class Factory {

	Connection con;
	public Statement statement;
	public ResultSet rs;
	
	String url = "jdbc:mysql://localhost:3306/crashsolutions_bd";
	String user = "root";
	String senha = "1234";

	public Connection conectaBanco(){
		if(con == null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, senha);

			} catch  (Exception e){
				System.out.println("Erro ao conectar: " + e.getMessage());
			}
		}
		return con;
	}
	public void desconectaBanco(){
		if(con != null){
			try{
				con.close();
				System.out.println("Conexão fechada!");
			} catch (Exception e){
				System.out.println(e);
			}
		}
	}
	
	public void executeSQL(String sql) {
		
		try {
			
			statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sql);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível a conexão de busca");
		}
	}
}

