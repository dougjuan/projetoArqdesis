package Controller;

import java.io.IOException;
import java.io.PrintWriter;

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

		ModelAluno modelAluno = new ModelAluno(id, pNome, pEndereco, pTelefone, pEmail, pRg, pCpf, pLogin, pSenha);


		if(pAcao.equals("Inserir")){

			modelAluno.criar();	
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Aluno Cadastrado");
			out.println("</title></head><body>");
			out.println("O aluno: " + modelAluno.getNome() +" foi cadastrado com sucesso!"+ "<br>");
			out.println("</body></html>");

		}else if(pAcao.equals("Excluir")){

			modelAluno.excluir(id);		
			JOptionPane.showMessageDialog(null,"Aluno excluído com sucesso");

		}else if (pAcao.equals("Carregar")){

			modelAluno.carregar(id);

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Aluno Cadastrado");
			out.println("</title></head><body>");
			out.println("Id:" + modelAluno.getId() + "<br>");
			out.println("Nome:" + modelAluno.getNome() + "<br>");
			out.println("Endereço:" + modelAluno.getEndereco() + "<br>");
			out.println("Telefone:" + modelAluno.getTelefone() + "<br>");
			out.println("Email:" + modelAluno.getEmail() + "<br>");
			out.println("Rg:" + modelAluno.getRg() + "<br>");
			out.println("Cpf:" + modelAluno.getCpf() + "<br>");
			out.println("Login:" + modelAluno.getLogin() + "<br>");
			out.println("Senha:" + modelAluno.getSenha() + "<br>");
			out.println("</body></html>");



		}else if (pAcao.equals("Atualizar")){


			modelAluno.atualizar();



		}









	}

}
