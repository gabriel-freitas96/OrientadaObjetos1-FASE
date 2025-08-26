package Usuario;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

public class Playlist {
	private String nome;
	private List<Midia>midias;
	
	public Playlist(String nomes) {
		this.nome=nomes;
	}

	public String getNomes() {
		return nome;
	}

	public List<Midia> getMidia() {
		return midias;
	}
	public void adicionarMusica(Midia midia) {
		 midias.add(midia);
	}

	public void removerMusica(Midia midia) {
		 midias.remove(midia);
	}
	public int calcularDuracaoTotal() {
		return
	}
	@Override
	 public String toString() {
        StringBuilder sb = new StringBuilder("Playlist: " + nome + "\n");
        for (Midia m : midias) {
            sb.append(" - ").append(m).append("\n");
        }
        sb.append("Duração total: ").append(calcularDuracaoTotal()).append(" segundos");
        return sb.toString();
    }

	}


	
