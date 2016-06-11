package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnectionFactory.FabricaConexao;
import To.ToArtes;


public class DaoArtes {

	public void inserir(ToArtes toArtes) throws ClassNotFoundException {

		String sqlInsert = "INSERT INTO ARTES (NOME, DATAINICIO, DATATERMINO, HORARIO, NUMEROVAGAS, VALOR, DESCMATERIAL, NOMELIVRO) VALUES (?,?,?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {


			stm.setString(1,toArtes.getNome());
			stm.setDate(2,toArtes.getDataInicio());
			stm.setDate(3,toArtes.getDataTermino());
			stm.setString(4,toArtes.getHorario());
			stm.setString(5,toArtes.getVagas());
			stm.setDouble(6,toArtes.getValor());
			stm.setString(7,toArtes.getDescMat());
			stm.setString(8,toArtes.getLivros());


			stm.execute();

			String sqlSelect = "SELECT LAST_INSERT_ID()";

			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
				if(rs.next()){
					toArtes.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void atualizar(ToArtes toArtes) {
		String sqlUpdate = "UPDATE ARTES SET NOME = ?, DATAINICIO= ?, DATATERMINO = ?, HORARIO= ?, NUMEROVAGAS= ?, VALOR= ?, DESCMATERIAL = ?, NOMELIVRO = ? WHERE COD_ARTES = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

			stm.setString(1,toArtes.getNome());
			stm.setDate(2,toArtes.getDataInicio());
			stm.setDate(3,toArtes.getDataTermino());
			stm.setString(4,toArtes.getHorario());
			stm.setString(5,toArtes.getVagas());
			stm.setDouble(6,toArtes.getValor());
			stm.setString(7,toArtes.getDescMat());
			stm.setString(8,toArtes.getLivros());
			stm.setInt(9,toArtes.getId());


			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remover(ToArtes toArtes) {
		String sqlDelete = "DELETE FROM ARTES WHERE COD_ARTES =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {

			stm.setInt(1, toArtes.getId());

			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ToArtes carregar(int id) throws ClassNotFoundException {
		ToArtes toArtes = new ToArtes();
		toArtes.setId(id);
		String sqlSelect = "SELECT * FROM ARTES WHERE COD_ARTES=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					toArtes.setId(rs.getInt("cod_Artes"));
					toArtes.setNome(rs.getString("nome"));
					toArtes.setDataInicio(rs.getDate("dataInicio")); 
					toArtes.setDataTermino(rs.getDate("dataTermino"));								
					toArtes.setHorario(rs.getString("horario"));
					toArtes.setVagas(rs.getString("numeroVagas"));
					toArtes.setValor(rs.getDouble("valor"));
					toArtes.setDescMat(rs.getString("descMaterial"));
					toArtes.setLivros(rs.getString("nomeLivro"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toArtes;
	}




	public ArrayList<ToArtes> listarArtes() throws ClassNotFoundException {
		ToArtes toArtes;
		ArrayList<ToArtes> lista = new ArrayList<>();
		String sqlSelect = "SELECT *  FROM ARTES";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toArtes = new ToArtes();


					toArtes.setId(rs.getInt("cod_Artes"));
					toArtes.setNome(rs.getString("nome"));
					toArtes.setDataInicio(rs.getDate("dataInicio")); 
					toArtes.setDataTermino(rs.getDate("dataTermino"));								
					toArtes.setHorario(rs.getString("horario"));
					toArtes.setVagas(rs.getString("numeroVagas"));
					toArtes.setValor(rs.getDouble("valor"));
					toArtes.setDescMat(rs.getString("descMaterial"));
					toArtes.setLivros(rs.getString("nomeLivro"));


					lista.add(toArtes);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}



	public ArrayList<ToArtes> listarArtes(String chave) throws ClassNotFoundException {
		ToArtes toArtes;
		ArrayList<ToArtes> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM ARTES WHERE UPPER (NOME) LIKE ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toArtes = new ToArtes();


					toArtes.setId(rs.getInt("cod_Artes"));
					toArtes.setNome(rs.getString("nome"));
					toArtes.setDataInicio(rs.getDate("dataInicio")); 
					toArtes.setDataTermino(rs.getDate("dataTermino"));								
					toArtes.setHorario(rs.getString("horario"));
					toArtes.setVagas(rs.getString("numeroVagas"));
					toArtes.setValor(rs.getDouble("valor"));
					toArtes.setDescMat(rs.getString("descMaterial"));
					toArtes.setLivros(rs.getString("nomeLivro"));


					lista.add(toArtes);
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
