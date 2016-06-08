package View;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewLogin extends JFrame implements ActionListener   {

	JLabel lblUsuario, lblSenha;
	JTextField txtUsuario, txtSenha;
	JButton btnConfirmar, btnCancelar;
	private ResourceBundle bn = null;
	private String parIdioma ,parPais ,msgErro1 , msgNivelAcesso,msgSenha,msgUsuario;
	String nomeArq="login.txt"; //NOME DO ARQUIVO
	String linha = "";//VAI RECEBER O Q ESTÁ DENTRO DO TXT
	File arq = new File(nomeArq); 
	int nivelAcesso = 0;
	JPanel panelUsuario, panelSenha, panelBotoes;



	public ViewLogin(String idioma ,String pais){

		parIdioma = idioma;
		parPais = pais;


		//TÍTULO
		setLayout(new FlowLayout());

		//CRIANDO E DEFININDO O LAYOUT DO CONTAINER

		/************************** CRIANDO LABELS E TEXTFIELDS *****************************/
		lblUsuario = new JLabel();
		txtUsuario = new JTextField(20);
		panelUsuario = new JPanel();

		panelUsuario.add(lblUsuario);
		panelUsuario.add(txtUsuario);

		lblSenha = new JLabel();		
		txtSenha = new JTextField(20);
		panelSenha = new JPanel();

		panelSenha.add(lblSenha);
		panelSenha.add(txtSenha);




		/************************** CRIANDO LABELS E TEXTFIELDS *****************************/


		/********************************** CRIANDO BOTÕES **********************************/
		panelBotoes = new JPanel();

		btnConfirmar = new JButton();
		btnCancelar = new JButton();

		panelBotoes.add(btnCancelar);
		panelBotoes.add(btnConfirmar);


		btnConfirmar.addActionListener(this);
		btnCancelar.addActionListener(this);
		/********************************** CRIANDO BOTÕES **********************************/

		MudarIdioma(parIdioma, parPais);


		add(panelUsuario);
		add(panelSenha);
		add(panelBotoes);

		/************************** CONFIGURAÇÕES DA JANELA ********************************/
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 360) / 2);
		int y = (int) ((dimension.getHeight() - 160) / 2);
		setLocation(x, y);
		setSize(360,160);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		/************************** CONFIGURAÇÕES DA JANELA ********************************/



	}

	public void MudarIdioma(String mIIdioma, String mIPais){
		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		setTitle (bn.getString("ProjetoIntegrado"));
		lblUsuario.setText(bn.getString("Usuario"));
		btnConfirmar.setText(bn.getString("Confirmar"));
		btnCancelar.setText(bn.getString("Cancelar"));
		lblSenha.setText(bn.getString("Senha"));
		msgErro1 = bn.getString("msgErro1");
		msgSenha = bn.getString("msgSenha");
		msgUsuario = bn.getString("msgUsuario");
		msgNivelAcesso = bn.getString("msgNivelAcesso");
	}

	public int buscaUsuario(String[][] vet, String x){
		for (int i = 0; i < vet.length; i++) {
			if (vet[i][0].equalsIgnoreCase(x)) {

				return i;           	
			}
		}
		return -1;
	}

	public int buscaSenha(String[][] vet, String x){
		for (int i = 0; i < vet.length; i++) {
			if (vet[i][1].equalsIgnoreCase(x)) {

				return i;         	
			}
		}
		return -1;
	}
	public void actionPerformed(ActionEvent e) {		

		String usuario = txtUsuario.getText();
		String senha = txtSenha.getText();

		if (e.getSource() == btnConfirmar){


			/****************************************** LÊ O ARQUIVO ***********************************/
			if (arq.exists()){     
				try{            
					FileReader reader = new FileReader(nomeArq);
					BufferedReader leitor = new BufferedReader(reader); 
					linha=leitor.readLine();
				}
				catch(Exception erro) {

					erro.printStackTrace();
				}
			}
			/****************************************** LÊ O ARQUIVO ***********************************/
			ViewCriptografia vc = new ViewCriptografia();
			String linhadescriptografa = vc.Descriptografa(linha);

			String[] arrayLinha = linhadescriptografa.split("&");

			Arrays.sort(arrayLinha);

			String [][] arrayFinal = new String[arrayLinha.length][];
			for (int i = 0 ; i < arrayLinha.length ; i++){
				arrayFinal[i] = String.valueOf(arrayLinha[i]).split("%");
			}


		
				if (buscaUsuario(arrayFinal,usuario)>=0){

					if (buscaSenha(arrayFinal,senha)>=0){


						int nivelAcesso = Integer.parseInt(arrayFinal[buscaUsuario(arrayFinal,usuario)][2]);

						if (nivelAcesso==1){

							ViewMenu vm = new ViewMenu(parIdioma,parPais);
							this.dispose();

						} else if (nivelAcesso==2){

							ViewMenuAluno vma = new ViewMenuAluno(parIdioma,parPais);
							this.dispose();

						}

					}else{

						JOptionPane.showMessageDialog(null, msgSenha);

					}


				} else {

					JOptionPane.showMessageDialog(null, msgUsuario);

				}
		
		} 
	}
}
