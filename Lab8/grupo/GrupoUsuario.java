/* Classe: GrupoUsuario
 * Descricao: classe associativa entre grupo e usuario
 * Autora: Naomi Takemoto Ra: 184849*/
package grupo;
import usuario.Usuario;
import interfaces.Salvavel;

public class GrupoUsuario implements Salvavel {
	private int id;
	private Usuario usuario;
	private Grupo grupo;
	private static int geradorId = 0;
	
	//Metodos construtores
	public GrupoUsuario(){
		id = geradorId++;
	}
	public GrupoUsuario(Grupo grupo){
		id = geradorId++;
		this.grupo = grupo;
	}
	
	public GrupoUsuario(Usuario usuario){
		id = geradorId++;
		this.usuario = usuario;
	}
	public GrupoUsuario(Grupo grupo, Usuario usuario){
		this(grupo);
		this.usuario = usuario;
		id = geradorId++;
	}
	
	//getters e setters
	public int getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public String salvarParaArquivos(){
		String out = "[";
		out += id  + "\n"
				+ usuario.getId() + "\n"
				+ grupo.getId() + "]";
		return out;
	}
}
