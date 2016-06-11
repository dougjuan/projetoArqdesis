package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import ConnectionFactory.FabricaConexao;

import To.ToInformatica;

public class DaoInformatica {




	public void inserir(ToInformatica toInformatica) throws ClassNotFoundException {

		String sqlInsert = "INSERT INTO INFORMATICA (NOME, DATAINICIO, DATATERMINO, HORARIO, NUMEROVAGAS, VALOR, NUMEROLABORATORIO, REGISTROSOFTWARE) VALUES (?,?,?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {


			stm.setString(1,toInformatica.getNome());
			stm.setDate(2,toInformatica.getDataInicio());
			stm.setDate(3,toInformatica.getDataTermino());
			stm.setString(4,toInformatica.getHorario());
			stm.setString(5,toInformatica.getVagas());
			stm.setDouble(6,toInformatica.getValor());
			stm.setString(7,toInformatica.getNumLab());
			stm.setString(8,toInformatica.getRegSoft());


			stm.execute();

			String sqlSelect = "SELECT LAST_INSERT_ID()";

			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
				if(rs.next()){
					toInformatica.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(ToInformatica toInformatica) {
		String sqlUpdate = "UPDATE INFORMATICA SET NOME = ?, DATAINICIO= ?, DATATERMINO = ?, HORARIO= ?, NUMEROVAGAS= ?, VALOR= ?, NUMEROLABORATORIO = ?, REGISTROSOFTWARE = ? WHERE COD_INFORMATICA = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

			stm.setString(1,toInformatica.getNome());
			stm.setDate(2,toInformatica.getDataInicio());
			stm.setDate(3,toInformatica.getDataTermino());
			stm.setString(4,toInformatica.getHorario());
			stm.setString(5,toInformatica.getVagas());
			stm.setDouble(6,toInformatica.getValor());
			stm.setString(7,toInformatica.getNumLab());
			stm.setString(8,toInformatica.getRegSoft());
			stm.setInt(9,toInformatica.getId());


			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void remover(ToInformatica toInformatica) {
		String sqlDelete = "DELETE FROM INFORMATICA WHERE COD_INFORMATICA =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, toInformatica.getId());

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ToInformatica carregar(int id) throws ClassNotFoundException {
		ToInformatica toInformatica = new ToInformatica();
		toInformatica.setId(id);
		String sqlSelect = "SELECT * FROM INFORMATICA WHERE COD_INFORMATICA=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					toInformatica.setId(rs.getInt("cod_Informatica"));
					toInformatica.setNome(rs.getString("nome"));
					toInformatica.setDataInicio(rs.getDate("dataInicio")); 
					toInformatica.setDataTermino(rs.getDate("dataTermino"));								
					toInformatica.setHorario(rs.getString("horario"));
					toInformatica.setVagas(rs.getString("numeroVagas"));
					toInformatica.setValor(rs.getDouble("valor"));
					toInformatica.setNumLab(rs.getString("numeroLaboratorio"));
					toInformatica.setRegSoft(rs.getString("registroSoftware"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toInformatica;
	}


	


	public ArrayList<ToInformatica> listarInformatica() throws ClassNotFoundException {
		ToInformatica toInformatica;
		ArrayList<ToInformatica> lista = new ArrayList<>();
		String sqlSelect = "SELECT *  FROM INFORMATICA";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toInformatica = new ToInformatica();


					toInformatica.setId(rs.getInt("cod_Informatica"));
					toInformatica.setNome(rs.getString("nome"));
					toInformatica.setDataInicio(rs.getDate("dataInicio")); 
					toInformatica.setDataTermino(rs.getDate("dataTermino"));								
					toInformatica.setHorario(rs.getString("horario"));
					toInformatica.setVagas(rs.getString("numeroVagas"));
					toInformatica.setValor(rs.getDouble("valor"));
					toInformatica.setNumLab(rs.getString("numeroLaboratorio"));
					toInformatica.setRegSoft(rs.getString("registroSoftware"));

					lista.add(toInformatica);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}


	public ArrayList<ToInformatica> listarInformatica(String chave) throws ClassNotFoundException {
		ToInformatica toInformatica;
		ArrayList<ToInformatica> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM INFORMATICA WHERE UPPER (NOME) LIKE ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toInformatica = new ToInformatica();


					toInformatica.setId(rs.getInt("cod_Informatica"));
					toInformatica.setNome(rs.getString("nome"));
					toInformatica.setDataInicio(rs.getDate("dataInicio")); 
					toInformatica.setDataTermino(rs.getDate("dataTermino"));								
					toInformatica.setHorario(rs.getString("horario"));
					toInformatica.setVagas(rs.getString("numeroVagas"));
					toInformatica.setValor(rs.getDouble("valor"));
					toInformatica.setNumLab(rs.getString("numeroLaboratorio"));
					toInformatica.setRegSoft(rs.getString("registroSoftware"));


					lista.add(toInformatica);
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
