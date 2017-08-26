package sirius.desafio.dextra.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lanche {

	private String nome;
	
	private List<Ingrediente> listIngredientes = new ArrayList<Ingrediente>();

	public Lanche(String nome, List<Ingrediente> listIngredientes) {
		super();
		this.nome = nome;
		this.listIngredientes = listIngredientes;
	}
	
	// Sobrecarga de construtor
	public Lanche(String nome, Ingrediente... ingredientes) {
		super();
		this.nome = nome;
		for (Ingrediente i : ingredientes) {
			this.listIngredientes.add(i);
		}
	}
	
	public Lanche() {
		
	}
	
	public Lanche(String nome) {
		this.nome = nome;
	}
	
	// ######################################################################## Getters e Setters ########################################################################
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingrediente> getListIngredientes() {
		return listIngredientes;
	}

	public void setListIngredientes(List<Ingrediente> listIngredientes) {
		this.listIngredientes = listIngredientes;
	}
	
	public void addIngrediente(Ingrediente ingrediente) {
		this.listIngredientes.add(ingrediente);
	}
	
	// ######################################################################## Regras do Lanche ########################################################################
	/**
	 * Calcula o valor do lanche conforme lista de ingredientes
	 * */
	public Double getValor() {
		Double valor = listIngredientes.stream().mapToDouble(i -> i.getValor()).sum();
		try {
			if (isMuitaCarne()) {
				Long qtdHamburgerDeCarne = getQuantidadeDeIngrediente().get("Hamburguer de Carne");
				Long qtdPagoHamburgerDeCarne = qtdHamburgerDeCarne - qtdHamburgerDeCarne/3;
				valor -= getIngrediente("Hamburguer de Carne").getValor() * qtdHamburgerDeCarne;
				valor += getIngrediente("Hamburguer de Carne").getValor() * qtdPagoHamburgerDeCarne;
			}
			if (isMuitoQueijo()) {
				Long qtdQueijo = getQuantidadeDeIngrediente().get("Queijo");
				Long qtdPagoQueijo = qtdQueijo - qtdQueijo/3;
				valor -= getIngrediente("Queijo").getValor() * qtdQueijo;
				valor += getIngrediente("Queijo").getValor() * qtdPagoQueijo;
			}
			if (isLight()) {
				valor = valor * 0.9;
			}
		}
		catch (Exception e) {
			// Provavelmente o lanche não possui algum dos ingredientes das promoções, perfeitamente normal.
		}
		return valor;
	}
	
	private boolean isLight() {
		return (listIngredientes.contains(new Ingrediente("Alface")) && !listIngredientes.contains(new Ingrediente("Bacon")));
	}

	private boolean isMuitaCarne() {
		return getQuantidadeDeIngrediente().get("Hamburguer de Carne") >= 3;
	}
	
	private boolean isMuitoQueijo() {
		return getQuantidadeDeIngrediente().get("Queijo") >= 3;
	}
	
	private Map<String, Long> getQuantidadeDeIngrediente() {
        Map<String, Long> qtdIngredientes = listIngredientes.stream().collect(Collectors.groupingBy(Ingrediente::getNome, Collectors.counting()));
		return qtdIngredientes;
	}

	private Ingrediente getIngrediente(String nomeIngrediente) {
		List<Ingrediente> resultado =listIngredientes.stream().filter(nome -> nome.equals(new Ingrediente(nomeIngrediente))).collect(Collectors.toList());
		if (resultado.size() > 0) {
			return resultado.get(0);
		}
		return null;
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listIngredientes == null) ? 0 : listIngredientes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.nome.toUpperCase().equals(((Ingrediente) obj).getNome().toUpperCase())) {
			return true;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Lanche [nome=" + nome + ", listIngredientes=" + listIngredientes + ", getValor()=" + getValor()
				+ ", isLight()=" + isLight() + ", isMuitaCarne()=" + isMuitaCarne() + ", isMuitoQueijo()="
				+ isMuitoQueijo() + "]";
	}

	
}
