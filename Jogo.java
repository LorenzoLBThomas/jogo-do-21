// Lorenzo Lái Barboza Thomas
// A classe jogo contém toda a lógica do jogo, e possui todos os métodos que serão utilizados nele.
public class Jogo {
	private Jogador jogador1;
	private Jogador jogador2;

// Construtor do jogo, que passa o nome dos jogadores por parâmetros.
	public Jogo(Jogador jogadorInput1, Jogador jogadorInput2) {
		this.jogador1 = jogadorInput1;
		this.jogador2 = jogadorInput2;
	}

	public void comecaJogo() {

System.out.println("	     ██  ██████   ██████   ██████      ██████   ██████      ██████    ██ ");
System.out.println("	     ██ ██    ██ ██       ██    ██      ██   ██ ██    ██          ██  ███  ");
System.out.println("	     ██ ██    ██ ██   ███ ██    ██     ██   ██ ██    ██      █████      ██ ");
System.out.println("	██   ██ ██    ██ ██    ██ ██    ██     ██   ██ ██    ██     ██          ██ ");
System.out.println("         █████  ██████   ██████   ██████      ██████   ██████      ███████   ██ ");
	                                                                        	                                                                        
		System.out.println();
		System.out.println("REGRAS DO JOGO");
		regras(); // Exibe as regras do jogo.
		System.out.println();
		int respJogador;
		do {
			for (int i = 0; i < 3; i++) {
				// Jogador 1
				if (i == 0) { // Caso seja a primeira repetição, ou seja, a rodada 1, zera os pontos dos
								// jogadores.
					jogador1.setPontos(0);
					jogador2.setPontos(0);
				}
				System.out.printf("É a vez de: %s\n", jogador1.getNome());
				System.out.printf("Você tem %s pontos.\n", jogador1.getPontos());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				System.out.println("Digite 1 para jogar os dados.");
				System.out.println("Digite 2 para passar a vez.");
				int escolhaJogador1 = Teclado.leInt("O que deseja?: ");
				if (escolhaJogador1 == 1) {
					int dadoBrancoJ1 = jogador1.getDadoBranco().jogaDado();
					jogador1.addPontos(dadoBrancoJ1); // Adiciona o valor do dado branco aos pontos do J1.
					int dadoVermelhoJ1;
					int dadoVermelhoJ1_aux = jogador1.getDadoVermelho().jogaDado(); // Variável auxiliar que pega o valor do dado
					// vermelho, e usa como condição para um if, parar verificar se o valor é 6 e se deve ser dobrado, ou não.
					if (dadoVermelhoJ1_aux == 6)
						dadoVermelhoJ1 = dadoVermelhoJ1_aux * 2;
					else
						dadoVermelhoJ1 = dadoVermelhoJ1_aux;

					jogador1.addPontos(dadoVermelhoJ1); // Incrementa o valor do dado vermelho aos pontos do jogador.
					System.out.println("Valor do dado branco: " + dadoBrancoJ1); // Imprime o valor do dado branco.
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
					System.out.println((dadoVermelhoJ1_aux == 6
							? "O valor do dado vermelho foi 6, portanto foram somados 12 pontos!"
							: "Valor do dado vermelho: " + dadoVermelhoJ1)); // Verifica se o valor foi duplicado ou não, pois se
					// o valor da variável for 6, o if lá de cima foi verdadeiro e duplicou os pontos.
					// Caso falso, imprime o valor do dado vermelho.
				} else
					System.out.println(jogador1.getNome() + " pulou a vez.");
				System.out.println();

				// Jogador 2
				System.out.printf("É a vez de: %s\n", jogador2.getNome());
				System.out.printf("Você tem %s pontos.\n", jogador2.getPontos());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				System.out.println("Digite 1 para jogar os dados.");
				System.out.println("Digite 2 para passar a vez.");
				int escolhaJogador2 = Teclado.leInt("O que deseja?: ");
				if (escolhaJogador2 == 1) {
					int dadoBrancoJ2 = jogador2.getDadoBranco().jogaDado();
					jogador2.addPontos(dadoBrancoJ2);
					int dadoVermelhoJ2;
					int dadoVermelhoJ2_aux = jogador2.getDadoVermelho().jogaDado();
					if (dadoVermelhoJ2_aux == 6)
						dadoVermelhoJ2 = dadoVermelhoJ2_aux * 2;
					else
						dadoVermelhoJ2 = dadoVermelhoJ2_aux;

					jogador2.addPontos(dadoVermelhoJ2);
					System.out.println("Valor do dado branco: " + dadoBrancoJ2);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
					System.out.println((dadoVermelhoJ2_aux == 6
							? "O valor do dado vermelho foi 6, portanto foram somados 12 pontos!"
							: "Valor do dado vermelho: " + dadoVermelhoJ2));
				} else
					System.out.println(jogador1.getNome() + " pulou a vez.");
				System.out.println();
			}
			vencedor(); // Aciona o método que aponta o vencedor do jogo.
			System.out.println("Digite 1 caso queira jogar novamente.");
			System.out.println("Digite 0 caso queira parar de jogar.");
			respJogador = Teclado.leInt("O que deseja?");
		} while (respJogador == 1);
		System.out.println();
		System.out.println("OBRIGADO POR JOGAR!");
	}

	public void vencedor() {
		// Primeira condição de vitória
		if (jogador1.getPontos() > 21)
			if (jogador2.getPontos() > 21)
				System.out.println("Empate. Os dois jogadores passaram de 21 pontos.");
			else
				System.out.printf("Vitória de %s !\n", jogador2.getNome());
		else if (jogador2.getPontos() > 21)
			if (jogador1.getPontos() > 21)
				System.out.println("Empate. Os dis jogadores passram de 21 pontos.");
			else
				System.out.printf("Vitória de %s !\n", jogador1.getNome());
		// Segunda condição de vitória
		else if (jogador1.getPontos() > jogador2.getPontos())
			System.out.printf("Vitória de %s !\n", jogador1.getNome());
		else if (jogador2.getPontos() > jogador1.getPontos())
			System.out.printf("Vitória de %s !\n", jogador2.getNome());
		else
			System.out.println("Empate! Os dois jogadores fizeram a mesma quantidade de pontos!");
	}

	public void regras() {
		System.out.println("Dois jogadores jogam o jogo, e os dois possuem dados: um branco e um vermelho.");
		System.out.println("O resultado do dado branco e do dado vermelho é somado a pontuação total.");
		System.out.println(
				"Caso o valor do dado vermelho seja 6, esse valor é duplicado, e será adicionado 12 aos pontos.");
		System.out.println("Os jogadores devem participar de 3 rodadas, começando com 0 pontos.");
		System.out.println("Quem se aproximar mais de 21 pontos ao fim das 3 rodadas é o vencedor.");
		System.out.println("Quem passar de 21 pontos perde o jogo, e se os dois passarem, é declarado empate.");
	}
}
