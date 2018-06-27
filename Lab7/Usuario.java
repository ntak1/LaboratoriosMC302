/*Classe: Usuario
 *Descricao: qualque pessoa que participe da rede social de caronas eh um Usuario
 *Autora: Naomi Takemoto
 *Modificao: laboratorio06
 *	Nao imprimime-se mais a lista de usuarios no toString
 *	grupos passou a ter o tipo GrupoUsuario
 *	Modificar metodos
 *		adicionar e romover grupo para comportar o uso de classe associativa
 **/
import java.util.ArrayList;

public class Usuario {
	
	//atributos
	private int id;
	private String nome;
	private String email;
	private String senha;
	private boolean status;
	private ArrayList <GrupoUsuario> grupos;
	private static int geradorId = 0;
	private Perfil perfil;
	
	//Metodo contrutor aqui
	public Usuario() {
		geradorId ++;
		id = geradorId; 
		this.grupos = new ArrayList <GrupoUsuario>();
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

	public ArrayList <GrupoUsuario> getGrupos() {
		return grupos;
	}

	// Possivelmente tirar
	public void setGrupos(ArrayList <GrupoUsuario> grupos) {
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
		return out;
	}
	
	/*Metodo: adicionarGrupo
	 *Parametros: recebe um grupo a ser adicionado na lista de grupos do usuario
	 *Descricao: adiciona o grupo na liista de grupos do usuario*/
	public void adicionarGrupo (Grupo grupo) {
		grupo.adicionarMembro(this);          //note que o metodo adiconar membro de grupos
		                                      //atualiza a lista de grupos do usuario (adicio-
		                                      //nando o grupo) e atualiza a lista de membros de grupo.
	}
	
	
	/*Metodo: atualizarGrupo
	 *Parametros: recebe id, nome e descricao(no primeiro caso), id e descricao (no segundo)
	 *Descricao: procura na lista de grupos do usuario o grupo com o id correspondente
	 *e atualiza os campos nome e descricao. Esse metodo so pode executado pelo dono
	 *do grupo*/
	public void atualizarGrupo (int id, String nome, String descricao){
		for(int i  = 0; i < grupos.size(); i++){
			if(grupos.get(i).getGrupo().getId() == id && grupos.get(i).getGrupo().getDono() == this){
				grupos.get(i).getGrupo().setNome(nome);
				grupos.get(i).getGrupo().setDescricao(descricao);
			}
		}
	}
	
	public void atualizarGrupo(int id, String descricao){
		for(int i  = 0; i < grupos.size(); i++){
			if(grupos.get(i).getGrupo().getId() == id && grupos.get(i).getGrupo().getDono() == this){
				grupos.get(i).getGrupo().setDescricao(descricao);
			}
		}
	}
	
	/*Metodo: removerGrupo
	 *Parametros:recebe o id do grupo (no primeiro caso), recebe diretamente o
	 *objeto grupo no segundo.
	 *Descricao:realiza a busca para excluir o grupo da lista de grupos.
	 *Retorno true se achou e removeu o grupo, false caso contrario*/
	public boolean removerGrupo(int idGrupo){
		boolean removeu = false;
		Grupo grupoAtual;
		for(int i = 0; i < grupos.size(); i++){
			grupoAtual =  grupos.get(i).getGrupo();
			if(grupoAtual.getId() == idGrupo){						//se achou o grupo  a ser removido
				//Exclui o usuario da lista de membros do grupo
				for(int j = 0; j < grupoAtual.getMembros().size(); j ++){
					if(grupoAtual.getMembros().get(j).getUsuario() == this){
						grupoAtual.getMembros().remove(j);
					}
				}
				//Exclui o grupo da lista de grupos do usuario;
				grupos.remove(i);
				removeu = true;
				break;
			}
		}
		return removeu;
	}
	
	public boolean removerGrupo(Grupo grupo){
		boolean removeu = false;
		Grupo grupoAtual;
		if(grupo != null){
			for(int i = 0; i < grupos.size(); i++){
				grupoAtual =  grupos.get(i).getGrupo();
				if(grupoAtual == grupo){//se achou o grupo  a ser removido
					//Exclui o usuario da lista de membros do grupo
					for(int j = 0; j < grupoAtual.getMembros().size(); j ++){
						if(grupoAtual.getMembros().get(j).getUsuario() == this){
							grupoAtual.getMembros().remove(j);
						}
					}
					//Exclui o grupo da lista de grupos do usuario;
					grupos.remove(i);
					removeu = true;
					break;
				}
			}
		}
		return removeu;
	}
}
