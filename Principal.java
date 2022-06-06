// Lorenzo Lái Barboza Thomas
// Apenas cria um novo jogo, e começa ele.

public class Principal {

	public static void main(String[] args) {
		Jogo jogo = new Jogo(new Jogador(Teclado.leString("Digite o nome do jogador 1: ")),
				new Jogador(Teclado.leString("Digite o nome do jogador 2: ")));
		jogo.comecaJogo();
	}
}
