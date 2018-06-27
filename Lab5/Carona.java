/*Classe: Carona
 *Descricao: evento que une caronante e caroneiros em uma viagem
 *Autora: Naomi Takemoto
 *Observacao: a partir do lab05 a classe CaronaAl deixa de existir e
 *Carona passa a utilizar arrayList
 */
import java.util.ArrayList;
public class Carona {
	
	//atributos
	private ArrayList <Caroneiro> caroneiros;
	private Caronante caronante;
	private double latitudeEncontro;
	private double longitudeEncontro;
	private double latitudeDestino;
	private double longitudeDestino;
	private String horaDiaEncontro;
	private int ocupacaoMaxima;
	private float valor;
	private ArrayList <MetodoPagamento> formaPagAceitas; 
	
	//metodo construtor sem parametros
	public Carona() {
		this.caroneiros = new ArrayList <Caroneiro>();
		this.formaPagAceitas = new ArrayList <MetodoPagamento>();
	}
	
	public Carona(Caronante caronante, int ocupacaoMaxima) {
		this();
		this.caronante = caronante;
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
	public ArrayList <Caroneiro> getCaroneiros() {
		return caroneiros;
	}
	
	public Caronante getCaronante() {
		return caronante;
	}
	
	public void setCaronante(Caronante caronante) {
		this.caronante = caronante;
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
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public ArrayList<MetodoPagamento> getFormaPagAceitas() {
		return formaPagAceitas;
	}

	@Override
	public String toString() {
		String out;
		out =  "Carona "+ "[latitudeEncontro: " + latitudeEncontro + ", longitudeEncontro: "
				+ longitudeEncontro + ", latitudeDestino: " + latitudeDestino + ", longitudeDestino: " + longitudeDestino
				+ ", horaDiaEncontro: " + horaDiaEncontro + ", ocupacaoMaxima: " + ocupacaoMaxima + ", valor: " + valor;
		out +=  "]\n" + caronante;
		out = out + "Lista de Caroneiros: [";
		for(int i = 0; i < caroneiros.size(); i++) {
			out += caroneiros.get(i).toString();
		}if(caroneiros.size() == 0) {
			out += "Vazio]";
		}
		else {
			out += "]";
		}
		out += "\nForma de Pagamento: " + formaPagAceitas;
		out +=  "\n";
		return out;
	}
	
	public boolean adicionarCaroneiro (Caroneiro caroneiro) {
		if (caroneiros.size() >=  ocupacaoMaxima) {return false;}
		else {caroneiros.add(caroneiro);}
		return true;
	}
	
	public boolean removerCaroneiro(Caroneiro caroneiro){
		boolean achou;
		achou = caroneiros.remove(caroneiro);
		return achou;
	}
	
	public int verificaOcupacao() {
		 return caroneiros.size();
	}
	
	public boolean caronaVazia() {
		if (caroneiros.size() == 0) return true;
		return false;
	}
	
	public boolean adicionarFormaPagamento(MetodoPagamento mp) {
		boolean adicionou = false;
		if(formaPagAceitas.contains(mp) == false){
			//Se a carona for gratuita, GRATIS sera a unica forma de pagamento
			//e o valor da carona fica setado como 0
			if(mp == MetodoPagamento.GRATIS) {
				formaPagAceitas.clear();
				this.valor = 0;
				adicionou = true;
			}
			formaPagAceitas.add(mp);
			adicionou = true;
		}
		return adicionou;
	}
	
	public boolean removerFormaPagamento(MetodoPagamento mp) {
		return formaPagAceitas.remove(mp);
	}
	
	public boolean checarExistenciaFormaPagamento(MetodoPagamento mp) {
		return formaPagAceitas.contains(mp);
	}
	
	public boolean caronaGratuita() {
		return formaPagAceitas.contains(MetodoPagamento.GRATIS);
	}
	
}
