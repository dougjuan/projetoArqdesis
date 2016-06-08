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

public class ViewMenu extends JFrame implements ActionListener {

	JMenu menuAluno, menuCurso, menuMatricula, menuCadastrarCurso, menuConsultarCurso;
	//Rud são as operações de consultar/alterar/excluir juntas
	JMenuItem miConsultarArtes, miConsultarInformatica, miCadastrarAluno, miRudAluno, miCadastrarMatricula, miCancelarMatricula;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;
	private JMenuItem miCadastrarArtes;
	private JMenuItem miCadastrarInformatica;


	public ViewMenu(String idioma ,String pais){


		parIdioma = idioma;
		parPais = pais;

		//CRIANDO O MENU BAR
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);		

		//********************************** ALUNO ******************************************
		menuAluno = new JMenu();		

		miCadastrarAluno = new JMenuItem ();
		miRudAluno = new JMenuItem ();

		menuAluno.add(miCadastrarAluno);
		menuAluno.add(miRudAluno);

		miCadastrarAluno.addActionListener(this);
		miRudAluno.addActionListener(this);
		//********************************** ALUNO ******************************************



		//*********************************** CURSO *****************************************
		menuCurso = new JMenu();

		menuCadastrarCurso = new JMenu ();
		menuConsultarCurso = new JMenu("Consultar (Alterar/Excluir)");

		miCadastrarArtes = new JMenuItem();
		miCadastrarInformatica = new JMenuItem();

		miConsultarArtes = new JMenuItem();
		miConsultarInformatica = new JMenuItem();

		menuCurso.add(menuCadastrarCurso);
		menuCurso.add(menuConsultarCurso);		

		menuCadastrarCurso.add(miCadastrarArtes);
		menuCadastrarCurso.add(miCadastrarInformatica);
		menuConsultarCurso.add(miConsultarArtes);
		menuConsultarCurso.add(miConsultarInformatica);


		menuCadastrarCurso.addActionListener(this);
		menuConsultarCurso.addActionListener(this);

		miCadastrarArtes.addActionListener(this);
		miCadastrarInformatica.addActionListener(this);
		miConsultarArtes.addActionListener(this);
		miConsultarInformatica.addActionListener(this);
		//*********************************** CURSO *****************************************



		//********************************* MATRÍCULA ***************************************
		menuMatricula = new JMenu();

		miCadastrarMatricula = new JMenuItem ();
		miCancelarMatricula= new JMenuItem ();

		menuMatricula.add(miCadastrarMatricula);
		menuMatricula.add(miCancelarMatricula);

		miCadastrarMatricula.addActionListener(this);
		miCancelarMatricula.addActionListener(this);

		//********************************* MATRÍCULA ***************************************



		

		//***************************METODO DE MUDANÇA DE IDIOMA*****************************
		MudarIdioma(parIdioma, parPais);

		//****************************** ADCIONANDO AO MENU *********************************
		menuBar.add(menuAluno);
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
		miCadastrarAluno.setText(bn.getString("Cadastrar"));
		menuAluno.setText(bn.getString("Aluno"));
		miRudAluno.setText(bn.getString("Consultar(Alterar/Excluir)"));
		menuCurso.setText(bn.getString("Curso"));
		menuCadastrarCurso.setText(bn.getString("Cadastrar"));

		menuMatricula.setText(bn.getString("Matricula"));
		miCadastrarMatricula.setText(bn.getString("Cadastrar"));
		miCancelarMatricula.setText(bn.getString("Cancelar"));
		miCadastrarArtes.setText(bn.getString("artes"));
		miConsultarInformatica.setText(bn.getString("informatica"));
		miConsultarArtes.setText(bn.getString("artes"));
		miCadastrarInformatica.setText(bn.getString("informatica"));
		menuConsultarCurso.setText(bn.getString("Consultar(Alterar/Excluir)"));


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == miCadastrarAluno){

			ViewCadastraAluno vca = new ViewCadastraAluno(parIdioma,parPais);
			this.dispose();

		}

		if(e.getSource() == miRudAluno){

			ViewRudAluno vra = new ViewRudAluno(parIdioma,parPais);
			this.dispose();

		}

		else if(e.getSource() == miCadastrarInformatica){

			ViewCadastraInformatica vci = new ViewCadastraInformatica(parIdioma,parPais);
			this.dispose();

		} else if (e.getSource() == miCadastrarArtes){

			ViewCadastraArtes vca = new ViewCadastraArtes(parIdioma,parPais);
			this.dispose();

		}




		else if(e.getSource() == miCadastrarMatricula){

			ViewCadastraMatricula vcm = new ViewCadastraMatricula(parIdioma,parPais);
			this.dispose();

		}

		else if(e.getSource() == miCancelarMatricula){

			ViewCancelaMatricula vcm = new ViewCancelaMatricula(parIdioma,parPais);
			this.dispose();

		}
		else if (e.getSource()==miConsultarArtes){

			ViewRudArtes vra = new ViewRudArtes(parIdioma,parPais);
			this.dispose();

		} else if (e.getSource()==miConsultarInformatica){

			ViewRudInformatica vri = new ViewRudInformatica(parIdioma,parPais);
			this.dispose();

		} 


	}


}
