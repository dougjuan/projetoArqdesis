package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Model.ModelAluno;
import To.ToAluno;

/**
 * Servlet implementation class ManterAlunoController
 */
@WebServlet("/manter_aluno.do")
public class ManterAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterAlunoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pAcao = request.getParameter("acao");	


		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pEndereco = request.getParameter("endereco");
		String pTelefone = request.getParameter("telefone");
		String pEmail = request.getParameter("email");
		String pRg = request.getParameter("rg");
		String pCpf = request.getParameter("cpf");
		String pLogin = request.getParameter("login");
		String pSenha = request.getParameter("senha");

		int id = Integer.parseInt(pId);

		//ModelAluno modelAluno = new ModelAluno(id,pNome,pEndereco,pTelefone,pEmail,pRg,pCpf,pLogin,pSenha);
		
		ModelAluno modelAluno = new ModelAluno();
		
		modelAluno.setId(id);
		modelAluno.setNome(pNome);
		modelAluno.setEndereco(pEndereco);
		modelAluno.setTelefone(pTelefone);
		modelAluno.setEmail(pEmail);
		modelAluno.setRg(pRg);
		modelAluno.setCpf(pCpf);
		modelAluno.setLogin(pLogin);
		modelAluno.setSenha(pSenha);
				
		if(pAcao.equals("Inserir")){

			modelAluno.criar();	
			
		}else if(pAcao.equals("Excluir")){

			modelAluno.excluir(id);		


		}else if (pAcao.equals("Atualizar")){

			modelAluno.atualizar();

		}
		
		modelAluno.carregar(id);
		request.setAttribute("alunoTO",modelAluno.getTO() );
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlunoCadastrado.jsp");
		dispatcher.forward(request, response);
		


	}

}
