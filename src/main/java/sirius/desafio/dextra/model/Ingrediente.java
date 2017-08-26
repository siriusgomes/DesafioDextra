package sirius.desafio.dextra.model;

public class Ingrediente {

	private String nome;
	
	private Double valor;

	public Ingrediente(String nome, Double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	public Ingrediente(String nome) {
		super();
		this.nome = nome;
	}
	
	public Ingrediente() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Ingrediente [nome=" + nome + ", valor=" + valor + "]";
	} 
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.nome.toUpperCase().equals(((Ingrediente) obj).getNome().toUpperCase())) {
			return true;
		}
		return false;
	}
}
