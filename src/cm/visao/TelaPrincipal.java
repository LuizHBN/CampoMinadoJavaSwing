package cm.visao;

import javax.swing.JFrame;
@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame{
	
	
	public TelaPrincipal() {
		

		
		add(new PainelTabuleiro());
		
		setTitle("Campo Minado");
		setSize(690,438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
	
		new TelaSeletora();
		
		}

}
