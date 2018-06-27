/*Classe: Perfil
 *Autora: Naomi Takemoto
 *Modificado em: laboratorio 06
 */
public class Perfil {
	
	//atributos
	private char sexo;
	private final String dataNascimento;
	private String cidade;
	private String estado; 
	private String telefone;
	private boolean fumante;
	private float avaliacao;
	private Caroneiro caroneiro;
	private Caronante caronante;
	private Usuario usuario;
	
	public Perfil (String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Perfil (char sexo, String dataNascimento, String cidade, String estado, String telefone, boolean fumante){
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
	public float getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
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
	//por enquanto nao precisa tratar o atributo caronas
	public String toString () {
		String out = "Perfil Informacoes gerais: [Sexo: " + this.sexo
					+ ", Data de Nascimento: " + this.dataNascimento
					+ ", Cidade: " + this.cidade
					+ ", Estado: " + this.estado
					+ ", Telefone: " + this.telefone
					+ ", Fumante: " + this.fumante 
					+ ", Avaliacao: " + this.avaliacao
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

}
