package View;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Model.ModelAluno;
import To.ToAluno;


public class ViewAlteraAluno extends JFrame implements ActionListener {

	private DefaultTableModel modelo = new DefaultTableModel(); 
	JButton btnConfirmar, btnCancelar;
	JLabel lblTitulo, lblId, lblNome, lblEndereco, lblTelefone, lblEmail, lblRg, lblCpf, lblLogin, lblSenha;
	JTextField txtId, txtNome, txtEndereco, txtEmail, txtLogin, txtSenha;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;
	JFormattedTextField jfCpf, jfRg, jfTelefone;
	String nome, endereco, telefone, email, rg, cpf, login, senha;


	private int linhaSelecionada; 



	public ViewAlteraAluno(DefaultTableModel md, int id, int linha){

		ToAluno toAluno = new ToAluno();
		DaoAluno daoAluno = new DaoAluno();

		criarJanela();
		modelo = md; 

		txtNome.requestFocus();

		toAluno = daoAluno.getAlunoById(id);

		txtId.setText(Integer.toString(toAluno.getId()));
		txtNome.setText(toAluno.getNome()); 
		txtEndereco.setText(toAluno.getEndereco()); 
		jfTelefone.setText(toAluno.getTelefone()); 
		txtEmail.setText(toAluno.getEmail());
		jfRg.setText(toAluno.getRg());
		jfCpf.setText(toAluno.getCpf());
		txtLogin.setText(toAluno.getLogin());
		txtSenha.setText(toAluno.getSenha());

		linhaSelecionada = linha; 
	}
	public void criarJanela(){

		setLayout(new BorderLayout());



		Container panelTitulo = new Container();
		panelTitulo.setLayout(new FlowLayout());

		lblTitulo = new JLabel ("Alterar Alunos:");
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

		lblEndereco = new JLabel ("Endereço");
		txtEndereco = new JTextField(40);

		lblTelefone = new JLabel ("Telefone");
		jfTelefone = new JFormattedTextField((setMascara("                            (##)                            ####                            -                            ####                            "))); 

		lblEmail = new JLabel ("Email");
		txtEmail = new JTextField(40);

		lblRg = new JLabel ("Rg");
		jfRg = new JFormattedTextField((setMascara("     AA     .     AAA     .     AAA     -     A"))); 


		lblCpf = new JLabel ("Cpf");
		jfCpf = new JFormattedTextField((setMascara("     AAA     .     AAA     .     AAA     -     AA"))); 

		lblLogin = new JLabel ("Login");
		txtLogin = new JTextField(40);

		lblSenha = new JLabel ("Senha");
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

	private MaskFormatter setMascara(String mascara){  
		MaskFormatter mask = null;  
		try {  
			mask = new MaskFormatter(mascara);                        
		} catch(java.text.ParseException ex){}  
		return mask;  
	}  



	@Override
	public void actionPerformed(ActionEvent e) {
		
		int id = Integer.parseInt(txtId.getText());
		nome = txtNome.getText( );
		endereco = txtEndereco.getText( );
		telefone = jfTelefone.getText( ).replace("(","").replace(")","").replace("-", "").replace(" ", "");
		email = txtEmail.getText( );
		rg = jfRg.getText( ).replace(".","").replace("-","").replace(" ", "");
		cpf = jfCpf.getText( ).replace(".","").replace("-","").replace(" ", "");
		login = txtLogin.getText( );
		senha = txtSenha.getText( );

		if (e.getSource() == btnConfirmar){

			if (verifica()){

				JOptionPane.showMessageDialog(null,"Preencha todos os campos");

			} else {

				try{

					
					ModelAluno modelAluno = new ModelAluno();
					modelAluno.setId(id);
					modelAluno.setNome(nome);
					modelAluno.setEndereco(endereco);
					modelAluno.setTelefone(telefone);
					modelAluno.setEmail(email);
					modelAluno.setRg(rg);
					modelAluno.setCpf(cpf);
					modelAluno.setLogin(login);
					modelAluno.setSenha(senha);
					
					modelAluno.atualizar();

					modelo.removeRow(linhaSelecionada);


					modelo.addRow(new Object[]{modelAluno.getId(), modelAluno.getNome(),
							modelAluno.getEndereco(), modelAluno.getTelefone(),
							modelAluno.getEmail(), modelAluno.getRg(),
							modelAluno.getCpf(), modelAluno.getLogin(), modelAluno.getSenha() });

					setVisible(false);

				}catch (Exception e1){

					JOptionPane.showMessageDialog(null,"Preencha os campos corretamente!");

				}

			}

		} else if (e.getSource()==btnCancelar){

			this.dispose();

		}

	}
}
