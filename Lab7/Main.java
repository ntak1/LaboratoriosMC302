/*Nome: Naomi Takemoto RA:184849 LABORATORIO 06
 * 1. Se quiséssemos ter um método atualizaGrupoPublicoParaPrivado(), qual seria a sua sugestão de
 * implementação? Onde este método deveria ter sido inserido?
 * R:
 * Sugestao de implementacao
 * public GrupoPrivado atualizaGrupoPublicoParaPrivado(GrupoPublico grupoPublico){
		GrupoPrivado atualizado = new GrupoPrivado(grupoPublico.getDono());
		atualizado.setNome(grupoPublico.getNome());
		atualizado.setDescricao(grupoPublico.getDescricao());
		atualizado.setMembros(grupoPublico.getMembros());
		return atualizado;
	}
 * Esse metodo ficaria localizado na classe Grupo, pois um objeto do tipo GrupoPublico pode ser
 * referenciado com uma referencia do tipo Grupo, nesse caso se houvesse uma versao do metodo de 
 * privado para publico, bastaria fazer um downcasting no momento da passem de parametro.
 * 
 * 2. Crie um método no GrupoPublico chamado testeDinamico(). Este método não tem na classe
 * Grupo. Se criarmos um objeto a do Grupo e tentarmos acessar esse método do GrupoPublico é
 * possível? Explique o conceito que foi usado e como esta questão poderia ser tratada.
 * R: Nao eh possivel acessar diretamente o metodo testeDinamico, pois ocorre erro de compilacao
 * grupo.testeDinamico(); //"The method testeDinamico() is undefined for the type Grupo"
 * Uma solucao para o problema seria o "downcasting", ou seja converter a referencia mais geral
 * para a mais especifica.
 * 
 * 3. Se no item anterior nós tentarmos acessar o método testeDinamico() do GrupoPublico por meio
 * de um objeto b do GrupoPrivado, seria possível? Caso sua resposta seja negativa, qual seria uma
 * alternativa para conseguir acessá-lo?
 * R: Nao eh possivel acessar o metodo teste dinamico a partir de uma referencia do tipo GrupoPrivado,
 * pois esse metodo nao foi implementado nessa classe ou em sua superclasse, como enfatiza o erro
 * de compilacao gerado "The method testeDinamico() is undefined for the type GrupoPrivado".
 * Se quisermos usar um metodo de GrupoPublico a partir de GrupoPrivado, a solucao seria
 * criar um objeto daquele primeiro tipo e copiar todos atributos pertinentes do objeto de GrupoPrivado.
 * A outra solucao tentada (no fim do codigo da Main), que consistitia em usar uma referencia de
 * Grupo para "apontar" para um objeto do tipo GrupoPublico e depois realizar um downcasting para
 * GrupoPrivado gera erro de compilacao.
 * 
 * 4. Qual a vantagem/desvantagem em definir Carona e Grupo como classes abstratas?
 * Uma desvantagem eh que quando Carona e Grupo sao definidas como abtratas, nao podem ser 
 * instanciadas, em alguns casos como em oferecerCarona, em que deve-se retornar um objeto do tipo
 * Carona essa operacao eh desejavel.
 * A vantagem eh que fazemos uso do polimorfismo e tipagem dinamica, isto eh podemos usar uma referencia
 * de uma superclasse para acessar metodos implementados em suas subclasses, que podem tem comportamentos
 * distintos, mas mesma assinatura sabendo que o metodo de fato acessado eh aquele com o qual a referencia
 * da superclasse foi instanciada.
 *  
 * 5. É possível sobrescrever ou sobrecarregar um método em um relacionamento que não seja herança?
 * Explique.
 * R: Nao existe sobrescrita sem heranca, ja que esse conceito descreve a situacao em que uma subclasse
 * reimplementa um metodo existente em uma superclasse, com a mesma assinatura.
 * Ja a sobrecarga sempre ocorre numa mesma classe, ou seja, nao requer relacionamento de heranca.
 * Ela ocorre quando dois metodos numa classe tem o mesmo nome, porem assinaturas diferentes.
 **/

public class Main {
	public static void main(String[] args) {
		
		/*Criando 3 usuarios com Id's diferentes*/
		Usuario usuarioSteven = new Usuario("Steven Universe", "steven@cristalgem.com", "leao", true);
		Usuario usuarioGarnet = new Usuario("Garnet", "garnet@cristalgem.com", "steven", true);
		Usuario usuarioPerola = new Usuario("Perola", "perola@cristalgem.com", "rose", true);
		
		/*Associando cada usuario a seu perfil*/
		Perfil perfilSteven = new Perfil('M', "05/05/2000", "Beach City", "Ocean State", "123456-7890", false, usuarioSteven);
		Perfil perfilGarnet = new Perfil('?', "3000AC", "Beach City", "Ocean State", "123456-7890", false, usuarioGarnet);
		Perfil perfilPerola = new Perfil('?', "05/05/2000", "Beach City", "Ocean State", "123456-7890", false, usuarioPerola);
		usuarioSteven.setPerfil(perfilSteven);
		usuarioGarnet.setPerfil(perfilGarnet);
		usuarioPerola.setPerfil(perfilPerola);
		
		/*Associando um usuario aa Caronante e os demais a Caroneiro*/
		Caronante perolaCaronante = new Caronante(5000, "classica", "12abc", "carteiraMotorista", "Greg's Van", "Universe", perfilPerola);
		Caroneiro stevenCaroneiro = new Caroneiro(perfilSteven, "cartaoSteven");
		Caroneiro garnetCaroneiro = new Caroneiro(perfilGarnet, "cartaoGarnet");
		perfilSteven.setCaroneiro(stevenCaroneiro);
		perfilGarnet.setCaroneiro(garnetCaroneiro);
		perfilPerola.setCaronante(perolaCaronante);
		
		/*cria caronas e grupos dos tipos de instnciacao privados e publicos7
		 *Cada grupo tem pelo menos dois membros, ja que o dono do grupo autometicamente eh inserido como tal.
		 */
		Carona carona1 = new CaronaPrivada();
		Carona carona2 = new CaronaPublica();
		Grupo grupo1 = new GrupoPrivado(usuarioSteven, "Grupo Privado 1", "O dono passado como parametro eh Steven");
		Grupo grupo2 = new GrupoPublico(usuarioPerola, "Grupo Publico 2",  "O dono passado como parametro eh Perola");
		grupo1.adicionarMembro(usuarioGarnet);
		grupo2.adicionarMembro(usuarioGarnet);
		grupo2.adicionarMembro(usuarioSteven);
		
		//associando caronas aos grupos pertinentes
		GrupoPrivado auxGrupo1 = (GrupoPrivado) grupo1;    
		auxGrupo1.getCaronas().add((CaronaPrivada)carona1);//Adiciona carona1 na lista de caronas do grupo1
		CaronaPrivada auxCarona1 = (CaronaPrivada) carona1;
		auxCarona1.adicionarGrupo(auxGrupo1);			   //Adiciona grupo1 na lista de grupos da carona1
		
		GrupoPublico auxGrupo2 = (GrupoPublico) grupo2;
		auxGrupo2.getCaronas().add((CaronaPublica)carona2);//Adiciona carona2 na lista de caronas do grupo2
		CaronaPublica auxCarona2 = (CaronaPublica)carona2;
		auxCarona2.adicionarGrupo(auxGrupo2);             //Adiciona grupo2 a lista de grupos de carona2
		
		
		//Liste todos os usuários de cada grupo criado e todos os grupos a que cada usuário criado pertence.
		System.out.println("Lista de usuarios do grupo privado grupo1");
		for(int i = 0; i < auxGrupo1.getMembros().size(); i++){
			System.out.println("Nome: " + auxGrupo1.getMembros().get(i).getUsuario().getNome()
								+ ", Id: " + auxGrupo1.getMembros().get(i).getUsuario().getId());
		}
		
		
		System.out.println("\nLista de usuarios do grupo publico grupo2");
		for(int i = 0; i < auxGrupo2.getMembros().size(); i++){
			System.out.println("Nome: " + auxGrupo2.getMembros().get(i).getUsuario().getNome()
								+ ", Id: " + auxGrupo2.getMembros().get(i).getUsuario().getId());
		}
		
		//Faça com que um dos usuários ofereça uma carona e o outro solicite uma carona.
		System.out.println("\nCaronante Perola oferece uma carona no grupo Publico grupo2: ");
		Carona caronaPerola = perolaCaronante.oferecerCarona(23.5, 24.5, 23.4, 27.7,"05/05/2018", 3,0);
		//Associa a caronaPerola a um grupoPublico
		CaronaPublica auxCaronaPerola = (CaronaPublica) caronaPerola;
		auxCaronaPerola.adicionarGrupo((GrupoPublico) grupo2);
		System.out.println("Pedido de Carona pelo usuario Steven: " + stevenCaroneiro.pedirCarona(caronaPerola));
		//Gere avaliações para a carona oferecida.
		caronaPerola.atribuirNotaCaronante(9);
		caronaPerola.atribuirNotaCaroneiro(1, 10);
		System.out.println("\nEstado final da caronaPerola\n" + caronaPerola);
		
		System.out.println("\nLista de Grupos do Usuario Steven");
		for(int i = 0; i <usuarioSteven.getGrupos().size(); i++){
			System.out.println(usuarioSteven.getGrupos().get(i).getGrupo());
		}
		
		System.out.println("\nLista de Caronas do Usuario Steven");
		for(int i = 0; i < stevenCaroneiro.getCaronas().size(); i++){
			System.out.println(stevenCaroneiro.getCaronas().get(i).getCarona().getHoraDiaEncontro());
		}
		
		System.out.println("\nLista de Grupos do Usuario Perola");
		for(int i = 0; i <usuarioPerola.getGrupos().size(); i++){
			System.out.println(usuarioPerola.getGrupos().get(i).getGrupo());
		}
		
		System.out.println("\nLista de Caronas do Usuario Perola");
		for(int i = 0; i < perolaCaronante.getCaronas().size(); i++){
			System.out.println(perolaCaronante.getCaronas().get(i).getCarona().getHoraDiaEncontro());
		}
		
		System.out.println("\nLista de Grupos do Usuario Garnet");
		for(int i = 0; i <usuarioGarnet.getGrupos().size(); i++){
			System.out.println(usuarioGarnet.getGrupos().get(i).getGrupo());
		}
		
		System.out.println("\nLista de Caronas do Usuario Garnet");
		for(int i = 0; i < garnetCaroneiro.getCaronas().size(); i++){
			System.out.println(garnetCaroneiro.getCaronas().get(i).getCarona().getHoraDiaEncontro());
		}
		
		garnetCaroneiro.getPerfil().getUsuario().removerGrupo((GrupoPublico)grupo2);
		System.out.println("\nLista de Grupos do Usuario Garnet depois da remocao do grupo2");
		for(int i = 0; i <usuarioGarnet.getGrupos().size(); i++){
			System.out.println(usuarioGarnet.getGrupos().get(i).getGrupo());
		}
		
		System.out.println("\nLista de usuarios do grupo publico grupo2 depois da remocao");
		for(int i = 0; i < auxGrupo2.getMembros().size(); i++){
			System.out.println("Nome: " + auxGrupo2.getMembros().get(i).getUsuario().getNome()
								+ ", Id: " + auxGrupo2.getMembros().get(i).getUsuario().getId());
		}
		
		//TESTES DAS QUESTOES: DESCOMENTAR PARA VERIFICAR
		//Grupo grupo = new GrupoPublico(usuarioSteven);//o construtor obrigatoriamente recebe o dono como parametro
		
		//Teste para a questao 2
		//grupo.testeDinamico(); //======> ERRO DE COMPILACAO The method testeDinamico() is undefined for the type Grupo
		//GrupoPrivado b = new GrupoPrivado(usuarioSteven);
		
		//Teste para a questao 3
		//b.testeDinamico();     //======>ERRO DE COMPILACAO The method testeDinamico() is undefined for the type GrupoPrivado
		//grupo = b;
		//GrupoPublico gP = (GrupoPublico)b;
	}
}
