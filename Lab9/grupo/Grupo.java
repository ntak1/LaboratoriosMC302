/*Classe: Grupo eh a classe da qual herdam GrupoPublico e GrupoPrivado
 *Autora: Naomi Takemoto
 *Modificado em: laboratorio 08
 *-Adicionou: metodo checarPresencaUsuario*/

package grupo;
import java.util.ArrayList;
import usuario.Usuario;
import grupo.GrupoUsuario;
import exception.SistemaCaronaExcecao;
import interfaces.Salvavel;

public abstract class Grupo implements Salvavel{
	
	private int id;
	private String nome;
	private String descricao;
	private static int geradorId = 0 ;
	private ArrayList <GrupoUsuario> membros;
	private Usuario dono;
	
	public Grupo() {
		id = geradorId++;
		nome = "";
		descricao = "";
		membros = new ArrayList <GrupoUsuario>();
	}
	public Grupo (String nome, String descricao) {
		this();
		this.nome = nome;
		this.descricao = descricao;
	}
	/*Metodo: Grupo
	 *Parametros: um obj do tipo Usuario
	 *Descricao: ao receber um usuario como dono, adiciona esse usuario como membro do grupo,
	 *bem como adiciona o grupo na lista de grupos desse usuario.
	 * */
	public Grupo(Usuario dono) {
		this.dono = dono;
		id = geradorId++;
		membros = new ArrayList <GrupoUsuario>();
		GrupoUsuario associativo = new GrupoUsuario(this, dono);//cria e instancia obj da classe associativa
		membros.add(associativo);                               //adiciona na lista de participantes do grupo
		dono.getGrupos().add(associativo);                      //adiciona o grupo na lista de grupos do usuario
	}
	
	public Grupo(Usuario dono, String nome, String descricao) {
		this(dono);
		this.nome = nome;
		this.descricao = descricao;
	}
	
	//getters e setters
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public ArrayList<GrupoUsuario> getMembros() {
		return membros;
	}

	public void setMembros(ArrayList<GrupoUsuario> membros) {
		this.membros = membros;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	@Override
	public String toString() {
		String out = "Grupo Nome do Grupo:" + nome + ", Descricao: " + descricao;
		out +="Don@ do grupo: " + dono.getNome() + "\nMembros do Grupo: ";
		for (int i = 0; i < membros.size(); i++){
			out +=  membros.get(i).getUsuario().getNome();
		}
		return out;
	}
	
	public abstract void adicionarMembro (Usuario usuario);
	
	/*Metodo: alterarDono
	 *Parametros: dois objetos do tipo Usuario que sao os donos antigo e novo
	 *Descricao: Adiciona o novo dono a lista de membros do grupo, adiciona o grupo
	 *a lista de grupos do novo dono. Faz a referencia de dono do grupo apontar
	 *para o novo usuario (nesse caso nao se assume que o antigo dono seja excluido
	 *do grupo)
	 */
	public void alterarDono(Usuario dono, Usuario novoDono){
		adicionarMembro(novoDono);
		setDono(novoDono);
		try{
			dono.removerGrupo(this);//remove o grupo da lista de grupos de dono
		}
		catch(SistemaCaronaExcecao erro) {
			System.out.println(erro);
		}
								//esse metodo tambem remove dono do grupo
	}
	
	public GrupoPrivado atualizaGrupoPublicoParaPrivado(GrupoPublico grupoPublico){
		GrupoPrivado atualizado = new GrupoPrivado(grupoPublico.getDono());
		atualizado.setNome(grupoPublico.getNome());
		atualizado.setDescricao(grupoPublico.getDescricao());
		atualizado.setMembros(grupoPublico.getMembros());
		return atualizado;
	}
	
	/*Metodo: checarPresencaUsuario
	 *Descricao: metodo sera usado para implementar a modificacao, na qual um usuario
	 *so podera ser adicionado a um grupo privado pelo dono do grupo (this).
	 *Retorno: boolean, true se o usuario pertence ao grupo, false caso contrario*/
	public boolean checarPresencaUsuario (Usuario usuario) throws SistemaCaronaExcecao{
		boolean presente = false;
		if(usuario == null || membros == null) {
			throw new SistemaCaronaExcecao();
		}
		for(int i = 0; i < membros.size(); i++) {
			if(membros.get(i).getUsuario() == usuario) {
				presente = true;
				break;
			}
		}
		return presente;
	}
	
	
}
