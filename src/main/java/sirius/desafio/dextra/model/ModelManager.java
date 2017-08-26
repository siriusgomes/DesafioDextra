package sirius.desafio.dextra.model;

import java.util.HashMap;
import java.util.Map;

public class ModelManager {

	private Map<String, Ingrediente> mapIngredientes = new HashMap<String, Ingrediente>();
	private Map<String, Lanche> mapLanches = new HashMap<String, Lanche>();
	
	
	// Aqui crio os ingredientes iniciais e os lanches iniciais.
	public ModelManager() {
		
		//Criando os ingredientes
		Ingrediente alface = new Ingrediente("Alface", 0.40d);
		Ingrediente bacon = new Ingrediente("Bacon", 2.0d);
		Ingrediente hamburguerDeCarne = new Ingrediente("Hamburguer de Carne", 3.0d);
		Ingrediente ovo = new Ingrediente("Ovo", 0.80d);
		Ingrediente queijo = new Ingrediente("Queijo", 1.50d);
		mapIngredientes.put(alface.getNome(), alface);
		mapIngredientes.put(bacon.getNome(), bacon);
		mapIngredientes.put(hamburguerDeCarne.getNome(), hamburguerDeCarne);
		mapIngredientes.put(ovo.getNome(), ovo);
		mapIngredientes.put(queijo.getNome(), queijo);

		// Criando os lanches
		Lanche xBacon = new Lanche("X-Bacon", bacon, hamburguerDeCarne, queijo);
		Lanche xBurger = new Lanche("X-Burger", hamburguerDeCarne, queijo);
		Lanche xEgg = new Lanche("X-Egg", ovo, hamburguerDeCarne, queijo);
		Lanche xEggBacon = new Lanche("X-Egg Bacon", ovo, bacon, hamburguerDeCarne, queijo);

		mapLanches.put(xBacon.getNome(), xBacon);
		mapLanches.put(xBurger.getNome(), xBurger);
		mapLanches.put(xEgg.getNome(), xEgg);
		mapLanches.put(xEggBacon.getNome(), xEggBacon);
		
	}


	public Map<String, Ingrediente> getMapIngredientes() {
		return mapIngredientes;
	}


	public void setMapIngredientes(Map<String, Ingrediente> mapIngredientes) {
		this.mapIngredientes = mapIngredientes;
	}


	public Map<String, Lanche> getMapLanches() {
		return mapLanches;
	}


	public void setMapLanches(Map<String, Lanche> mapLanches) {
		this.mapLanches = mapLanches;
	}

}
