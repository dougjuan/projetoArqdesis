package View;
import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Locale;
import java.util.ResourceBundle;

public class ViewEscolheIdioma extends JFrame implements ActionListener{

	JComboBox <String> cbEscolherIdioma;
	JButton btnConfirmar, btnSair;
	JLabel lblEscolherIdioma;
	private ResourceBundle bn = null;
	String parIdioma;
	String parPais;

	public ViewEscolheIdioma(String idioma,String pais){
		setLayout(new FlowLayout());


		//Adcionando itens ao combobox
		String[] strEscolherIdioma ={"Português","Inglês","Espanhol"};
		cbEscolherIdioma = new JComboBox<String>(strEscolherIdioma);

		JPanel pTitle = new JPanel();
		JPanel pBotoes = new JPanel();
		JPanel pComboBox = new JPanel();


		lblEscolherIdioma = new JLabel ();
		btnConfirmar = new JButton();
		btnSair = new JButton();
		
		
		btnConfirmar.addActionListener(this);
		btnSair.addActionListener(this);
		cbEscolherIdioma.addActionListener(this);

		pTitle.add(lblEscolherIdioma);
		pComboBox.add(cbEscolherIdioma);
		pBotoes.add(btnSair);
		pBotoes.add(btnConfirmar);

				
		add(pTitle);
		add(pComboBox);
		add(pBotoes);
		
		
		MudarIdioma(idioma, pais);


		/************************** CONFIGURAÇÕES DA JANELA ********************************/
		setVisible(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 300) / 2);
		int y = (int) ((dimension.getHeight() - 150) / 2);
		setLocation(x, y);
		setSize(300,150);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		/************************** CONFIGURAÇÕES DA JANELA ********************************/
	}

	// strings que serao trocadas.
	public void MudarIdioma(String mIIdioma, String mIPais){
		Locale.setDefault(new Locale(mIIdioma, mIPais));
		Locale locale = Locale.getDefault();
		bn = ResourceBundle.getBundle("tr1", locale);

		parIdioma = mIIdioma;
		parPais = mIPais;


		setTitle (bn.getString("ProjetoIntegrado"));
		lblEscolherIdioma.setText(bn.getString("EscolhaoIdioma"));
		btnConfirmar.setText(bn.getString("Confirmar"));
		btnSair.setText(bn.getString("Sair"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == btnSair)
		{
			System.exit(0);
		}

		if (e.getSource() == btnConfirmar){
			ViewLogin vl = new ViewLogin(parIdioma,parPais);
			this.dispose();
		}

		if(cbEscolherIdioma.getSelectedIndex() == 0 ){
			MudarIdioma("pt","BR");
		}
		else if(cbEscolherIdioma.getSelectedIndex() == 1 ){

			MudarIdioma("en","US");
		}
		else if (cbEscolherIdioma.getSelectedIndex() == 2 ){

			MudarIdioma("es","ES");
		}
	}
}
