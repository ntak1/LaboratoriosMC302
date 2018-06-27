import java.util.ArrayList;
public class CaronaPublica extends Carona {
	ArrayList <GrupoPublico> grupos;
	
	public CaronaPublica(){
		super();
		grupos = new ArrayList <GrupoPublico>();
	}
	
	public CaronaPublica (Caronante caronante, int ocupacaoMaxima) {
		super(caronante, ocupacaoMaxima);
		grupos = new ArrayList <GrupoPublico>();
	}
	public CaronaPublica(Caronante caronante, double latitudeEncontro, double longitudeEncontro,
			double latitudeDestino, double longitudeDestino,
			String horaDiaEncontro, int ocupacaoMaxima){
		super (caronante, latitudeEncontro,longitudeEncontro, latitudeDestino, longitudeDestino, horaDiaEncontro,ocupacaoMaxima);
		grupos = new ArrayList <GrupoPublico>();
	}
	
	public String toString() {
		String out;
		ArrayList <Caroneiro> caroneirosLocal;
		out =  "Carona Publica: [" + "latitudeEncontro: " +super.getLatitudeEncontro() + ", longitudeEncontro :"
				+ super.getLongitudeEncontro() + ", latitudeDestino: " + super.getLatitudeDestino() + ", longitudeDestino: " + super.getLongitudeDestino()
				+ ", horaDiaEncontro: " + super.getHoraDiaEncontro() + ", ocupacaoMaxima: " + super.getOcupacaoMaxima() + ", valor: " + super.getValor();
		out += "]\n"  + super.getCaronante();
		caroneirosLocal = super.getCaroneiros();
		out += "\nLista de caroneiros: [";
		for(int i = 0; i < caroneirosLocal.size(); i++) {
			out += caroneirosLocal.get(i).toString();
		}
		ArrayList<MetodoPagamento> formaPagAceitas2 = super.getFormaPagAceitas();
		out += "]\nFormas de pagamento aceitas: ";
		for (int i = 0; i < formaPagAceitas2.size(); i++) {
			MetodoPagamento formaPagamento = formaPagAceitas2.get(i);
			out += formaPagamento.toString();
		}
		out += "\nListas de Grupos: [";
		for(int i = 0; i < grupos.size(); i++){
			out +=grupos.get(i).toString();
		}
		if (grupos.size() == 0) {
			out += "Vazio]";
		}
		else {
			out += "]";
		}
		return out;
	}
	
	public boolean adicionarCaroneiro(Caroneiro caroneiro) {
		boolean adicionou = false;
		//verifica a ocupacao maxima
		if(super.getCaroneiros().size() <= super.getOcupacaoMaxima()){
			super.getCaroneiros().add(caroneiro);
			adicionou = true;
		}
		return adicionou;
	}
	
	public boolean adicionarGrupo (GrupoPublico grupo){
		return grupos.add(grupo);
	}
}

