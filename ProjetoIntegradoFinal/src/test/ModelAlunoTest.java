package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Model.ModelAluno;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ModelAlunoTest{
	ModelAluno mAluno, copia;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * ModelAluno. 
	 * Certifique-se que a fixture mAluno1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		mAluno = new ModelAluno(3, "Jayminho",	"Rua anita Ferraz",	"(11)3207-2328","jayminho@bol.com.br","	33.456.123-9","783.864.032-03","jayminho","123");
		copia = new ModelAluno(3, "Jayminho",	"Rua anita Ferraz",	"(11)3207-2328","jayminho@bol.com.br","	33.456.123-9","783.864.032-03","jayminho","123");
	}
	
	@Test
	public void test00Carregar() throws ClassNotFoundException  {
		//para funcionar o mAluno 1 deve ter sido carregado no banco por fora
		//delete from mAluno;
		//insert into mAluno (nome, fone) values ('nome1', 'fone1');
		ModelAluno fixture = new ModelAluno(1, "nome1", "endereco1", "telefone1","email1", "rg1", "cpf1", "login1","senha1");
		ModelAluno novo = new ModelAluno(1, null, null, null, null, null, null, null, null);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() throws ClassNotFoundException{
		mAluno.criar();
		mAluno.carregar();
		copia.setId(mAluno.getId());
		assertEquals("testa criacao", mAluno, copia);
	}

	@Test
	public void test02Atualizar() {
		mAluno.setTelefone("(11)3207-2355");
		copia.setTelefone("(11)3207-2355");		
		mAluno.atualizar();
		assertEquals("testa inclusao", mAluno, copia);
	}

	@Test
	public void test03Excluir() {
		mAluno.setNome(null);
		mAluno.setEndereco(null);
		mAluno.setTelefone(null);
		mAluno.setEmail(null);
		mAluno.setRg(null);
		mAluno.setCpf(null);
		mAluno.setLogin(null);
		mAluno.setSenha(null);
		copia.setNome(null);
		copia.setEndereco(null);
		copia.setTelefone(null);
		copia.setEmail(null);
		copia.setRg(null);
		copia.setCpf(null);
		copia.setLogin(null);
		copia.setSenha(null);
		mAluno.excluir();
		assertEquals("testa inclusao", mAluno, copia);
	}
}