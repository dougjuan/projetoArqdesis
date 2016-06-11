package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.ModelAluno;
import To.ToAluno;

/**
 * Servlet implementation class ListarAlunoController
 */
@WebServlet(name = "listar_aluno.do", urlPatterns = { "/listar_aluno.do" })
public class ListarAlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarAlunoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String chave = request.getParameter("data[search]");
		
		ModelAluno modelAluno = new ModelAluno();
		
		ArrayList<ToAluno> lista = null;
		
		if(chave != null && chave.length() > 0){
		
			try {
				lista = modelAluno.listarAlunos(chave);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
		
			try {
				lista = modelAluno.listarAlunos();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		request.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.
		
				getRequestDispatcher("ListarAlunos.jsp");
		
		dispatcher.forward(request, response);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
