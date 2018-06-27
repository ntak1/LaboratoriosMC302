/*Classe: Perfil
 *Autora: Naomi Takemoto
 *Modificado em: laboratorio 08
 *Adicionei o atribuito geradorId e Id para que a implementacao de salvavel em
 *Usuario fosse mais simples.
 */

package perfil;
import usuario.Usuario;
import caronante.Caronante;
import caroneiro.Caroneiro;
import interfaces.Salvavel;

public class Perfil  implements Salvavel, Comparable <Perfil> {
	
	//atributos
	private static int geradorId = 0;
	private int id; 
	private char sexo;
	private final String dataNascimento;
	private String cidade;
	private String estado; 
	private String telefone;
	private boolean fumante;
	private Caroneiro caroneiro;
	private Caronante caronante;
	private Usuario usuario;
	
	//Metodos contrutores
	public Perfil (String dataNascimento) {
		id = geradorId ++;
		this.dataNascimento = dataNascimento;
	}
	public Perfil (char sexo, String dataNascimento, String cidade, 
					String estado, String telefone, boolean fumante){
		id = geradorId ++;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.fumante = fumante;
	}
	public Perfil(char sexo, String dataNascimento, String cidade, String estado, String telefone, boolean fumante,
		          Usuario usuario) {
		this(sexo, dataNascimento, cidade, estado, telefone, fumante);
		this.usuario = usuario;
	}
	public Perfil(char sexo, String dataNascimento, String cidade, String estado, String telefone, boolean fumante,
			Caroneiro caroneiro, Caronante caronante, Usuario usuario) {
		this(sexo, dataNascimento, cidade, estado, telefone, fumante);
		this.caroneiro = caroneiro;
		this.caronante = caronante;
		this.usuario = usuario;
	}

	//implementacao do metodo compareTo da interface Comparable
	public int compareTo(Perfil outroPerfil){
		int retorno;
		retorno = this.getAvaliacao() < outroPerfil.getAvaliacao()?  -1  : (this.getAvaliacao() > outroPerfil.getAvaliacao() ? 1 : 0);
		return retorno;
	}
	
	//gets e sets
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
		
	public boolean getFumante() {
		return fumante;
	}
	
	public void setFumante(boolean fumante) {
		this.fumante = fumante;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/*Metodo: getAvaliacao
	 *Descricao: Percorre todas as caronas que um perfil participou, tanto como caronante como caroneiro
	 *calculando o numero total e a soma das avaliacoes.
	 *Retorno: a media de todas as avaliacoes
	 * */
	public float getAvaliacao() {
		int tamCaronante  = caronante.getCaronas().size();
		int tamCaroneiro = caroneiro.getCaronas().size();
		int tamTotal = tamCaronante + tamCaroneiro;
		float avaliacao = 0;
		for(int i = 0; i < tamCaronante; i++) {
			avaliacao += caronante.getCaronas().get(i).getAvaliacao();
		}
		for(int i = 0; i < tamCaroneiro; i++) {
			avaliacao += caroneiro.getCaronas().get(i).getAvaliacao();
		}
		avaliacao = avaliacao/tamTotal;
		return avaliacao;
	}
	
	public Caroneiro getCaroneiro() {
		return caroneiro;
	}

	public void setCaroneiro(Caroneiro caroneiro) {
		this.caroneiro = caroneiro;
	}

	public Caronante getCaronante() {
		return caronante;
	}

	public void setCaronante(Caronante caronante) {
		this.caronante = caronante;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId(){
		return id;
	}
	
	//por enquanto nao precisa tratar o atributo caronas
	public String toString () {
		String out = "Perfil Informacoes gerais: [Sexo: " + this.sexo
					+ ", Data de Nascimento: " + this.dataNascimento
					+ ", Cidade: " + this.cidade
					+ ", Estado: " + this.estado
					+ ", Telefone: " + this.telefone
					+ ", Fumante: " + this.fumante 
					+ "], Caroneiro: ";
					if(this.caroneiro == null){
						out += "[Nao se aplica]";
					}
					else{
						out += "[Cartao de credito: " + caroneiro.getCartaoDeCredito() + "]";
					}
					out += ", Dados do Caronante: ";
					if(this.caronante == null){
						out += "[Nao se aplica]";
					}else{
						out += "[Tempo de Habilitacao: " + caronante.getTempoHabilitacao()
						+ ", Genero Musical Favorito: " + caronante.getGeneroMusicalFavorito()
						+ ", Placa do Veiculo: " + caronante.getPlacaVeiculo()
						+ ", Carteira de Motorista: " + caronante.getCarteiraMotorista()
						+ ", Marca do Veiculo: " + caronante.getMarcaVeiculo()
						+ ", Modelo Veiculo: " + caronante.getModeloVeiculo();
						out += "]";
					}
					
		return out;
	}
	
	public String salvarParaArquivos(){
		String out = "[";
		out += id + "\n"
				+ sexo + "\n"
				+ dataNascimento + "\n"
				+ cidade + "\n"
				+ estado + "\n"
				+ telefone + "\n"
				+ fumante + "\n"
				+ caroneiro.getId() + "\n"
				+ caronante.getId() + "\n"
				+ usuario.getId() + "]";
		return out;
	}

}
