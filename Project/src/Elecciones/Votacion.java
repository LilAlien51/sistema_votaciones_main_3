package Elecciones;

public class Votacion{
	int votos[];
	int cantidadCandidatos;
	
	public Votacion(int cantidadCandidatos) {
		this.cantidadCandidatos = cantidadCandidatos;
		votos = new int[5];
		for (int i = 0; i < 5; i++) {
			votos[i] = 0;
		}
	}

	public void sumarVoto(int candidato) {
		// numCandidato es uno menos que el numero "real"
		votos[candidato] = votos[candidato] + 1;
	}
}