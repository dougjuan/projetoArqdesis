package View;
import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Dao.DaoAluno;
import Dao.DaoInformatica;
import Model.ModelAluno;
import Model.ModelInformatica;
import To.ToInformatica;

public class ViewAlteraInformatica extends JFrame implements ActionListener {

	private DefaultTableModel modelo = new DefaultTableModel(); 
	JButton btnConfirmar, btnCancelar;
	JLabel lblTitulo, lblId, lblNome, lblDataIni, lblDataTermino, lblHorario, lblVagas, lblValor, lblNumLab, lblRegSoft;
	JTextField txtId, txtNome, txtHorario, txtVagas, txtValor, txtNumLab, txtRegSoft;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;
	private int linhaSelecionada; 
	JFormattedTextField jfDataIni, jfDataTermino;
	String nome, dataInicio, dataTermino, horario, vagas, numLab, regSoft;
	Double valor = null;


	public ViewAlteraInformatica(DefaultTableModel md, int id, int linha){

		ToInformatica toInformatica = new ToInformatica();
		DaoInformatica daoInformatica = new DaoInformatica();

		criarJanela();
		modelo = md; 

		txtNome.requestFocus();

		toInformatica = daoInformatica.getInformaticaById(id);


		txtId.setText(Integer.toString(toInformatica.getId()));
		txtNome.setText(toInformatica.getNome()); 
		jfDataIni.setText(toInformatica.getDataInicio().toString()); 
		jfDataTermino.setText(toInformatica.getDataTermino().toString()); 
		txtHorario.setText(toInformatica.getHorario());
		txtVagas.setText(toInformatica.getVagas());
		txtValor.setText(toInformatica.getValor().toString());
		txtNumLab.setText(toInformatica.getNumLab());
		txtRegSoft.setText(toInformatica.getRegSoft());

		linhaSelecionada = linha; 	
	}

	public void criarJanela(){

		setLayout(new BorderLayout());



		Container panelTitulo = new Container();
		panelTitulo.setLayout(new FlowLayout());

		lblTitulo = new JLabel ("Alterar Curso:");
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 16));

		panelTitulo.add(lblTitulo);

		//---------------------------------------------------------------------------------

		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new FlowLayout());




		lblId = new JLabel ("Id");
		txtId = new JTextField(40);
		txtId.setEditable(false);


		lblNome = new JLabel ("Nome");
		txtNome = new JTextField(40);


		lblDataIni= new JLabel ("Data início");
		jfDataIni = new JFormattedTextField((setMascara("                            ##                              /          ##          /                              ####                            ")));


		lblDataTermino = new JLabel ("Data término");
		jfDataTermino = new JFormattedTextField((setMascara("                            ##                              /          ##          /                              ####                            ")));


		lblHorario = new JLabel ("Horário");
		txtHorario = new JTextField(40);

		lblVagas = new JLabel ("Vas");
		txtVagas = new JTextField(40);

		lblValor = new JLabel ("Valor");
		txtValor = new JTextField(40);

		lblNumLab = new JLabel ("Número laboratório");
		txtNumLab = new JTextField(40);

		lblRegSoft = new JLabel ("Registro de Software");
		txtRegSoft = new JTextField(40);

		panelInfo.add(lblId);
		panelInfo.add(txtId);
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



		//************************* CONFIGURAÇÕES DA JANELA ********************************
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 485) / 2);
		int y = (int) ((dimension.getHeight() - 570) / 2);
		setLocation(x, y);
		setSize(482,570);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//************************* CONFIGURAÇÕES DA JANELA ********************************

	}


	private MaskFormatter setMascara(String mascara){  
		MaskFormatter mask = null;  
		try {  
			mask = new MaskFormatter(mascara);                        
		} catch(java.text.ParseException ex){}  
		return mask;  
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
		if(dataInicio.equals("//")){

			flag = true; 

		}
		if(dataTermino.equals("//")){

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



	public void actionPerformed(ActionEvent e) {




		if (e.getSource() == btnCancelar){

			ViewMenu vm = new ViewMenu(parIdioma,parPais);
			this.dispose();

		}

		if( e.getSource( ) == btnConfirmar )  { 




			try {

				int id = Integer.parseInt(txtId.getText());
				nome = txtNome.getText( );
				dataInicio = jfDataIni.getText( ).replace(" ","");
				dataTermino = jfDataTermino.getText( ).replace(" ","");
				horario = txtHorario.getText( );
				vagas = txtVagas.getText( );
				valor = Double.parseDouble(txtValor.getText( ));;
				numLab = txtNumLab.getText();
				regSoft = txtRegSoft.getText();


				if (verifica()){

					JOptionPane.showMessageDialog(null,"Preencha todos os campos");

				} else {

					ModelInformatica modelInformatica = new  ModelInformatica();
					

					Date dataInicioD = modelInformatica.formataData(dataInicio);
					Date dataTerminoD = modelInformatica.formataData(dataTermino);
					
					
					modelInformatica.setId(id);
					modelInformatica.setNome(nome);
					modelInformatica.setDataInicio(dataInicioD);
					modelInformatica.setDataTermino(dataTerminoD);
					modelInformatica.setHorario(horario);
					modelInformatica.setVagas(vagas);
					modelInformatica.setValor(valor);
					modelInformatica.setNumLab(numLab);
					modelInformatica.setRegSoft(regSoft);

					 
					modelInformatica.atualizar();
					
					modelo.removeRow(linhaSelecionada);


					modelo.addRow(new Object[]{modelInformatica.getId(), modelInformatica.getNome(),
							modelInformatica.getDataInicio(), modelInformatica.getDataTermino(),
							modelInformatica.getHorario(), modelInformatica.getVagas(),
							modelInformatica.getValor(), modelInformatica.getNumLab(),
							modelInformatica.getRegSoft() });

					limpar();
					setVisible(false);



				}
			}
			//Caso ocorra uma excessão, a mensagem será exibida na tela 
			catch (Exception ex){ 

				JOptionPane.showMessageDialog(null,ex);


			}             
		}
	}

}
