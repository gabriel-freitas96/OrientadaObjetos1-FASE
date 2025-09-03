package Usuario;
import java.util.ArrayList;
import java.util.Objects;

public class Catalogo {
  private ArrayList<Midia>midias = new ArrayList<>();

  public Catalogo(ArrayList<Midia> midias) {
	  super();
	  this.midias = midias;
 	}
  
  public Catalogo() {
	  
  }

  public ArrayList<Midia> getMidias() {
	  return midias;
  	}

  public void setMidias(ArrayList<Midia> midias) {
	  this.midias = midias;
  	}
  public void adicionarMidia(Midia midia) {
      midias.add(midia);
  }
  
  public void adicionarMidias(Midia playlist){
	  midias.add(playlist);
  }

  @Override
  public int hashCode() {
	return Objects.hash(midias);
  }

  @Override
  public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Catalogo other = (Catalogo) obj;
	return Objects.equals(midias, other.midias);
  }

  @Override
  public String toString() {
	return "Catalogo [midias=" + midias + "]";
  }
 
}
