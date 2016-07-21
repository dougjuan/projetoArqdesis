package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import To.ToAluno;

public class ToAlunoTest {
	ToAluno to;
	@Before
	public void setUp() throws Exception {
		to = new ToAluno();
		to.setNome("Maurice");
		to.setEndereco("Rua Goiatá"); 
		to.setTelefone("(11)3453-9762");								
		to.setEmail("maurice@yahoo.com.br");
		to.setRg("67.474.110-6");
		to.setCpf("341.863.022-02");
		to.setLogin("maurice");
		to.setSenha("kkkk");
		to.setId(2);
	}

	@Test
	public void testGets() {
		assertEquals("getNome", to.getNome(), "Maurice");
		assertEquals("getEndereco", to.getEndereco(), "Rua Goiatá");
		assertEquals("getTelefone", to.getTelefone(), "(11)3453-9762");
		assertEquals("getEmail", to.getEmail(), "maurice@yahoo.com.br");
		assertEquals("getRg", to.getRg(), "67.474.110-6");
		assertEquals("getCpf", to.getCpf(), "341.863.022-02");
		assertEquals("getLogin", to.getLogin(), "maurice");
		assertEquals("getSenha", to.getSenha(), "kkkk");
		assertEquals("getId", to.getId(), 2);
	}
	
	@Test
	public void testEquals(){
		ToAluno copia = new ToAluno();
		copia.setNome(to.getNome());
		copia.setEndereco(to.getEndereco());
		copia.setTelefone(to.getTelefone());
		copia.setEmail(to.getEmail());
		copia.setRg(to.getRg());
		copia.setCpf(to.getCpf());
		copia.setLogin(to.getLogin());
		copia.setSenha(to.getSenha());
		copia.setId(to.getId());
		assertEquals("teste to igual a copia", to, copia);
	}

}
