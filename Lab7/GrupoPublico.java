import java.util.ArrayList;

public class GrupoPublico extends Grupo {
	private ArrayList<CaronaPublica> caronas;
	
	//Metodos construtores
	public GrupoPublico(Usuario dono) {
		super(dono);
		caronas = new ArrayList<CaronaPublica>();
	}
	public GrupoPublico(Usuario dono, String nome, String descricao){
		super(dono, nome,  descricao);
		caronas = new ArrayList<CaronaPublica>();
	}
	
	public ArrayList<CaronaPublica> getCaronas() {
		return caronas;
	}
	
	public String toString() {
		String out = "GrupoPublico Nome do Grupo:" + getNome() + ", Descricao: " + getDescricao();
		out +="Don@ do grupo: " + getDono().getNome() + "\nMembros do Grupo: ";
		for (int i = 0; i < getMembros().size(); i++){
			out +=  getMembros().get(i).getUsuario().getNome() + ", ";
		}
		return out;
	}
	
	// Implementacao dos metodos abtratos de Grupo
	//O que exatamente precisa ser feito aqui?
	/*Metodo: adicionarMembro
	 *Parametros: um objeto do tipo Usuario
	 *Descricao: adiciona o usuario na lista de participantes do grupo
	 *e adiciona o grupo na lista de grupos do usuario (usa classe associa-
	 *tiva para implementar o relacionamento.
	 * */
	public void adicionarMembro (Usuario usuario){
		boolean adicionou = true;
		for(int i = 0; i < getMembros().size(); i++){
			if(getMembros().get(i).getUsuario().getId() == usuario.getId()) adicionou = false;
		}
		if(adicionou == true){
			GrupoUsuario associativo = new GrupoUsuario(this,usuario);//cria e instancia obj associativo
			usuario.getGrupos().add(associativo);                     //adiciona grupo na lista de grupos do usuario
			getMembros().add(associativo);                            //adiciona usuario na lista de membros do grupo	
		}
	}
	
	
	
	public void testeDinamico(){
		
	}
	
}
