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

import Dao.DaoInformatica;
import Model.ModelInformatica;
import To.ToInformatica;


public class ViewConsultaInformatica extends JFrame implements ActionListener{

	JComboBox <String> cbEscolherBusca;
	JButton btnConfirmar, btnCancelar, btnPesquisar, btnPreencher;
	JTextField txtPesquisar;
	JLabel lblTitulo, lblPesquisar;
	private ResourceBundle bn = null;
	private String parIdioma,parPais,msgErro1;

	private DefaultTableModel modelo = new DefaultTableModel(); 
	private JTable tabela; 
	private JScrollPane barraRolagem; 

	public ViewConsultaInformatica(String idioma ,String pais){

		//------------------- INTERNACIONALIZA플O, CRIA플O DA JTABLE E DEFINI플O DO LAYOUT -----------------
		criaJTable();
		parIdioma = idioma;
		parPais= pais;
		setLayout(new FlowLayout());
		//------------------- INTERNACIONALIZA플O, CRIA플O DA JTABLE E DEFINI플O DO LAYOUT -----------------


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


		//-------------------------------- A BUSCA ------------------------------------------------------		
		JPanel panelBusca = new JPanel();
		panelBusca.setLayout(new FlowLayout());


		lblPesquisar = new JLabel();


		txtPesquisar = new JTextField(30);		

		String[] strEscolherBusca ={"C�digo","Nome do curso","N� de vagas"};
		cbEscolherBusca = new JComboBox<String>(strEscolherBusca);

		btnPesquisar = new JButton ();

		panelBusca.add(lblPesquisar);
		panelBusca.add(txtPesquisar);
		panelBusca.add(cbEscolherBusca);
		panelBusca.add(btnPesquisar);

		btnPesquisar.addActionListener(this);
		//-------------------------------- A BUSCA ------------------------------------------------------

		//-------------------------------- OS BOT�ES ------------------------------------------------------
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());

		btnCancelar = new JButton ();		
		btnPreencher = new JButton();


		panelBotoes.add(btnCancelar);
		panelBotoes.add(btnPreencher);

		btnCancelar.addActionListener(this);
		btnPreencher.addActionListener(this);
		//-------------------------------- OS BOT�ES ------------------------------------------------------




		//------------------------------ ADCIONANDO OS PAINEIS AO FRAME ----------------------------------
		add(panelTitulo);
		add(panelBusca);
		add(panelInfo);	
		add(panelBotoes);
		//------------------------------ ADCIONANDO OS PAINEIS AO FRAME ----------------------------------





		// ---------------------------- M�TODO DA MUDAN�A DE IDIOMA --------------------------------------	
		MudarIdioma(parIdioma, parPais);
		// ---------------------------- M�TODO DA MUDAN�A DE IDIOMA --------------------------------------	






		//************************* CONFIGURA합ES DA JANELA ********************************
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 760) / 2);
		int y = (int) ((dimension.getHeight() - 600) / 2);
		setLocation(x, y);
		setSize(760,600);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		//************************* CONFIGURA합ES DA JANELA ********************************


	}

	private void criaJTable() { 

		tabela = new JTable(modelo);

		modelo.addColumn("Id"); 
		modelo.addColumn("Nome");
		modelo.addColumn("Data de in�cio");
		modelo.addColumn("Data de t�rmino");
		modelo.addColumn("Hor�rio");
		modelo.addColumn("Vagas"); 
		modelo.addColumn("Valor");
		modelo.addColumn("N�mero do labor�torio");
		modelo.addColumn("Registro de Software");

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
		DaoInformatica daoInformatica = new DaoInformatica();

		for (ToInformatica toInformatica : daoInformatica.getInformatica()) { 

			modelo.addRow(new Object[]{toInformatica.getId(), toInformatica.getNome(),
					toInformatica.getDataInicio(), toInformatica.getDataTermino(),
					toInformatica.getHorario(), toInformatica.getVagas(),
					toInformatica.getValor(), toInformatica.getNumLab(),
					toInformatica.getRegSoft() });

			//(NOME, DATAINICIO, DATATERMINO, HORARIO, NUMEROVAGAS, VALOR, NUMEROLABORATORIO, REGISTROSOFTWARE)

		}
	}
	public void MudarIdioma(String mIIdioma, String mIPais){
		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		setTitle (bn.getString("ProjetoIntegrado"));
		lblTitulo.setText(bn.getString("Consultar(Alterar/Excluir)Curso"));
		btnCancelar.setText(bn.getString("Cancelar"));
		btnPreencher.setText(bn.getString("PreencherTabela"));
		lblPesquisar.setText(bn.getString("Pesquisar"));
		btnPesquisar.setText(bn.getString("Pesquisar"));
		msgErro1 = bn.getString("msgErro1");
		



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnCancelar){

			ViewMenuAluno vma = new ViewMenuAluno(parIdioma,parPais);
			this.dispose();



		} else if (e.getSource()==btnPesquisar){

			if(cbEscolherBusca.getSelectedIndex() == 0 ){


				try{

					ToInformatica toInformatica = new ToInformatica();
					DaoInformatica daoInformatica = new DaoInformatica();

					int pesquisarId = Integer.parseInt(txtPesquisar.getText());	

					toInformatica = daoInformatica.getInformaticaById(pesquisarId);

					int x = modelo.getRowCount();
					for (int a = 0 ; a < x ; a++){

						modelo.removeRow(0);

					}

					modelo.addRow(new Object[]{toInformatica.getId(), toInformatica.getNome(),
							toInformatica.getDataInicio(), toInformatica.getDataTermino(),
							toInformatica.getHorario(), toInformatica.getVagas(),
							toInformatica.getValor(), toInformatica.getNumLab(),
							toInformatica.getRegSoft() });



				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro1);


				}

			}
			else if(cbEscolherBusca.getSelectedIndex() == 1 ){


				try{

					ToInformatica toInformatica = new ToInformatica();
					DaoInformatica daoInformatica = new DaoInformatica();

					String pesquisar = txtPesquisar.getText();	

					toInformatica = daoInformatica.getInformaticaByNome(pesquisar);

					int x = modelo.getRowCount();
					for (int a = 0 ; a < x ; a++){

						modelo.removeRow(0);

					}
					
					
					
					modelo.addRow(new Object[]{toInformatica.getId(), toInformatica.getNome(),
							toInformatica.getDataInicio(), toInformatica.getDataTermino(),
							toInformatica.getHorario(), toInformatica.getVagas(),
							toInformatica.getValor(), toInformatica.getNumLab(),
							toInformatica.getRegSoft() });



				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro1);


				}

			}

			else if (cbEscolherBusca.getSelectedIndex() == 2 ){



				try{

					ToInformatica toInformatica = new ToInformatica();
					DaoInformatica daoInformatica = new DaoInformatica();

					String pesquisar = txtPesquisar.getText();	

					toInformatica = daoInformatica.getInformaticaByVagas(pesquisar);

					int x = modelo.getRowCount();
					for (int a = 0 ; a < x ; a++){

						modelo.removeRow(0);

					}

					modelo.addRow(new Object[]{toInformatica.getId(), toInformatica.getNome(),
							toInformatica.getDataInicio(), toInformatica.getDataTermino(),
							toInformatica.getHorario(), toInformatica.getVagas(),
							toInformatica.getValor(), toInformatica.getNumLab(),
							toInformatica.getRegSoft() });



				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro1);


				}
			}

		} else if (e.getSource()==btnPreencher){

			pesquisar(modelo);

		}

	}

}
