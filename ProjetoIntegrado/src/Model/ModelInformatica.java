package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Dao.DaoInformatica;
import To.ToInformatica;

public class ModelInformatica {

		private String nome, horario, vagas, numLab, regSoft;
		Double valor;
		Date dataInicio, dataTermino;
		private int id;


		public ModelInformatica(){

			id = 0;
			nome = "";
			dataInicio = null;
			dataTermino = null;
			horario = "";	
			vagas = "";
			valor = null;
			numLab = "";
			regSoft = "";
			


		}
		
		public ModelInformatica(int id, String nome, Date dataInicio, Date dataTermino, String horario, String vagas, Double valor, String numLab, String regSoft){

			this.id = id;
			this.nome = nome;
			this.dataInicio = dataInicio;
			this.dataTermino = dataTermino;
			this.horario = horario;
			this.vagas = vagas;
			this.valor = valor;
			this.numLab = numLab;
			this.regSoft = regSoft;
			
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
		
		public String getNumLab(){
			return numLab;
		}
		
		public String getRegSoft(){
			return regSoft;
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
		
		public void setNumLab(String numLab){
			this.numLab = numLab;
		}
		
		public void setRegSoft (String regSoft){
			this.regSoft = regSoft;
		}

		//************************* SETS ********************************


		
		public void criar() {

			DaoInformatica dao = new DaoInformatica();		
			ToInformatica toInformatica = new ToInformatica(); 
			
			
			toInformatica.setNome(nome);
			toInformatica.setDataInicio(dataInicio);
			toInformatica.setDataTermino(dataTermino);
			toInformatica.setHorario(horario);
			toInformatica.setVagas(vagas);
			toInformatica.setValor(valor);
			toInformatica.setNumLab(numLab);
			toInformatica.setRegSoft(regSoft);

			dao.inserir(toInformatica); 	

		}
		
		public void atualizar() {

			DaoInformatica dao = new DaoInformatica();		
			ToInformatica toInformatica = new ToInformatica(); 
			
			toInformatica.setId(id);
			toInformatica.setNome(nome);
			toInformatica.setDataInicio(dataInicio);
			toInformatica.setDataTermino(dataTermino);
			toInformatica.setHorario(horario);
			toInformatica.setVagas(vagas);
			toInformatica.setValor(valor);
			toInformatica.setNumLab(numLab);
			toInformatica.setRegSoft(regSoft);

			dao.atualizar(toInformatica); 	

		}
		
		public void excluir(int id) {
			DaoInformatica dao = new DaoInformatica();
			ToInformatica toInformatica = new ToInformatica();
			toInformatica.setId(id);
			dao.remover(id);
		}
		
		public void carregar(int num) {
			
			ToInformatica toInformatica = new ToInformatica();
			
			DaoInformatica dao = new DaoInformatica();
			
			toInformatica = dao.getInformaticaById(num);
			
			id = toInformatica.getId();
			nome = toInformatica.getNome();
			dataInicio = toInformatica.getDataInicio();
			dataTermino = toInformatica.getDataTermino();
			horario = toInformatica.getHorario();
			vagas = toInformatica.getVagas();
			valor = toInformatica.getValor();
			numLab = toInformatica.getNumLab();
			regSoft = toInformatica.getRegSoft();
			
		}
		

		public static java.sql.Date formataData(String data) throws Exception {   
			if (data == null || data.equals(""))  
				return null;  

			java.sql.Date date = null;  
			try {  
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
				date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
			} catch (ParseException e) { 
				throw e; 
			}  
			return date;  
		}  

		
		
		

	}


