package main;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CustomTableModel<T extends ObjectInfo> extends DefaultTableModel {

	private static final long serialVersionUID = 1L;	
	
	private ArrayList<T> objetos;
	
	public static void main(String[] args) {
		
		ArrayList<Objeto> a = new ArrayList<>();
		a.add(new Objeto());
		a.add(new Objeto());
		
		CustomTableModel<Objeto> tabela = new CustomTableModel<>(a);
		
		JFrame frm = new JFrame();
		frm.setSize(300, 300);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLayout(null);
		
		JScrollPane table = tabela.getScroll();
		table.setBounds(25, 25, 250, 250);
		
		frm.add(table);
		
		frm.setVisible(true);
	}
	
	public CustomTableModel() {}
	
	public CustomTableModel(ArrayList<T> objetos) {
		
		setObjects(objetos);
	}
	
	public void setObjects(ArrayList<T> objetos) {
		
		this.objetos = objetos;
		
		setRowCount(0);
		setColumnCount(0);
		
		for (int i = 0; i < objetos.get(0).getInfoName().length; i++) {
			
			addColumn(objetos.get(0).getInfoName()[i]);
		}
		
		for (int i = 0; i < objetos.size(); i++) {
		
			addRow(objetos.get(i).getInfo());
		}
	}
	
	public JTable getTable() {
		
		JTable tabela = new JTable(this);
		tabela.setDefaultEditor(Object.class, null);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabela.getDefaultRenderer(Object.class);
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		return tabela;
	}
	
	public JScrollPane getScroll() {
		
		return new JScrollPane(getTable());
	}
	
	public T getObject(int index) {
		
		return objetos.get(index);
	}
}
