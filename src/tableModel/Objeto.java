package tableModel;

class Objeto implements ObjectInfo {

	private String nome;
	private int idade;
	
	public Objeto(String nome, int idade) {
		
		this.nome = nome;
		this.idade = idade;
	}
	
	@Override
	public Object[] getInfo() {

		return new Object[] {nome, idade};
	}

	@Override
	public Object[] getInfoName() {
		
		return new Object[] {"Nome", "Idade"};
	}

	
}
