package Acoes;

import java.sql.Connection; 
import java.sql.SQLException;

public class TestaConexao {
	
	private static Connection con;
	
	public static void main(String[] args) throws SQLException {
         con = new Factory().conectaBanco();
         System.out.println("Conexão aberta!");
         con.close();
     }
}
