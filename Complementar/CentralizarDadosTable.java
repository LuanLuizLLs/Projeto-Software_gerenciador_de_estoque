package Complementar;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CentralizarDadosTable extends DefaultTableCellRenderer{
	
	private static final long serialVersionUID = 1L;

	public CentralizarDadosTable() {
		super();
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		this.setHorizontalAlignment(CENTER);
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
	}
}

