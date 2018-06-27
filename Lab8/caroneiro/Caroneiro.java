/*Classe: Caroneiro
 *Descricao: aquele que precisa de carona
 *Autora: Naomi Takemoto
 *Atualizado em: laboratotio 6
 */
package caroneiro;
import java.util.ArrayList;
import perfil.Perfil;
import carona.*;
import interfaces.Salvavel;

public class Caroneiro implements Salvavel{

	//Atributos
	private String cartaoDeCredito;
	private ArrayList<CaronaCaroneiro> caronas;
	private Perfil perfil;
	private static int geradorId = 0;
	private int id;
	//Metodos construtores
	public Caroneiro() {
		id = geradorId++;
		caronas = new ArrayList <CaronaCaroneiro>();
	}
	
	public Caroneiro(Perfil perfil) {
		this();
		this.perfil = perfil;
	}

	public Caroneiro (Perfil perfil, String cartaoDeCredito) {
		this(perfil);
		this.cartaoDeCredito = cartaoDeCredito;
	}

	//gets e sets
	public String getCartaoDeCredito() {
		return cartaoDeCredito;
	}
	
	public void setCartaoDeCredito(String cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public ArrayList<CaronaCaroneiro> getCaronas() {
		return caronas;
	}
	
	public int getId(){
		return id;
	}

	public String toString () {
		String out = "Caroneiro: [";
		out +=       perfil.toString()
				     +", Cartao de Credito: " + getCartaoDeCredito() + "]";
		return out;
		
	}
	
	
	/*Metodo: pedirCarona
	 *Parametros: um objeto do tipo Carona
	 *Descricao: verifica qual o tipo real (de instanciacao) da carona,
	 *depois verifica se o usuario pertence a algum dos grupos da carona,
	 *se sim adiciona, se nao nao adiciona
	 *Retorno: true se o usuario conseguiu a carona, false caso contrario.
	 * */
	public boolean pedirCarona(Carona carona){
		boolean pedidoAceito = false;
		if(carona.getOcupacaoMaxima() > carona.getCaroneiros().size()){
			//verifica se o caronante pertence a algum dos grupos da carona
			if(carona instanceof CaronaPrivada){
				CaronaPrivada caronaPrivada = (CaronaPrivada) carona;
				for(int i = 0; i < caronaPrivada.getGrupos().size(); i ++){
					//verifica se o usuario pertence a algum dos grupos da carona
					for(int j = 0; j < caronaPrivada.getGrupos().get(i).getMembros().size(); j ++){
						if(caronaPrivada.getGrupos().get(i).getMembros().get(j).getUsuario().getId() == this.getPerfil().getUsuario().getId()){
							pedidoAceito = true;
							caronaPrivada.adicionarCaroneiro(this);
							break;
						}
					}
				}
			}
			//Se a carona eh publica, ha necessidade de verificar se o usuario pertence ao grupo???
			else if(carona instanceof CaronaPublica){
				CaronaPublica caronaPublica = (CaronaPublica) carona;
				for(int i = 0; i < caronaPublica.getGrupos().size(); i ++){
					//verifica se o usuario pertence a algum dos grupos da carona
					for(int j = 0; j < caronaPublica.getGrupos().get(i).getMembros().size(); j ++){
						if(caronaPublica.getGrupos().get(i).getMembros().get(j).getUsuario().getId() == this.getPerfil().getUsuario().getId()){
							pedidoAceito = true;
							caronaPublica.adicionarCaroneiro(this);
							break;
						}
					}
				}
			}
		}
		return pedidoAceito;
	}
	
	public String salvarParaArquivos(){
		String out = "[";
		out += cartaoDeCredito + "\n"
				+perfil.getId() +"]";
		return out;
	}
}
