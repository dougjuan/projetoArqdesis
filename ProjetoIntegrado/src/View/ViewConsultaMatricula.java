package View;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.DaoMatricula;
import Model.ModelMatricula;

public class ViewConsultaMatricula extends JFrame implements ActionListener{

	JComboBox <String> cbEscolherBusca;
	JButton btnConfirmar, btnCancelar, btnPesquisar, btnPreencher;
	JTextField txtPesquisar;
	JLabel lblTitulo, lblPesquisar;
	private ResourceBundle bn = null;
	private String parIdioma,parPais,msgErro1,msgErro2;

	private DefaultTableModel modelo = new DefaultTableModel(); 
	private JTable tabela; 
	private JScrollPane barraRolagem; 

	public ViewConsultaMatricula(String idioma ,String pais){

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


		//-------------------------------- A BUSCA ------------------------------------------------------		
		JPanel panelBusca = new JPanel();
		panelBusca.setLayout(new FlowLayout());


		lblPesquisar = new JLabel("Pesquisar");


		txtPesquisar = new JTextField(30);		

		String[] strEscolherBusca ={"Código da matrícula","Status do Pagamento","Status da Matrícula"};
		cbEscolherBusca = new JComboBox<String>(strEscolherBusca);


		btnPesquisar = new JButton ("Pesquisar");

		panelBusca.add(lblPesquisar);
		panelBusca.add(txtPesquisar);
		panelBusca.add(cbEscolherBusca);
		panelBusca.add(btnPesquisar);

		btnPesquisar.addActionListener(this);
		//-------------------------------- A BUSCA ------------------------------------------------------

		//-------------------------------- OS BOTÕES ------------------------------------------------------
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());

		btnCancelar = new JButton ();		
		btnPreencher = new JButton();


		panelBotoes.add(btnCancelar);
		panelBotoes.add(btnPreencher);

		btnCancelar.addActionListener(this);
		btnPreencher.addActionListener(this);
		//-------------------------------- OS BOTÕES ------------------------------------------------------




		//------------------------------ ADCIONANDO OS PAINEIS AO FRAME ----------------------------------
		add(panelTitulo);
		add(panelBusca);
		add(panelInfo);	
		add(panelBotoes);
		//------------------------------ ADCIONANDO OS PAINEIS AO FRAME ----------------------------------





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

		modelo.addColumn("ID"); 
		modelo.addColumn("Data da matrícula");
		modelo.addColumn("Valor da matrícula");
		modelo.addColumn("Status do Pagamento");
		modelo.addColumn("Status da matrícula");


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
		btnPreencher.setText(bn.getString("PreencherTabela"));
		lblPesquisar.setText(bn.getString("Pesquisar"));
		btnPesquisar.setText(bn.getString("Pesquisar"));
		msgErro1 = bn.getString("msgErro1");
		msgErro2 = bn.getString("msgErro2");
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar){

			ViewMenu vm = new ViewMenu(parIdioma,parPais);
			this.dispose();

		}  else if (e.getSource()==btnPreencher){
			
			pesquisar(modelo);
			
		} else if (e.getSource()==btnPesquisar){

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


				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro1);

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

					modelo.addRow(new Object[]{modelMatricula.getId(), modelMatricula.getDataMatricula(),
							modelMatricula.getValorMatricula(), modelMatricula.getStatusPagamento(),
							modelMatricula.getStatusMatricula() });


				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro1);


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

					modelo.addRow(new Object[]{modelMatricula.getId(), modelMatricula.getDataMatricula(),
							modelMatricula.getValorMatricula(), modelMatricula.getStatusPagamento(),
							modelMatricula.getStatusMatricula() });


				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro1);


				}



			}
		}




	}

}
