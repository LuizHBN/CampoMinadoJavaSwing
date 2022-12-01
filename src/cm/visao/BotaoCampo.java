package cm.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import cm.modelo.Campo;
import cm.modelo.CampoEvento;
import cm.modelo.CampoObservador;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton 
implements CampoObservador, MouseListener{
	
	private final Color BG_DEFAULT = new Color(184,184,184);
	private final Color BG_MARCADO = new Color(8,179,247);
	private final Color BG_EXPLODIR = new Color(189,66,68);
	private final Color TEXTO_VERDE = new Color(0,100,0);
	
	private Campo campo;
	
	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBackground(BG_DEFAULT);
		setOpaque(true);
		setBorder(BorderFactory.createBevelBorder(0));
		
		addMouseListener(this);
		campo.registrarObservador(this);
		
	}

	public void eventoOcorreu(Campo c, CampoEvento evento) {
	    switch (evento) {
		case ABRIR: 
			aplicarEstiloAbrir();
			break;
		
		case MARCAR: 
			aplicarEstiloMarcar();
			break;
		
		case EXPLODIR: 
			aplicarEstiloExplodir();
			break;
		
		default:
			aplicarEstiloDefault();
			
		}
		
	}

	private void aplicarEstiloDefault() {
		setBackground(BG_DEFAULT);
		setText("");
		setBorder(BorderFactory.createBevelBorder(0));
		
	}


	private void aplicarEstiloExplodir() {
		setBackground(BG_EXPLODIR);
		setForeground(Color.white);
		setText("X");
	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCADO);
		setForeground(Color.black);
		setText("M");
		
		
	}

	private void aplicarEstiloAbrir() {
		
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		if(campo.isMinado()) {
			setBackground(BG_EXPLODIR);
			
			
		}else 
		
		setBackground(BG_DEFAULT);
		
		if(!campo.isMarcado()) {
		switch (campo.minasNaVizinhanca()) {
		case 1:
			setForeground(TEXTO_VERDE);
			break;
			
		case 2:
			setForeground(Color.BLUE);
			break;
			
		case 3:
			setForeground(Color.YELLOW);
			break;
		case 4:
		case 5:
		case 6:
			setForeground(Color.YELLOW);
			break;
		default:
			setForeground(Color.pink);
		}
		if (!campo.isMinado()) {
			
		String valor = !campo.vizinhacaSegura() ?
				campo.minasNaVizinhanca() + "" : "";
		setText(valor);
		}
		}
	}
	
	//Interface dos eventos do mouse
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			campo.abrir();
		}else { 
			campo.alternarMarcacao();
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	
	

}
