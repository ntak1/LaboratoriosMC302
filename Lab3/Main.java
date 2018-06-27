/* Nome: Naomi Takemoto
 * Ra: 184849
 * Laboratorio 03
 *
 *QUESTOES:
 * 1)Tente modificar o valor da carteira de motorista (que agora é um atributo final) de algum
 *   caronante. Crie um setter se necessário. Foi possível fazer a modificação? Explique.
 *   R: Quando tentamos modificar o valor da de uma variável declarrada como final, depois de ela
 *   já ter um valor atribuido, ocorre um erro de compilacao "The final field Caronante.carteiraMotorista
 *   cannot be assigned". Isso ocorre porque um atributo final so pode ter valor atribuido uma vez, i.e
 *   na declaracao ou no metodo contrutor.
 *   
 * 2)Agora, no método main, crie uma variável final do tipo Caronante, e instancie ela com os valores 
 *   que preferir.  Tente modificar algum atributo do objeto através de um setter, como o atributo re-
 *   ferente ao tempo de habilitação.  Foi possível modificar esse atributo, mesmo com o objeto sendo
 *   final? Por quê?
 *	 R: Depois de criado o objeto caronante2, como final, foi possivel modificar todos os seus atri-
 *   butos, exceto a carteira de motorista. Isso se explica porque o "final" aplicado para objetos de
 *   tipos nao primitivos impede apenas que se modifique a referencia para ele, ou seja, como alterar
 *   seus atributos nao mexe com a referencia, essa operacao eh permitida.
 *
 *3)Agora adicione o modificador final no atributo caroneiros da classe Carona, e execute seu programa
 *  novamente. O comportamento do programa mudou? Por que essa alteração fez/não fez efeito?
 *  R: A alteracao proposta nao teve efeito, ja que um quando declara-se um vetor como final, significa
 *  apenas que sua referencia nao pode ser mudada, mas seu conteudo sim. Nota-se em especial o que foi
 *  observado no na pergunta anterior, um vetor em java eh de "tipo por referencia".  
 *  
 *4)No cenário que foi construído, onde a ocupação máxima é definida no objeto carona, qual(is) a(s)
 *  vantagem(ns)/desvantagem(ns) (caso existam) de se adotar a solução com array e com ArrayList?
 *  R:Uma possivel vantagem de se utillizar uma implementacao por array eh que se o tamanho maximo do vetor
 *  for realmente limitado e for pequeno (ex: carros geralmente nao tem mais que 10 lugares),pode-se
 *  economizar  ja que nao seria necessario que o Java implementasse uma estrutura de dados mais
 *  complexa. Ao usar um ArrayList, por sua vez ha uma maior flexibilidade quanto ao tamano do conjunto
 *  de dados e seria mais facil determinar num dado instante a quantide de caroneiros numa carona por 
 *  exemplo, ja que nao seria mais necessario manter uma variavel criada justamente para esse fim.
 * */

public class Main {
	public static void main(String[] args) {
		
		Caronante caronante1 = new Caronante(1, "rock", "placa", "carteira", "marca", "modelo",3);
		Caroneiro caroneiro1 = new Caroneiro("cartao");
		Caroneiro caroneiro2 = new Caroneiro(true);
		Caroneiro caroneiro3 = new Caroneiro(true);
		Caroneiro caroneiro4 = new Caroneiro("cartao4", true);
		
		Carona caronaTeste = new Carona(caronante1);
		System.out.println ("No inicio\nCarona vazia: " + caronaTeste.caronaVazia());
		System.out.println("\nSetando detalhes da carona e adicionando caroneiros");
		caronaTeste.setLatitudeEncontro(15.7);
		caronaTeste.setLongitudeEncontro(45.778);
		caronaTeste.setLatitudeDestino(23.54);
		caronaTeste.setLongitudeDestino(23.53);
		caronaTeste.setHoraDiaEncontro("31/02/2018");

		System.out.println("MaxOcup: " + caronaTeste.getOcupacaoMaxima());
		System.out.println("AddCaroneiro: " + caronaTeste.adicionarCaroneiro(caroneiro1));
		System.out.println("AddCaroneiro: " + caronaTeste.adicionarCaroneiro(caroneiro2));
		System.out.println("AddCaroneiro: " + caronaTeste.adicionarCaroneiro(caroneiro3));
		System.out.println("AddCaroneiro: " + caronaTeste.adicionarCaroneiro(caroneiro4));
		System.out.println("\nToString da Carona" + caronaTeste.toString());
		System.out.println("Remove caroneiro1: " + caronaTeste.removeCaroneiro(caroneiro1));
		System.out.println("ToString da Carona" + caronaTeste.toString());
		
		
		//Repetindo o processo com o uso da Classe CaronaAL
		System.out.println("\n*Repetindo o processo com o uso da Classe CaronaAL");
		CaronaAL caronaTeste2 = new CaronaAL(caronante1);
		System.out.println ("No inicio\nCarona vazia: " + caronaTeste2.caronaVazia());
		System.out.println("\nSetando detalhes da carona e adicionando caroneiros");
		caronaTeste2.setLatitudeEncontro(15.7);
		caronaTeste2.setLongitudeEncontro(45.778);
		caronaTeste2.setLatitudeDestino(23.54);
		caronaTeste2.setLongitudeDestino(23.53);
		caronaTeste2.setHoraDiaEncontro("31/02/2018");

		System.out.println("MaxOcup: " + caronaTeste2.getOcupacaoMaxima());
		System.out.println("AddCaroneiro: " + caronaTeste2.adicionarCaroneiro(caroneiro1));
		System.out.println("AddCaroneiro: " + caronaTeste2.adicionarCaroneiro(caroneiro2));
		System.out.println("AddCaroneiro: " + caronaTeste2.adicionarCaroneiro(caroneiro3));
		System.out.println("AddCaroneiro: " + caronaTeste2.adicionarCaroneiro(caroneiro4));
		System.out.println("\nToString da Carona" + caronaTeste2.toString());
		
	}
	
}
