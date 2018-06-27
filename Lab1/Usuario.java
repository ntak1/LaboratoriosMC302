
public class Usuario {
	
	//atributos
	private int id;
	private String nome;
	private String email;
	private String senha;
	private boolean status;
	
	//Metodo contrutor aqui
	public Usuario(int id, String nome, String email, String senha, boolean status) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.status = status;
	}
	
	//Demais metodos aqui
	//gests e sets
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome ;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String toString () {
		String out = getNome() + " (id: " + getId() + " ) \n";
		out = out + "email: " + getEmail() + "\n";
		out = out + "senha: " + getSenha() + "\n";
		out = out + "status: " + getStatus () + "\n";
		return out;
	}

}
