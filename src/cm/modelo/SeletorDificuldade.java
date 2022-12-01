package cm.modelo;

public class SeletorDificuldade {
	
	private int minasPorDificuldade;
	private int colunasPorDificuldade;
	private int linhasPorDificuldade;
	
	
	private static final SeletorDificuldade instancia = new SeletorDificuldade();
	
	public static SeletorDificuldade getInstancia() {
		return instancia;
	}
	

	public void detectarTipoComando(String texto) {
		if(texto.equalsIgnoreCase("FACIL")) {
			setMinasPorDificuldade(15);
			setLinhasPorDificuldade(10);
			setColunasPorDificuldade(20);
		}else if(texto.equalsIgnoreCase("MÉDIO")) {
			setMinasPorDificuldade(30);
			setLinhasPorDificuldade(13);
			setColunasPorDificuldade(24);
		}else if(texto.equalsIgnoreCase("DIFICIL")) {
			setMinasPorDificuldade(50);
			setLinhasPorDificuldade(16);
			setColunasPorDificuldade(30);
		} else if(texto.equalsIgnoreCase("SAIR")) {
		System.exit(0);
	} 
		
	}

	//Getters and Setters
	public int getMinasPorDificuldade() {
		return minasPorDificuldade;
	}
	public void setMinasPorDificuldade(int minasPorDificuldade) {
		if(minasPorDificuldade >=15 && minasPorDificuldade <=50) {
			this.minasPorDificuldade = minasPorDificuldade;
		}
	}
	public int getColunasPorDificuldade() {
		return colunasPorDificuldade;
	}
	public void setColunasPorDificuldade(int colunasPorDificuldade) {
		if(colunasPorDificuldade >=20 && colunasPorDificuldade <= 30) {
		this.colunasPorDificuldade = colunasPorDificuldade;
		}
	}
	public int getLinhasPorDificuldade() {
		return linhasPorDificuldade;
	}
	public void setLinhasPorDificuldade(int linhasPorDificuldade) {
		if(linhasPorDificuldade >=10 && linhasPorDificuldade <= 16) {
		this.linhasPorDificuldade = linhasPorDificuldade;
		}
	}
	


	
	
	
	
}
