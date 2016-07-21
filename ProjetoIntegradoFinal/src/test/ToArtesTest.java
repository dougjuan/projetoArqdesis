package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import To.ToArtes;

public class ToArtesTest {
	ToArtes to;
	@Before
	public void setUp() throws Exception {
		to = new ToArtes();
		to.setNome("Pintura");
		to.setDataInicio(null); 
		to.setDataTermino(null);								
		to.setHorario("18h");
		to.setVagas("20");
		to.setValor(null);
		to.setDescMat("pincel");
		to.setLivros("ArteModerna");
		to.setId(3);
	}

	@Test
	public void testGets() {
		assertEquals("getNome", to.getNome(), "Pintura");
		assertEquals("getDataInicio", to.getDataInicio(), null);
		assertEquals("getDataTermino", to.getDataTermino(), null);
		assertEquals("getHorario", to.getHorario(), "18h");
		assertEquals("getVagas", to.getVagas(), "20");
		assertEquals("getValor", to.getValor(), null);
		assertEquals("getDescMat", to.getDescMat(), "pincel");
		assertEquals("getLivros", to.getLivros(), "ArteModerna");
		assertEquals("getId", to.getId(), 3);
	}
	
	@Test
	public void testEquals(){
		ToArtes copia = new ToArtes();
		copia.setNome(to.getNome());
		copia.setDataInicio(to.getDataInicio());
		copia.setDataTermino(to.getDataTermino());
		copia.setHorario(to.getHorario());
		copia.setVagas(to.getVagas());
		copia.setValor(to.getValor());
		copia.setDescMat(to.getDescMat());
		copia.setLivros(to.getLivros());
		copia.setId(to.getId());
		assertEquals("teste to igual a copia", to, copia);
	}
	

}
