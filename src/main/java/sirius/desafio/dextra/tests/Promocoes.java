
package sirius.desafio.dextra.tests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import sirius.desafio.dextra.model.Lanche;
import sirius.desafio.dextra.model.ModelManager;

public class Promocoes {
	
	// Basicamente o BD da aplicação. Ao instanciá-lo, já são criados os ingredientes e lanches do enunciado do desafio.
	private ModelManager modelManager = null;
	
	
	@Before 
	public void beforeTest() {
		// Criamos os lanches e ingredientes padrões para testarmos as promoções
		modelManager = new ModelManager(); 
		
		// Criamos o X-Salada, o lanche da promoção "light"
		Lanche lanchePromoLight = new Lanche("X-Salada");
		lanchePromoLight.addIngrediente(modelManager.getMapIngredientes().get("Alface"));
		lanchePromoLight.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoLight.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		modelManager.getMapLanches().put(lanchePromoLight.getNome(), lanchePromoLight);
		
		// Criamos o X-Burger Triplo, o lanche da promoção "muita carne" e light ao mesmo tempo
		Lanche lanchePromoMuitaCarne = new Lanche("X-Burguer Triplo");
		lanchePromoMuitaCarne.addIngrediente(modelManager.getMapIngredientes().get("Alface"));
		lanchePromoMuitaCarne.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoMuitaCarne.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoMuitaCarne.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoMuitaCarne.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));	
		modelManager.getMapLanches().put(lanchePromoMuitaCarne.getNome(), lanchePromoMuitaCarne);
		
	
		// Criamos o X-Queijo, o lanche da promoção "muito queijo" 
		Lanche lanchePromoMuitoQueijo = new Lanche("X-Queijo");
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoMuitoQueijo.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		modelManager.getMapLanches().put(lanchePromoMuitoQueijo.getNome(), lanchePromoMuitoQueijo);
		
		
		// Criamos o X-Monstro, o lanche que vai pegar todas as promoções.
		Lanche lanchePromoTodas = new Lanche("X-Monstro");
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Alface"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Alface"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Bacon"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Bacon"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Bacon"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Ovo"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Ovo"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Ovo"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Hamburguer de Carne"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		lanchePromoTodas.addIngrediente(modelManager.getMapIngredientes().get("Queijo"));
		modelManager.getMapLanches().put(lanchePromoTodas.getNome(), lanchePromoTodas);
		
	}
		
	@Test
	public void Lanches() {
		assertEquals(4.41, modelManager.getMapLanches().get("X-Salada").getValor(), AllTests.variacaoPromocao);
		assertEquals(7.11, modelManager.getMapLanches().get("X-Burguer Triplo").getValor(), AllTests.variacaoPromocao);
		assertEquals(12, modelManager.getMapLanches().get("X-Queijo").getValor(), AllTests.variacaoPromocao);
		assertEquals(27.2, modelManager.getMapLanches().get("X-Monstro").getValor(), AllTests.variacaoPromocao);
	}

	
}
