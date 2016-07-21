package Model;

import java.sql.Date;

public class ModelMatricula {
	
	Date dataMatricula;
	Double valorMatricula;
	private String statusPagamento,statusMatricula;
	private int id;

	public ModelMatricula(){

		id = 0;
		dataMatricula = null;
		valorMatricula = 0.0;
		statusPagamento = "";
		statusMatricula = "";	

	}
	public ModelMatricula (int id, Date dataMatricula , Double valorMatricula , String statusPagamento,String statusMatricula ){

		this.id = id;
		this.dataMatricula = dataMatricula;
		this.valorMatricula = valorMatricula;
		this.statusPagamento = statusPagamento;
		this.statusMatricula = statusMatricula;

	}


	//************************* GETS ********************************

	public int getId(){
		return id;
	}

	public Date getDataMatricula(){
		return dataMatricula;
	}

	public Double getValorMatricula(){
		return valorMatricula;
	}

	public String getStatusPagamento(){
		return statusPagamento;
	}

	public String getStatusMatricula(){
		return statusMatricula;
	}

	//************************* GETS ********************************

	//************************* SETS ********************************

	public void setId(int id){

		this.id = id;

	}

	public void setDataMatricula(Date date){
		this.dataMatricula = date;
	}

	public void setValorMatricula(Double valorMatricula2){
		this.valorMatricula = valorMatricula2;
	}

	public void setStatusPagamento(String statusPagamento){
		this.statusPagamento = statusPagamento;

	}

	public void setStatusMatricula(String statusMatricula){
		this.statusMatricula = statusMatricula;
	}

	//************************* SETS ********************************


}












