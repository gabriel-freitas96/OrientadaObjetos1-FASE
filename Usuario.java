import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
	private String nome;
	private String email;
	
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
		
	}
	
	public Usuario() {
		
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
	
	@Override
	public int hashCode() {
		return Objects.hash(email, nome);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome);
				
	}
	
	
	
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + "]";
	}
}

