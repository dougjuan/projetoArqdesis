package View;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ViewMenuAluno extends JFrame implements ActionListener {

	JMenu menuCurso, menuMatricula;
	//Rud são as operações de consultar/alterar/excluir juntas
	JMenuItem miConsultarArtes, miConsultarInformatica, miConsultarMatricula;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;


	public ViewMenuAluno(String idioma ,String pais){


		parIdioma = idioma;
		parPais = pais;

		//CRIANDO O MENU BAR
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		


		//*********************************** CURSO *****************************************
		menuCurso = new JMenu();

		miConsultarArtes = new JMenuItem("Artes");
		miConsultarInformatica = new JMenuItem("Informática");

		menuCurso.add(miConsultarArtes);
		menuCurso.add(miConsultarInformatica);	

		miConsultarArtes.addActionListener(this);
		miConsultarInformatica.addActionListener(this);


		//*********************************** CURSO *****************************************



		//********************************* MATRÍCULA ***************************************
		menuMatricula = new JMenu();

		miConsultarMatricula= new JMenuItem ("Matrícula");

		menuMatricula.add(miConsultarMatricula);


		miConsultarMatricula.addActionListener(this);


		//********************************* MATRÍCULA ***************************************



		//***************************METODO DE MUDANÇA DE IDIOMA*****************************
		MudarIdioma(parIdioma, parPais);

		//****************************** ADCIONANDO AO MENU *********************************

		menuBar.add(menuCurso);
		menuBar.add(menuMatricula);

		//****************************** ADCIONANDO AO MENU *********************************


		//************************* CONFIGURAÇÕES DA JANELA ********************************
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 500) / 2);
		int y = (int) ((dimension.getHeight() - 400) / 2);
		setLocation(x, y);
		setSize(500,400);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//************************* CONFIGURAÇÕES DA JANELA ********************************

	}

	public void MudarIdioma(String mIIdioma, String mIPais){
		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		setTitle (bn.getString("ProjetoIntegrado"));
		menuCurso.setText(bn.getString("Curso"));
		menuMatricula.setText(bn.getString("Matricula"));


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()== miConsultarArtes){

			ViewConsultaArtes vca = new ViewConsultaArtes(parIdioma,parPais);
			this.dispose();

		} else if(e.getSource()== miConsultarInformatica){

			ViewConsultaInformatica vci = new ViewConsultaInformatica(parIdioma,parPais);
			this.dispose();
		
		} else if (e.getSource()==miConsultarMatricula){
			
		ViewConsultaMatricula vcm = new ViewConsultaMatricula(parIdioma,parPais);	
			
		}

	}
}