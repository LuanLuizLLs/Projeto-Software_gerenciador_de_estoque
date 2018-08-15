package Acoes;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class TabelaProdutoCon extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private int colunas, linhas;
	private ResultSet RespTable;
	private ResultSetMetaData respMetaData;
	
	public TabelaProdutoCon (ResultSet respTable) throws SQLException {
		
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
			return "Produto";
		case 2:
			return "Modelo";
		case 3:
			return "Tamanho";
		case 4:
			return "Cor";
		case 5:
			return "Valor";
		case 6:
			return "Quantidade";
		
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
