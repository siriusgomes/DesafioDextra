package sirius.desafio.dextra.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sirius.desafio.dextra.model.Lanche;
import sirius.desafio.dextra.model.ModelManager;

public class CalculoPreco {
	
	// Basicamente o BD da aplicação. Ao instanciá-lo, já são criados os ingredientes e lanches do enunciado do desafio.
	private ModelManager modelManager = null;
	
	@Before 
	public void beforeTest() {
		modelManager = new ModelManager();
		
		// Criamos o X-50 Saladas, o lanche que vale 20 reais
		Lanche lanche50saladas = new Lanche("X-50 Saladas");
		for (int i = 0; i < 50; i++) 
			lanche50saladas.addIngrediente(modelManager.getMapIngredientes().get("Alface"));
		modelManager.getMapLanches().put(lanche50saladas.getNome(), lanche50saladas);
		
		// Criamos o X-50 Bacons, o lanche que vale 100 reais
		Lanche lanche50bacons = new Lanche("X-50 Bacons");
		for (int i = 0; i < 50; i++) 
			lanche50bacons.addIngrediente(modelManager.getMapIngredientes().get("Bacon"));
		modelManager.getMapLanches().put(lanche50bacons.getNome(), lanche50bacons);
	}
		
	@Test
	public void Lanches() {
		assertEquals(20, modelManager.getMapLanches().get("X-50 Saladas").getValor(), AllTests.variacaoInflacao);
		assertEquals(100, modelManager.getMapLanches().get("X-50 Bacons").getValor(), AllTests.variacaoInflacao);
	}
}
