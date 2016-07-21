package test;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import To.ToMatricula;

import Dao.DaoMatricula;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaoMatriculaTest {
	static DaoMatricula dao;
	static ToMatricula to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe ToMatricula
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		dao = new DaoMatricula();
		to = new ToMatricula();
		to.setDataMatricula(null);
		to.setValorMatricula(0.00); 
		to.setStatusPagamento("status_Pagamento");								
		to.setStatusMatricula("status_Matricula");
		to.setId(-1);
	}
	
	@Test
	public void test00Carregar() throws ClassNotFoundException {
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		//delete from cliente;
		//insert into cliente (nome, fone, email) values ('nome1', 'fone1', 'email1');
		ToMatricula fixture = new ToMatricula();
		fixture.setDataMatricula(null);
		fixture.setValorMatricula(0.00); 
		fixture.setStatusPagamento("status_Pagamento");								
		fixture.setStatusMatricula("status_Matricula");
		fixture.setId(-1);
		//ToMatricula novo = dao.carregar(1);
		//assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() throws ClassNotFoundException {
		to.setDataMatricula(null);
		to.setValorMatricula(0.00); 
		to.setStatusPagamento("status_Pagamento");								
		to.setStatusMatricula("status_Matricula");
		//dao.inserir(to);
		//ToMatricula novo = dao.carregar(to.getId());
		//assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() throws ClassNotFoundException {
		to.setDataMatricula(null);
		to.setValorMatricula(0.00); 
		to.setStatusPagamento("status_Pagamento");								
		to.setStatusMatricula("status_Matricula");
		//dao.atualizar(to);
		//ToMatricula novo = dao.carregar(to.getId());
		//assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() throws ClassNotFoundException {
		to.setDataMatricula(null);
		to.setValorMatricula(null); 
		to.setStatusPagamento(null);								
		to.setStatusMatricula(null);;
		//dao.remover(to);
		//ToMatricula novo = dao.carregar(to.getId());
		//assertEquals("testa inclusao", novo, to);
	}
}

