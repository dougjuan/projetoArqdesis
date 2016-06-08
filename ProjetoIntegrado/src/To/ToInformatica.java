package To;

import java.sql.Date;

public class ToInformatica {
	
	private String nome, horario, vagas, numLab, regSoft;
	Double valor;
	Date dataInicio, dataTermino;
	private int id;

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



}
