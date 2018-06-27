/*Classe: Caroneiro
 *Descricao: aquele que precisa de carona
 *Autora: Naomi Takemoto
 *Atualizado em: laboratotio 6
 */
import java.util.ArrayList;
public class Caroneiro {

	//Atributos
	private String cartaoDeCredito;
	private ArrayList<CaronaCaroneiro> caronas;
	private Perfil perfil;
	
	//Metodos construtores
	public Caroneiro() {
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

	public String toString () {
		String out = "Caroneiro: [";
		out +=       perfil.toString()
				     +", Cartao de Credito: " + getCartaoDeCredito() + "]";
		return out;
		
	}

}
