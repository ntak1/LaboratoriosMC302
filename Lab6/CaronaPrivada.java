/*Classe: CaronaPrivada
 *Descricao:  carona que so eh visivel para membros de determinado grupo (GrupoPrivado).
 *Autora: Naomi Takemoto
 *Modificado em: laboratorio 06
 */
import java.util.ArrayList;
public class CaronaPrivada extends Carona {
	ArrayList <GrupoPrivado> grupos;
	
	public CaronaPrivada(){
		super();
		grupos = new ArrayList <GrupoPrivado> ();
	}
	public CaronaPrivada (CaronaCaronante caronante) {
		super(caronante);
		grupos = new ArrayList <GrupoPrivado> ();
	}
	public CaronaPrivada(CaronaCaronante caronante, double latitudeEncontro, double longitudeEncontro,
			double latitudeDestino, double longitudeDestino,
			String horaDiaEncontro, int ocupacaoMaxima){
		super (caronante, latitudeEncontro,longitudeEncontro, latitudeDestino, longitudeDestino, horaDiaEncontro,ocupacaoMaxima);
		grupos = new ArrayList <GrupoPrivado> ();
	}
	
	public String toString() {
		String out;
		ArrayList <CaronaCaroneiro> caroneirosLocal;
		out =  "Carona Privada: "  +  "[latitudeEncontro: " +super.getLatitudeEncontro() + ", longitudeEncontro: "
				+ super.getLongitudeEncontro() + ", latitudeDestino: " + super.getLatitudeDestino() + ", longitudeDestino: " + super.getLongitudeDestino()
				+ ", horaDiaEncontro: " + super.getHoraDiaEncontro() + ", ocupacaoMaxima: " + super.getOcupacaoMaxima() + ", valor: " + super.getValor();
		out += "]\nCaronante: " + super.getCaronante();
		out = out + "Lista de Caroneiros:";
		if(super.getCaroneiros() == null || super.getCaroneiros().size() == 0) {
			out += "[Vazio]";
		}
		else {
			out += "[";
		}
		caroneirosLocal = super.getCaroneiros();
		for(int i = 0; i < caroneirosLocal.size(); i++) {
			out += caroneirosLocal.get(i).toString();
		}
		out += "]\nFormas de pagamento aceitas: ";
		ArrayList<MetodoPagamento> formaPagAceitas2 = super.getFormaPagAceitas();
		for (int i = 0; i < formaPagAceitas2.size(); i++) {
			MetodoPagamento formaPagamento = formaPagAceitas2.get(i);
			out += formaPagamento.toString();
		}
		out += "\nLista de Grupos: ";
		for(int i = 0; i < grupos.size(); i++){
			out += grupos.get(i).toString();
		}
		return out;
	}
	
	
	public boolean adicionarGrupo (GrupoPrivado grupo){
		return grupos.add(grupo);
	}
}

