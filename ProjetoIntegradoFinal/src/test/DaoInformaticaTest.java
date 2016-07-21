package test;



import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import To.ToInformatica;

import Dao.DaoInformatica;
import Model.ModelArtes;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaoInformaticaTest {
	static DaoInformatica dao;
	static ToInformatica to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe ToInformatica
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		String dataString = "1111-11-11";
		String dataString2 = "2222-10-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		
		dao = new DaoInformatica();
		to = new ToInformatica();
		to.setNome("nome");
		to.setDataInicio(dataInicio); 
		to.setDataTermino(dataTermino);								
		to.setHorario("horario");
		to.setVagas("numeroVagas");
		to.setValor(60.00);
		to.setNumLab("numeroLaboratorio");
		to.setRegSoft("RegistrodeSoftware");
		to.setId(-1);
	}
	
	@Test
	public void test00Carregar() throws Exception {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone, email) values ('nome1', 'fone1', 'email1');
		String dataString = "1111-11-11";
		String dataString2 = "2222-10-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		ToInformatica fixture = new ToInformatica();
		fixture.setNome("nome1");
		fixture.setDataInicio(dataInicio); 
		fixture.setDataTermino(dataTermino);								
		fixture.setHorario("horario1");
		fixture.setVagas("numeroVagas1");
		fixture.setValor(60.00);
		fixture.setNumLab("numeroLaboratorio1");
		fixture.setRegSoft("RegistroSoftware1");
		fixture.setId(1);
		ToInformatica novo = dao.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() throws Exception {
		String dataString = "1111-11-11";
		String dataString2 = "2222-10-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		to.setNome("nome");
		to.setDataInicio(dataInicio); 
		to.setDataTermino(dataTermino);								
		to.setHorario("horario");
		to.setVagas("numeroVagas");
		to.setValor(60.00);
		to.setNumLab("numeroLaboratorio");
		to.setRegSoft("RegistrodeSoftware");
		dao.inserir(to);
		ToInformatica novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() throws Exception {
		String dataString = "1111-11-11";
		String dataString2 = "2222-10-22";
		Date dataInicio = null;
		Date dataTermino = null;
		dataInicio = ModelArtes.formataData(dataString);
		dataTermino = ModelArtes.formataData(dataString2);
		to.setNome("nome");
		to.setDataInicio(dataInicio); 
		to.setDataTermino(dataTermino);								
		to.setHorario("horario");
		to.setVagas("numeroVagas");
		to.setValor(60.00);
		to.setNumLab("numeroLaboratorio");
		to.setRegSoft("RegistrodeSoftware");
		dao.atualizar(to);
		ToInformatica novo = dao.carregar(to.getId());
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
		to.setNumLab(null);
		to.setRegSoft(null);
		dao.remover(to);
		ToInformatica novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
}

