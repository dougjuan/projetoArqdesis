package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import To.ToMatricula;

public class ToMatriculaTest {
	ToMatricula to;
	
	@Before
	public void setUp() throws Exception {
		to = new ToMatricula();
		to.setDataMatricula(null);
		to.setValorMatricula(null); 
		to.setStatusPagamento("Aprovado");								
		to.setStatusMatricula("Matriculado");
		to.setId(3);
	}

	@Test
	public void testGets() {
		assertEquals("getDataMatricula", to.getDataMatricula(), null);
		assertEquals("getValorMatricula", to.getValorMatricula(), null);
		assertEquals("getStatusPagamento", to.getStatusPagamento(), "Aprovado");
		assertEquals("getStatusMatricula", to.getStatusMatricula(), "Matriculado");
		assertEquals("getId", to.getId(), 3);
	}
	
	@Test
	public void testEquals(){
		ToMatricula copia = new ToMatricula();
		copia.setDataMatricula(to.getDataMatricula());
		copia.setValorMatricula(to.getValorMatricula());
		copia.setStatusPagamento(to.getStatusPagamento());
		copia.setStatusMatricula(to.getStatusMatricula());
		copia.setId(to.getId());
		assertEquals("teste to igual a copia", to, copia);
	}

}
