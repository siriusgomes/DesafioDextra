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
		int promocao = getPromocao();
		switch (promocao) {
		case 1:
			valor = valor * 0.9;
			break;
		case 2:
			Long qtdHamburgerDeCarne = getQuantidadeDeIngrediente().get("Hamburger de Carne");
			Long qtdPagoHamburgerDeCarne = qtdHamburgerDeCarne - qtdHamburgerDeCarne/3;
			valor -= getIngrediente("Hamburger de Carne").getValor() * qtdHamburgerDeCarne;
			valor += getIngrediente("Hamburger de Carne").getValor() * qtdPagoHamburgerDeCarne;
			break;
		case 3: 
			Long qtdQueijo = getQuantidadeDeIngrediente().get("Queijo");
			Long qtdPagoQueijo = qtdQueijo - qtdQueijo/3;
			valor -= getIngrediente("Queijo").getValor() * qtdQueijo;
			valor += getIngrediente("Queijo").getValor() * qtdPagoQueijo;
			break;
		}
		return valor;
	}
	
	/**
	 * Função que retorna o numero da promoção, caso o lanche se enquadre em alguma. 
	 * */
	private int getPromocao() {
		// Promoção light
		if (listIngredientes.contains(new Ingrediente("Alface")) && !listIngredientes.contains(new Ingrediente("Bacon"))) {
			return 1;
		}
		
		// Promoção muita carne
		if (getQuantidadeDeIngrediente().get("Hamburger de Carne") > 0) {
			return 2;
		}
	
		// Promoção muito queijo
		if (getQuantidadeDeIngrediente().get("Queijo") > 0) {
			return 3;
		}
		
		return 0;
	}

	private Map<String, Long> getQuantidadeDeIngrediente() {
        Map<String, Long> qtdIngredientes = listIngredientes.stream().collect(Collectors.groupingBy(Ingrediente::getNome, Collectors.counting()));
		return qtdIngredientes;
	}

	private Ingrediente getIngrediente(String nomeIngrediente) {
		List<Ingrediente> resultado =listIngredientes.stream().filter(nome -> nome.equals(nomeIngrediente)).collect(Collectors.toList());
		if (resultado.size() > 0) {
			return resultado.get(0);
		}
		return null;
    }
	
	@Override
	public String toString() {
		return "Lanche [nome=" + nome + ", listIngredientes=" + listIngredientes + ", preço=" + listIngredientes.stream().mapToDouble(i -> i.getValor()).sum() + "]";
	}
}
