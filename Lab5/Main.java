/*Nome: Naomi Takemoto RA:184849 LABORATORIO 5
 *• Qual a diferença de um enumerate que foi declarado com um modificador public e um que
 *	não foi?
 * Apenas o modificador public eh permitido para um enum, quando o omitimos, o enum eh
 * aumoticamente tomado como public. No entanto, se tentarmos colocar um modificador de
 * visibilidade diferente, como, protected ou provate por exemplo, ocorre um erro de compilacao.
 * 
 *• Qual a vantagem e quando se deve utilizar um enumerate ao invés de um campo String?
 * O uso de enum eh recomendavel quando queremos trabalhar com valores constantes que serao
 * usados recorrentemente como referencia para comparacoes. Nesse contexto, seu uso eh
 * mais vantajoso que de uma String pelo fato de que a comparacao entre um enum
 * nao requer a verificacao "caractere por caractere", que eh exigida quando se executa essa
 * operacao com uma String.
 **/

public class Main {
	public static void main(String[] args) {
		 Perfil perfilJujuba = new Perfil ('F', "5232", "Reino Doce", "Ooo", "1234-5678",false,10);
		 Perfil perfilMarceline = new Perfil('F',"5059", " Passagem das Rochas Vermelhas", "Ooo", "7654-4321", false, 10);
		 Perfil perfilFinn = new Perfil('M',"6000", "Casa da Arvore", "Ooo", "9090-4321", false, 10);
		 Usuario usuarioJujuba = new Usuario ("Princesa Jujuba", "jujuba@ooo.com", "ciencia", true, perfilJujuba);
		 Usuario usuarioMarceline = new Usuario ("Marceline Rainha dos Vampiros", "marceline@ooo.com", "vermelho", true, perfilMarceline);
		 Usuario usuarioFinn = new Usuario ("Finn o Humano", "finn@ooo.com", "aventura", true, perfilFinn);
		 Caronante caronanteJujuba = new Caronante (5000,"classica", "princesa","111111111","JujubaCar", "nave espacial", perfilJujuba);
		 Carona caronaEspacial = new Carona (caronanteJujuba,23.5, 23.6, 50.2, 50.3, "12/12 7:45",  3);
		 CaronaPrivada caronaPrivada = new CaronaPrivada (caronanteJujuba,24.5, 24.6, 51.2, 51.3, "12/12 7:45",  1);
		 CaronaPublica caronaPublica = new CaronaPublica (caronanteJujuba,25.5, 25.6, 52.2, 52.3, "12/12 7:45",  1);
		 Caroneiro caroneiroFinn = new Caroneiro(perfilFinn, "cartaoFinn", true);
		 Caroneiro caroneiroMarceline = new Caroneiro(perfilFinn, "cartaoMarceline", true);
		 GrupoPublico grupoPublico = new GrupoPublico("Grupo dos amigos", "Carona para todos os amigos");
		 GrupoPrivado grupoPrivado = new GrupoPrivado("Grupo das Meninas", "Carona somente para mulheres");
		 grupoPrivado.adicionarMembro(usuarioMarceline);
		 grupoPrivado.adicionarMembro(usuarioJujuba);
		 grupoPublico.adicionarMembro(usuarioFinn);
		 grupoPublico.adicionarMembro(usuarioJujuba);
		 
		 System.out.println("\n*EXECUCAO DAS INSTRUCOES*\n");
		 System.out.println("CARONA");
		 caronaEspacial.adicionarFormaPagamento(MetodoPagamento.CARTAODECREDITO);
		 System.out.println("Adiciona cartao de credito como forma de pagamento  : " + caronaEspacial.getFormaPagAceitas());
		 caronaEspacial.adicionarFormaPagamento(MetodoPagamento.DINHEIRO);
		 System.out.println("Adiciona dinheiro como forma de pagamento           : " + caronaEspacial.getFormaPagAceitas());
		 System.out.println("A carona eh gratuita                                : " + caronaEspacial.caronaGratuita());
		 System.out.println("Verifica se dinheiro eh uma forma de pagamento      : " + caronaEspacial.checarExistenciaFormaPagamento(MetodoPagamento.DINHEIRO));
		 caronaEspacial.removerFormaPagamento(MetodoPagamento.DINHEIRO);
		 System.out.println("Remove  dinheiro como forma de pagamento            : " + caronaEspacial.getFormaPagAceitas());
		 caronaEspacial.adicionarFormaPagamento(MetodoPagamento.GRATIS);
		 System.out.println("Altera a forma de pagamento para gratis             : " + caronaEspacial.getFormaPagAceitas());
		 System.out.println("Verifica se dinheiro eh uma forma de pagamento      : " + caronaEspacial.checarExistenciaFormaPagamento(MetodoPagamento.DINHEIRO));
		 System.out.println("Valor final da carona " + caronaEspacial.getValor());
		 System.out.println("A carona eh grauita                                 : " + caronaEspacial.caronaGratuita());
		 
		 System.out.println("\nCARONA PUBLICA");
		 caronaPublica.adicionarFormaPagamento(MetodoPagamento.CARTAODECREDITO);
		 System.out.println("Adiciona cartao de credito como forma de pagamento  : " + caronaPublica.getFormaPagAceitas());
		 caronaPublica.adicionarFormaPagamento(MetodoPagamento.DINHEIRO);
		 System.out.println("Adiciona dinheiro como forma de pagamento           : " + caronaPublica.getFormaPagAceitas());
		 System.out.println("A carona eh gratuita                                : " + caronaPublica.caronaGratuita());
		 System.out.println("Verifica se dinheiro eh uma forma de pagamento      : " + caronaPublica.checarExistenciaFormaPagamento(MetodoPagamento.DINHEIRO));
		 caronaPublica.removerFormaPagamento(MetodoPagamento.DINHEIRO);
		 System.out.println("Remove  dinheiro como forma de pagamento            : " + caronaPublica.getFormaPagAceitas());
		 caronaPublica.adicionarFormaPagamento(MetodoPagamento.GRATIS);
		 System.out.println("Altera a forma de pagamento para gratis             : " + caronaPublica.getFormaPagAceitas());
		 System.out.println("Verifica se dinheiro eh uma forma de pagamento      : " + caronaPublica.checarExistenciaFormaPagamento(MetodoPagamento.DINHEIRO));
		 System.out.println("Valor final da carona " + caronaPublica.getValor());
		 System.out.println("A carona eh grauita                                 : " + caronaPublica.caronaGratuita());
		 System.out.println("Verifica se a carona eh vazia                       : " + caronaPublica.caronaVazia());
		 caronaPublica.adicionarCaroneiro(caroneiroFinn);
		 System.out.println("Adicionou caroneiro                                 : " + caronaPublica.adicionarCaroneiro(caroneiroFinn));
		 System.out.println("Adicionou caroneiro (excede a ocupacao maxima)      : " + caronaPublica.adicionarCaroneiro(caroneiroFinn));
		 caronaPublica.adicionarGrupo(grupoPublico);
		 
		 System.out.println("\nCARONA PRIVADA");
		 caronaPrivada.adicionarFormaPagamento(MetodoPagamento.CARTAODECREDITO);
		 System.out.println("Adiciona cartao de credito como forma de pagamento  : " + caronaPrivada.getFormaPagAceitas());
		 caronaPrivada.adicionarFormaPagamento(MetodoPagamento.DINHEIRO);
		 System.out.println("Adiciona dinheiro como forma de pagamento           : " + caronaPrivada.getFormaPagAceitas());
		 System.out.println("A carona eh gratuita                                : " + caronaPrivada.caronaGratuita());
		 System.out.println("Verifica se dinheiro eh uma forma de pagamento      : " + caronaPrivada.checarExistenciaFormaPagamento(MetodoPagamento.DINHEIRO));
		 caronaPrivada.removerFormaPagamento(MetodoPagamento.DINHEIRO);
		 System.out.println("Remove  dinheiro como forma de pagamento            : " + caronaPrivada.getFormaPagAceitas());
		 caronaPrivada.adicionarFormaPagamento(MetodoPagamento.GRATIS);
		 System.out.println("Altera a forma de pagamento para gratis             : " + caronaPrivada.getFormaPagAceitas());
		 System.out.println("Verifica se dinheiro eh uma forma de pagamento      : " + caronaPrivada.checarExistenciaFormaPagamento(MetodoPagamento.DINHEIRO));
		 System.out.println("Valor final da carona " + caronaPrivada.getValor());
		 System.out.println("A carona eh grauita                                 : " + caronaPrivada.caronaGratuita());
		 System.out.println("Verifica se a carona eh vazia                       : " + caronaPublica.caronaVazia());
		 caronaPrivada.adicionarCaroneiro(caroneiroMarceline);
		 System.out.println("Adicionou caroneiro                                 : " + caronaPublica.adicionarCaroneiro(caroneiroFinn));
		 System.out.println("Adicionou caroneiro (excede a ocupacao maxima)      : " + caronaPublica.adicionarCaroneiro(caroneiroFinn));
		 caronaPrivada.adicionarGrupo(grupoPrivado);
		 
		 System.out.println("\n*ESTADO FINAL DAS CARONAS IMPRESSAO DO TOSTRING*\n");
		 System.out.println(caronaEspacial + "\n");
		 System.out.println(caronaPublica + "\n");
		 System.out.println(caronaPrivada + "\n");
	
	}
}
