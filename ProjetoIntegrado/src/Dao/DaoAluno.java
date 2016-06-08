package Dao;
import ConnectionFactory.FabricaConexao;
import Model.ModelAluno;


import To.ToAluno;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List; 

import javax.swing.JOptionPane; 

public class DaoAluno {


	private final String INSERT = "INSERT INTO ALUNO (NOME, ENDERECO, TELEFONE, EMAIL, RG, CPF, LOGIN, SENHA) VALUES (?,?,?,?,?,?,?,?)"; 
	private final String UPDATE = "UPDATE ALUNO SET NOME = ?, ENDERECO= ?, TELEFONE= ?, EMAIL= ?, RG= ?, CPF= ?, LOGIN= ?, SENHA= ? WHERE COD_ALUNO = ?";
	private final String DELETE = "DELETE FROM ALUNO WHERE cod_Aluno =?";
	private final String LIST = "SELECT * FROM ALUNO";
	private final String LISTBYID = "SELECT * FROM ALUNO WHERE cod_Aluno=?"; 
	private final String LISTBYNAME = "SELECT * FROM ALUNO WHERE nome = ?";
	private final String LISTBYRG = "SELECT * FROM ALUNO WHERE rg=?";

	public void inserir(ToAluno toAluno) { 

		if (toAluno != null) { 

			Connection conn = null; 

			try { 

				conn = FabricaConexao.getConexao();
				PreparedStatement pstm;				
				pstm = conn.prepareStatement(INSERT);


				pstm.setString(1,toAluno.getNome());
				pstm.setString(2,toAluno.getEndereco());
				pstm.setString(3,toAluno.getTelefone());
				pstm.setString(4,toAluno.getEmail());
				pstm.setString(5,toAluno.getRg());
				pstm.setString(6,toAluno.getCpf());
				pstm.setString(7,toAluno.getLogin());
				pstm.setString(8,toAluno.getSenha());



				pstm.execute();
				JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso"); 
				FabricaConexao.fechaConexao(conn, pstm); 
			} catch (Exception e){ 
				JOptionPane.showMessageDialog(null, "Preencha os dados corretamente");}
		} else {
			System.out.println("O aluno enviado por parâmetro está vazio");
		} 
	}
	public void atualizar(ToAluno toAluno) {

		if (toAluno != null) { 

			Connection conn = null;

			try { 

				conn = FabricaConexao.getConexao();
				PreparedStatement pstm; 
				pstm = conn.prepareStatement(UPDATE);


				pstm.setString(1,toAluno.getNome());
				pstm.setString(2,toAluno.getEndereco());
				pstm.setString(3,toAluno.getTelefone());
				pstm.setString(4,toAluno.getEmail());
				pstm.setString(5,toAluno.getRg());
				pstm.setString(6,toAluno.getCpf());
				pstm.setString(7,toAluno.getLogin());
				pstm.setString(8,toAluno.getSenha());
				pstm.setInt(9,toAluno.getId());


				pstm.execute(); 

				JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso"); 

				FabricaConexao.fechaConexao(conn);

			} catch (Exception e) { 
				JOptionPane.showMessageDialog(null, "Preencha os dados corretamente");
			}

		} else {

			JOptionPane.showMessageDialog(null, "O aluno enviado por parâmetro está vazio"); 

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
			JOptionPane.showMessageDialog(null, "Erro ao excluir aluno do banco de" + "dados " + e.getMessage()); 
		}
	}
	public List<ToAluno> getAlunos() { 
		Connection conn = null;
		PreparedStatement pstm = null; 
		ResultSet rs = null; 
		ArrayList<ToAluno> arrayAluno = new ArrayList<ToAluno>(); 
		try { 
			conn = FabricaConexao.getConexao();
			pstm = conn.prepareStatement(LIST); 
			rs = pstm.executeQuery(); 
			while (rs.next()) {
				ToAluno toAluno = new ToAluno();

				toAluno.setId(rs.getInt("cod_Aluno"));
				toAluno.setNome(rs.getString("nome"));
				toAluno.setEndereco(rs.getString("endereco")); 
				toAluno.setTelefone(rs.getString("telefone"));								
				toAluno.setEmail(rs.getString("email"));
				toAluno.setRg(rs.getString("rg"));
				toAluno.setCpf(rs.getString("cpf"));
				toAluno.setLogin(rs.getString("login"));
				toAluno.setSenha(rs.getString("senha"));

				arrayAluno.add(toAluno); 
			} 
			FabricaConexao.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar alunos" + e.getMessage());
		}
		return arrayAluno;
	} 
	public ToAluno getAlunoById(int id) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToAluno toAluno = new ToAluno();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYID); 
			pstm.setInt(1, id);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 

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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar alunos" + e.getMessage());

		} 

		return toAluno;

	} 

	public ToAluno getAlunoByName(String aluno) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToAluno toAluno = new ToAluno();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYNAME); 
			pstm.setString(1, aluno);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 

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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar alunos" + e.getMessage());

		} 

		return toAluno;

	} 

	public ToAluno getAlunoByRg(String rg) { 
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		ToAluno toAluno = new ToAluno();
		try { 
			conn = FabricaConexao.getConexao(); 
			pstm = conn.prepareStatement(LISTBYRG); 
			pstm.setString(1, rg);
			rs = pstm.executeQuery(); 
			while (rs.next()) { 

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

			FabricaConexao.fechaConexao(conn, pstm, rs);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Erro ao listar alunos" + e.getMessage());

		} 

		return toAluno;

	} 

}
