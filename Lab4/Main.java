/*Nome: Naomi Takemoto
 *Ra: 184849
 * Qual o principal benefício da herança?
 *     R: A heranca permite maior reusabilidade do codigo ao tomar vantagem da relacao de generalizacao/
 *     especializacao, i.e, uma classe mais especifica pode reproveitar metodos/atributos/relacionamentos
 *     de sua superclasse, assim evita-se a repeticao de codigo.
 * 
 * Adicione final na classe Grupo , o que aconteceu com o código? Por que isso aconteceu? Em vez
 * de Grupo ser final e se definirmos GrupoPublico como final?
 *    R: Adicionando a palavra final houve um erro de compliacao, pois uma classe delcarada com a palavra
 *    final nao pode ter herdeiros, ou seja GrupoPrivado e GrupoPublico nao herdam  de Grupo e nao podem reaproveitar
 *    metodos deste.
 *    Quando definimos GrupoPublico como final, nao houve problemas ja que este nao possui herdeiros.
 * 
 * Crie uma variável estática em Grupo e GrupoPublico com o nome testStatic do tipo inteiro. No
 * main, instancie 3 objetos: a da classe Grupo, b e c da classe GrupoPublico. Faça a=b e b=c.
 * – Se você imprimir a variável testStatic qual das duas classes foi chamada para a, b e c?
 *     R: Para a variavel a foi impressa a variavel testStatic, relacionada aa classe Grupo e para b e c foi impressa a
 *     variavel relacionada aa classe GrupoPublico. Isso se deve ao fato de que atributos estaticos sao
 *     atributos de classe, ou seja um se um objeto eh declarado como referencia para uma dada classe,
 *     os atributos estaticos acessados serao sempre da classe da declaracao, independentemente da instanciacao.
 *     
 * – Altere as variáveis testStatic das duas classes, removendo o static. Não esqueça de adicionar
 * o get neste caso, pois você terá que acessar o atributo por meio de instância de objeto.
 * O resultado é o mesmo? O que mudou?
 *     R: O resultado eh o mesmo. Por conta do fato de Grupo e GrupoPublico possuirem um atributo com o mesmo nome,
 *     houve um ocultamento de variavel, i.e, quando b e c foram criados (sendo referencia para objetos da classe GrupoPublico),
 *     o atributo testStatic de Grupo foi ocultado. Portanto, toda vez que essa variavel for acessada por uma referencia
 *     para a classe GrupoPublico seu valor sera o instanciado para o objeto dessa ultima classe. Quando fazemos 
 *     a = b, apesar de b ser um objeto de GrupoPublico, a ainda eh uma referencia para Grupo e essa atribuicao causa
 *     um "desocultamento" de testStatic, que assume o valor instanciado para esta ultima classe.
 * */

public class Main {
	public static void main(String[] args) {
		
		//Criacao e estanciacao de objetos
		Perfil perfilA = new Perfil('F', "26/12/1998", "Campinas", "SP", "12233445", false, 9);
		Perfil perfilB = new Perfil('F', "14/12/1990", "Sao Paulo","SP", "90909678", false, 9);
		Usuario usuarioA = new Usuario("Oi eu sou o Goku !", "usuarioA@email.com", "senha1", false, perfilA);
		Usuario usuarioB = new Usuario("UsuarioB", "usuarioB@email.com", "senha2", true, perfilB);
		Caroneiro caroneiroA = new Caroneiro(perfilA);
		Caroneiro caroneiroC = new Caroneiro(perfilA);
		Caronante caronanteB = new Caronante(1, "rock", "abc12", "asdasdasd", "Honda", "Fit", perfilB);
		Caronante caronanteD = new Caronante(1, "rock", "abc12", "asdasdasd", "Honda", "Fit", perfilB);
		Grupo grupoPai = new Grupo("GrupoPai", "Esse grupo eh o mais geral da hierarquia.");
		GrupoPrivado grupoPrivado = new GrupoPrivado("Grupo Privado", "Nada diferente do pai por enquanto.");
		GrupoPublico grupoPublico = new GrupoPublico("Grupo Publico", "Oi, eu sou um grupo publico!");
		
		perfilA.setCaronante(caronanteB);
		perfilA.setCaroneiro(caroneiroA);
		perfilB.setCaroneiro(caroneiroC);
		perfilB.setCaronante(caronanteD);
		usuarioA.adicionarGrupo(grupoPai);
		grupoPai.adicionarMembro(usuarioA);
		usuarioB.adicionarGrupo(grupoPrivado);
		grupoPrivado.adicionarMembro(usuarioB);
		
		System.out.println(perfilA);
		System.out.println(perfilB);
		System.out.println(usuarioA);
		System.out.println(usuarioB);
		System.out.println(caroneiroA);
		System.out.println(caronanteB);
		System.out.println(grupoPai);
		System.out.println("Grupo Privado: " + grupoPrivado);
		System.out.println("Grupo Publico: " + grupoPublico);		
	}
}
