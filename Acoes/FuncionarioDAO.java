package Acoes;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncionarioDAO{
	
	private String sql;
	private Connection con;
	private PreparedStatement stmtConsultar, stmtInserir, stmtExcluir, stmtAlterar;
	private ResultSet respConsulta;
	private SGFuncionario retornoConsulta;
	
	public void alterar(SGFuncionario sgfuncionario){
		
		con = new Factory().conectaBanco();
		sql = "update funcionarios set nome = ?, sobrenome = ?, endereco = ?, numero = ?, datanasc = ?, tel = ?, cel = ?, email = ?, cpf = ?, rg = ?, dataadm = ?, cargo = ?, salario = ?, ativo = ? where idfunc = ?";
		
		try{
			
			stmtAlterar = con.prepareStatement(sql);
			stmtAlterar.setString(1, sgfuncionario.getNome());
			stmtAlterar.setString(2, sgfuncionario.getSobrenome());
			stmtAlterar.setString(3, sgfuncionario.getEndereco());
			stmtAlterar.setString(4, sgfuncionario.getNumero());
			stmtAlterar.setString(5, sgfuncionario.getDatanasc());
			stmtAlterar.setString(6, sgfuncionario.getTel());
			stmtAlterar.setString(7, sgfuncionario.getCel());
			stmtAlterar.setString(8, sgfuncionario.getEmail());
			stmtAlterar.setString(9, sgfuncionario.getCpf());
			stmtAlterar.setString(10, sgfuncionario.getRg());
			stmtAlterar.setString(11, sgfuncionario.getDataadm());
			stmtAlterar.setString(12, sgfuncionario.getFuncao());			
			stmtAlterar.setFloat(13, sgfuncionario.getSalario());
			stmtAlterar.setString(14, sgfuncionario.getAtivo());
			stmtAlterar.setInt(15, sgfuncionario.getIdfunc());
			
			stmtAlterar.execute();
			stmtAlterar.close();
			con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void excluir (SGFuncionario sgfuncionario){
		
		con = new Factory().conectaBanco();
		sql = "delete from funcionarios where idfunc = ?";
		
		try{
			
			stmtExcluir = con.prepareStatement(sql);
			stmtExcluir.setInt(1, sgfuncionario.getIdfunc());
			stmtExcluir.execute();
			stmtExcluir.close();
			con.close();
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void inserir (SGFuncionario sgfuncionario) {
		
		con = new Factory().conectaBanco();
		sql = "insert into	funcionarios (nome, sobrenome, endereco, numero, datanasc, tel, cel, email, sexo, cpf, rg, dataadm, cargo, salario, usuario, senha, ativo) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			stmtInserir = con.prepareStatement(sql);
			stmtInserir.setString(1, sgfuncionario.getNome());
			stmtInserir.setString(2, sgfuncionario.getSobrenome());			
			stmtInserir.setString(3, sgfuncionario.getEndereco());
			stmtInserir.setString(4, sgfuncionario.getNumero());
			stmtInserir.setString(5, sgfuncionario.getDatanasc());
			stmtInserir.setString(6, sgfuncionario.getTel());
			stmtInserir.setString(7, sgfuncionario.getCel());
			stmtInserir.setString(8, sgfuncionario.getEmail());
			stmtInserir.setString(9, sgfuncionario.getSexo());
			stmtInserir.setString(10, sgfuncionario.getCpf());
			stmtInserir.setString(11, sgfuncionario.getRg());
			stmtInserir.setString(12, sgfuncionario.getDataadm());			
			stmtInserir.setString(13, sgfuncionario.getFuncao());
			stmtInserir.setFloat(14, sgfuncionario.getSalario());
			stmtInserir.setString(15, sgfuncionario.getUsuario());			
			stmtInserir.setString(16, sgfuncionario.getSenha());			
			stmtInserir.setString(17, sgfuncionario.getAtivo());
			stmtInserir.execute();
			stmtInserir.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SGFuncionario consultar (String pesquisa) {
		
		con = new Factory().conectaBanco();
		sql = "select * from funcionarios where idfunc = ?";
		
		try {
			
			stmtConsultar = con.prepareStatement(sql);
			stmtConsultar.setString(1, pesquisa);
			respConsulta = stmtConsultar.executeQuery();
			
			while (respConsulta.next()) {
				
				retornoConsulta = new SGFuncionario();
				retornoConsulta.setIdfunc(respConsulta.getInt("idfunc"));
				retornoConsulta.setNome(respConsulta.getString("nome"));
				retornoConsulta.setSobrenome(respConsulta.getString("sobrenome"));				
				retornoConsulta.setEndereco(respConsulta.getString("endereco"));
				retornoConsulta.setNumero(respConsulta.getString("numero"));
				retornoConsulta.setDatanasc(respConsulta.getString("datanasc"));
				retornoConsulta.setTel(respConsulta.getString("tel"));
				retornoConsulta.setCel(respConsulta.getString("cel"));
				retornoConsulta.setEmail(respConsulta.getString("email"));
				retornoConsulta.setSexo(respConsulta.getString("sexo"));
				retornoConsulta.setCpf(respConsulta.getString("cpf"));
				retornoConsulta.setRg(respConsulta.getString("rg"));
				retornoConsulta.setDataadm(respConsulta.getString("dataadm"));
				retornoConsulta.setFuncao(respConsulta.getString("cargo"));				
				retornoConsulta.setSalario(respConsulta.getFloat("salario"));				
				retornoConsulta.setUsuario(respConsulta.getString("usuario"));
				retornoConsulta.setSenha(respConsulta.getString("senha"));
				retornoConsulta.setAtivo(respConsulta.getString("ativo"));
				
			}
			stmtConsultar.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retornoConsulta;
	}
}


