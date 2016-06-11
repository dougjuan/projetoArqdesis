package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelInformatica;

import To.ToInformatica;

/**
 * Servlet implementation class ListarInformaticaController
 */
@WebServlet(name = "listar_informatica.do", urlPatterns = { "/listar_informatica.do" })
public class ListarInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarInformaticaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String chave = request.getParameter("data[search]");

		ModelInformatica modelInformatica = new ModelInformatica();

		ArrayList<ToInformatica> lista = null;

		if(chave != null && chave.length() > 0){

			try {
				lista = modelInformatica.listarInformatica(chave);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {
				lista = modelInformatica.listarInformatica();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		request.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.

				getRequestDispatcher("ListarInformatica.jsp");

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
