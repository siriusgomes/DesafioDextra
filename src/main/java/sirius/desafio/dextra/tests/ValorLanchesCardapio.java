package sirius.desafio.dextra.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import sirius.desafio.dextra.model.ModelManager;

public class ValorLanchesCardapio {
	
	// Basicamente o BD da aplicação. Ao instanciá-lo, já são criados os ingredientes e lanches do enunciado do desafio.
	private ModelManager modelManager = null;
	
	
	@Before 
	public void beforeTest() {
		modelManager = new ModelManager();
	}
		
	@Test
	public void Lanches() {
		assertEquals(6.5, modelManager.getMapLanches().get("X-Bacon").getValor(), AllTests.variacaoInflacao);
		assertEquals(4.5, modelManager.getMapLanches().get("X-Burger").getValor(), AllTests.variacaoInflacao);
		assertEquals(5.3, modelManager.getMapLanches().get("X-Egg").getValor(), AllTests.variacaoInflacao);
		assertEquals(7.3, modelManager.getMapLanches().get("X-Egg Bacon").getValor(), AllTests.variacaoInflacao);
	}

	
}
