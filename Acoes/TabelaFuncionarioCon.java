package Acoes;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class TabelaFuncionarioCon extends AbstractTableModel {
	 
	private static final long serialVersionUID = 1L;
	private int colunas, linhas;
	private ResultSet RespTable;
	private ResultSetMetaData respMetaData;
	
	public TabelaFuncionarioCon (ResultSet respTable) throws SQLException {
		
		respMetaData = respTable.getMetaData();
		this.RespTable = respTable;
		respTable.last();
		linhas = respTable.getRow();
		fireTableStructureChanged();
		
	}
	
	public String getColumnName(int column) {
		
		switch (column) {
		
		case 0:
			return "ID";
		case 1:
			return "Nome";
		case 2:
			return "Sobrenome";
		case 3:
			return "CPF";
		case 4:
			return "Cargo";
		
		}
		
		return null;
	}
	
	public int getColumnCount() {
		
		colunas = 0;
		try {
			
			colunas = respMetaData.getColumnCount();
			
		} catch (Exception erro) {
			
		}
		return colunas;
	}

	public int getRowCount() {
		
		return linhas;
	}

	public Object getValueAt(int row, int column) {
		
		try {
			
			RespTable.absolute(row+1);
			return RespTable.getObject(column+1);
			
		} catch (Exception erro) {
			
		}
		return "";
	}
}
