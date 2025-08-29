package Usuario;

import java.util.ArrayList;
import java.util.Objects;

public class Playlist {
    private String nome;
    private Usuario usuario;
    private ArrayList<Musica> musicas;
    private int duracao;

    public Playlist(String nome, Usuario usuario, int duracao) {
        this.nome = nome;
        this.usuario = usuario;
        this.duracao = duracao;
        this.musicas = new ArrayList<>();
    }

    public Playlist(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
        this.musicas = new ArrayList<>();
    }

    public Playlist() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracaoTotal(int duracaoTotal) {
        this.duracao = duracaoTotal;
    }

    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(musicas, playlist.musicas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(musicas);
    }

	@Override
	public String toString() {
		return "Playlist [nome=" + nome + ", usuario=" + usuario + ", musicas=" + musicas + ", duracaoTotal="
				+ duracao + "]";
	}

    

	
}
