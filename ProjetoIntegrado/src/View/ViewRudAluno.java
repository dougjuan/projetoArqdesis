package View;


import Dao.DaoAluno;
import Model.ModelAluno;
import To.ToAluno;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewRudAluno extends JFrame implements ActionListener {

	JComboBox <String> cbEscolherBusca;
	JButton  btnCancelar, btnExcluir, btnAlterar, btnPesquisar, btnPreencher;
	JTextField txtPesquisar;
	JRadioButton jrbNome, jrbRg, jrbCpf, jrbLogin;
	JLabel lblTitulo, lblPesquisar;
	private ResourceBundle bn = null;
	private String parIdioma,parPais;
	private String msgErro1 , msgErro2 ,msgAlerta, msgPesquisar,msgRegistro,tituloAlerta;


	private DefaultTableModel modelo = new DefaultTableModel(); 
	private JTable tabela; 
	private JScrollPane barraRolagem; 


	public ViewRudAluno(String idioma ,String pais){

		//------------------- INTERNACIONALIZAÇÃO, CRIAÇÃO DA JTABLE E DEFINIÇÃO DO LAYOUT -----------------
		criaJTable();
		parIdioma = idioma;
		parPais= pais;
		
		
		setLayout(new FlowLayout());
		//------------------- INTERNACIONALIZAÇÃO, CRIAÇÃO DA JTABLE E DEFINIÇÃO DO LAYOUT -----------------





		//------------------------------------ TÍTULO ----------------------------------------------------
		Container panelTitulo = new Container();
		panelTitulo.setLayout(new FlowLayout());

		lblTitulo = new JLabel ();
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 16));

		panelTitulo.add(lblTitulo);
		//------------------------------------ TÍTULO ----------------------------------------------------





		//-------------------------------- A TABELA NO FRAME ---------------------------------------------
		barraRolagem = new JScrollPane(tabela); 

		JPanel panelInfo = new JPanel();


		panelInfo.setLayout(new FlowLayout());
		panelInfo.add(barraRolagem);		
		//-------------------------------- A TABELA NO FRAME ---------------------------------------------



		//-------------------------------- OS BOTÕES ------------------------------------------------------
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());

		btnCancelar = new JButton ();		
		btnExcluir = new JButton(); 
		btnAlterar = new JButton();
		btnPreencher = new JButton();

		panelBotoes.add(btnCancelar);
		panelBotoes.add(btnExcluir);
		panelBotoes.add(btnAlterar);
		panelBotoes.add(btnPreencher);
		//-------------------------------- OS BOTÕES ------------------------------------------------------


		//-------------------------------- A BUSCA ------------------------------------------------------		
		JPanel panelBusca = new JPanel();
		panelBusca.setLayout(new FlowLayout());


		lblPesquisar = new JLabel();


		txtPesquisar = new JTextField(30);		
		
		String[] strEscolherBusca ={"Código","Nome","Rg"};
		
		
		
		cbEscolherBusca = new JComboBox<String>(strEscolherBusca);

		btnPesquisar = new JButton ();
		

		panelBusca.add(lblPesquisar);
		panelBusca.add(txtPesquisar);
		panelBusca.add(cbEscolherBusca);
		panelBusca.add(btnPesquisar);
		//-------------------------------- A BUSCA ------------------------------------------------------






		//------------------------------ ADCIONANDO OS PAINEIS AO FRAME ----------------------------------
		add(panelTitulo);
		add(panelBusca);
		add(panelInfo);		
		add(panelBotoes);
		//------------------------------ ADCIONANDO OS PAINEIS AO FRAME ----------------------------------




		//------------------------------ ADCIONANDO EVENTO AOS BOTÕES ------------------------------------
		btnCancelar.addActionListener(this);
		btnExcluir.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnPreencher.addActionListener(this);
		//------------------------------ ADCIONADO EVENTO AOS BOTÕES ------------------------------------		



		// ---------------------------- MÉTODO DA MUDANÇA DE IDIOMA --------------------------------------	
		MudarIdioma(parIdioma, parPais);
		// ---------------------------- MÉTODO DA MUDANÇA DE IDIOMA --------------------------------------	




		//************************* CONFIGURAÇÕES DA JANELA ********************************
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 760) / 2);
		int y = (int) ((dimension.getHeight() - 600) / 2);
		setLocation(x, y);
		setSize(760,600);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//************************* CONFIGURAÇÕES DA JANELA ********************************

	}

	private void criaJTable() { 
		tabela = new JTable(modelo);
		modelo.addColumn("Id"); 
		modelo.addColumn("Nome");
		modelo.addColumn("Endereço");
		modelo.addColumn("telefone");
		modelo.addColumn("Email");
		modelo.addColumn("Rg"); 
		modelo.addColumn("Cpf");
		modelo.addColumn("Login");
		modelo.addColumn("senha");


		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(80); 
		tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(5).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(6).setPreferredWidth(80); 
		tabela.getColumnModel().getColumn(7).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(8).setPreferredWidth(120);


		pesquisar(modelo);

	} 

	public static void pesquisar(DefaultTableModel modelo) { 


		modelo.setNumRows(0);
		DaoAluno daoAluno = new DaoAluno();

		for ( ToAluno toAluno : daoAluno.getAlunos()) { 

			modelo.addRow(new Object[]{toAluno.getId(), toAluno.getNome(),
					toAluno.getEndereco(), toAluno.getTelefone(),
					toAluno.getEmail(), toAluno.getRg(),
					toAluno.getCpf(), toAluno.getLogin(), toAluno.getSenha() });


		}
	}

	public void MudarIdioma(String mIIdioma, String mIPais){
		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		setTitle (bn.getString("ProjetoIntegrado"));
		lblTitulo.setText(bn.getString("Consultar(Alterar/Excluir)Aluno"));
		btnCancelar.setText(bn.getString("Cancelar"));
		lblPesquisar.setText(bn.getString("Pesquisar"));
		btnPesquisar.setText(bn.getString("Pesquisar"));
		btnExcluir.setText(bn.getString("ExcluirRegistro"));
		btnAlterar.setText(bn.getString("AlterarRegistro"));
		btnPreencher.setText(bn.getString("PreencherTabela"));
		msgErro1 = bn.getString("msgErro1");
		msgErro2 = bn.getString("msgErro2");
		msgAlerta = bn.getString("msgAlerta");
		msgPesquisar= bn.getString("msgPesquisar");
		msgRegistro = bn.getString("msgRegistro");
		tituloAlerta = bn.getString("tituloAlerta");
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnPreencher){

			pesquisar(modelo);



		}else if (e.getSource() == btnCancelar){

			ViewMenu vm = new ViewMenu(parIdioma,parPais);
			this.dispose();

		} else if (e.getSource()==btnExcluir){

			int linhaSelecionada = -1;

			linhaSelecionada = tabela.getSelectedRow(); 

			if (linhaSelecionada >= 0) { 

				if (JOptionPane.showConfirmDialog(null, msgAlerta,tituloAlerta,
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					int idAluno = (int) tabela.getValueAt(linhaSelecionada, 0);
					
					
					ModelAluno modelAluno = new ModelAluno();
					modelAluno.excluir(idAluno); 
					
					
					
					modelo.removeRow(linhaSelecionada);

				} else {

				}

			} else {
				JOptionPane.showMessageDialog(null, msgErro1); 
			}




		} else if (e.getSource()==btnAlterar){


			//Caso a linha não seja selecionada, isso forçará o erro
			int linhaSelecionada = -1; 
			//Pega a linha clicada na tabela
			linhaSelecionada = tabela.getSelectedRow(); 
			//Se a linha for maior que zero 
			if (linhaSelecionada >= 0) { 
				//Pega id da linha
				int idAluno = (int) tabela.getValueAt(linhaSelecionada, 0);
				//Chama a tela de alteração passando a table, o id e a linha como parâmetro 
				ViewAlteraAluno vac = new ViewAlteraAluno(modelo, idAluno, linhaSelecionada);
				//mostra a tela
				vac.setVisible(true);

			} else { 
				JOptionPane.showMessageDialog(null, msgErro1); 
			}


		} else if (e.getSource()==btnPesquisar){


			if (txtPesquisar.getText().equals("")){

				JOptionPane.showMessageDialog(null,msgPesquisar);

			} 
			else {

				if(cbEscolherBusca.getSelectedIndex() == 0 ){


					try{

						ToAluno toAluno = new ToAluno();
						DaoAluno daoAluno = new DaoAluno();

						int pesquisarId = Integer.parseInt(txtPesquisar.getText());	

						toAluno = daoAluno.getAlunoById(pesquisarId);

						int x = modelo.getRowCount();
						for (int a = 0 ; a < x ; a++){

							modelo.removeRow(0);

						}
						modelo.addRow(new Object[]{toAluno.getId(), toAluno.getNome(),
								toAluno.getEndereco(), toAluno.getTelefone(),
								toAluno.getEmail(), toAluno.getRg(),
								toAluno.getCpf(), toAluno.getLogin(), toAluno.getSenha() });

						if(toAluno.getId()==0){
							modelo.removeRow(0);
							txtPesquisar.setText("");
							txtPesquisar.requestFocus();
							JOptionPane.showMessageDialog(null,msgRegistro);


						}


					} catch(Exception ex2 ){

						JOptionPane.showMessageDialog(null,msgErro2);


					}

				}
				else if(cbEscolherBusca.getSelectedIndex() == 1 ){


					try{

						ToAluno toAluno = new ToAluno();
						DaoAluno daoAluno = new DaoAluno();

						String pesquisarNome = txtPesquisar.getText();	

						toAluno = daoAluno.getAlunoByName(pesquisarNome);

						int x = modelo.getRowCount();
						for (int a = 0 ; a < x ; a++){

							modelo.removeRow(0);

						}


						modelo.addRow(new Object[]{toAluno.getId(), toAluno.getNome(),
								toAluno.getEndereco(), toAluno.getTelefone(),
								toAluno.getEmail(), toAluno.getRg(),
								toAluno.getCpf() ,toAluno.getLogin(), toAluno.getSenha() });

						if(toAluno.getId()==0){

							modelo.removeRow(0);
							txtPesquisar.setText("");
							txtPesquisar.requestFocus();
							JOptionPane.showMessageDialog(null,msgRegistro);

						}

					} catch(Exception ex2 ){

						JOptionPane.showMessageDialog(null,msgErro2);


					}
				}

				else if (cbEscolherBusca.getSelectedIndex() == 2 ){



					try{

						ToAluno toAluno = new ToAluno();
						DaoAluno daoAluno = new DaoAluno();

						String pesquisarRg = txtPesquisar.getText();	

						toAluno = daoAluno.getAlunoByRg(pesquisarRg);

						int x = modelo.getRowCount();
						for (int a = 0 ; a < x ; a++){

							modelo.removeRow(0);

						}


						modelo.addRow(new Object[]{toAluno.getId(), toAluno.getNome(),
								toAluno.getEndereco(), toAluno.getTelefone(),
								toAluno.getEmail(), toAluno.getRg(),
								toAluno.getCpf() ,toAluno.getLogin(), toAluno.getSenha() });

						if(toAluno.getId()==0){

							modelo.removeRow(0);
							txtPesquisar.setText("");
							txtPesquisar.requestFocus();
							JOptionPane.showMessageDialog(null,msgRegistro);

						}

					} catch(Exception ex2 ){

						JOptionPane.showMessageDialog(null,msgErro2);


					}

				}
			}

		} 


	}


}
