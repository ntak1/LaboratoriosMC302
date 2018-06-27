/*Classe: Caronante
 *Descricao: aquele que oferece carona
 *Autora: Naomi Takemoto
 *Modificado em: laboratorio 06
 */
package caronante;
import java.util.ArrayList;
import perfil.Perfil;
import carona.*;
import interfaces.Salvavel;

public class Caronante implements Salvavel{
	
		//atributos
		private int tempoHabilitacao;
		private String generoMusicalFavorito;
		private String placaVeiculo;
		private String carteiraMotorista;
		private String marcaVeiculo; 
		private String modeloVeiculo;
		private ArrayList <CaronaCaronante> caronas;
		private Perfil perfil;
		private static int geradorId = 0;
		private int id;
		//metodos construtores
		public Caronante() {
			id = geradorId++;
			caronas = new ArrayList<CaronaCaronante>();
		}
		public Caronante(Perfil perfil) {
			this();
			this.perfil = perfil;
		}
		public Caronante(int tempoHabilitacao, String generoMusicalFavorito, String placaVeiculo,
				String carteiraMotorista, String marcaVeiculo, String modeloVeiculo, Perfil perfil) {
			this();
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
		
		public ArrayList<CaronaCaronante> getCaronas(){
			return caronas;
		}
		public int getId(){
			return id;
		}
		public String toString () {
			String out = "Caronante: ";
			out = out
					+ "[Tempo de Habilitacao: " + getTempoHabilitacao()
					+ ", Genero Musical Favorito: " + getGeneroMusicalFavorito()
					+ ", Placa do Veiculo: " + getPlacaVeiculo()
					+ ", Carteira de Motorista: " + getCarteiraMotorista()
					+ ", Marca do Veiculo: " + getMarcaVeiculo()
					+ ", Modelo Veiculo: " + getModeloVeiculo();
			out = out 
					+ "]Perfil do Caronante: "
					+ "[Sexo: " + perfil.getSexo()
					+ ", Data de Nascimento: " + perfil.getDataNascimento()
					+ ", Cidade: " + perfil.getCidade()
					+ ", Estado: " + perfil.getEstado()
					+ ", Telefone: " + perfil.getTelefone()
					+ ", Fumante: " + perfil.getFumante()
					+ ", Avaliacao: " + perfil.getAvaliacao()
					+ "]";
			return out;
		}
		
		/*Metodo: oferecerCaronaPublica (sobrecarregados)
		 * 	O caronante cria uma carona, com seus atributos necessarios e eh criado
		 *	tambem um objeto do tipo CaronaCaronante para estabecer a relacao entre 
		 *	essas duas classses.
		 * */
		public CaronaPublica oferecerCaronaPublica(){
			CaronaCaronante caronante = new CaronaCaronante(this);
			CaronaPublica carona = new CaronaPublica(caronante);
			caronas.add(new CaronaCaronante(carona,this));
			return carona;
		}
		
		public CaronaPublica oferecerCaronaPublica(double latitudeEncontro, double longitudeEncontro, double latitudeDestino,
									 double longitudeDestino, String horaDiaEncontro, int ocupacaoMaxima,
									 float valor){
			CaronaCaronante caronante = new CaronaCaronante(this);
			CaronaPublica carona = new CaronaPublica(caronante,latitudeEncontro, longitudeEncontro, latitudeDestino, longitudeDestino,
									   horaDiaEncontro,ocupacaoMaxima);
			carona.setValor(valor);
			caronas.add(new CaronaCaronante(carona,this));
			return carona;
		}
	
		/*Metodo: oferecerCaronaPrivada
		 *Descricao:O caronante cria uma carona, com seus atributos necessarios e eh criado
		 *tambem um objeto do tipo CaronaCaronante para estabecer a relacao entre 
		 *essas duas classses.
		 * */
		public CaronaPrivada oferecerCaronaPrivada(){
			CaronaCaronante associativo = new CaronaCaronante(this);
			CaronaPrivada carona = new CaronaPrivada(associativo);
			associativo.setCarona(carona);
			caronas.add(associativo);
			return carona;
		}
		
		public String salvarParaArquivos(){
			String out = "[";
			out +=   tempoHabilitacao + "\n"
					+ generoMusicalFavorito + "\n"
					+ placaVeiculo + "\n"
					+ carteiraMotorista + "\n"
					+ marcaVeiculo + "\n"
					+ modeloVeiculo + "\n"
					+ perfil.getId()
					+ "]";
			
			return out;
		}

}
