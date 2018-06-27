/*Classe: Usuario
 *Descricao: qualque pessoa que participe da rede social de caronas eh um Usuario
 *Autora: Naomi Takemoto
 **/
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
	
	public Usuario(String nome, String email, String senha, boolean status) {
		this();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.status = status;
	}
	
	public Usuario(String nome, String email, String senha, boolean status,
			Perfil perfil) {
		this(nome,email, senha,status);
		this.perfil = perfil;
	}
	
	//gets e sets
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
		String out =  "Classe Usuario\n";
		out = out + "[Nome: " +getNome()
				  + ", Id: " + getId()
				  + ", E-mail: " + getEmail()
		          + ", Senha: " + getSenha()
		          + ", Status: " + getStatus ()
		          +"]\nDados do perfil do Usuario: ["
		          +"Sexo: " + perfil.getSexo()
		          +", Data de Nascimento: " + perfil.getDataNascimento()
		          +", Cidade: " + perfil.getCidade()
		          +", Estado: " + perfil.getEstado() 
		          +", Telefone: " + perfil.getTelefone()
		          +", Fumante: " + perfil.getFumante()
		          +", Avaliacao: " + perfil.getAvaliacao() + " ]\n"
				  +"Perfil Caronante do usuario";
		if(perfil.getCaronante() == null){
			out += "[nao ha perfil caronante]\n";
		}else{
			out += "[ Tempo de Habilitacao: " + perfil.getCaronante().getTempoHabilitacao()
				+ ", Genero Musical Favorito: " + perfil.getCaronante().getGeneroMusicalFavorito()
				+ ", Placa do Veiculo: " + perfil.getCaronante().getPlacaVeiculo()
				+ ", Carteira de Motorista: " + perfil.getCaronante().getCarteiraMotorista()
				+ ", Marca do Veiculo: " + perfil.getCaronante().getMarcaVeiculo()
				+ ", Modelo do Veiculo: " + perfil.getCaronante().getModeloVeiculo()
				+"]\n";
		}
		out += "Perfil de caroneiro do usuario:";
		if(perfil.getCaroneiro() == null){
			out += "[nao ha perfil de caroneiro]\n";
		}
		else{
			out += "[Cartao de Credito: " + perfil.getCaroneiro().getCartaoDeCredito() + "]\n";
		}
		out +="Lista de grupos do usuario: ";
		if(grupos.size() == 0) {
			out += "[Vazio]\n";
		}else{
			out += "[\n";
			for(int i = 0; i< grupos.size(); i++){
				out += "Nome: " + grupos.get(i).getNome() + ", Descricao: " + grupos.get(i).getDescricao()+"\n";
				
			}
			out += "]\n";
		}
		return out;
	}
	
	public void adicionarGrupo (Grupo grupo) {
		this.grupos.add(grupo);
	}
	
	public boolean removerGrupo (Grupo grupo) {
		return this.grupos.remove(grupo);
	}
}
