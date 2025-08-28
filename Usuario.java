package Usuario;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	protected String nome;
	protected String email;
	protected ArrayList<Playlist> playlist;
	
	public Usuario(String nome, String email) {
		this.nome=nome;
		this.email=email;
		this.playlist = new ArrayList<>();
	  }

    public void criarPlaylist(String nomePlaylist) {
    	Playlist nova = new Playlist(nomePlaylist, this);
        playlist.add(nova);
    }

    public Playlist getPlaylist(String nome) {
        for (Playlist p : playlist) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
    public ArrayList<Playlist> getPlaylists() {
        return playlist;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Playlist> getPlaylist() {
		return playlist;
	}

	}
