package Acoes;

import java.sql.*;

import Acoes.Factory;

public class AcessoLogin {
	
	public boolean acesso;
	private String sql;
	private Connection con;
	private Statement stmt, stmtMaster;
	private ResultSet respConsulta;
	private SGFuncionario retornoConsulta;
	
	
	public SGFuncionario Login (String usuario, String senha, String ativo) {
		
		try{
			
			con = new Factory().conectaBanco();
			stmt = (Statement) con.createStatement();
			sql = "select nome, usuario, senha, ativo from funcionarios where usuario = '"+usuario+"' and senha ='"+senha+"' and ativo = '"+ativo+"'";
			respConsulta = stmt.executeQuery(sql);
			
			if(respConsulta.next()){
				retornoConsulta = new SGFuncionario();
				retornoConsulta.setNome(respConsulta.getString("nome"));
				retornoConsulta.setAtivo(respConsulta.getString("ativo"));
				acesso = true;
			}
			else {
				acesso = false;
			}
			stmt.close();
			con.close();
			
		} catch (Exception e) {
		}
		return retornoConsulta;
	}
	
	public void Master (String usuariomaster, String senhamaster) {
		
		try{
			
			con = new Factory().conectaBanco();
			stmtMaster = (Statement) con.createStatement();
			sql = "select usuario, senha from administrador where usuario = '"+usuariomaster+"' and senha ='"+senhamaster+"'";
			respConsulta = stmtMaster.executeQuery(sql);
			
			if(respConsulta.next()){
				acesso = true;
			}
			else {
				acesso = false;
			}
			
			stmt.close();
			con.close();
			
		} catch (Exception e) {
		}
	}

	public SGFuncionario RetornaNome (String nome, String nusuario) {
		
		try{
			
			con = new Factory().conectaBanco();
			stmt = (Statement) con.createStatement();
			sql = "select nome, usuario, ativo from funcionarios where usuario = '"+nusuario+"'";
			respConsulta = stmt.executeQuery(sql);
			
			if(respConsulta.next()){
				retornoConsulta = new SGFuncionario();
				retornoConsulta.setNome(respConsulta.getString("nome"));
			}
			stmt.close();
			con.close();
			
		} catch (Exception e) {
		}
		
		return retornoConsulta;
	}
}