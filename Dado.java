// Lorenzo Lái Barboza Thomas

public class Dado {
	private int quantLados = 6;
	private String cor;

// Construtor pedindo só cor, já que todos os dados envolvidos tem 6 lados.
	public Dado(String cor) {
		this.cor = cor;
	}

// Getters and Setters
	public int getQuantLados() {
		return quantLados;
	}

	public void setQuantLados(int quantLados) {
		this.quantLados = quantLados;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

// Método que randomiza um número de 0 até 1 (não incluso) e o transforma em um número inteiro de 0 até 6.
	public int jogaDado() {
		return (int) (Math.random() * 6 + 1);
	}

}
