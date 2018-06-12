package main;

import java.util.ArrayList;

public class Filtro {

	private String filtro;
	private ArrayList<Integer> indexes = new ArrayList<>();
	
	
	public Filtro(String filtro, int length) {
		
		this.filtro = filtro;
		
		for (int i = 0; i < length; i++) {
			
			addIndex(i);
		}
		
	}
	
	public Filtro(String filtro, int[] indexes) {
		
		this.filtro = filtro;
		
		for (Integer index : indexes) {
			
			addIndex(index);
		}
	}
	
	
	public void addIndex(int index) {
		
		indexes.add(index);
	}
	
	public <T extends ObjectInfo> boolean matches(T obj) {
		
		Object[] info = obj.getInfo();
		
		for (Integer index : indexes) {
			
			if (!String.valueOf(info[index]).matches(filtro)) {
				
				return false;
			}
		}
		
		return true;
	}
}