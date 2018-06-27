/*Classe: Caronante
 *Descricao: aquele que oferece carona
 *Autora: Naomi Takemoto
 */

public class Caronante {
	
		//atributos
		private int tempoHabilitacao;
		private String generoMusicalFavorito;
		private String placaVeiculo;
		private final  String carteiraMotorista;
		private String marcaVeiculo; 
		private String modeloVeiculo; 
		private int assentosDisponiveis;
		private static int numCaroneiros;
		
		//metodos construtores
		public Caronante(String carteiraMotorista) {
			this.carteiraMotorista = carteiraMotorista;
		}
		
		public Caronante (int tempoHabilitacao, String generoMusical,String placa,
						  String carteira, String marca, String modelo, int assentos)
		{
			this.tempoHabilitacao = tempoHabilitacao;
			this.generoMusicalFavorito = generoMusical;
			this.placaVeiculo = placa;
			this.carteiraMotorista = carteira;
			this.marcaVeiculo = marca;
			this.modeloVeiculo = modelo;
			this.assentosDisponiveis = assentos;
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
		
//		Mantido aqui somente para fins de teste
//		public void setCarteiraMotorista(String carteiraMotorista){
//			this.carteiraMotorista = carteiraMotorista;
//		}
		
		public String getCarteiraMotorista() {
			return carteiraMotorista;
		}
		
		public String getMarcaVeiculo() {
			return marcaVeiculo;
		}

		public void setMarcaVeiculo(String marcaVeiculo) {
			this.marcaVeiculo = marcaVeiculo;
		}
		
		public int getAssentosDisponiveis() {
			return assentosDisponiveis;
		}
		
		public void setAssentosDisponiveis(int assentosDisponiveis) {
			this.assentosDisponiveis = assentosDisponiveis;
		}
		
		public String getModeloVeiculo() {
			return modeloVeiculo;
		}
		
		public void setModeloVeiculo(String modeloVeiculo) {
			this.modeloVeiculo = modeloVeiculo;
		}
		
		public static int  getNumCaroneiros () {
			return numCaroneiros;
		}
		
		public String toString () {
			String out = "\nTempo de Habilitacao: " + getTempoHabilitacao()
						 + "\nGenero Musical Favorito: " + getGeneroMusicalFavorito()
						 + "\nPlaca do Veiculo: " + getPlacaVeiculo()
						 + "\nCarteira de Motorista: " + getCarteiraMotorista()
						 + "\nMarca do Veiculo: " + getMarcaVeiculo()
						 + "\nModelo Veiculo: " + getModeloVeiculo()
						 + "\nAssentos Disponiveis: " + getAssentosDisponiveis()
						 + "\nNumero de Caroneiros: " + getNumCaroneiros ();
			return out;
		}
		
	

}
