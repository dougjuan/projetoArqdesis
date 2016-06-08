package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ConnectionFactory.FabricaConexao;
import Model.ModelMatricula;

public class DaoMatricula {



	private final String INSERT = "INSERT INTO MATRICULA (DATA_MATRICULA, VALOR_MATRICULA, STATUS_PAGAMENTO, STATUS_MATRICULA) VALUES (?,?,?,?)"; 
	private final String UPDATE = "UPDATE MATRICULA SET DATA_MATRICULA = ?, VALOR_MATRICULA = ?, STATUS_PAGAMENTO = ?, STATUS_MATRICULA WHERE COD_MATRICULA = ?";
	private final String DELETE = "DELETE FROM MATRICULA WHERE COD_MATRICULA =?";
	private final String LIST = "SELECT * FROM MATRICULA";
	private final String LISTBYID = "SELECT * FROM MATRICULA WHERE COD_MATRICULA = ?"; 
	private final String LISTBYSTATUSPAGAMENTO = "SELECT * FROM MATRICULA WHERE STATUS_PAGAMENTO = ?";
	private final String LISTBYSTATUSMATRICULA = "SELECT * FROM MATRICULA WHERE STATUS_MATRICULA = ?";

	public void inserir(ModelMatricula modelMatricula) { 

		if (modelMatricula != null) { 

			Connection conn = null; 

			try { 

				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;				
				pstm = conn.prepareStatement(INSERT);


				pstm.setDate(1,modelMatricula.getDataMatricula());
				pstm.setDouble(2,modelMatricula.getValorMatricula());
				pstm.setString(3,modelMatricula.getStatusPagamento());
				pstm.setString(4,modelMatricula.getStatusMatricula());


				pstm.execute();
				JOptionPane.showMessageDialog(null, "Matricula cadastrada com sucesso"); 
				FabricaConexao.fechaConexao(conn, pstm); 
			} catch (Exception e){ 
				JOptionPane.showMessageDialog(null, "Preencha os dados corretamente");}
		} else {
			System.out.println("A matrícula enviado por parâmetro está vazio");
		} 
	}
	public void atualizar(ModelMatricula modelMatricula) {

		if (modelMatricula != null) { 

			Connection conn = null;

			try { 

				conn = FabricaConexao.getConexao();
				PreparedStatement pstm; 
				pstm = conn.prepareStatement(UPDATE);


				pstm.setDate(1,modelMatricula.getDataMatricula());
				pstm.setDouble(2,modelMatricula.getValorMatricula());
				pstm.setString(3,modelMatricula.getStatusPagamento());
				pstm.setString(4,modelMatricula.getStatusMatricula());
				pstm.setInt(9,modelMatricula.getId());


				pstm.execute(); 

				JOptionPane.showMessageDialog(null, "Matrícula alterado com sucesso"); 

				FabricaConexao.fechaConexao(conn);

			} catch (Exception e) { 
				JOptionPane.showMessageDialog(null, "Preencha os dados corretamente");
			}

		} else {

			JOptionPane.showMessageDialog(null, "A matrícula enviado por parâmetro está vazio"); 

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
			JOptionPane.showMessageDialog(null, "Erro ao excluir a matrícula do banco de" + "dados " + e.getMessage()); 
		}
	}

	public List<ModelMatricula> getMatriculas() { 
		Connection conn = null;
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		ArrayList<ModelMatricula> arrayMatricula = new ArrayList<ModelMatricula>(); 
		try { 
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LIST); 
			rs = pstm.executeQuery(); 
			while (rs.next()) {
				ModelMatricula modelMatricula = new ModelMatricula();

				modelMatricula.setId(rs.getInt("cod_Matricula"));
				modelMatricula.setDataMatricula(rs.getDate("data_Matricula"));
				modelMatricula.setValorMatricula(rs.getDouble("valor_Matricula")); 
				modelMatricula.setStatusPagamento(rs.getString("status_Pagamento"));								
				modelMatricula.setStatusMatricula(rs.getString("status_Matricula"));


				arrayMatricula.add(modelMatricula); 
			} 
			FabricaConexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar matrícula" + e.getMessage());
		}
		return arrayMatricula;
	} 
	public ModelMatricula getMatriculaById(int id) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ModelMatricula modelMatricula = new ModelMatricula();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYID); 
			pstm.setInt(1, id);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 

				modelMatricula.setId(rs.getInt("cod_Matricula"));
				modelMatricula.setDataMatricula(rs.getDate("data_Matricula"));
				modelMatricula.setValorMatricula(rs.getDouble("valor_Matricula")); 
				modelMatricula.setStatusPagamento(rs.getString("status_Pagamento"));								
				modelMatricula.setStatusMatricula(rs.getString("status_Matricula"));

			} 

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar matrícula" + e.getMessage());

		} 

		return modelMatricula;

	} 
	public ModelMatricula getMatriculaByStatusDoPagamento(String StatusPagamento) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ModelMatricula modelMatricula = new ModelMatricula();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYSTATUSPAGAMENTO); 
			pstm.setString(1, StatusPagamento);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 

				modelMatricula.setId(rs.getInt("cod_Matricula"));
				modelMatricula.setDataMatricula(rs.getDate("data_Matricula"));
				modelMatricula.setValorMatricula(rs.getDouble("valor_Matricula")); 
				modelMatricula.setStatusPagamento(rs.getString("status_Pagamento"));								
				modelMatricula.setStatusMatricula(rs.getString("status_Matricula"));

			} 

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar matrícula" + e.getMessage());

		} 

		return modelMatricula;

	} 

	public ModelMatricula getMatriculaByStatusDaMatricula(String StatusMatricula) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ModelMatricula modelMatricula = new ModelMatricula();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYSTATUSMATRICULA); 
			pstm.setString(1, StatusMatricula);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 

				modelMatricula.setId(rs.getInt("cod_Matricula"));
				modelMatricula.setDataMatricula(rs.getDate("data_Matricula"));
				modelMatricula.setValorMatricula(rs.getDouble("valor_Matricula")); 
				modelMatricula.setStatusPagamento(rs.getString("status_Pagamento"));								
				modelMatricula.setStatusMatricula(rs.getString("status_Matricula"));

			} 

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar matrícula" + e.getMessage());

		} 

		return modelMatricula;

	} 


}
