/*Classe: Caronante
 *Descricao: aquele que oferece carona
 *Autora: Naomi Takemoto
 */

public class Caronante {
	
		//atributos
		private int tempoHabilitacao;
		private String generoMusicalFavorito;
		private String placaVeiculo;
		private String carteiraMotorista;
		private String marcaVeiculo; 
		private String modeloVeiculo;
		private Perfil perfil;
		
		//metodos construtores
		public Caronante() {
			
		}
		public Caronante(Perfil perfil) {
			this.perfil = perfil;
		}
		public Caronante(int tempoHabilitacao, String generoMusicalFavorito, String placaVeiculo,
				String carteiraMotorista, String marcaVeiculo, String modeloVeiculo, Perfil perfil) {
			super();
			this.tempoHabilitacao = tempoHabilitacao;
			this.generoMusicalFavorito = generoMusicalFavorito;
			this.placaVeiculo = placaVeiculo;
			this.carteiraMotorista = carteiraMotorista;
			this.marcaVeiculo = marcaVeiculo;
			this.modeloVeiculo = modeloVeiculo;
			this.perfil = perfil;
		}
		
		//gets e sets
		public int getTempoHabilitacao() {
			return tempoHabilitacao;
		}
		
		public void setTempoHabilitacao(int tempoHabilitacao) {
			this.tempoHabilitacao = tempoHabilitacao;
		}
		
		public String getGeneroMusicalFavorito() {
			return generoMusicalFavorito;
		}
		
		public void setGeneroMusicalFavorito(String generoMusicalFavorito) {
			this.generoMusicalFavorito = generoMusicalFavorito;
		}
		
		public String getPlacaVeiculo() {
			return placaVeiculo;
		}
		
		public void setPlacaVeiculo(String placaVeiculo) {
			this.placaVeiculo = placaVeiculo;
		}
		
		public void setCarteiraMotorista(String carteiraMotorista){
			this.carteiraMotorista = carteiraMotorista;
		}
		
		public String getCarteiraMotorista() {
			return carteiraMotorista;
		}
		
		public String getMarcaVeiculo() {
			return marcaVeiculo;
		}

		public void setMarcaVeiculo(String marcaVeiculo) {
			this.marcaVeiculo = marcaVeiculo;
		}
		
		public String getModeloVeiculo() {
			return modeloVeiculo;
		}
		
		public void setModeloVeiculo(String modeloVeiculo) {
			this.modeloVeiculo = modeloVeiculo;
		}

		public Perfil getPerfil() {
			return perfil;
		}

		public void setPerfil(Perfil perfil) {
			this.perfil = perfil;
		}
		
		public String toString () {
			String out = "Classe Caronante {\n";
			out = out
					+ "	\n    Tempo de Habilitacao: " + getTempoHabilitacao()
					+ "	\n    Genero Musical Favorito: " + getGeneroMusicalFavorito()
					+ "	\n    Placa do Veiculo: " + getPlacaVeiculo()
					+ "	\n    Carteira de Motorista: " + getCarteiraMotorista()
					+ "	\n    Marca do Veiculo: " + getMarcaVeiculo()
					+ "	\n    Modelo Veiculo: " + getModeloVeiculo();
			out = out 
					+ "\n    Perfil:\n"
					+ "\n    Sexo: " + perfil.getSexo()
					+ "\n    Data de Nascimento: " + perfil.getDataNascimento()
					+ "\n    Cidade: " + perfil.getCidade()
					+ "\n    Estado: " + perfil.getEstado()
					+ "\n    Telefone: " + perfil.getTelefone()
					+ "\n    Fumante: " + perfil.getFumante()
					+ "\n    Avaliacao: " + perfil.getAvaliacao()
					+ "\n}\n";
			return out;
		}
		
		//Criar aqui o metodo oferecer carona
		public Carona oferecerCarona(Caronante caronante, double latitudeEncontro, double longitudeEncontro,
				double latitudeDestino, double longitudeDestino, String horaDiaEncontro,
				int ocupacaoMaxima){
			Carona novaCarona = new Carona(caronante, latitudeEncontro,longitudeEncontro,
					latitudeDestino, longitudeDestino, horaDiaEncontro,ocupacaoMaxima);
			return novaCarona;
			
		}

}
