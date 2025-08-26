package Usuario;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private List<Midia>midias=new ArrayList<>();
	
	public void adicionarMusica(Midia midia) {
		midias.add(midia);
	}
	public List<Midia>buscarPorTitulo(String Titulo){
		List<Midia>resultado=new ArrayList<>();
		for(Midia m:midias) {
			if(m.getTitulo().equalsIgnoreCase(Titulo)){
				resultado.add(m);
			}
		}
		return resultado;
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
	public List<Midia>getTodasAsMidias(){
		return midias;
	}
	
	

}
