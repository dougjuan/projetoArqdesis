package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ConnectionFactory.FabricaConexao;
import To.ToInformatica;

public class DaoInformatica {


	private final String INSERT = "INSERT INTO INFORMATICA (NOME, DATAINICIO, DATATERMINO, HORARIO, NUMEROVAGAS, VALOR, NUMEROLABORATORIO, REGISTROSOFTWARE) VALUES (?,?,?,?,?,?,?,?)"; 
	private final String UPDATE = "UPDATE INFORMATICA SET NOME = ?, DATAINICIO= ?, DATATERMINO = ?, HORARIO= ?, NUMEROVAGAS= ?, VALOR= ?, NUMEROLABORATORIO = ?, REGISTROSOFTWARE = ? WHERE COD_INFORMATICA = ?";
	private final String DELETE = "DELETE FROM INFORMATICA WHERE COD_INFORMATICA =?";
	private final String LIST = "SELECT * FROM INFORMATICA";
	private final String LISTBYID = "SELECT * FROM INFORMATICA WHERE COD_INFORMATICA=?"; 
	private final String LISTBYNOME = "SELECT * FROM INFORMATICA WHERE NOME=?"; 
	private final String LISTBYVAGAS = "SELECT * FROM INFORMATICA WHERE NUMEROVAGAS=?"; 


	public void inserir(ToInformatica toInformatica) { 

		if (toInformatica != null) { 

			Connection conn = null; 

			try { 

				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;				
				pstm = conn.prepareStatement(INSERT);

				pstm.setString(1,toInformatica.getNome());
				pstm.setDate(2,toInformatica.getDataInicio());
				pstm.setDate(3,toInformatica.getDataTermino());
				pstm.setString(4,toInformatica.getHorario());
				pstm.setString(5,toInformatica.getVagas());
				pstm.setDouble(6,toInformatica.getValor());
				pstm.setString(7,toInformatica.getNumLab());
				pstm.setString(8,toInformatica.getRegSoft());



				pstm.execute();
				JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso"); 
				FabricaConexao.fechaConexao(conn, pstm); 
			} catch (Exception e){ 
				JOptionPane.showMessageDialog(null, "Preencha os dados corretamente");}
		} else {
			System.out.println("O curso enviado por parâmetro está vazio");
		} 
	}
	public void atualizar(ToInformatica toInformatica) {

		if (toInformatica != null) { 

			Connection conn = null;

			try { 

				conn = FabricaConexao.getConexao();
				PreparedStatement pstm; 
				pstm = conn.prepareStatement(UPDATE);


				pstm.setString(1,toInformatica.getNome());
				pstm.setDate(2,toInformatica.getDataInicio());
				pstm.setDate(3,toInformatica.getDataTermino());
				pstm.setString(4,toInformatica.getHorario());
				pstm.setString(5,toInformatica.getVagas());
				pstm.setDouble(6,toInformatica.getValor());
				pstm.setString(7,toInformatica.getNumLab());
				pstm.setString(8,toInformatica.getRegSoft());
				pstm.setInt(9,toInformatica.getId());


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
	public List<ToInformatica> getInformatica() { 
		Connection conn = null;
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		ArrayList<ToInformatica> arrayInformatica = new ArrayList<ToInformatica>(); 
		try { 
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LIST); 
			rs = pstm.executeQuery(); 
			while (rs.next()) {
				ToInformatica toInformatica = new ToInformatica();

				toInformatica.setId(rs.getInt("cod_Informatica"));
				toInformatica.setNome(rs.getString("nome"));
				toInformatica.setDataInicio(rs.getDate("dataInicio")); 
				toInformatica.setDataTermino(rs.getDate("dataTermino"));								
				toInformatica.setHorario(rs.getString("horario"));
				toInformatica.setVagas(rs.getString("numeroVagas"));
				toInformatica.setValor(rs.getDouble("valor"));
				toInformatica.setNumLab(rs.getString("numeroLaboratorio"));
				toInformatica.setRegSoft(rs.getString("registroSoftware"));

				arrayInformatica.add(toInformatica); 
			} 
			FabricaConexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar curso" + e.getMessage());
		}
		return arrayInformatica;
	} 
	public ToInformatica getInformaticaById(int id) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToInformatica toInformatica = new ToInformatica();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYID); 
			pstm.setInt(1, id);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 


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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar curso" + e.getMessage());

		} 

		return toInformatica;

	} 
	public ToInformatica getInformaticaByNome(String nome) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToInformatica toInformatica = new ToInformatica();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYNOME); 
			pstm.setString(1, nome);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 


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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar curso" + e.getMessage());

		} 

		return toInformatica;

	} 

	public ToInformatica getInformaticaByVagas(String vagas) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToInformatica toInformatica = new ToInformatica();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYVAGAS); 
			pstm.setString(1, vagas);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 


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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar curso" + e.getMessage());

		} 

		return toInformatica;

	} 




}
