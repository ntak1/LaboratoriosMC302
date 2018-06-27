/*Classe: Carona
 *Descricao: evento que une caronante e caroneiros em uma viagem
 *Autora: Naomi Takemoto
 */
public class Carona {
	
	//atributos
	private final Caroneiro caroneiros [];
	private final Caronante caronante;
	private double latitudeEncontro;
	private double longitudeEncontro;
	private double latitudeDestino;
	private double longitudeDestino;
	private String horaDiaEncontro;
	private int ocupacaoMaxima;
	private int numOcupantes;
	
	//metodo construtor sem parametros
	public Carona(Caronante caronante) {
		this.caronante = caronante;
		this.caroneiros = new Caroneiro [10]; //instanciar array vazio
		this.numOcupantes = 0;
	}
	
	public Carona(Caronante caronante, int ocupacaoMaxima) {
		this(caronante);
		this.ocupacaoMaxima = ocupacaoMaxima;
	}
	//metodo construtor com todos os parametros, exceto caroneiros
	public Carona (Caronante caronante, double latitudeEncontro, double longitudeEncontro,
					double latitudeDestino, double longitudeDestino,
					String horaDiaEncontro, int ocupacaoMaxima)
	{
		this(caronante, ocupacaoMaxima);
		this.latitudeEncontro = latitudeEncontro;
		this.longitudeEncontro = longitudeEncontro;
		this.latitudeDestino = latitudeDestino;
		this.longitudeDestino = longitudeDestino;
		this.horaDiaEncontro = horaDiaEncontro;
	}
	
	//gets e sets
	public Caroneiro[] getCaroneiros() {
		return caroneiros;
	}
	
	public Caronante getCaronante() {
		return caronante;
	}
	
	public double getLatitudeEncontro() {
		return latitudeEncontro;
	}
	
	public void setLatitudeEncontro(double latitudeEncontro) {
		this.latitudeEncontro = latitudeEncontro;
	}
	
	public double getLongitudeEncontro() {
		return longitudeEncontro;
	}
	
	public void setLongitudeEncontro(double longitudeEncontro) {
		this.longitudeEncontro = longitudeEncontro;
	}
	
	public double getLatitudeDestino() {
		return latitudeDestino;
	}
	
	public void setLatitudeDestino(double latitudeDestino) {
		this.latitudeDestino = latitudeDestino;
	}
	
	public double getLongitudeDestino() {
		return longitudeDestino;
	}
	
	public void setLongitudeDestino(double longitudeDestino) {
		this.longitudeDestino = longitudeDestino;
	}
	
	public String getHoraDiaEncontro() {
		return horaDiaEncontro;
	}
	
	public void setHoraDiaEncontro(String horaDiaEncontro) {
		this.horaDiaEncontro = horaDiaEncontro;
	}
	
	public int getOcupacaoMaxima() {
		return ocupacaoMaxima;
	}
	
	public void setOcupacaoMaxima(int ocupacaoMaxima) {
		this.ocupacaoMaxima = ocupacaoMaxima;
	}
	
	public String toString () {
		String out = "Classe Carona{\n";
		out = out + "	Caronante: " + caronante.toString() + "\n";
		for (int i = 0; i < numOcupantes; i++) {
			out = out + "Caroneiro: " + (i+1 )+ " " + caroneiros[i].toString() + "\n";
		}
		out = out
			  + "\n    Latitude de encontro: " + latitudeEncontro
			  + "\n    Longitude de encontro: " + longitudeEncontro
			  + "\n    Latitude de destino: " + latitudeEncontro
			  + "\n    Longitude de destino: " + longitudeDestino
			  + "\n    Hora e dia de encontro: " + horaDiaEncontro
			  + "\n    Ocupacao Maxima: " + ocupacaoMaxima
			  + "\n}\n";
		return out;
	}
	
	public boolean adicionarCaroneiro (Caroneiro caroneiro) {
		if (numOcupantes >= ocupacaoMaxima) {return false;}
		else {caroneiros[numOcupantes++] = caroneiro;}
		return true;
	}
	
	//retorna o numero de ocupantes
	public int verificaOcupacao() {
		 return this.numOcupantes;
	}
	
	public boolean caronaVazia() {
		if (numOcupantes == 0) return true;
		return false;
	}
	
	public boolean removeCaroneiro(Caroneiro caroneiro){
		boolean achou = false;
		int i = 0;
		for( i = 0; i< numOcupantes; i++){
			if (caroneiro == this.caroneiros[i]){
				achou = true;
				for(; i< numOcupantes && i < 9; i++){
					this.caroneiros[i] = caroneiros[i+1];
				}
				numOcupantes--;
				break;
			}
		}
		return achou;
	}

}
