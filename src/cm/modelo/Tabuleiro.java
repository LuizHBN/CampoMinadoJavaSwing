package cm.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cm.visao.PainelSeletor;

@SuppressWarnings("serial")
public class Tabuleiro extends PainelSeletor implements CampoObservador {

	private final int linhas;
	private final int colunas;
	private final int minas ;
	
	private final List<Campo> campos = new ArrayList<>();
	private final List<Consumer<ResultadoEvento>> observadores = 
			new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		this.linhas = linhas;
		this.colunas = colunas;
	    this.minas = minas;
		
        gerarCampo();
        associarOsVizinhos();
        sortearMinas();
	}
	
	public void forEachCampo(Consumer<Campo> funcao) {
		campos.forEach(funcao);
	}
	
	public void registrarObservador(Consumer<ResultadoEvento> observador) {
		observadores.add(observador);
	}
	
	private void notificarObservadores(boolean resultado) {
		observadores.stream().forEach(o -> o.accept(new ResultadoEvento(resultado)));
	}
	
	public void abrir(int linha, int coluna) {
	      campos.stream()
		  .filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
		  .findFirst()
		  .ifPresent(c -> c.abrir());
		
	}
	
	
	
	public void alternarMarcacao(int linha, int coluna) {
		
		campos.stream()
		.filter(c -> c.getLinha() == linha && c.getColuna() == coluna)
		.findFirst()
		.ifPresent(c -> c.alternarMarcacao());
		
	}




	private void gerarCampo() {
      for (int linha = 0; linha < linhas; linha++) {
    	  for (int coluna = 0; coluna < colunas; coluna++) {
    		  Campo campo = new  Campo(linha, coluna);
    		  campo.registrarObservador(this);
    		  campos.add(campo);
			
		}
		
	}
		
	}
	
	private void associarOsVizinhos() {
		for(Campo c1: campos) {
			for(Campo c2: campos){
	            c1.adicionarVizinho(c2);
		  }
		}
		
	}
	
	private void sortearMinas() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		
		do {
			int aleatorio = ThreadLocalRandom.current().nextInt(0,campos.size());
			campos.get(aleatorio).minar();
			minasArmadas = campos.stream().filter(minado).count();
		} while(minasArmadas < minas ); 
	}
	
	public boolean objetivoAlcancado() {
	    	return campos.stream().allMatch(c -> c.objetivoAlcancado());
	}
	
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}
	
	
	
	

	public void eventoOcorreu(Campo c, CampoEvento evento) {
		if(evento == CampoEvento.EXPLODIR) {
			mostrarMinas();
			notificarObservadores(false);
		} else if(objetivoAlcancado()) {
			notificarObservadores(true);
			
		}
		
	}
	private void mostrarMinas() {
		campos.stream().filter(c -> c.isMinado())
		.forEach(c -> c.setAberto(true));
		
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	public int getMinas() {
		return minas;
	}
	
	

}
