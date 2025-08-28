package Usuario;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private ArrayList<Midia> midias;
	
	public Catalogo() {
		this.midias = new ArrayList<>();
	}
	
	public void adicionarMidia(Midia midia) {
		midias.add(midia);
	}
	public Midia buscarPorTitulo(String titulo) {
	    for (Midia musicas : midias) {
	    	 if (musicas.getTitulo().equalsIgnoreCase(titulo)) { 
	            return musicas;
	        }
	    }
	    return null;
	}
	public List<Midia>buscarPorArtista(String Titulo){
		List<Midia>resultado=new ArrayList<>();
		for(Midia m:midias) {
			if(m.getArtista().equalsIgnoreCase(Titulo)) {
				resultado.add(m);
			}
		}
		return resultado;
	}
	public List<Midia>buscarPorGenero(Genero genero){
		List<Midia>resultado=new ArrayList<>();
		for(Midia m:midias) {
			if(m.getGenero()==genero) {
				resultado.add(m);
			}
		}
		return resultado;
	}
	public ArrayList<Midia> getMidias() {
		return midias;
	}
	
	

}
