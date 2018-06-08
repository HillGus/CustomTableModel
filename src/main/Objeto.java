package main;

public class Objeto implements ObjectInfo {

	@Override
	public Object[] getInfo() {

		return new Object[] {"Teasdasd", 2};
	}

	@Override
	public Object[] getInfoName() {
		
		return new Object[] {"Nome", "Idade"};
	}

	
}
