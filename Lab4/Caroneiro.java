/*Classe: Caroneiro
 *Descricao: aquele que precisa de carona
 *Autora: Naomi Takemoto
 */

public class Caroneiro {
	
	//Atributos
	private String cartaoDeCredito;
	private boolean pagamentoEmDinheiro;
	private Perfil perfil;
	
	//Metodos construtores
	public Caroneiro() {
		this.cartaoDeCredito = "";
	}
	
	public Caroneiro(Perfil perfil) {
		this.perfil = perfil;
	}

	public Caroneiro (Perfil perfil, String cartaoDeCredito) {
		this(perfil);
		this.cartaoDeCredito = cartaoDeCredito;
		this.pagamentoEmDinheiro = false;
	}

	//gets e sets
	public String getCartaoDeCredito() {
		return cartaoDeCredito;
	}
	
	public void setCartaoDeCredito(String cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
	}
	
	public boolean getPagamentoEmDinheiro() {
		return pagamentoEmDinheiro;
	}
	
	public void setPagamentoEmDinheiro(boolean pagamentoEmDinheiro) {
		this.pagamentoEmDinheiro = pagamentoEmDinheiro;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public String toString () {
		String out = "Classe Caroneiro {\n";
		out +=        perfil.toString()
				     +"\n    Cartao de Credito: " + getCartaoDeCredito()
					 +"\n}\n";
		return out;
		
	}

}
