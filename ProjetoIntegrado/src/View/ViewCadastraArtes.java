package View;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Dao.DaoArtes;
import Model.ModelArtes;

public class ViewCadastraArtes extends JFrame implements ActionListener {

	JButton btnConfirmar, btnCancelar;
	JLabel lblTitulo, lblCodigo, lblNome, lblDataIni, lblDataTermino, lblHorario, lblVagas, lblValor, lblDescMat, lblLivros;
	JTextField txtCodigo, txtNome, txtHorario, txtVagas, txtValor, txtDescMat, txtLivros;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;
	JFormattedTextField jfDataIni, jfDataTermino;
	String nome, dataInicio, dataTermino, horario, vagas, descMat, livros;
	Double valor = null;



	public ViewCadastraArtes(String idioma ,String pais){

		parIdioma = idioma;
		parPais= pais;
		setLayout(new BorderLayout());


		Container panelTitulo = new Container();
		panelTitulo.setLayout(new FlowLayout());

		lblTitulo = new JLabel ();
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 16));

		panelTitulo.add(lblTitulo);

		//---------------------------------------------------------------------------------

		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new FlowLayout());

		lblCodigo = new JLabel ();
		txtCodigo = new JTextField(40);

		lblNome = new JLabel ();
		txtNome = new JTextField(40);

		lblDataIni = new JLabel ();
		jfDataIni = new JFormattedTextField((setMascara("                            ##                              /          ##          /                              ####                            ")));

		lblDataTermino = new JLabel ();
		jfDataTermino = new JFormattedTextField((setMascara("                            ##                              /          ##          /                              ####                            ")));

		lblHorario = new JLabel ();
		txtHorario = new JTextField(40);

		lblVagas = new JLabel ();
		txtVagas = new JTextField(40);

		lblValor = new JLabel ();
		txtValor = new JTextField(40);

		lblDescMat = new JLabel ();
		txtDescMat = new JTextField(40);

		lblLivros = new JLabel ();
		txtLivros = new JTextField(40);




		panelInfo.add(lblCodigo);
		panelInfo.add(txtCodigo);
		panelInfo.add(lblNome);
		panelInfo.add(txtNome);
		panelInfo.add(lblDataIni);
		panelInfo.add(jfDataIni);
		panelInfo.add(lblDataTermino);
		panelInfo.add(jfDataTermino);
		panelInfo.add(lblHorario);
		panelInfo.add(txtHorario);
		panelInfo.add(lblVagas);
		panelInfo.add(txtVagas);
		panelInfo.add(lblValor);
		panelInfo.add(txtValor);
		panelInfo.add(lblDescMat);
		panelInfo.add(txtDescMat);
		panelInfo.add(lblLivros);
		panelInfo.add(txtLivros);



		//---------------------------------------------------------------------------------------------

		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());

		btnCancelar= new JButton ();
		btnConfirmar = new JButton();


		panelBotoes.add(btnCancelar);
		panelBotoes.add(btnConfirmar);

		//---------------------------------------------------------------------------------------------

		add(panelTitulo, BorderLayout.NORTH);
		add(panelInfo, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);

		btnConfirmar.addActionListener(this);
		btnCancelar.addActionListener(this);
		txtCodigo.setEditable(false);

		MudarIdioma(parIdioma, parPais);

		//************************* CONFIGURAÇÕES DA JANELA ********************************
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 491) / 2);
		int y = (int) ((dimension.getHeight() - 570) / 2);
		setLocation(x, y);
		setSize(491,570);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//************************* CONFIGURAÇÕES DA JANELA ********************************

	}

	public void MudarIdioma(String mIIdioma, String mIPais){
		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		setTitle (bn.getString("ProjetoIntegrado"));
		lblNome.setText(bn.getString("Nome"));
		lblTitulo.setText(bn.getString("CadastrarCursos"));
		lblCodigo.setText(bn.getString("Codigo"));
		lblDataIni.setText(bn.getString("DataDeInicio"));
		lblDataTermino.setText(bn.getString("DataDeTermino"));
		lblHorario.setText(bn.getString("Horario"));
		lblVagas.setText(bn.getString("Vagas"));
		lblValor.setText(bn.getString("Valor"));
		btnCancelar.setText(bn.getString("Cancelar"));
		btnConfirmar.setText(bn.getString("Confirmar"));
		lblDescMat.setText(bn.getString("DescricaoMaterial"));
		lblLivros.setText(bn.getString("Livros"));


	}
	
	//************************* Metodo para limpar os campos ********************************
		public void limpar(){

			//Este método "limpa" os campos de texto enviando "" (nada)
			txtNome.setText("");
			jfDataIni.setText("");
			jfDataTermino.setText("");
			txtHorario.setText("");
			txtVagas.setText(""); 
			txtValor.setText("");
			txtDescMat.setText("");
			txtLivros.setText("");


		}

	
	private MaskFormatter setMascara(String mascara){  
		MaskFormatter mask = null;  
		try {  
			mask = new MaskFormatter(mascara);                        
		} catch(java.text.ParseException ex){}  
		return mask;  
	}  

	

	public static java.sql.Date formataData(String data) throws Exception {   
		if (data == null || data.equals(""))  
			return null;  

		java.sql.Date date = null;  
		try {  
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );  
		} catch (ParseException e) { 
			throw e; 
		}  
		return date;  
	}  

	
	public boolean verifica(){
		boolean flag = false;


		if(nome.equals("")){

			flag = true; 

		}
		if(dataInicio.equals("")){

			flag = true; 

		}
		if(dataTermino.equals("")){

			flag = true; 

		}

		if(horario.equals("")){
			flag = true; 
		}
		if(vagas.equals("")){

			flag = true; 
		}
		if(valor.equals("")){

			flag = true; 
		}
		if(descMat.equals("")){

			flag = true; 

		}
		if(livros.equals("")){

			flag = true; 

		}
		return flag;	

	}



	public void actionPerformed(ActionEvent e) {




		if (e.getSource() == btnCancelar){

			ViewMenu vm = new ViewMenu(parIdioma,parPais);
			this.dispose();

		}

		if( e.getSource( ) == btnConfirmar )  { 


			try {

				nome = txtNome.getText( );
				dataInicio = jfDataIni.getText( ).replace(" ","");
				dataTermino = jfDataTermino.getText( ).replace(" ","");
				horario = txtHorario.getText( );
				vagas = txtVagas.getText( );
				valor = Double.parseDouble(txtValor.getText( ));
				descMat = txtDescMat.getText( );
				livros = txtLivros.getText( );


				if (verifica()){

					JOptionPane.showMessageDialog(null,"Preencha todos os campos");

				} else {



					ModelArtes modelArtes = new ModelArtes();
					
					modelArtes.setNome(nome);
					modelArtes.setDataInicio(formataData(dataInicio));
					modelArtes.setDataTermino(formataData(dataTermino));
					modelArtes.setHorario(horario);
					modelArtes.setVagas(vagas);
					modelArtes.setValor(valor);
					modelArtes.setDescMat(descMat);
					modelArtes.setLivros(livros);
					
					modelArtes.criar();

					txtNome.requestFocus();
					limpar();

				}
			}
			//Caso ocorra uma excessão, a mensagem será exibida na tela 
			catch (Exception ex){ 

				JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente");


			} 
		}

	}

}
