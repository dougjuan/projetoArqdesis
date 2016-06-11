package Model;


import java.util.ArrayList;
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
		this.senha = senha;

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


	public void criar() throws ClassNotFoundException {

		DaoAluno dao = new DaoAluno();		
		ToAluno toAluno = getTO();
		dao.inserir(toAluno); 
		this.id = toAluno.getId();

	}
	
	

	public ToAluno getTO() {
		
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
		
		return toAluno;
	}

	public void atualizar() {

		DaoAluno dao = new DaoAluno();
		ToAluno toAluno = getTO();
		dao.atualizar(toAluno);
	}


	public void excluir() {
		DaoAluno dao = new DaoAluno();
		ToAluno toAluno = new ToAluno();
		toAluno.setId(id);
		dao.remover(toAluno);
	}

	public void carregar() throws ClassNotFoundException {

	

		DaoAluno dao = new DaoAluno();

		ToAluno toAluno = dao.carregar(id);

		id = toAluno.getId();	
		nome = toAluno.getNome();
		endereco = toAluno.getEndereco();
		telefone = toAluno.getTelefone();
		email = toAluno.getEmail();
		rg = toAluno.getRg();
		cpf = toAluno.getCpf();
		login = toAluno.getLogin();
		senha = toAluno.getSenha();



	}
	
	public ArrayList<ToAluno> listarAlunos() throws ClassNotFoundException{
		ArrayList<ToAluno> lista;
		DaoAluno dao = new DaoAluno();
		lista = dao.listarAlunos();
		return lista;
	}
	public ArrayList<ToAluno> listarAlunos(String chave) throws ClassNotFoundException{
		ArrayList<ToAluno> lista;
		DaoAluno dao = new DaoAluno();
		lista = dao.listarAlunos(chave);
		return lista;
	}








}