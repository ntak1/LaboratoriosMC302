/*Classe: Grupo eh a classe
 *Autora: Naomi Takemoto*/
import java.util.ArrayList;

public class Grupo {
	
	private int id;
	private String nome;
	private String descricao;
	private static int geradorId = 0 ;
	private ArrayList <Usuario> membros;
	
	//metodos contrutores
	public Grupo() {
		id = geradorId++;
		membros = new ArrayList <Usuario>();
	}
	
	public Grupo(String nome, String descricao) {
		this();
		this.nome = nome;
		this.descricao = descricao;
	}
	
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

	public ArrayList<Usuario> getMembros() {
		return membros;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void adicionarMembro (Usuario usuario) {
		membros.add(usuario);
	}
	

	@Override
	public String toString() {
		String out = "{\n    Nome:" + nome + "\n    Descricao: " + descricao + "\n    Membros:";
		for (int i = 0; i < membros.size(); i++){
			out += membros.get(i).toString();
		}
		out += "\n}\n";
		return out;
	}
	
}
