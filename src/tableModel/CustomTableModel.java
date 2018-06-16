package tableModel;

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
	
	private int[] indexes;
	
	
	public static void main(String[] args) {
		
		ArrayList<Objeto> a = new ArrayList<>();
		a.add(new Objeto("Gustavo", 16));
		a.add(new Objeto("Nathan", 19));
		
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
	
	
	public void atualizar() {
		
		criarIndexes();
		
		atualizarColunas();
		atualizarLinhas();
	}
	
	private void atualizarColunas() {
		
		setColumnCount(0);
		
		for (int i : indexes) {
			
			addColumn(objetos.get(0).getInfoName()[i]);
		}
	}
	
	private void atualizarLinhas() {
		
		setRowCount(0);

		for (T obj : objetos) {
			
			Object[] info = obj.getInfo();
			Object[] rowInfo = new Object[indexes.length];
			
			for (int i = 0; i < indexes.length; i++) {
				
				int index = indexes[i];
				
				rowInfo[i] = info[index];
			}
			
			addRow(rowInfo);
		}
	}
	
	private void criarIndexes() {
		
		if (indexes == null) {
			
			int[] indexes = new int[objetos.get(0).getInfo().length];
			
			for (int i = 0; i < indexes.length; i++) {
				
				indexes[i] = i;
			}
			
			this.indexes = indexes;
		}
	}
	
	
	public void setObjects(ArrayList<T> objetos) {
		
		this.objetos = objetos;
		
		atualizar();
	}
	
	public void setIndexes(int[] indexes) {
		
		this.indexes = indexes;
		
		atualizar();
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