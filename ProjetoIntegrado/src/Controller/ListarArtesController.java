package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelArtes;
import To.ToArtes;

/**
 * Servlet implementation class ListarArtesController
 */
@WebServlet(name = "listar_artes.do", urlPatterns = { "/listar_artes.do" })
public class ListarArtesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarArtesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String chave = request.getParameter("data[search]");

		ModelArtes modelArtes = new ModelArtes();

		ArrayList<ToArtes> lista = null;

		if(chave != null && chave.length() > 0){

			try {
				lista = modelArtes.listarArtes(chave);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			try {
				lista = modelArtes.listarArtes();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		request.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.

				getRequestDispatcher("ListarArtes.jsp");

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
