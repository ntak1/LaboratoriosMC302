/* Nome: Naomi Takemoto
 * Ra: 184849
 * Laboratorio 02
 * 
 * 1)É possível escrever uma classe sem escrever nenhum construtor? Por quê?
 * R: Sim, em Java, toda classe herda da classe Object, esta implementa um metodo construtor
 *    default.
 *    
 * 2)Um método estático pode acessar uma variável (atributo) não estático da classe? Por quê?
 *  Nao, quando um metodo eh declarado estatico ele pode ser usado mesmo que nao exitam objetos
 *  da classe a qual pertence, ou seja nao ha como um metodo estatico acessar um atributo de
 *  instancia pois, sem a existencia de um objeto propriamente dito, nao ha o que acessar.
 * 
 * 3)Um método não estático pode acessar uma variável (atributo) estático da classe? Por quê?
 *  Sim, atraves de qualquer objeto de uma classe, um metodo nao estatico consegue alterar
 *  um atributo nao estatico. A alteracao de uma variavel estatica em um dos objetos altera-
 *  ra o valor que visto por todos os demais objetos da classe.
 * */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//variaveis do caronante
		int tempoHabilitacao;
		String generoMusicalFavorito;
		String placaVeiculo;
		String carteiraMotorista;
		String marcaVeiculo; 
		String modeloVeiculo; 
		int assentosDisponiveis;
		
		//Variaveis do caroneiro
		String cartaoDeCredito;
		boolean pagamentoEmDinheiro;
		
		//Cria objeto da classe Scanner para ler entrada
		Scanner entrada = new Scanner(System.in);
		System.out.println ("[Dados do Caronante]");
		
		//leitura dos argumentos que serao passados como parametro
		System.out.print ("Tempo de Habilitacao: ");
		tempoHabilitacao = entrada.nextInt();
		System.out.print("Genero Musical Favorito: ");
		generoMusicalFavorito = entrada.next();
		System.out.print("Placa do Veiculo: ");
		placaVeiculo = entrada.next();
		System.out.print("Carteira de Motorista: ");
		carteiraMotorista = entrada.next();
		System.out.print("Marca do Veiculo: ");
		marcaVeiculo = entrada.next();
		System.out.print("Modelo do Veiculo: ");
		modeloVeiculo = entrada.next();
		System.out.print("Assentos Disponiveis: ");
		assentosDisponiveis = entrada.nextInt();
		System.out.println("\nAgora vamos instanciar alguns objetos da classe caroneiro!");
		System.out.print("Cartao de Credito: ");
		cartaoDeCredito = entrada.next();
		System.out.print("Pagamento em Dinheiro: ");
		pagamentoEmDinheiro = entrada.nextBoolean();
		
		//instancia objetos
		Caronante caronante1 = new Caronante(tempoHabilitacao, generoMusicalFavorito,
											placaVeiculo, carteiraMotorista, marcaVeiculo,
											modeloVeiculo, assentosDisponiveis);
		Caronante caronante2 = new Caronante();
		Caroneiro caroneiro1 = new Caroneiro(cartaoDeCredito);
		Caroneiro caroneiro2 = new Caroneiro(pagamentoEmDinheiro);
		Caroneiro caroneiro3 = new Caroneiro(cartaoDeCredito, pagamentoEmDinheiro);
		Caroneiro caroneiro4 = new Caroneiro();
		
		//imprime os atributos dos objetos
		System.out.println("\nCaronante1\n" + caronante1.toString());
		System.out.println("\nCaronante2\n" + caronante2.toString());
		System.out.println("\nCaroneiro1\n" + caroneiro1.toString());
		System.out.println("\nCaroneiro2\n" + caroneiro2.toString());
		System.out.println("\nCaroneiro3\n" + caroneiro3.toString());
		System.out.println("\nCaroneiro4\n" + caroneiro4.toString());
		
		entrada.close();
	}
	
}
