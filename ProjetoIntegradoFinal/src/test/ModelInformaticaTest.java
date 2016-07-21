package test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Model.ModelArtes;
import Model.ModelInformatica;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModelInformaticaTest{
	ModelInformatica mInformatica, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se tamb√©m que sobrecarregou o equals na classe
	 * ModelInformatica. 
	 * Certifique-se que a fixture mInformatica1 foi criada no banco.
	 * Al√©m disso, a ordem de execu√ß√£o dos testes √© importante; por
	 * isso a anota√ß√£o FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		String dataString = "1111-11-11";
		String dataString2 = "2222-10-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		mInformatica = new ModelInformatica(3, "Redes",dataInicio,dataTermino,"Manh„","50",60.00,"109L","N„o h· softwares registrados");
		copia = new ModelInformatica(3, "Redes",dataInicio,dataTermino,"Manh„","50",60.00,"109L","N„o h· softwares registrados");
	}
	
	@Test
	public void test00Carregar() throws Exception  {
		String dataString = "1111-11-11";
		String dataString2 = "2222-10-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		//para funcionar o mInformatica 1 deve ter sido carregado no banco por fora
		//delete from mInformatica;
		//insert into mInformatica (nome, fone) values ("nome1", "fone1");
		ModelInformatica fixture = new ModelInformatica(1, "nome1",dataInicio, dataTermino,"horario1", "numeroVagas1",60.00, "numeroLaboratorio1","RegistroSoftware1");
		ModelInformatica novo = new ModelInformatica(1, null, null, null, null, null, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() throws ClassNotFoundException{
		mInformatica.criar();
		mInformatica.carregar();
		copia.setId(mInformatica.getId());
		assertEquals("testa criacao", mInformatica, copia);
	}

	@Test
	public void test02Atualizar() {
		mInformatica.setNumLab("110L");
		copia.setNumLab("110L");		
		mInformatica.atualizar();
		assertEquals("testa inclusao", mInformatica, copia);
	}

	@Test
	public void test03Excluir() {
		mInformatica.setNome(null);
		mInformatica.setDataInicio(null);
		mInformatica.setDataTermino(null);
		mInformatica.setHorario(null);
		mInformatica.setVagas(null);
		mInformatica.setValor(null);
		mInformatica.setRegSoft(null);
		mInformatica.setNumLab(null);
		copia.setNome(null);
		copia.setDataInicio(null);
		copia.setDataTermino(null);
		copia.setHorario(null);
		copia.setVagas(null);
		copia.setValor(null);
		copia.setRegSoft(null);
		copia.setNumLab(null);
		mInformatica.excluir();
		assertEquals("testa inclusao", mInformatica, copia);
	}
}