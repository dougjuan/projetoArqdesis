package test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import To.ToAluno;
import Dao.DaoAluno;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DaoAlunoTest {
	static DaoAluno dao;
	static ToAluno to;
	
	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco
	 * nenhuma linha com o id igual ao do escolhido para o to instanciado
	 * abaixo. Se houver, delete. 
	 * Certifique-se de que o fixture cliente 1 existe no banco.
	 * Certifique-se também que sobrecarregou o equals na classe ToAluno
	 * Além disso, a ordem de execução dos testes é importante; por isso a anotação
	 * FixMethodOrder logo acima do nome desta classe
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		dao = new DaoAluno();
		to = new ToAluno();
		
		to.setNome("Jayminho");
		to.setEndereco("Rua anita Ferraz"); 
		to.setTelefone("(11)3207-2328");								
		to.setEmail("jayminho@bol.com.br");
		to.setRg("33.456.123-9");
		to.setCpf("783.864.032-03");
		to.setLogin("jayminho");
		to.setSenha("123");
		to.setId(3);
	}
	
	@Test
	public void test00Carregar() throws ClassNotFoundException {
		//para funcionar o aluno 1 deve ter sido carregado no banco por fora
		//delete from aluno;
		//insert into aluno(nome, fone, email) values ('nome1', 'fone1', 'email1');
		ToAluno fixture = new ToAluno();
		fixture.setNome("nome1");
		fixture.setEndereco("endereco1"); 
		fixture.setTelefone("telefone1");								
		fixture.setEmail("email1");
		fixture.setRg("rg1");
		fixture.setCpf("cpf1");
		fixture.setLogin("login1");
		fixture.setSenha("senha1");
		fixture.setId(1);
		ToAluno novo = dao.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() throws ClassNotFoundException {
		dao.inserir(to);
		ToAluno novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() throws ClassNotFoundException {
		to.setNome("nome");
		to.setEndereco("endereco"); 
		to.setTelefone("11985234675");								
		to.setEmail("email");
		to.setRg("rg");
		to.setCpf("cpf");
		to.setLogin("login");
		to.setSenha("senha");
		dao.atualizar(to);
		ToAluno novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() throws ClassNotFoundException {
		to.setNome(null);
		to.setEndereco(null); 
		to.setTelefone(null);								
		to.setEmail(null);
		to.setRg(null);
		to.setCpf(null);
		to.setLogin(null);
		to.setSenha(null);
		dao.remover(to);
		ToAluno novo = dao.carregar(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
}

