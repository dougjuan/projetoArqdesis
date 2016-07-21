package To;

import java.sql.Date;

public class ToMatricula {
	
	Date dataMatricula;
	Double valorMatricula;
	private String statusPagamento,statusMatricula;
	private int id;
	

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
