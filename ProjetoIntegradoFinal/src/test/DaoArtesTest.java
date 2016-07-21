package test;



import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import To.ToArtes;

import Dao.DaoArtes;
import Model.ModelArtes;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaoArtesTest {
	static DaoArtes dao;
	static ToArtes to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe ToArtes
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		
		String dataString = "1111-11-11";
		String dataString2 = "2222-22-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		
		dao = new DaoArtes();
		to = new ToArtes();
		to.setNome("nome");
		to.setDataInicio(dataInicio); 
		to.setDataTermino(dataTermino);								
		to.setHorario("horario");
		to.setVagas("numeroVagas");
		to.setValor(null);
		to.setDescMat("descMaterial");
		to.setLivros("nomeLivro");
		to.setId(-1);
	}
	
	@Test
	public void test00Carregar() throws Exception {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone, email) values ('nome1', 'fone1', 'email1');
		String dataString = "1111-11-11";
		String dataString2 = "2222-22-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		
		ToArtes fixture = new ToArtes();
		fixture.setNome("nome1");
		fixture.setDataInicio(dataInicio); 
		fixture.setDataTermino(dataTermino);								
		fixture.setHorario("horario1");
		fixture.setVagas("numeroVagas1");
		fixture.setValor(50.00);
		fixture.setDescMat("descMaterial1");
		fixture.setLivros("nomeLivro1");
		fixture.setId(1);
		ToArtes novo = dao.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() throws Exception {
		String dataString = "1111-11-11";
		String dataString2 = "2222-22-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		to.setNome("nome");
		to.setDataInicio(dataInicio); 
		to.setDataTermino(dataTermino);								
		to.setHorario("horario");
		to.setVagas("numeroVagas");
		to.setValor(50.00);
		to.setDescMat("descMaterial");
		to.setLivros("nomeLivro");
		dao.inserir(to);
		ToArtes novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() throws Exception {
		String dataString = "1111-11-11";
		String dataString2 = "2222-22-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		to.setNome("nome");
		to.setDataInicio(dataInicio); 
		to.setDataTermino(dataTermino);								
		to.setHorario("horario");
		to.setVagas("numeroVagas");
		to.setValor(50.00);
		to.setDescMat("descMaterial");
		to.setLivros("nomeLivro");
		dao.atualizar(to);
		ToArtes novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() throws ClassNotFoundException {
		to.setNome(null);
		to.setDataInicio(null); 
		to.setDataTermino(null);								
		to.setHorario(null);
		to.setVagas(null);
		to.setValor(null);
		to.setDescMat(null);
		to.setLivros(null);
		dao.remover(to);
		ToArtes novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
}

