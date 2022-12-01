package cm.visao;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TelaSeletora extends JFrame{
	
	public TelaSeletora() {

		add( new PainelSeletor());
		
		setTitle("Dificuldade");
		setSize(400,135);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}

}
