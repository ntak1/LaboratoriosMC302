/*Classe: associativa entre Carona e Caroneiro
 *Autora: Naomi Takemoto	Ra: 184849
 *Modificado em: laboratorio 06
 */
package caroneiro;
import caroneiro.Caroneiro;
import carona.Carona;

public class CaronaCaroneiro {
	private Caroneiro caroneiro;
	private Carona carona;
	private float avaliacao;
	
	//metodos construtores
	public CaronaCaroneiro(Carona carona){
		this.carona = carona;
	}
	
	public CaronaCaroneiro(Caroneiro caroneiro){
		this.caroneiro = caroneiro;
	}
	
	public CaronaCaroneiro(Carona carona, Caroneiro caroneiro){
		this.carona = carona;
		this.caroneiro = caroneiro;
	}
	
	//getters e setters
	public Caroneiro getCaroneiro() {
		return caroneiro;
	}
	
	public void setCaroneiro(Caroneiro caroneiro) {
		this.caroneiro = caroneiro;
	}
	
	public Carona getCarona() {
		return carona;
	}
	
	public void setCarona(Carona carona) {
		this.carona = carona;
	}
	
	public float getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	@Override
	public String toString() {
		return "CaronaCaroneiro [caroneiro=" + caroneiro + ", carona=" + carona
				+ ", avaliacao=" + avaliacao + "]";
	}
}
