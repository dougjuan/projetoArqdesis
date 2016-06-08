package View;
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

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.DaoAluno;
import Dao.DaoMatricula;
import Model.ModelAluno;
import Model.ModelMatricula;

public class ViewCancelaMatricula extends JFrame implements ActionListener {

	JButton btnCancelar, btnExcluir;
	JLabel lblTitulo, lblIdMatricula;
	JTextField txtIdMatricula;
	private ResourceBundle bn = null;
	private String parIdioma,parPais,msgErro1,msgErro2;
	private DefaultTableModel modelo = new DefaultTableModel(); 
	private JTable tabela; 
	private JScrollPane barraRolagem;
	private JLabel lblPesquisar;
	private JTextField txtPesquisar;
	private JComboBox<String> cbEscolherBusca;
	private JButton btnPesquisar;
	private JButton btnPreencher; 



	public ViewCancelaMatricula(String idioma ,String pais){

		//------------------- INTERNACIONALIZA��O, CRIA��O DA JTABLE E DEFINI��O DO LAYOUT -----------------

		criaJTable();
		parIdioma = idioma;
		parPais= pais;
		setLayout(new FlowLayout());


		//------------------- INTERNACIONALIZA��O, CRIA��O DA JTABLE E DEFINI��O DO LAYOUT -----------------




		//------------------------------------ T�TULO ----------------------------------------------------

		Container panelTitulo = new Container();
		panelTitulo.setLayout(new FlowLayout());

		lblTitulo = new JLabel ();
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 16));

		panelTitulo.add(lblTitulo);

		//------------------------------------ T�TULO ----------------------------------------------------


		//-------------------------------- A TABELA NO FRAME ---------------------------------------------

		barraRolagem = new JScrollPane(tabela); 

		JPanel panelInfo = new JPanel();


		panelInfo.setLayout(new FlowLayout());
		panelInfo.add(barraRolagem);

		//-------------------------------- A TABELA NO FRAME ---------------------------------------------



		//-------------------------------- OS BOT�ES ------------------------------------------------------

		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());

		btnCancelar= new JButton ();			
		btnExcluir = new JButton();
		btnPreencher = new JButton();

		panelBotoes.add(btnCancelar);		
		panelBotoes.add(btnExcluir);
		panelBotoes.add(btnPreencher);
		//-------------------------------- OS BOT�ES ------------------------------------------------------




		//-------------------------------- A BUSCA ------------------------------------------------------		
		JPanel panelBusca = new JPanel();
		panelBusca.setLayout(new FlowLayout());


		lblPesquisar = new JLabel();


		txtPesquisar = new JTextField(30);		

		String[] strEscolherBusca ={"C�digo da matr�cula","Status do Pagamento","Status da Matr�cula"};
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



		//------------------------------ ADCIONANDO EVENTO AOS BOT�ES ------------------------------------
		btnCancelar.addActionListener(this);
		btnExcluir.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnPreencher.addActionListener(this);
		//------------------------------ ADCIONANDO EVENTO AOS BOT�ES ------------------------------------


		// ---------------------------- M�TODO DA MUDAN�A DE IDIOMA --------------------------------------
		MudarIdioma(parIdioma, parPais);
		// ---------------------------- M�TODO DA MUDAN�A DE IDIOMA --------------------------------------




		//************************* CONFIGURA��ES DA JANELA ********************************
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 700) / 2);
		int y = (int) ((dimension.getHeight() - 600) / 2);
		setLocation(x, y);
		setSize(700,600);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//************************* CONFIGURA��ES DA JANELA ********************************

	}

	private void criaJTable() { 
		tabela = new JTable(modelo);

		modelo.addColumn("ID"); 
		modelo.addColumn("Data da matr�cula");
		modelo.addColumn("Valor da matr�cula");
		modelo.addColumn("Status do Pagamento");
		modelo.addColumn("Status da matr�cula");


		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(520);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(500); 
		tabela.getColumnModel().getColumn(3).setPreferredWidth(500);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(500);



		pesquisar(modelo);
	} 
	public static void pesquisar(DefaultTableModel modelo) { 

		modelo.setNumRows(0);
		DaoMatricula daoMatricula = new DaoMatricula();

		for (ModelMatricula modelMatricula : daoMatricula.getMatriculas()) { 

			modelo.addRow(new Object[]{modelMatricula.getId(), modelMatricula.getDataMatricula(),
					modelMatricula.getValorMatricula(), modelMatricula.getStatusPagamento(),
					modelMatricula.getStatusMatricula() });

		}
	}


	public void MudarIdioma(String mIIdioma, String mIPais){

		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		setTitle (bn.getString("ProjetoIntegrado"));
		lblTitulo.setText(bn.getString("CancelarMatricula"));
		btnCancelar.setText(bn.getString("Cancelar"));
		lblPesquisar.setText(bn.getString("Pesquisar"));
		btnPesquisar.setText(bn.getString("Pesquisar"));
		btnExcluir.setText(bn.getString("ExcluirRegistro"));
		btnPreencher.setText(bn.getString("PreencherTabela"));
		msgErro1 = bn.getString("msgErro1");
		msgErro2 = bn.getString("msgErro2");


	}

	public void limpar(){

		//Este m�todo "limpa" os campos de texto enviando "" (nada)



	}




	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == btnCancelar){

			ViewMenu vm = new ViewMenu(parIdioma,parPais);
			this.dispose();

		}


		if( e.getSource( ) == btnExcluir )  { 


			int linhaSelecionada = -1; linhaSelecionada = tabela.getSelectedRow(); 

			if (linhaSelecionada >= 0) { 
				int idMatricula = (int) tabela.getValueAt(linhaSelecionada, 0);
				DaoMatricula daoMatricula = new DaoMatricula();
				daoMatricula.remover(idMatricula); 
				modelo.removeRow(linhaSelecionada);

			} else {

				JOptionPane.showMessageDialog(null, msgErro1); 

			}

		} else if (e.getSource()==btnPreencher){

			pesquisar(modelo);



		} else if (e.getSource()==btnPesquisar){

			if (txtPesquisar.getText().equals("")){

				JOptionPane.showMessageDialog(null,"Preencha o campo pesquisar!");

			} 

			if(cbEscolherBusca.getSelectedIndex() == 0 ){


				try{

					ModelMatricula modelMatricula = new ModelMatricula();
					DaoMatricula daoMatricula = new DaoMatricula();

					int pesquisarId = (Integer.parseInt(txtPesquisar.getText()));	

					modelMatricula = daoMatricula.getMatriculaById(pesquisarId);

					int x = modelo.getRowCount();
					for (int a = 0 ; a < x ; a++){

						modelo.removeRow(0);

					}

					modelo.addRow(new Object[]{modelMatricula.getId(), modelMatricula.getDataMatricula(),
							modelMatricula.getValorMatricula(), modelMatricula.getStatusPagamento(),
							modelMatricula.getStatusMatricula() });

					if(modelMatricula.getId()==0){
						modelo.removeRow(0);
						txtPesquisar.setText("");
						txtPesquisar.requestFocus();
						JOptionPane.showMessageDialog(null,"N�o foram encontrados registros!");


					}

				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro2);

				}

			}
			else if(cbEscolherBusca.getSelectedIndex() == 1 ){

				try{

					ModelMatricula modelMatricula = new ModelMatricula();
					DaoMatricula daoMatricula = new DaoMatricula();

					String pesquisar = txtPesquisar.getText();	

					modelMatricula = daoMatricula.getMatriculaByStatusDoPagamento(pesquisar);

					int x = modelo.getRowCount();
					for (int a = 0 ; a < x ; a++){

						modelo.removeRow(0);

					}

					if(modelMatricula.getId()==0){
						modelo.removeRow(0);
						txtPesquisar.setText("");
						txtPesquisar.requestFocus();
						JOptionPane.showMessageDialog(null,"N�o foram encontrados registros!");


					}

					modelo.addRow(new Object[]{modelMatricula.getId(), modelMatricula.getDataMatricula(),
							modelMatricula.getValorMatricula(), modelMatricula.getStatusPagamento(),
							modelMatricula.getStatusMatricula() });


				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro2);


				}




			}

			else if(cbEscolherBusca.getSelectedIndex() == 2 ){

				try{

					ModelMatricula modelMatricula = new ModelMatricula();
					DaoMatricula daoMatricula = new DaoMatricula();

					String pesquisar = txtPesquisar.getText();	

					modelMatricula = daoMatricula.getMatriculaByStatusDaMatricula(pesquisar);

					int x = modelo.getRowCount();
					for (int a = 0 ; a < x ; a++){

						modelo.removeRow(0);

					}
					if(modelMatricula.getId()==0){
						modelo.removeRow(0);
						txtPesquisar.setText("");
						txtPesquisar.requestFocus();
						JOptionPane.showMessageDialog(null,"N�o foram encontrados registros!");


					}
					modelo.addRow(new Object[]{modelMatricula.getId(), modelMatricula.getDataMatricula(),
							modelMatricula.getValorMatricula(), modelMatricula.getStatusPagamento(),
							modelMatricula.getStatusMatricula() });


				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro2);


				}



			}
		}
	}
}
