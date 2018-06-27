/*Autora: Naomi Takemoto
 *Classe: associativa entre Carona e Caronante
 *Modificado em: laboratorio 06*/
package caronante;
import carona.Carona;
public class CaronaCaronante {
	private Caronante caronante;
	private Carona carona;
	private float avaliacao;
	
	//Metodos contrutores
	CaronaCaronante(Carona carona){
		this.carona = carona;
	}
	CaronaCaronante(Caronante caronante){
		this.caronante = caronante;
	}
	CaronaCaronante(Carona carona, Caronante caronante){
		this(carona);
		this.caronante = caronante;
	}
	
	//getters e setters
	public Caronante getCaronante() {
		return caronante;
	}
	public void setCaronante(Caronante caronante) {
		this.caronante = caronante;
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
		return "CaronaCaronante [caronante=" + caronante + ", carona=" + carona
				+ ", avaliacao=" + avaliacao + "]";
	}
	
}
