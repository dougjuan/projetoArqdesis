package Model;

import Dao.DaoAluno;
import To.ToAluno;


public class ModelAluno {

	private String nome, endereco, telefone, email, rg, cpf, login, senha;
	private int id;

	public ModelAluno(){

		id = 0;
		nome = "";
		endereco = "";
		telefone = "";
		email = "";	
		rg = "";
		cpf = "";
		login = "";
		senha = "";

	}

	public ModelAluno (int id, String nome , String endereco , String telefone,String email , String rg ,String cpf,String login,String senha){

		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.rg = rg;
		this.cpf = cpf;
		this.login = login;

	}

	//************************* GETS ********************************

	public int getId(){

		return id;

	}

	public String getNome(){

		return nome;

	}

	public String getEndereco(){
		return endereco;
	}

	public String getTelefone(){
		return telefone;
	}

	public String getEmail(){
		return email;
	}

	public String getRg(){
		return rg;
	}

	public String getCpf(){
		return cpf;
	}

	public String getLogin(){
		return login;
	}

	public String getSenha(){
		return senha;
	}

	//************************* GETS ********************************

	//************************* SETS ********************************

	public void setId (int id){

		this.id = id;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setEndereco(String endereco){
		this.endereco = endereco;
	}

	public void setTelefone(String telefone){
		this.telefone = telefone;

	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setRg(String rg){
		this.rg = rg;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public void setLogin(String login){
		this.login = login;
	}

	public void setSenha(String senha){
		this.senha = senha;
	}

	//************************* SETS ********************************


	public void criar() {

		DaoAluno dao = new DaoAluno();		
		ToAluno toAluno = new ToAluno(); 

		toAluno.setNome(nome);
		toAluno.setEndereco(endereco);
		toAluno.setTelefone(telefone);
		toAluno.setEmail(email);
		toAluno.setRg(rg);
		toAluno.setCpf(cpf);
		toAluno.setLogin(login);
		toAluno.setSenha(senha);



		dao.inserir(toAluno); 	

	}
	
	public void atualizar() {
		
		DaoAluno dao = new DaoAluno();
		ToAluno toAluno = new ToAluno();
		
		toAluno.setId(id);		
		toAluno.setNome(nome);
		toAluno.setEndereco(endereco);
		toAluno.setTelefone(telefone);
		toAluno.setEmail(email);
		toAluno.setRg(rg);
		toAluno.setCpf(cpf);
		toAluno.setLogin(login);
		toAluno.setSenha(senha);
		
		dao.atualizar(toAluno);
		}

	
	public void excluir(int id) {
		DaoAluno dao = new DaoAluno();
		ToAluno toAluno = new ToAluno();
		toAluno.setId(id);
		dao.remover(id);
	}
	
	
	



}