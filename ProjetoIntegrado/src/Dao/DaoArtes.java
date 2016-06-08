package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;




import ConnectionFactory.FabricaConexao;
import Model.ModelArtes;
import To.ToArtes;


public class DaoArtes {
	

	private final String INSERT = "INSERT INTO ARTES (NOME, DATAINICIO, DATATERMINO, HORARIO, NUMEROVAGAS, VALOR, descMaterial, NOMELIVRO) VALUES (?,?,?,?,?,?,?,?)"; 
	private final String UPDATE = "UPDATE ARTES SET NOME = ?, DATAINICIO= ?, DATATERMINO = ?, HORARIO= ?, NUMEROVAGAS= ?, VALOR= ?, descMaterial = ?, NOMELIVRO = ? WHERE COD_ARTES = ?";
	private final String DELETE = "DELETE FROM ARTES WHERE COD_ARTES =?";
	private final String LIST = "SELECT * FROM ARTES";
	private final String LISTBYID = "SELECT * FROM ARTES WHERE COD_ARTES=?"; 
	private final String LISTBYNOME = "SELECT * FROM ARTES WHERE NOME=?"; 
	private final String LISTBYVAGAS = "SELECT * FROM ARTES WHERE NUMEROVAGAS=?"; 


	public void inserir(ToArtes toArtes) { 

		if (toArtes != null) { 

			Connection conn = null; 

			try { 

				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;				
				pstm = conn.prepareStatement(INSERT);
			
				pstm.setString(1,toArtes.getNome());
				pstm.setDate(2,toArtes.getDataInicio());
				pstm.setDate(3,toArtes.getDataTermino());
				pstm.setString(4,toArtes.getHorario());
				pstm.setString(5,toArtes.getVagas());
				pstm.setDouble(6,toArtes.getValor());
				pstm.setString(7,toArtes.getDescMat());
				pstm.setString(8,toArtes.getLivros());



				pstm.execute();
				JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso"); 
				FabricaConexao.fechaConexao(conn, pstm); 
			} catch (Exception e){
				
				JOptionPane.showMessageDialog(null,"Preencha os campos corretamente!");
			
			}
		} else {
			System.out.println("O curso enviado por parâmetro está vazio");
		} 
	}
	public void atualizar(ToArtes toArtes) {

		if (toArtes != null) { 

			Connection conn = null;

			try { 

				conn = FabricaConexao.getConexao();
				PreparedStatement pstm; 
				pstm = conn.prepareStatement(UPDATE);
				

				pstm.setString(1,toArtes.getNome());
				pstm.setDate(2,toArtes.getDataInicio());
				pstm.setDate(3,toArtes.getDataTermino());
				pstm.setString(4,toArtes.getHorario());
				pstm.setString(5,toArtes.getVagas());
				pstm.setDouble(6,toArtes.getValor());
				pstm.setString(7,toArtes.getDescMat());
				pstm.setString(8,toArtes.getLivros());
				pstm.setInt(9,toArtes.getId());


				pstm.execute(); 

				JOptionPane.showMessageDialog(null, "Curso alterado com sucesso"); 

				FabricaConexao.fechaConexao(conn);

			} catch (Exception e) { 

				JOptionPane.showMessageDialog(null, "Preencha os dados corretamente");

			}

		} else {

			JOptionPane.showMessageDialog(null, "O curso enviado por parâmetro está vazio"); 

		}
	}
	public void remover(int id) { 
		Connection conn = null;
		try {
			conn = FabricaConexao.getConexao();
			PreparedStatement pstm; 
			pstm = conn.prepareStatement(DELETE);
			pstm.setInt(1, id);
			pstm.execute();
			FabricaConexao.fechaConexao(conn, pstm);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir curso do banco de" + "dados " + e.getMessage()); 
		}
	}
	public List<ToArtes> getArtes() { 
		Connection conn = null;
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		ArrayList<ToArtes> arrayArtes = new ArrayList<ToArtes>(); 
		try { 
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LIST); 
			rs = pstm.executeQuery(); 
			while (rs.next()) {
				ToArtes toArtes = new ToArtes();
	
				toArtes.setId(rs.getInt("cod_Artes"));
				toArtes.setNome(rs.getString("nome"));
				toArtes.setDataInicio(rs.getDate("dataInicio")); 
				toArtes.setDataTermino(rs.getDate("dataTermino"));								
				toArtes.setHorario(rs.getString("horario"));
				toArtes.setVagas(rs.getString("numeroVagas"));
				toArtes.setValor(rs.getDouble("valor"));
				toArtes.setDescMat(rs.getString("descMaterial"));
				toArtes.setLivros(rs.getString("nomeLivro"));

				arrayArtes.add(toArtes); 
			} 
			FabricaConexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar curso" + e.getMessage());
		}
		return arrayArtes;
	} 
	public ToArtes getArtesById(int id) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToArtes toArtes = new ToArtes();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYID); 
			pstm.setInt(1, id);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 
				

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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar curso" + e.getMessage());

		} 

		return toArtes;

	} 
	public ToArtes getArtesByNome(String nome) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToArtes toArtes = new ToArtes();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYNOME); 
			pstm.setString(1, nome);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 
				

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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar curso" + e.getMessage());

		} 

		return toArtes;

	} 
	
	public ToArtes getArtesByVagas(String vagas) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToArtes toArtes = new ToArtes();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYVAGAS); 
			pstm.setString(1, vagas);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 
				

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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar curso" + e.getMessage());

		} 

		return toArtes;

	} 

	


}
