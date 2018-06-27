/*Classe: CaronaPrivada
 *Descricao:  carona que so eh visivel para todos osmembros do grupo (GrupoPublico).
 *Autora: Naomi Takemoto
 *Modificado em: laboratorio 06
 */
import java.util.ArrayList;
public class CaronaPublica extends Carona {
	ArrayList <GrupoPublico> grupos;
	
	//Metodos construtores
	public CaronaPublica(){
		super();
		grupos = new ArrayList <GrupoPublico>();
	}
	public CaronaPublica (CaronaCaronante caronante) {
		super(caronante);
		grupos = new ArrayList <GrupoPublico> ();
	}
	public CaronaPublica (CaronaCaronante caronante, int ocupacaoMaxima) {
		super(caronante, ocupacaoMaxima);
		grupos = new ArrayList <GrupoPublico>();
	}
	
	public CaronaPublica(CaronaCaronante caronante, double latitudeEncontro, double longitudeEncontro,
			double latitudeDestino, double longitudeDestino,
			String horaDiaEncontro, int ocupacaoMaxima){
		super (caronante, latitudeEncontro,longitudeEncontro, latitudeDestino, longitudeDestino, horaDiaEncontro,ocupacaoMaxima);
		grupos = new ArrayList <GrupoPublico>();
	}
	
	//getter
	public ArrayList<GrupoPublico> getGrupos() {
		return grupos;
	}

	
	public String toString() {
		String out;
		out =  "Carona Publica: [" + "latitudeEncontro: " +super.getLatitudeEncontro() + ", longitudeEncontro :"
				+ super.getLongitudeEncontro() + ", latitudeDestino: " + super.getLatitudeDestino()
				+ ", longitudeDestino: " + super.getLongitudeDestino()
				+ ", horaDiaEncontro: " + super.getHoraDiaEncontro() + ", ocupacaoMaxima: "
				+ super.getOcupacaoMaxima() + ", valor: " + super.getValor();
		out += "]\n"  + super.getCaronante().getCaronante();
		ArrayList<MetodoPagamento> formaPagAceitas2 = super.getFormaPagAceitas();
		out += "]\nFormas de pagamento aceitas: ";
		for (int i = 0; i < formaPagAceitas2.size(); i++) {
			MetodoPagamento formaPagamento = formaPagAceitas2.get(i);
			out += formaPagamento.toString();
		}
		out += "\nAvaliacao do caronante: " + getCaronante().getAvaliacao();
		out += "\nAvaliacao dos caroneiros: ";
		for(int i = 0; i < getCaroneiros().size(); i++){
			out += getCaroneiros().get(i).getCaroneiro().getPerfil().getUsuario().getNome() + ": ";
			out += getCaroneiros().get(i).getAvaliacao();
		}
		return out;
	}
	
	
	public boolean adicionarGrupo (GrupoPublico grupo){
		return grupos.add(grupo);
	}
	
	/*Metodo adicionarCaroneiro
	 *Parametro: um objeto do tipo caroneiro
	 *Saida: boolean, true se o objeto foi adicionado com sucesso,
	 *falso caso contraio
	 */
	public boolean adicionarCaroneiro (Caroneiro caroneiro) {
		CaronaCaroneiro novaCaronaCaroneiro;
		if (getCaroneiros().size() >= getOcupacaoMaxima()) {return false;}
		else {
			novaCaronaCaroneiro = new CaronaCaroneiro(this, caroneiro); /*instancia obj da classe assocativa*/
			getCaroneiros().add(novaCaronaCaroneiro);					/*adiciona no ArrayList do obj de tipo Carona*/
			caroneiro.getCaronas().add(novaCaronaCaroneiro);			/*adiciona no ArrayList do obj de tipo Caroneiro*/
			
		}
		return true;
	}
	
	/*Metodo: removerCaroneiro
	 *Parametro: recebe o caroneiro que deve ser removido
	 *O que faz: acha o caroneiro que deve ser removido, remove a refenecia CaronaCaroneiro e depois re
	 *move a referencia CaroneiroCarona
	 *Retorna: boolean, true se achou o elemento para ser removido, false caso contrario*/
	public  boolean removerCaroneiro(Caroneiro caroneiro){
		boolean removeu = false;
		for(int i = 0; i < getCaroneiros().size(); i++){
			if(getCaroneiros().get(i).getCaroneiro() == caroneiro){         //Se achou o caroneiro
				removeu = true;
				for(int j = 0;j < caroneiro.getCaronas().size(); j ++){//procura a carona na lista de caronas do caroneiro
					if(caroneiro.getCaronas().get(j).getCarona() == this){
						caroneiro.getCaronas().remove(j);			   //exlcui a carona da lista de caronas do caroneiro
					}
				}
				getCaroneiros().remove(i);                            //exclui caroneiro da carona
			}
		}
		return removeu;
	}
}

