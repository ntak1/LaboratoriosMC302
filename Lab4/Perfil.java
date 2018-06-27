
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
	
	public Perfil (String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Perfil (char sexo, String dataNascimento, String cidade, String estado, String telefone, boolean fumante,
			      float avaliacao){
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.fumante = fumante;
		this.avaliacao = avaliacao;
	}
	
	public Perfil(char sexo, String dataNascimento, String cidade, String estado, String telefone, boolean fumante,
			      float avaliacao, Caroneiro caroneiro, Caronante caronante) {
		this(sexo, dataNascimento, cidade, estado, telefone, fumante, avaliacao);
		this.caroneiro = caroneiro;
		this.caronante = caronante;
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
	
	//por enquanto nao precisa tratar o atributo caronas
	public String toString () {
		String out = "Classe Perfil {\n    Sexo: " + this.sexo
					+ "\n    Data de Nascimento: " + this.dataNascimento
					+ "\n    Cidade: " + this.cidade
					+ "\n    Estado: " + this.estado
					+ "\n    Telefone: " + this.telefone
					+ "\n    Fumante: " + this.fumante 
					+ "\n    Avaliacao: " + this.avaliacao
					+ "\n    Caroneiro: " + "Cartao de credito: " + caroneiro.getCartaoDeCredito()
					+ "\n    Caronante: "
					+ "\n        Tempo de Habilitacao: " + caronante.getTempoHabilitacao()
					+ "\n        Genero Musical Favorito: " + caronante.getGeneroMusicalFavorito()
					+ "\n        Placa do Veiculo: " + caronante.getPlacaVeiculo()
					+ "\n        Carteira de Motorista: " + caronante.getCarteiraMotorista()
					+ "\n        Marca do Veiculo: " + caronante.getMarcaVeiculo()
					+ "\n        Modelo Veiculo: " + caronante.getModeloVeiculo()
					+ "\n}\n";
		return out;
	}

	
}
