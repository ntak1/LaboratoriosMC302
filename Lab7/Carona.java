/*Classe: Carona
 *Descricao: evento que une caronante e caroneiros em uma viagem
 *Autora: Naomi Takemoto
 *Observacao: a partir do lab06 a classe Carona passa a ser abstrata
 */
import java.util.ArrayList;
public abstract class Carona {
	
	//atributos
	private ArrayList <CaronaCaroneiro> caroneiros;
	private CaronaCaronante caronante;
	private double latitudeEncontro;
	private double longitudeEncontro;
	private double latitudeDestino;
	private double longitudeDestino;
	private String horaDiaEncontro;
	private int ocupacaoMaxima;
	private float valor;
	private ArrayList <MetodoPagamento> formaPagAceitas; 
	
	//metodos contrutores
	public Carona() {
		this.caroneiros = new ArrayList <CaronaCaroneiro>();
		this.formaPagAceitas = new ArrayList <MetodoPagamento>();
	}
	
	public Carona(CaronaCaronante caronante){
		this();
		this.caronante = caronante;
	}
	
	public Carona(CaronaCaronante caronante, int ocupacaoMaxima) {
		this();
		this.caronante = caronante;
		this.ocupacaoMaxima = ocupacaoMaxima;
	}
	//metodo construtor com todos os parametros, exceto caroneiros
	public Carona (CaronaCaronante caronante, double latitudeEncontro, double longitudeEncontro,
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
	public ArrayList <CaronaCaroneiro> getCaroneiros() {
		return caroneiros;
	}
	
	public CaronaCaronante getCaronante() {
		return caronante;
	}
	
	public void setCaronante(CaronaCaronante caronante) {
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
		out =  "Carona\n"+ "Informacoes Gerais da Carona: [latitudeEncontro: " + latitudeEncontro + ", longitudeEncontro: "
				+ longitudeEncontro + ", latitudeDestino: " + latitudeDestino + ", longitudeDestino: " + longitudeDestino
				+ ", horaDiaEncontro: " + horaDiaEncontro + ", ocupacaoMaxima: " + ocupacaoMaxima + ", valor: " + valor;
		
		out += "\nId do caronante" + " " + caronante.getCaronante().getPerfil().getUsuario().getId();
		out +=  "\n" + caronante.getCaronante();
		out += "\nAvaliacao do caronante " +  caronante.getCaronante().getPerfil().getUsuario().getNome() + " " + caronante.getAvaliacao();
		out = out + "\nLista de Caroneiros:";
		for(int i = 0; i < caroneiros.size(); i++) {
			out += "\nId do caroneiro"  + " " + caroneiros.get(i).getCaroneiro().getPerfil().getUsuario().getId();
			out += "\n[" + caroneiros.get(i).getCaroneiro() + "]";
			out += "\n[Avaliacao do caroneiro "
					 +" "+ caroneiros.get(i).getCaroneiro().getPerfil().getUsuario().getNome()
					 + ": "+ caroneiros.get(i).getAvaliacao()+"]";
		}if(caroneiros.size() == 0) {
			out += "[Vazio]";
		}
		out += "\nFormas de Pagamento: " + formaPagAceitas;
		out +=  "\n";
		return out;
	}
	
	//Metodos abstratos: adicionar e remover carona
	public abstract boolean adicionarCaroneiro (Caroneiro caroneiro);
	public abstract boolean removerCaroneiro(Caroneiro caroneiro);
	
	public int verificaOcupacao() {
		 return caroneiros.size();
	}
	
	public boolean caronaVazia() {
		if (caroneiros.size() == 0) return true;
		return false;
	}
	
	/*Metodo: adicionarFormaPagamento
	 *Parametro: um objeto do tipo MetodoPagamento (mp)
	 *O que faz: adiciona o metodo ao ArrayList de formas de pagamento, mas
	 *se mp for GRATIS, essa sera a unica forma de pagamento e o valor da ca-
	 *rona fica setado como 0.
	 *Saida: boolean, true se adicioneou corretamente, false caso contrario*/
	public boolean adicionarFormaPagamento(MetodoPagamento mp) {
		boolean adicionou = false;
		if(formaPagAceitas.contains(mp) == false){
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
	
	/*Metodo: atribuirNotaCaroneiro
	 *Entrada: um inteiro que eh o id do usuario, um float avaliacao
	 *O que faz: percorre a lista de objetos CaronaCaroneiro, verificando
	 *           se o id de algum deles é o passado
	 *Saida: bool, true se achou o carnoneiro, false se nao*/
	boolean atribuirNotaCaroneiro(int idUsuario, float avaliacao){
		boolean achou = false;
		for (int i = 0; i < caroneiros.size(); i++){
			if(caroneiros.get(i).getCaroneiro().getPerfil().getUsuario().getId() == idUsuario){
				achou = true;
				caroneiros.get(i).setAvaliacao(avaliacao);
			}
		}
		return achou;
	}
	
	/*Metodo: atribuirNotaCaronante
	 *Entrada: um float que eh a avaliacao
	 *O que faz: se nao houver caronante seta a avaliacao.
	 *Saida: bool, true se achou o carnoneiro, false se nao
	 **/
	boolean atribuirNotaCaronante(float avaliacao){
		boolean achou = false;
		if(this.caronante != null){
			achou = true;
			caronante.setAvaliacao(avaliacao);
		}
		return achou;
	}
}
