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

public class ViewRudInformatica extends JFrame implements ActionListener {
	JComboBox <String> cbEscolherBusca;
	JButton btnCancelar, btnExcluir, btnAlterar, btnPesquisar, btnPreencher;
	JTextField txtPesquisar;
	JLabel lblTitulo, lblPesquisar;
	private ResourceBundle bn = null;
	private String parIdioma,parPais,msgErro1 , msgErro2,msgAlerta,msgPesquisar,msgRegistro,tituloAlerta;

	private DefaultTableModel modelo = new DefaultTableModel(); 
	private JTable tabela; 
	private JScrollPane barraRolagem; 

	public ViewRudInformatica(String idioma ,String pais){

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

		String[] strEscolherBusca ={"Código","Nome do curso","Nº de vagas"};
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
		modelo.addColumn("Data de início");
		modelo.addColumn("Data de término");
		modelo.addColumn("Horário");
		modelo.addColumn("Vagas"); 
		modelo.addColumn("Valor");
		modelo.addColumn("Número do laborátorio");
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
		if (e.getSource()==btnPreencher){

			pesquisar(modelo);
		}
		else if (e.getSource() == btnCancelar){

			ViewMenu vm = new ViewMenu(parIdioma,parPais);
			this.dispose();



		} else if (e.getSource()==btnExcluir){

			int linhaSelecionada = -1;

			linhaSelecionada = tabela.getSelectedRow(); 

			if (linhaSelecionada >= 0) { 

				if (JOptionPane.showConfirmDialog(null, msgAlerta, tituloAlerta,
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {


					int idInformatica = (int) tabela.getValueAt(linhaSelecionada, 0);
					DaoInformatica daoInformatica = new DaoInformatica();
					daoInformatica.remover(idInformatica); 
					modelo.removeRow(linhaSelecionada);

				} else {

				}
			} else {
				JOptionPane.showMessageDialog(null, msgErro1); 
			}

		}else if (e.getSource()==btnAlterar){

			//Caso a linha não seja selecionada, isso forçará o erro
			int linhaSelecionada = -1; 
			//Pega a linha clicada na tabela
			linhaSelecionada = tabela.getSelectedRow(); 
			//Se a linha for maior que zero 
			if (linhaSelecionada >= 0) { 
				//Pega id da linha
				int idInformatica = (int) tabela.getValueAt(linhaSelecionada, 0);
				//Chama a tela de alteração passando a table, o id e a linha como parâmetro 
				ViewAlteraInformatica vai = new ViewAlteraInformatica(modelo, idInformatica, linhaSelecionada);
				//mostra a tela
				vai.setVisible(true);

			} else { 
				JOptionPane.showMessageDialog(null, msgErro1); 
			}
		} else if (e.getSource()==btnPesquisar){

			if (txtPesquisar.getText().equals("")){

				JOptionPane.showMessageDialog(null,msgPesquisar);

			} 

			else if(cbEscolherBusca.getSelectedIndex() == 0 ){


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

					if(toInformatica.getId()==0){
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

					if(toInformatica.getId()==0){
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

					if(toInformatica.getId()==0){
						modelo.removeRow(0);
						txtPesquisar.setText("");
						txtPesquisar.requestFocus();
						JOptionPane.showMessageDialog(null,msgRegistro);

					}



				} catch(Exception ex2 ){

					JOptionPane.showMessageDialog(null,msgErro2);


				}
			}

		} else if (e.getSource()==btnPreencher){

			pesquisar(modelo);

		}

	}
}