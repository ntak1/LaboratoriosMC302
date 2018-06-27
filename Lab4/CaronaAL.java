import java.util.ArrayList;

public class CaronaAL {
	
	private ArrayList <Caroneiro> caroneiros;
	private final Caronante caronante;
	private double latitudeEncontro;
	private double longitudeEncontro;
	private double latitudeDestino;
	private double longitudeDestino;
	private String horaDiaEncontro;
	private int ocupacaoMaxima;
	
	//Metodos construtores
	public CaronaAL (Caronante caronante) {
		this.caronante = caronante;
		this.caroneiros = new ArrayList<Caroneiro>();
	}
	public CaronaAL (Caronante caronante, int ocupacaoMaxima) {
		this(caronante);
		this.ocupacaoMaxima = ocupacaoMaxima;
	}
	public CaronaAL (Caronante caronante, double latitudeEncontro, double longitudeEncontro,
					double latitudeDestino, double longitudeDestino, String horaDiaEncontro,
					int ocupacaoMaxima) {
		this(caronante, ocupacaoMaxima);
		this.latitudeEncontro = latitudeEncontro;
		this.longitudeEncontro = longitudeEncontro;
		this.latitudeDestino = latitudeDestino;
		this.longitudeDestino = longitudeDestino;
		this.horaDiaEncontro = horaDiaEncontro;
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
	
	public String toString() {
		String out = "Classe CaronaAL {\n";
		out +="\n	Caronante: " + caronante.toString() + "\n";
		for(int i = 0; i< caroneiros.size(); i++) {
			out = out + "Caroneiro: " + (i+1) + " " +  caroneiros.get(i).toString() + "\n";
		}
		out += "    Latitude de Encontro: " + latitudeEncontro
			+ "\n    Longitude de Encontro: " + longitudeEncontro
			+ "\n    Latitude de Destino: " + latitudeDestino
			+ "\n    Dia e hora do encontro: " + horaDiaEncontro
			+ "\n    Ocupacao Maxima: " + ocupacaoMaxima
			+ "\n}\n";
		return out;
	}
	
	public boolean adicionarCaroneiro (Caroneiro caroneiro) {
		if(caroneiros.size() >= ocupacaoMaxima) {return false;}
		else {caroneiros.add(caroneiro);}
		return true;
	}
	
	public int verificaOcupacao() {
		return caroneiros.size();
	}
	
	public boolean caronaVazia() {
		if (caroneiros.size() == 0) {
			return true;
		}
		return false;
	}
}
