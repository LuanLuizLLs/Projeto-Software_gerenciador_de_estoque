package Acoes;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public  class ModeloTabela extends AbstractTableModel {

			@SuppressWarnings("rawtypes")
			private ArrayList linhas = null;
			private String[] colunas = null;
			
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public ModeloTabela(ArrayList lin,String[] col){
		setLinhas(lin);
		setColunas(col);
		
		}

	public ModeloTabela(ResultSet rs) {
		
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getLinhas(){
		return linhas;
	}
	
	@SuppressWarnings("rawtypes")
	public void setLinhas(ArrayList dados){
		linhas = dados;
	}
	
	public String[] getColunas(){
		return colunas;
	}
	
	public void setColunas(String[] nomes){
		colunas = nomes;
	}
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return linhas.size();
	}

	public String getColumnName(int numCol){
		return colunas[numCol];
		
	}
	
	public void removeRoew (int linha) {
		this.linhas.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}
	
	@Override
	public Object getValueAt(int numLin, int numCol) {
		Object[] linha = (Object[])getLinhas().get(numLin);
		return linha[numCol];
	}
	
}
