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
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ToAluno other = (ToAluno) obj;
			
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			
			if (endereco == null) {
				if (other.endereco != null)
					return false;
			} else if (!endereco.equals(other.endereco))
				return false;
			
			if (telefone == null) {
				if (other.telefone != null)
					return false;
			} else if (!telefone.equals(other.telefone))
				return false;
			
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			
			if (id != other.id)
				return false;
			
			if (rg == null) {
				if (other.rg != null)
					return false;
			} else if (!rg.equals(other.rg))
				return false;
			
			if (cpf == null) {
				if (other.cpf != null)
					return false;
			} else if (!cpf.equals(other.cpf))
				return false;
			
			if (login == null) {
				if (other.login != null)
					return false;
			} else if (!login.equals(other.login))
				return false;
			
			if (senha == null) {
				if (other.senha != null)
					return false;
			} else if (!senha.equals(other.senha))
				return false;
			
			return true;
		}
		//************************* SETS ********************************

}


