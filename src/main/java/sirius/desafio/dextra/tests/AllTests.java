package sirius.desafio.dextra.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ValorLanchesCardapio.class, CalculoPreco.class, Promocoes.class })
public class AllTests {

	public final static double variacaoInflacao = 0.5; // Valor máximo de diferença dos testes de valores dos lanches conforme requisito de inflação.
	public final static double variacaoPromocao = 0.1; // menor para testar a efetividade do calculo das promoções.
	
}
