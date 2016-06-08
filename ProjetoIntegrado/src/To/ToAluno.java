package To;

public class ToAluno {
	
		private String nome, endereco, telefone, email, rg, cpf, login, senha;
		private int id;

		
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

	}


