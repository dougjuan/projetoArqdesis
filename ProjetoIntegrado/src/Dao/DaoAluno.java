package Dao;
import ConnectionFactory.FabricaConexao;



import To.ToAluno;


import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 


public class DaoAluno {

	
	public void inserir(ToAluno toAluno) throws ClassNotFoundException {
		
		String sqlInsert = "INSERT INTO ALUNO (NOME, ENDERECO, TELEFONE, EMAIL, RG, CPF, LOGIN, SENHA) VALUES (?,?,?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {


			stm.setString(1,toAluno.getNome());
			stm.setString(2,toAluno.getEndereco());
			stm.setString(3,toAluno.getTelefone());
			stm.setString(4,toAluno.getEmail());
			stm.setString(5,toAluno.getRg());
			stm.setString(6,toAluno.getCpf());
			stm.setString(7,toAluno.getLogin());
			stm.setString(8,toAluno.getSenha());
			
			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toAluno.setId(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(ToAluno toAluno) {
		String sqlUpdate = "UPDATE ALUNO SET NOME = ?, ENDERECO= ?, TELEFONE= ?, EMAIL= ?, RG= ?, CPF= ?, LOGIN= ?, SENHA= ? WHERE COD_ALUNO = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1,toAluno.getNome());
			stm.setString(2,toAluno.getEndereco());
			stm.setString(3,toAluno.getTelefone());
			stm.setString(4,toAluno.getEmail());
			stm.setString(5,toAluno.getRg());
			stm.setString(6,toAluno.getCpf());
			stm.setString(7,toAluno.getLogin());
			stm.setString(8,toAluno.getSenha());
			stm.setInt(9,toAluno.getId());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(ToAluno toAluno) {
		String sqlDelete = "DELETE FROM ALUNO WHERE cod_Aluno =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toAluno.getId());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ToAluno carregar(int id) throws ClassNotFoundException {
		ToAluno toAluno = new ToAluno();
		toAluno.setId(id);
		String sqlSelect = "SELECT * FROM ALUNO WHERE cod_Aluno=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					toAluno.setId(rs.getInt("cod_Aluno"));
					toAluno.setNome(rs.getString("nome"));
					toAluno.setEndereco(rs.getString("endereco")); 
					toAluno.setTelefone(rs.getString("telefone"));								
					toAluno.setEmail(rs.getString("email"));
					toAluno.setRg(rs.getString("rg"));
					toAluno.setCpf(rs.getString("cpf"));
					toAluno.setLogin(rs.getString("login"));
					toAluno.setSenha(rs.getString("senha"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toAluno;
	}
	
	
	public ArrayList<ToAluno> listarAlunos() throws ClassNotFoundException {
		ToAluno toAluno;
		ArrayList<ToAluno> lista = new ArrayList<>();
		String sqlSelect = "SELECT *  FROM ALUNO";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAluno = new ToAluno();
					
					
					toAluno.setId(rs.getInt("cod_Aluno"));
					toAluno.setNome(rs.getString("nome"));
					toAluno.setEndereco(rs.getString("endereco")); 
					toAluno.setTelefone(rs.getString("telefone"));								
					toAluno.setEmail(rs.getString("email"));
					toAluno.setRg(rs.getString("rg"));
					toAluno.setCpf(rs.getString("cpf"));
					toAluno.setLogin(rs.getString("login"));
					toAluno.setSenha(rs.getString("senha"));
					
					
					lista.add(toAluno);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<ToAluno> listarAlunos(String chave) throws ClassNotFoundException {
		ToAluno toAluno;
		ArrayList<ToAluno> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM ALUNO WHERE UPPER (NOME) LIKE ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAluno = new ToAluno();

					toAluno.setId(rs.getInt("cod_Aluno"));
					toAluno.setNome(rs.getString("nome"));
					toAluno.setEndereco(rs.getString("endereco")); 
					toAluno.setTelefone(rs.getString("telefone"));								
					toAluno.setEmail(rs.getString("email"));
					toAluno.setRg(rs.getString("rg"));
					toAluno.setCpf(rs.getString("cpf"));
					toAluno.setLogin(rs.getString("login"));
					toAluno.setSenha(rs.getString("senha"));
					
					
					lista.add(toAluno);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}
