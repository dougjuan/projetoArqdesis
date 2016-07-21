package test;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import Model.ModelArtes;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModelArtesTest{
	ModelArtes mArtes, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se tambÃ©m que sobrecarregou o equals na classe
	 * ModelArtes. 
	 * Certifique-se que a fixture mArtes1 foi criada no banco.
	 * AlÃ©m disso, a ordem de execuÃ§Ã£o dos testes Ã© importante; por
	 * isso a anotaÃ§Ã£o FixMethodOrder logo acima do nome desta classe
	 */
	
	@Before
	public void setUp() throws Exception {
		
		String dataString = "1111-11-11";
		String dataString2 = "2222-22-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		
		mArtes = new ModelArtes(3, "Artes cênicas",dataInicio,dataTermino,"Manhã","50",50.00,"Sem especificações","Arte, corpo e alma");
		copia = new ModelArtes(3, "Artes cênicas",dataInicio,dataTermino,"Manhã","50",50.00,"Sem especificações","Arte, corpo e alma");
	}
	
	@Test
	public void test00Carregar() throws Exception  {
		
		String dataString = "1111-11-11";
		String dataString2 = "2222-22-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		//para funcionar o mArtes 1 deve ter sido carregado no banco por fora
		//delete from mArtes;
		//insert into mArtes (nome, fone) values ("nome1", "fone1");
		ModelArtes fixture = new ModelArtes(1, "nome1", dataInicio, dataTermino,"horario1", "numeroVagas1",50.00, "descMaterial1","nomeLivro1");
		ModelArtes novo = new ModelArtes(1, null, null, null, null, null, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() throws ClassNotFoundException{
		mArtes.criar();
		mArtes.carregar();
		copia.setId(mArtes.getId());
		assertEquals("testa criacao", mArtes, copia);
	}

	@Test
	public void test02Atualizar() {
		mArtes.setLivros("Game of Thrones");
		copia.setLivros("Game of Thrones");		
		mArtes.atualizar();
		assertEquals("testa inclusao", mArtes, copia);
	}

	@Test
	public void test03Excluir() {
		mArtes.setNome(null);
		mArtes.setDataInicio(null);
		mArtes.setDataTermino(null);
		mArtes.setHorario(null);
		mArtes.setVagas(null);
		mArtes.setValor(null);
		mArtes.setDescMat(null);
		mArtes.setLivros(null);
		copia.setNome(null);
		copia.setDataInicio(null);
		copia.setDataTermino(null);
		copia.setHorario(null);
		copia.setVagas(null);
		copia.setValor(null);
		copia.setDescMat(null);
		copia.setLivros(null);
		mArtes.excluir();
		assertEquals("testa inclusao", mArtes, copia);
	}
}