package sirius.desafio.dextra.model;

import java.util.ArrayList;
import java.util.List;

public class ModelManager {

	private List<Ingrediente> listIngredientes = new ArrayList<Ingrediente>();
	private List<Lanche> listLanches = new ArrayList<Lanche>();
	
	
	// Aqui crio os ingredientes iniciais e os lanches iniciais.
	public ModelManager() {
		
		//Criando os ingredientes
		Ingrediente alface = new Ingrediente("Alface", 0.40d);
		Ingrediente bacon = new Ingrediente("Bacon", 2.0d);
		Ingrediente hamburguerDeCarne = new Ingrediente("Hamburguer de Carne", 3.0d);
		Ingrediente ovo = new Ingrediente("Ovo", 0.80d);
		Ingrediente queijo = new Ingrediente("Queijo", 1.50d);
		listIngredientes.add(alface);
		listIngredientes.add(bacon);
		listIngredientes.add(hamburguerDeCarne);
		listIngredientes.add(ovo);
		listIngredientes.add(queijo);

		// Criando os lanches
		listLanches.add(new Lanche("X-Bacon", bacon, hamburguerDeCarne, queijo));
		listLanches.add(new Lanche("X-Burger", hamburguerDeCarne, queijo));
		listLanches.add(new Lanche("X-Egg", ovo, hamburguerDeCarne, queijo));
		listLanches.add(new Lanche("X-Egg Bacon", ovo, bacon, hamburguerDeCarne, queijo));
		
	}
	
	public List<Ingrediente> getListIngredientes() {
		return listIngredientes;
	}


	public void setListIngredientes(List<Ingrediente> listIngredientes) {
		this.listIngredientes = listIngredientes;
	}


	public List<Lanche> getListLanches() {
		return listLanches;
	}

	public void setListLanches(List<Lanche> listLanches) {
		this.listLanches = listLanches;
	}
}
