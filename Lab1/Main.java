/*
 *1) Qual o impacto de se tentar mudar diretamente o valor do atributo nome de um dos objetos Usuario
 * no método main? Por quê?
 *		Quando tenta-se realizar a modificação, ocorre um erro:
 * 		"Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
 *		The field Usuario.nome is not visible at Main.main(Main.java:19)".
 *		Esse erro ocorre porque o atributo nome da classe Usuario foi declarada como "private", não estando portanto visível a outros
 *		métodos que não os próprios.
 *
 *
 *2)Como você trataria o problema levantado na questão anterior? Qual seriam os prós e os contras
 *desta nova abordagem? Que conceito de Orientação a Objetos estaria sendo ”quebrado” neste caso?
 *		Uma possível abordagem seria especificar o atributo nome como público, mas isso seria uma quebra do
 *		conceito de encapsulamento. Uma possivel vantagem dessa abordagem estaria no momento de criar a classe, 
 *		poupariam-se algumas linhas de código, mas a longo prazo, os programas/sistemas que dependem dela seriam
 *		mais difíceis de serem mantidos, ou seja haveria uma redução de escalabilidade. Uma vez que o atributo é visível,
 *		qualquer mudança sobre ele não é mais local. 
*/


public class Main {

	public static void main(String[] args) {
		Usuario user1 = new  Usuario(1, "Naomi Takemoto", "naomitkm1@gmail.com", "senharuim",true);
		Perfil perfil1 = new Perfil('F', "26/12/1998", "São José dos Campos", "SP", "123456", false, 0);
		Usuario user2 = new  Usuario(2, "Pessoa", "pessoa@mail.com", "senharuim",true);
		Perfil perfil2 = new Perfil('X', "00/00/0000", "Algum Lugar", "XX", "123456", false, 0);
		
		System.out.println ("Usuario1:\n" + user1);
		System.out.println ("\nPerfil1:\n" + perfil1);
		System.out.println ("Usuario2:\n" + user2);
		System.out.println ("\nPerfil2:\n" + perfil2);


	}
	

}
