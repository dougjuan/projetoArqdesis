package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import To.ToInformatica;

public class ToInformaticaTest {
	ToInformatica to;
	@Before
	public void setUp() throws Exception {
		to = new ToInformatica();
		to.setNome("Pintura");
		to.setDataInicio(null); 
		to.setDataTermino(null);								
		to.setHorario("18h");
		to.setVagas("20");
		to.setValor(null);
		to.setNumLab("l108");
		to.setRegSoft("windows");
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
		assertEquals("getNumLab", to.getNumLab(), "l108");
		assertEquals("getRegSoft", to.getRegSoft(), "windows");
		assertEquals("getId", to.getId(), 3);
	}
	
	@Test
	public void testEquals(){
		ToInformatica copia = new ToInformatica();
		copia.setNome(to.getNome());
		copia.setDataInicio(to.getDataInicio());
		copia.setDataTermino(to.getDataTermino());
		copia.setHorario(to.getHorario());
		copia.setVagas(to.getVagas());
		copia.setValor(to.getValor());
		copia.setNumLab(to.getNumLab());
		copia.setRegSoft(to.getRegSoft());
		copia.setId(to.getId());
		assertEquals("teste to igual a copia", to, copia);
	}

}
