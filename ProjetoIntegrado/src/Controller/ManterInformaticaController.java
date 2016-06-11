package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Model.ModelArtes;
import Model.ModelInformatica;

/**
 * Servlet implementation class ManterInformaticaController
 */
@WebServlet("/manter_informatica.do")
public class ManterInformaticaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterInformaticaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String pAcao = request.getParameter("acao");
		
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pDiaInicio = request.getParameter("diaInicio");
		String pMesInicio = request.getParameter("mesInicio");
		String pAnoInicio = request.getParameter("anoInicio");
		String pDiaTermino = request.getParameter("diaTermino");
		String pMesTermino = request.getParameter("mesTermino");
		String pAnoTermino = request.getParameter("anoTermino");
		String pHorario = request.getParameter("horario");
		String pVagas = request.getParameter("vagas");
		String pValor = request.getParameter("valor");
		String pNumLab = request.getParameter("numLab");
		String pRegSoft = request.getParameter("regSoft");

		ModelInformatica modelInformatica = new ModelInformatica();
		
		int id = Integer.parseInt(pId);

		if(pAcao.equals("Inserir")){


			String pDataInicio = pDiaInicio+"/"+pMesInicio+"/"+pAnoInicio;

			String pDataTermino = pDiaTermino+"/"+pMesTermino+"/"+pAnoTermino;

			Date dataInicioD = null;

			try {
				dataInicioD = ModelArtes.formataData(pDataInicio);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Date dataTerminoD = null;
			try {
				dataTerminoD = ModelArtes.formataData(pDataTermino);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			double valorD = 0.0;

			valorD = Double.parseDouble(pValor);


			modelInformatica.setId(id);
			modelInformatica.setNome(pNome);
			modelInformatica.setDataInicio(dataInicioD);
			modelInformatica.setDataTermino(dataTerminoD);
			modelInformatica.setHorario(pHorario);
			modelInformatica.setVagas(pVagas);
			modelInformatica.setValor(valorD);
			modelInformatica.setNumLab(pNumLab);
			modelInformatica.setRegSoft(pRegSoft);


			modelInformatica.criar();	
			
		}else if(pAcao.equals("Excluir")){

			modelInformatica.excluir(id);		
		

		}else if (pAcao.equals("Atualizar")){
			
					
			String pDataInicio = pDiaInicio+"/"+pMesInicio+"/"+pAnoInicio;

			String pDataTermino = pDiaTermino+"/"+pMesTermino+"/"+pAnoTermino;

			Date dataInicioD = null;

			try {
				dataInicioD = ModelArtes.formataData(pDataInicio);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			Date dataTerminoD = null;
			try {
				dataTerminoD = ModelArtes.formataData(pDataTermino);
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			double valorD = 0.0;

			valorD = Double.parseDouble(pValor);


			modelInformatica.setId(id);
			modelInformatica.setNome(pNome);
			modelInformatica.setDataInicio(dataInicioD);
			modelInformatica.setDataTermino(dataTerminoD);
			modelInformatica.setHorario(pHorario);
			modelInformatica.setVagas(pVagas);
			modelInformatica.setValor(valorD);
			modelInformatica.setNumLab(pNumLab);
			modelInformatica.setRegSoft(pRegSoft);
			modelInformatica.atualizar();
			
		}
		
		modelInformatica.carregar(id);
		request.setAttribute("informaticaTO",modelInformatica.getToInformatica() );
		RequestDispatcher dispatcher = request.getRequestDispatcher("InformaticaCadastrado.jsp");
		dispatcher.forward(request, response);





	}

}
