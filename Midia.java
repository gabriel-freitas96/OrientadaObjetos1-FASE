package Usuario;

public abstract class Midia {
	protected String titulo;
	protected String artista;
	protected int duracaoSegudos;
	protected Genero genero;
	
	public  Midia(String titulo,String artista,int duracaoSegudos,Genero genero) {
		this.titulo=titulo;
		this.artista=artista;
		this.duracaoSegudos=duracaoSegudos;
		this.genero=genero;
	}



	public String getTitulo() {
		return titulo;
	}
	public String getArtista() {
		return artista;
	}
	public int getDuracaoSegudos() {
		return duracaoSegudos;
	}
	public Genero getGenero() {
		return genero;
	}



	@Override
	public String toString() {
		return "Midia [titulo=" + titulo + ", artista=" + artista + ", duracaoSegudos=" + duracaoSegudos + ", genero="
				+ genero + "]";
	}
}



	


