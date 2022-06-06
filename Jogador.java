// Lorenzo Lái Barboza Thomas
public class Jogador {
	private String nome;
	private int pontos;
	private Dado dadoBranco = new Dado("branco");
	private Dado dadoVermelho = new Dado("vermelho");

// Constrtutor dos jogadores que irão jogar o jogo.
	public Jogador(String nome) {
		this.nome = nome;
	}

// Getters and Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Dado getDadoBranco() {
		return dadoBranco;
	}

	public void setDadoBranco(Dado dadoBranco) {
		this.dadoBranco = dadoBranco;
	}

	public Dado getDadoVermelho() {
		return dadoVermelho;
	}

	public void setDadoVermelho(Dado dadoVermelho) {
		this.dadoVermelho = dadoVermelho;
	}

// Método que incrementa o número atual de pontos com o novo valor obtido pelos dados.
	public void addPontos(int pontos) {
		this.pontos += pontos;
	}

}
