package Usuario;

public class Musica extends Midia{
	private GeneroMusical genero;
	
	public Musica(String titulo, String artista, double duracao) {
		super(titulo,artista,duracao);
		this.genero = genero;
		
	}
	
	public Musica() {
	}

	public GeneroMusical getGenero() {
		return genero;
	}

	public void setGenero(GeneroMusical genero) {
		this.genero = genero;
	}
	
}
