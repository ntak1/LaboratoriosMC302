/*Nome: Naomi Takemoto RA:184849 LABORATORIO 06
 * 
 * • Há diversos relacionamentos bi-direcionais em todo o sistema, como é o caso entre Carona e Ca-
 * ronaCaroneiro, por exemplo. Quais são as vantagens e desvantagens de se utilizar relacionamentos
 * bi-direcionais?
 * Usar relacionamentos bidirecionais facilita o aparecimento de inconsistencias no codigo. Isto eh,
 * se dois objetos se relacionam dessa maneira, deve-se cuidar para que uma alteracao em um seja vista
 * e "assimilada" pelo outro. Por exemplo, quando se remove um caroneiro (ou caronante) de uma carona,
 * deve-se tambem remover a carona da lista de caronas do caroneiro. 
 * 
 * • O relacionamento entre a classe Carona e Caronante não é de muitos para muitos. Considerando
 * esse fato, foi realmente necessário criar a classe CaronaCaronante? Qual seria uma alternativa se
 * não quiséssemos criar a classe associativa, mas ainda assim guardar informação do relacionamento
 * (nesse caso, a nota)? Quais as vantagens e desvantagens dessa abordagem alternativa, comparando
 * com a atual?
 * 	R:Caso nao quisessemos criar uma classe associativa, poderiamos ter em Caronante um atributo do tipo
 * 	Carona e em Carona um atributo do tipo Caronante, e a nota da Carona/Caronante deveria ser guardada
 * 	nos objetos de ambas as classes. Esse metodo reforca a possibilidade de inconsistencias, pois, suponha
 * 	que desejemos modificar a nota que um caronate atribuiu a uma carona, teriamos que fazer isso do
 * 	lado do caronante, depois teriamos que lembrar de tomar o atributo carona e modificar o atributo avaliacao desta.
 * 	Com o uso da classe associativa, basta modificar uma vez a avaliacao da classe associativa e ela sera
 *  "assimilada" tanto pelo objeto de tipo Caronante quanto pelo objeto de tipo Carona.
 *  Desvantagem da classe associativa: acessar um atributo de um caronante atraves de uma carona fica mais longo;
 *  =>Sem classe associativa
 * 		caronaExemplo.getCaronante().getAtributo()
 *  =>Com
 *  	caronaExemplo.getCaronante().getCaronante().getAtributo
 *  Essa desvantagem eh quase insignificante.
 *  
 * • Em um sistema real, o funcionamento dos métodos criados (caso nenhuma modificação adicional
 * tenha sido feita) são suficientes para garantir consistência do sistema? É possível que haja algum
 * problema com um relacionamento entre as classes caso não seja feito alguma verificação adicional?
 * Por exemplo, poderíamos chegar em um estado onde um caronante se relaciona com uma carona,
 * mas tal carona não tem referência a esse caronante? Como poderíamos impedir que algo assim
 * ocorra? Caso no seu sistema não seja possível criar esse tipo de inconsistência, então "Não é
 * possível"é uma resposta válida (mas iremos verificar se é verdade).
 * R: Nao ha como garantir que nao hajam inconsistencias. Por exemplo, no metodo de remocao de caronantes
 * de uma carona, recebemos o caroneiro que deve ser retirado, temos que retirar o caroneiro da carona
 * e a carona da listas de caronas do caroneiro (nao foi pedido no enunciado do laboratorio que o metodo
 * fosse alterado- mas eu o modifiquei conforme entendi como correto).
 **/

public class Main {
	public static void main(String[] args) {
		
		/*Criando 4 usuarios com Id's diferentes*/
		Usuario usuarioSteven = new Usuario("Steven Universe", "steven@cristalgem.com", "leao", true);
		Usuario usuarioGarnet = new Usuario("Garnet", "garnet@cristalgem.com", "steven", true);
		Usuario usuarioPerola = new Usuario("Perola", "perola@cristalgem.com", "rose", true);
		Usuario usuarioAmetista = new Usuario("Ametista", "ametista@cristalgem.com", "steven", true);
		
		/*Associando cada usuario a seu perfil*/
		Perfil perfilSteven = new Perfil('M', "05/05/2000", "Beach City", "Ocean State", "123456-7890", false, usuarioSteven);
		Perfil perfilGarnet = new Perfil('?', "3000AC", "Beach City", "Ocean State", "123456-7890", false, usuarioGarnet);
		Perfil perfilPerola = new Perfil('?', "05/05/2000", "Beach City", "Ocean State", "123456-7890", false, usuarioPerola);
		Perfil perfilAmetista = new Perfil('?', "05/05/2000", "Beach City", "Ocean State", "123456-7890", false, usuarioAmetista);
		usuarioSteven.setPerfil(perfilSteven);
		usuarioGarnet.setPerfil(perfilGarnet);
		usuarioPerola.setPerfil(perfilPerola);
		usuarioAmetista.setPerfil(perfilAmetista);
		
		/*Associando um usuario aa Caronante e os demais a Caroneiro*/
		Caronante perolaCaronante = new Caronante(5000, "classica", "12abc", "carteiraMotorista", "Greg's Van", "Universe", perfilPerola);
		Caroneiro stevenCaroneiro = new Caroneiro(perfilSteven, "cartaoSteven");
		Caroneiro garnetCaroneiro = new Caroneiro(perfilGarnet, "cartaoGarnet");
		Caroneiro ametistaCaroneiro = new Caroneiro(perfilAmetista, "cartaoAmestista");
		perfilSteven.setCaroneiro(stevenCaroneiro);
		perfilGarnet.setCaroneiro(garnetCaroneiro);
		perfilAmetista.setCaroneiro(ametistaCaroneiro);
		perfilPerola.setCaronante(perolaCaronante);
		
		/*Criando uma carona atraves do metodo oferecer carona*/
		Carona carona = perolaCaronante.oferecerCarona(23.55,12.1, 24.90, 15.13, "8:15 23/04/2018", 4, 0);
		
		/*Adicionando caroneiros a carona*/
		carona.adicionarCaroneiro(stevenCaroneiro);
		carona.adicionarCaroneiro(garnetCaroneiro);
		carona.adicionarCaroneiro(ametistaCaroneiro);
		
		/*Identificando as personagens pelo Id*/
		System.out.println("Identificando as personagens pelo Id:");
		System.out.println(usuarioSteven.getNome() + ": " + usuarioSteven.getId());
		System.out.println(usuarioGarnet.getNome() + ": " + usuarioGarnet.getId());
		System.out.println(usuarioPerola.getNome() + ": " + usuarioPerola.getId());
		System.out.println(usuarioAmetista.getNome() + ": " + usuarioAmetista.getId());
		
		/*Atribuindo notas que cada caroneiro e caronante deram para a carona*/
		System.out.println("Atribuindo nota (8) do caronante (Perola): " + carona.atribuirNotaCaronante(8) + ", ");
		System.out.println("Atribuindo nota (10) do caroneiro (Steven): " + carona.atribuirNotaCaroneiro(usuarioSteven.getId(), 10));
		System.out.println("Atribuindo nota (9) do caroneiro (Garnet): " + carona.atribuirNotaCaroneiro(usuarioGarnet.getId(), 9));
		System.out.println("Atribuindo nota (7) do caroneiro (Ametista): " + carona.atribuirNotaCaroneiro(usuarioAmetista.getId(), 7));
		System.out.println("Atribuindo a id invalido: " + carona.atribuirNotaCaroneiro(5, 5) + "\n");/*uma atribuicao invalida*/
		
		/*Imprimindo estado dos usuarios*/
		System.out.println("Imprimindo estado dos usuarios:\n" + usuarioSteven + "\n" + usuarioGarnet + "\n" + usuarioPerola + "\n" + usuarioAmetista + "\n");
		System.out.println("Imprimindo a Carona, com caronante, caroneiros e suas avaliacoes pelo toString\n" + carona);
	}
}
