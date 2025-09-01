package Usuario;

public class Musica extends Midia{
	private GeneroMusical genero;
	
	public Musica(String titulo, String artista, double duracao) {
		super(titulo,artista,duracao);
	}
	public Musica() {
	}
	public GeneroMusical getGenero() {
		return genero;
	}
	public void setGenero(GeneroMusical genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Musica [genero=" + genero + "]";
	}
}
