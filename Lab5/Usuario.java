import java.util.ArrayList;

public class Usuario {
	
	//atributos
	private int id;
	private String nome;
	private String email;
	private String senha;
	private boolean status;
	private ArrayList <Grupo> grupos;
	private static int geradorId = 0;
	private Perfil perfil;
	
	//Metodo contrutor aqui
	public Usuario() {
		geradorId ++;
		id = geradorId; 
		this.grupos = new ArrayList <Grupo>();
	}
	
	public Usuario(String nome, String email, String senha, boolean status,
			Perfil perfil) {
		this();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.status = status;
		this.perfil = perfil;
	}
	
	//gests e sets
	public int getId() {
		return id;
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
	

	public static int getGeradorId() {
		return geradorId;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public ArrayList <Grupo> getGrupos() {
		return grupos;
	}

	// Possivelmente tirar
	public void setGrupos(ArrayList <Grupo> grupos) {
		this.grupos = grupos;
	}
	
	public String toString () {
		String out =  "Usuario: [";
		Grupo aux;
		ArrayList <Usuario> listaMembros;
		out = out + "[Nome: " +getNome()
				  + ", Id: " + getId()
				  + ", E-mail: " + getEmail()
		          + ", Senha: " + getSenha()
		          + ", Status: " + getStatus ()
		          + "]\nGrupos:";
		if(grupos.size() == 0) {
			out += "[Vazio]";
		}
		for(int i = 0; i < grupos.size(); i++){
			aux = grupos.get(i);
			listaMembros = aux.getMembros();
			out += grupos.get(i) + "Lista de membros: ";
			for(int j = 0; j< listaMembros.size(); j++){
				out +=  "\n[Nome: " +listaMembros.get(j).getNome()
						+", Email: " + listaMembros.get(j).getEmail()
						+", Senha: "+ listaMembros.get(j).getSenha() //grupos nao entra aqui para nao ficar circular
						+", Id: " + listaMembros.get(j).getId()
						+", Status: " +listaMembros.get(j).getStatus()
						+", Lista de membros do grupo:   "+ listaMembros.get(j).getPerfil();
				out += "]";
			}
		}
		out += perfil.toString() + "]";
		return out;
	}
	
	public void adicionarGrupo (Grupo grupo) {
		this.grupos.add(grupo);
	}
	
	public boolean removerGrupo (Grupo grupo) {
		return this.grupos.remove(grupo);
	}
}
