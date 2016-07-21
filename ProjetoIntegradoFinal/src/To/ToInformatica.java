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
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				ToInformatica other = (ToInformatica) obj;
				
				if (nome == null) {
					if (other.nome != null)
						return false;
				} else if (!nome.equals(other.nome))
					return false;
				
				if (dataInicio == null) {
					if (other.dataInicio != null)
						return false;
				} else if (!dataInicio.equals(other.dataInicio))
					return false;
				
				if (dataTermino == null) {
					if (other.dataTermino != null)
						return false;
				} else if (!dataTermino.equals(other.dataTermino))
					return false;
				
				if (horario == null) {
					if (other.horario != null)
						return false;
				} else if (!horario.equals(other.horario))
					return false;
				
				if (id != other.id)
					return false;
				
				if (vagas == null) {
					if (other.vagas != null)
						return false;
				} else if (!vagas.equals(other.vagas))
					return false;
				
				if (valor == null) {
					if (other.valor != null)
						return false;
				} else if (!valor.equals(other.valor))
					return false;
				
				if (numLab == null) {
					if (other.numLab != null)
						return false;
				} else if (!numLab.equals(other.numLab))
					return false;
				
				if (regSoft == null) {
					if (other.regSoft != null)
						return false;
				} else if (!regSoft.equals(other.regSoft))
					return false;
				
				return true;
			}


}
