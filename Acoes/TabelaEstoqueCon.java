package Acoes;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class TabelaEstoqueCon extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private int colunas, linhas;
	private ResultSet RespTable;
	private ResultSetMetaData respMetaData;
	
	public TabelaEstoqueCon (ResultSet respTable) throws SQLException {
		
		respMetaData = respTable.getMetaData();
		this.RespTable = respTable;
		respTable.last();
		linhas = respTable.getRow();
		
		fireTableStructureChanged();
		
	}
	
	public String getColumnName(int column) {
		
		switch (column) {
		
		case 0:
			return "Produto";
		case 1:
			return "Quantidade";
		case 2:
			return "Valor do Itém";
	
		
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
