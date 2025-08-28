package Usuario;

public class Midia {
	protected String titulo;
	protected String artista;
	protected int duracaoSegudos;
	protected Genero genero;
	private String tipo;
	
	public  Midia(String titulo,String artista,int duracaoSegudos,Genero genero,String tipo) {
		this.titulo=titulo;
		this.artista=artista;
		this.duracaoSegudos=duracaoSegudos;
		this.genero=genero;
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getDuracaoSegudos() {
		return duracaoSegudos;
	}

	public void setDuracaoSegudos(int duracaoSegudos) {
		this.duracaoSegudos = duracaoSegudos;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Midia [titulo=" + titulo + ", artista=" + artista + ", duracaoSegudos=" + duracaoSegudos + ", genero="
				+ genero + ", tipo=" + tipo + "]";
	}
}




	


