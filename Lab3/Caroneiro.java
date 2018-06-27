/*Classe: Caroneiro
 *Descricao: aquele que precisa de carona
 *Autora: Naomi Takemoto
 */

public class Caroneiro {
	
	//Atributos
	private String cartaoDeCredito;
	private boolean pagamentoEmDinheiro;
	private static int numCaronantes;
	
	//Construtor sem parametros, inicializa com valores default
	public Caroneiro() {
		this.cartaoDeCredito = "";
		this.pagamentoEmDinheiro = false;
	}
	
	//Cartao de credito
	public Caroneiro (String cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
		this.pagamentoEmDinheiro = false;
	}
	
	//Pagamento em dinheiro
	public Caroneiro (boolean pagamentoEmDinheiro) {
		this.cartaoDeCredito  = "";
		this.pagamentoEmDinheiro = pagamentoEmDinheiro;
	}
	
	//pagamento em dinhero e cartao: talvez sirva para algo ...
	public Caroneiro(String cartaoDeCredito, boolean pagamentoEmDinheiro){
		this.cartaoDeCredito = cartaoDeCredito;
		this.pagamentoEmDinheiro = pagamentoEmDinheiro;
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
	
	public static int getNumCaronantes() {
		return numCaronantes;
	}
	
	
	public String toString () {
		String out = "Cartao de Credito: " + getCartaoDeCredito()
					 +"\nPagamento em Dinheiro: " + getPagamentoEmDinheiro()
					 +"\nNumero de Caronantes: " + getNumCaronantes();
		return out;
		
	}

}
