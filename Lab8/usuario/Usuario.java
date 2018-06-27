/*Classe: Usuario
 *Descricao: qualque pessoa que participe da rede social de caronas eh um Usuario
 *Autora: Naomi Takemoto
 *Modificado em: laboratorio 08
 *    Adicionou metodos:
 *    criarGrupoPublico
 *    criarGrupoPrivado
 *    Implementa: interface salvavel
 **/
package usuario;
import java.util.ArrayList;
import grupo.*;
import grupo.GrupoUsuario;
import perfil.Perfil; 
import exception.SistemaCaronaExcecao;
import interfaces.Salvavel;

public class Usuario implements Salvavel{
	
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
		id = geradorId++;
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
	public void adicionarGrupo (GrupoPublico grupo) throws SistemaCaronaExcecao{
		if(!(grupo instanceof GrupoPublico) ) throw new SistemaCaronaExcecao();
		else grupo.adicionarMembro(this);          //note que o metodo adiconar membro de grupos
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
				break;
			}
		}
	}
	
	public void atualizarGrupo(int id, String descricao){
		for(int i  = 0; i < grupos.size(); i++){
			if(grupos.get(i).getGrupo().getId() == id && grupos.get(i).getGrupo().getDono() == this){
				grupos.get(i).getGrupo().setDescricao(descricao);
				break;
			}
		}
	}
	
	/*Metodo: removerGrupo
	 *Parametros:recebe o id do grupo (no primeiro caso), recebe diretamente o
	 *objeto grupo no segundo.
	 *Descricao:realiza a busca para excluir o grupo da lista de grupos.
	 *Retorno true se achou e removeu o grupo, false caso contrario*/
	public void removerGrupo(int idGrupo) throws SistemaCaronaExcecao {
		boolean removeu = false;
		Grupo grupoAtual;
		for(int i = 0; i < grupos.size(); i++){
			grupoAtual =  grupos.get(i).getGrupo();
			//se achou o grupo  a ser removido, remove se o usuario nao for dono de um grupo privado
			if(grupoAtual.getId() == idGrupo && (grupoAtual instanceof GrupoPrivado == false || grupoAtual.getDono() != this)){
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
		if(removeu == false) {
			throw new SistemaCaronaExcecao();
		}
		
	}
	
	//Metodo sobrecarregado ver descricao geral acima
	public void removerGrupo(Grupo grupo) throws SistemaCaronaExcecao{
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
		
		if(removeu == false) {
			throw new SistemaCaronaExcecao();
		}
	}
	
	/*Metodo: criarGrupoPublico
	 *Parametros:
	 *Descricao: o usuario cria um novo grupo para o qual ele eh o dono
	 *Retorno: a referencia para o novo objeto GrupoPublico criado
	 **/
	public GrupoPublico criarGrupoPublico() {
		GrupoPublico novoGrupo = new GrupoPublico(this);
		return novoGrupo;
	}
	
	/*Metodo analogo ao anterior, com a diferenca que o grupo criado eh
	 *privado.
	 **/
	public GrupoPrivado criarGrupoPrivado() {
		GrupoPrivado novoGrupo = new GrupoPrivado(this);
		return novoGrupo;
	}
	
	/*Metodo: adicionarUsuarioAUmGrupo
	 *Descricao: adiciona um usuario a um grupo privado, essa insercao so sera efetivada se
	 *se o usuario que esta tentando inserir outro eh o dono do grupo privado
	 *Parametros: o usuario a ser inserido e o grupo provado em que ele pode acabar entrando
	 *Retorno: true caso a insercao tenha ocorrido, false caso contrario
	 **/
	public void adicionanrUsuarioAUmGrupo(Usuario novoUsuario, GrupoPrivado grupo)  throws SistemaCaronaExcecao{
		if(grupo.getDono() == this){
			grupo.adicionarMembro(novoUsuario);//Nota-se que o metodo adicionarMembro ja constroi a relacao bidirecional
		}else {
			throw new SistemaCaronaExcecao();
		}
	
	}
	
	/*Metodo: salvarParaArquivos
	 *Parametros: nenhum
	 *Retorna uma String que contem os atributos do objeto
	 **/
	public String salvarParaArquivos(){
		String out = "[";
		out = out + getId()  + "\n"
				  + getNome() + "\n"
				  + getEmail() + "\n"
		          + getSenha() + "\n"
		          + getStatus () + "\n";
		if(grupos != null && grupos.size() > 0){
			for(int i = 0; i < grupos.size(); i++){
				out += grupos.get(i).getId() + "\n";
			}
		}else{
			out += "null\n";
		}
		if(perfil != null){
			out += perfil.getId();
		}
		out += "]";
		return out;
	}

}
