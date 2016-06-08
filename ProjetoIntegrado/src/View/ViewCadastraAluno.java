package View;

import Dao.DaoAluno;




import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Model.ModelAluno;
import To.ToAluno;


public class ViewCadastraAluno extends JFrame implements ActionListener {

	JButton btnConfirmar, btnCancelar;
	JLabel lblTitulo, lblId, lblNome, lblEndereco, lblTelefone, lblEmail, lblRg, lblCpf, lblLogin, lblSenha;
	JTextField txtId, txtNome, txtEndereco, txtEmail, txtLogin, txtSenha;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;
	String nome, endereco, telefone, email, rg, cpf, login, senha;
	JFormattedTextField jfCpf, jfRg, jfTelefone;


	public ViewCadastraAluno(String idioma ,String pais){
		parIdioma = idioma;
		parPais= pais;

		setLayout(new BorderLayout());




		Container panelTitulo = new Container();
		panelTitulo.setLayout(new FlowLayout());

		lblTitulo = new JLabel ("Cadastrar Alunos:");
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 16));

		panelTitulo.add(lblTitulo);

		//---------------------------------------------------------------------------------

		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new FlowLayout());

		lblId = new JLabel("Id");
		txtId = new JTextField(40);
		txtId.setEditable(false);

		lblNome = new JLabel ();
		txtNome = new JTextField(40);
		txtNome.requestFocus();

		lblEndereco = new JLabel ();
		txtEndereco = new JTextField(40);

		lblTelefone = new JLabel ();
		jfTelefone = new JFormattedTextField((setMascara("                            (##)                            ####                            -                            ####                            "))); 

		lblEmail = new JLabel ();
		txtEmail = new JTextField(40);

		lblRg = new JLabel ();
		jfRg = new JFormattedTextField((setMascara("       AA       .       AAA       .       AAA       -       A"))); 

		lblCpf = new JLabel ();
		jfCpf = new JFormattedTextField((setMascara("       AAA       .       AAA       .       AAA       -       AA"))); 

		lblLogin = new JLabel ();
		txtLogin = new JTextField(40);

		lblSenha = new JLabel ();
		txtSenha = new JTextField(40);

		panelInfo.add(lblId);
		panelInfo.add(txtId);
		panelInfo.add(lblNome);
		panelInfo.add(txtNome);
		panelInfo.add(lblEndereco);
		panelInfo.add(txtEndereco);
		panelInfo.add(lblTelefone);
		panelInfo.add(jfTelefone);
		panelInfo.add(lblEmail);
		panelInfo.add(txtEmail);
		panelInfo.add(lblRg);
		panelInfo.add(jfRg);
		panelInfo.add(lblCpf);
		panelInfo.add(jfCpf);
		panelInfo.add(lblLogin);
		panelInfo.add(txtLogin);
		panelInfo.add(lblSenha);
		panelInfo.add(txtSenha);



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

		//************************* CONFIGURAÇÕES DA JANELA ********************************
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 485) / 2);
		int y = (int) ((dimension.getHeight() - 570) / 2);
		setLocation(x, y);
		setSize(485,570);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//************************* CONFIGURAÇÕES DA JANELA ********************************

	}//CHAVE DO MÉTODO CONSTRUTOR

	public void MudarIdioma(String mIIdioma, String mIPais){
		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		setTitle (bn.getString("ProjetoIntegrado"));
		lblNome.setText(bn.getString("Nome"));
		lblTitulo.setText(bn.getString("CadastrarAlunos"));
		lblEndereco.setText(bn.getString("Endereço"));
		lblTelefone.setText(bn.getString("Telefone"));
		lblEmail.setText(bn.getString("Email"));
		lblRg.setText(bn.getString("RG"));
		lblLogin.setText(bn.getString("Login"));
		lblSenha.setText(bn.getString("Senha"));
		lblCpf.setText(bn.getString("CPF"));
		btnCancelar.setText(bn.getString("Cancelar"));
		btnConfirmar.setText(bn.getString("Confirmar"));


	}

	//************************* Metodo para limpar os campos ********************************
	public void limpar(){

		//Este método "limpa" os campos de texto enviando "" (nada)
		txtNome.setText("");
		txtEndereco.setText("");
		jfTelefone.setText("");
		txtEmail.setText("");
		jfRg.setText(""); 
		jfCpf.setText("");
		txtLogin.setText("");
		txtSenha.setText("");

	}
	
	private MaskFormatter setMascara(String mascara){  
		MaskFormatter mask = null;  
		try {  
			mask = new MaskFormatter(mascara);                        
		} catch(java.text.ParseException ex){}  
		return mask;  
	}  


	//---------------------------------------------------------------------------------------------

	public boolean verifica(){

		boolean flag = false;


		if(nome.equals("")){

			flag = true; 

		}
		if(endereco.equals("")){

			flag = true; 

		}
		if(telefone.equals("")){

			flag = true; 

		}
		if(email.equals("")){
			flag = true; 
		}
		if(rg.equals("")){

			flag = true; 
		}
		if(cpf.equals("")){

			flag = true; 
		}
		if(login.equals("")){

			flag = true; 

		}
		if(senha.equals("")){

			flag = true; 

		}




		return flag;	

	}

	//---------------------------------------------------------------------------------------------


	//******************************* EVENTO DOS BOTÕES ************************************
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		nome = txtNome.getText( );
		endereco = txtEndereco.getText( );
		telefone = jfTelefone.getText( ).replace("(","").replace(")","").replace("-", "").replace(" ", "");
		email = txtEmail.getText( );
		rg = jfRg.getText( ).replace(".","").replace("-","").replace(" ", "");
		cpf = jfCpf.getText( ).replace(".","").replace("-","").replace(" ", "");
		login = txtLogin.getText( );
		senha = txtSenha.getText( );

		if (e.getSource() == btnCancelar){

			ViewMenu vm = new ViewMenu(parIdioma,parPais);
			this.dispose();

		}
		if( e.getSource( ) == btnConfirmar )  { 

			if (verifica()){

				JOptionPane.showMessageDialog(null,"Preencha todos os campos");

			} else {

				try {

					ModelAluno modelAluno = new ModelAluno();
					
					modelAluno.setNome(nome);
					modelAluno.setEndereco(endereco);
					modelAluno.setTelefone(telefone);
					modelAluno.setEmail(email);
					modelAluno.setRg(rg);
					modelAluno.setCpf(cpf);
					modelAluno.setLogin(login);
					modelAluno.setSenha(senha);
					
					modelAluno.criar();
					
					txtNome.requestFocus();
					limpar();


				}
				//Caso ocorra uma excessão, a mensagem será exibida na tela 
				catch (Exception ex){ 

					JOptionPane.showMessageDialog(null,ex);


				}             

			}

		}
	

	}

}