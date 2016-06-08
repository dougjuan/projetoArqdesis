package View;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
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

import Dao.DaoAluno;
import Dao.DaoMatricula;
import Model.ModelAluno;
import Model.ModelMatricula;

public class ViewCadastraMatricula extends JFrame implements ActionListener {

	JButton btnConfirmar, btnCancelar;
	JLabel lblTitulo, lblCodigo, lblDataMat, lblValor, lblStatusPag, lblStatusMatricula, lblStatusMat;
	JTextField txtCodigo,  txtValor, txtStatusPag, txtStatusMatricula, txtStatusMat;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;
	JFormattedTextField jfDataMat;
	String dataMatricula, statusPagamento, statusMatricula;
	Double valorMatricula = null;

	//private ControlCadastraMatricula CtrlMatricula;

	public ViewCadastraMatricula(String idioma ,String pais){
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
		txtCodigo.setEditable(false);

		lblDataMat = new JLabel ();
		jfDataMat = new JFormattedTextField((setMascara("                            ##                              /          ##          /                              ####                            "))); 

		lblValor = new JLabel ();
		txtValor = new JTextField(40);

		lblStatusPag = new JLabel ();
		txtStatusPag = new JTextField(40);

		lblStatusMatricula = new JLabel ();
		txtStatusMatricula = new JTextField(40);

		panelInfo.add(lblCodigo);
		panelInfo.add(txtCodigo);
		panelInfo.add(lblDataMat);
		panelInfo.add(jfDataMat);
		panelInfo.add(lblValor);
		panelInfo.add(txtValor);
		panelInfo.add(lblStatusPag);
		panelInfo.add(txtStatusPag);
		panelInfo.add(lblStatusMatricula);
		panelInfo.add(txtStatusMatricula);


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

		MudarIdioma(parIdioma, parPais);
		txtCodigo.setEditable(false);

		//************************* CONFIGURAÇÕES DA JANELA ********************************
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 491) / 2);
		int y = (int) ((dimension.getHeight() - 500) / 2);
		setLocation(x, y);
		setSize(491,500);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//************************* CONFIGURAÇÕES DA JANELA ********************************

	}

	public void MudarIdioma(String mIIdioma, String mIPais){
		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		setTitle (bn.getString("ProjetoIntegrado"));
		lblDataMat.setText(bn.getString("DataDaMatricula"));
		lblTitulo.setText(bn.getString("CadastrarMatricula"));
		lblCodigo.setText(bn.getString("Codigo"));
		lblStatusPag.setText(bn.getString("StatusDoPagamento"));
		lblStatusMatricula.setText(bn.getString("StatusDaMatricula"));
		lblValor.setText(bn.getString("Valor"));
		btnCancelar.setText(bn.getString("Cancelar"));
		btnConfirmar.setText(bn.getString("Confirmar"));


	}
	//************************* Metodo para limpar os campos ********************************
	public void limpar(){

		//Este método "limpa" os campos de texto enviando "" (nada)
		//txtCodigo.setText("");
		jfDataMat.setText("");
		txtValor.setText("");
		txtStatusPag.setText("");
		txtStatusMatricula.setText("");   

	}
	private MaskFormatter setMascara(String mascara){  
		MaskFormatter mask = null;  
		try {  
			mask = new MaskFormatter(mascara);                        
		} catch(java.text.ParseException ex){}  
		return mask;  
	}  

	public static java.sql.Date formataData(String data) throws Exception {   

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


		if(dataMatricula.equals("")){

			flag = true; 

		}
		if(valorMatricula.equals("")){

			flag = true; 

		}
		if(statusPagamento.equals("")){

			flag = true; 

		}
		if(statusMatricula.equals("")){
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

				dataMatricula = jfDataMat.getText( ).replace(" ","");
				valorMatricula = Double.parseDouble(txtValor.getText( ));
				statusPagamento = txtStatusPag.getText( );
				statusMatricula = txtStatusMatricula.getText( );

				if (verifica()){

					JOptionPane.showMessageDialog(null,"Preencha todos os campos");

				} else {


					ModelMatricula modelMatricula = new ModelMatricula();
					modelMatricula.setDataMatricula(formataData(dataMatricula));
					modelMatricula.setValorMatricula(valorMatricula);
					modelMatricula.setStatusPagamento(statusPagamento);
					modelMatricula.setStatusMatricula(statusMatricula);


					DaoMatricula dao = new DaoMatricula();

					dao.inserir(modelMatricula); 
					jfDataMat.requestFocus();
					limpar();

				}

			}
			//Caso ocorra uma excessão, a mensagem será exibida na tela 
			catch (Exception ex){ 

				JOptionPane.showMessageDialog(null,"Preencha todos os campos corretamente" );


			}             


		}

	}
}