package www.br.com.unifacisa;

import java.util.Objects;

public class Midia {
	protected String titulo;
	protected String artista;
	protected double duracao;
	
	
	public Midia(String titulo, String artista, double duracao) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.duracao = duracao;
	}
	
	public Midia() {
		
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

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artista, duracao, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Midia other = (Midia) obj;
		return Objects.equals(artista, other.artista)
				&& Double.doubleToLongBits(duracao) == Double.doubleToLongBits(other.duracao)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Midia [titulo=" + titulo + ", artista=" + artista + ", duracao=" + duracao + "]";
	}

}
