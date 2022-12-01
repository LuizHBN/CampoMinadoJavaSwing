package cm.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import cm.modelo.SeletorDificuldade;




@SuppressWarnings("serial")
public class PainelSeletor extends JPanel implements ActionListener {

	public PainelSeletor() {
	  FlowLayout layout = new FlowLayout();
	  
	  setLayout(layout);
	  adicionarBotao("Facil");
	  adicionarBotao("Médio");
	  adicionarBotao("Dificil");
	  adicionarBotao("Sair", new Color(255,0,91),30,80);
	  layout.setHgap(10);
	  
	  
	
	}
	
      private void adicionarBotao(String texto) {
		
		BotaoDificuldade botao = new BotaoDificuldade(texto);
		botao.addActionListener(this);
		add(botao);

	}   
      private void adicionarBotao(String texto, Color c, int altura, int largura) {
    	  
    	  BotaoDificuldade botao = new BotaoDificuldade(texto,c, largura,altura);
    	  botao.addActionListener(this);
    	  add(botao);
    	  
      }   
      
      
      @Override
    public void actionPerformed(ActionEvent e) {
    		SeletorDificuldade.getInstancia().detectarTipoComando(e.getActionCommand());
    		new TelaPrincipal();
    		
      }
      
      }
	

