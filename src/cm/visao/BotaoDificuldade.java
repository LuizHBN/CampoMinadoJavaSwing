package cm.visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;



@SuppressWarnings("serial")
public class BotaoDificuldade extends JButton{
	
	public BotaoDificuldade(String texto) {
		setText(texto);
		setOpaque(true);
		setFont(new Font("Serif",Font.PLAIN, 20));
//		setBackground(new Color(214,213,142));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setForeground(Color.BLACK);
		setPreferredSize(new Dimension(100,40));
	
	}
	
	public BotaoDificuldade(String texto,Color c, int largura, int altura) {
		setText(texto);
		setOpaque(true);
		setFont(new Font("Serif",Font.PLAIN, 20));
	    setBackground(c);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setForeground(Color.black);
		setPreferredSize(new Dimension(largura,altura));
	}

}
