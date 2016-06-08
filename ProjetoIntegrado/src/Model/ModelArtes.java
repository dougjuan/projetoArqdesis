package Model;

import java.sql.Date;
import java.util.ArrayList;

import Dao.DaoAluno;
import Dao.DaoArtes;
import To.ToAluno;
import To.ToArtes;

public class ModelArtes {

	private int id;
	private String nome, horario, vagas, descMat, livros;
	Double valor;
	Date dataTermino;
	Date dataInicio;



	public ModelArtes(){

		id = 0;
		nome = "";
		dataInicio = null;
		dataTermino = null;
		horario = "";	
		vagas = "";
		valor = null;
		descMat = "";
		livros = "";



	}

	public ModelArtes(int id, String nome, Date dataInicio, Date dataTermino, String horario, String vagas, Double valor, String descMat, String livros){

		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.horario = horario;
		this.vagas = vagas;
		this.valor = valor;
		this.descMat = descMat;
		this.livros = livros;

	}

	//************************* GETS ********************************

	public int getId(){		
		return id;		
	}

	public String getNome(){
		return nome;
	}

	public Date getDataInicio(){
		return dataInicio;
	}

	public Date getDataTermino(){
		return dataTermino;
	}

	public String getHorario(){
		return horario;
	}

	public String getVagas(){
		return vagas;
	}

	public Double getValor(){
		return valor;
	}

	public String getDescMat(){
		return descMat;
	}

	public String getLivros(){
		return livros;
	}

	//************************* GETS ********************************

	//************************* SETS ********************************

	public void setId (int id){

		this.id = id;

	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public void setDataInicio(Date dataInicio){
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(Date dataTermino){
		this.dataTermino = dataTermino;

	}

	public void setHorario(String horario){
		this.horario = horario;
	}

	public void setVagas(String vagas){
		this.vagas = vagas;
	}

	public void setValor(Double valor){
		this.valor = valor;
	}

	public void setDescMat(String descMat){
		this.descMat = descMat;
	}

	public void setLivros(String livros){
		this.livros = livros;
	}

	public void criar() {

		DaoArtes dao = new DaoArtes();		
		ToArtes toArtes = new ToArtes(); 


		toArtes.setNome(nome);
		toArtes.setDataInicio(dataInicio);
		toArtes.setDataTermino(dataTermino);
		toArtes.setHorario(horario);
		toArtes.setVagas(vagas);
		toArtes.setValor(valor);
		toArtes.setDescMat(descMat);
		toArtes.setLivros(livros);

		dao.inserir(toArtes); 	

	}

	public void atualizar() {

		DaoArtes dao = new DaoArtes();		
		ToArtes toArtes = new ToArtes(); 

		toArtes.setId(id);
		toArtes.setNome(nome);
		toArtes.setDataInicio(dataInicio);
		toArtes.setDataTermino(dataTermino);
		toArtes.setHorario(horario);
		toArtes.setVagas(vagas);
		toArtes.setValor(valor);
		toArtes.setDescMat(descMat);
		toArtes.setLivros(livros);

		dao.atualizar(toArtes); 	

	}

	public void excluir(int id) {
		DaoArtes dao = new DaoArtes();
		ToArtes toArtes = new ToArtes();
		toArtes.setId(id);
		dao.remover(id);
	}

	public void carregar() {
		
		DaoArtes dao = new DaoArtes();
		ToArtes toArtes = dao.getArtesById(id);
		
		id = toArtes.getId();
		nome = toArtes.getNome();
		dataInicio = toArtes.getDataInicio();
		dataTermino = toArtes.getDataTermino();
		horario = toArtes.getHorario();
		vagas = toArtes.getVagas();
		valor = toArtes.getValor();
		descMat = toArtes.getDescMat();
		livros = toArtes.getLivros();
		
	}





}
