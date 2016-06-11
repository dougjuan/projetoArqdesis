package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Dao.DaoArtes;
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

	public void criar() throws ClassNotFoundException {

		DaoArtes dao = new DaoArtes();		
		ToArtes toArtes = getToArtes();
		dao.inserir(toArtes); 	
		this.id = toArtes.getId();

	}

	public ToArtes getToArtes() {
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
		return toArtes;
	}

	public void atualizar() {

		DaoArtes dao = new DaoArtes();		
		ToArtes toArtes = getToArtes();

		dao.atualizar(toArtes); 	

	}

	public void excluir() {
		DaoArtes dao = new DaoArtes();
		ToArtes toArtes = new ToArtes();
		toArtes.setId(id);
		dao.remover(toArtes);
	}

	
	
	
	public void carregar() throws ClassNotFoundException {

		ToArtes toArtes = new ToArtes();
		
		DaoArtes dao = new DaoArtes();
		
		toArtes = dao.carregar(id);

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
	

	public static java.sql.Date formataData(String data) throws Exception {   
		if (data == null || data.equals(""))  
			return null;  

		java.sql.Date date = null;  
		try {  
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
		} catch (ParseException e) { 
			throw e; 
		}  
		return date;  
	}  
	
	
	
	public ArrayList<ToArtes> listarArtes() throws ClassNotFoundException{
		ArrayList<ToArtes> lista;
		DaoArtes dao = new DaoArtes();
		lista = dao.listarArtes();
		return lista;
	}
	public ArrayList<ToArtes> listarArtes(String chave) throws ClassNotFoundException{
		ArrayList<ToArtes> lista;
		DaoArtes dao = new DaoArtes();
		lista = dao.listarArtes(chave);
		return lista;
	}

	
	
	
	
	

}
