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

import Dao.DaoAluno;
import Dao.DaoInformatica;
import Model.ModelAluno;
import Model.ModelInformatica;
import To.ToInformatica;

public class ViewCadastraInformatica extends JFrame implements ActionListener {

	JButton btnConfirmar, btnCancelar;
	JLabel lblTitulo, lblCodigo, lblNome, lblDataIni, lblDataTermino, lblHorario, lblVagas, lblValor, lblNumLab, lblRegSoft;
	JTextField txtCodigo, txtNome, txtHorario, txtVagas, txtValor, txtNumLab, txtRegSoft;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;
	JFormattedTextField jfDataIni, jfDataTermino;
	String nome, dataInicio, dataTermino, horario, vagas, numLab, regSoft;
	Double valor = null;




	public ViewCadastraInformatica(String idioma ,String pais){
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

		lblNumLab = new JLabel ();
		txtNumLab = new JTextField(40);

		lblRegSoft = new JLabel ();
		txtRegSoft = new JTextField(40);

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
		panelInfo.add(lblNumLab);
		panelInfo.add(txtNumLab);
		panelInfo.add(lblRegSoft);
		panelInfo.add(txtRegSoft);

		//---------------------------------------------------------------------------------------------

		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());

		btnCancelar= new JButton ("Cancelar");
		btnConfirmar = new JButton("Confirmar");


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
		lblNumLab.setText(bn.getString("NumeroDoLaboratorio"));
		lblRegSoft.setText(bn.getString("RegistroDeSoftware"));
		btnCancelar.setText(bn.getString("Cancelar"));
		btnConfirmar.setText(bn.getString("Confirmar"));


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
			txtNumLab.setText("");
			txtRegSoft.setText("");


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
		if(numLab.equals("")){

			flag = true; 

		}
		if(regSoft.equals("")){

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
				numLab = txtNumLab.getText();
				regSoft = txtRegSoft.getText();

				if (verifica()){

					JOptionPane.showMessageDialog(null,"Preencha todos os campos");

				} else {

					ToInformatica toInformatica = new ToInformatica();
					toInformatica.setNome(nome);
					toInformatica.setDataInicio(formataData(dataInicio));
					toInformatica.setDataTermino(formataData(dataTermino));
					toInformatica.setHorario(horario);
					toInformatica.setVagas(vagas);
					toInformatica.setValor(valor);
					toInformatica.setNumLab(numLab);
					toInformatica.setRegSoft(regSoft);

					DaoInformatica dao = new DaoInformatica();

					dao.inserir(toInformatica); 
					txtNome.requestFocus();
					limpar();

				}
			}
			//Caso ocorra uma excessão, a mensagem será exibida na tela 
			catch (Exception ex){ 

				JOptionPane.showMessageDialog(null, "Preencha os dados corretamente");


			}   
		}

	}

}
