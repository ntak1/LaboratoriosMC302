/*Nome: Naomi Takemoto RA:184849
 LABORATORIO 08 QUESTOES
 Parte I:
 Sobre interfaces e classes abstratas, responda as seguintes questões:
 1.  É possível uma interface herdar de uma classe abstrata? É possível uma classe abstrata implementar
 uma interface?
 	Nao é possivel que uma interface herde de uma classe (mesmo que abstrata), pois interfaces herdam apenas
 	de interfaces. Há portante erro de compilacao:
 	"The type Grupo cannot be a superinterface of Salvavel; a superinterface must be an interface"
 	Uma classe abstrata por sua vez pode implementar uma interface, como ocorre no caso da classe Grupo que
 	implementa a interface Salvavel.
 2.  Quais as principais diferenças entre classes abstratas e interfaces?
 	Uma interface pose ser usada para classes dispares, sem qualquer carcteristica comum além dos metodos
 	descritos na interface, já classes abstratas se aplicam quando há uma relacao de herança entre as classes envolvidas.
 	Além disso, interfaces podem herdar de mais de uma interface o que nao ocorre com as classes abstratas, já que
 	java não permite herança múltipla de classes.
 	
 3.  O que acontece se uma classe implementar 2 interfaces diferentes, mas que tem um método com o
 mesmo nome e assinatura?
 	A classe que implementou essas duas interfaces tera que implementar o metodo (uma vez)
 	descrito nas duas interfaces para que seja uma classe concreta.Ao fazer isso ela satisfaz à requisaão de 
 	implementacao das duas interfaces.
 4.  No caso geral, não é possível implementar métodos em interfaces. Mas a partir do Java 8, é possível
 um de dois modificadores aos métodos de uma interface para que seja possível implementá-los.
 Quais são esses modificadores?
 	Uma interface pode fornecer uma implementacao de um metodo se usarmos um dos dois modficadores
 	=>defaut: usamos quando queremos uma implementacao padrao para um metodo, caso a classe que implementa a
 	interface nao a forneça.
 	=>static
 
Parte II:
Sobre arquivos e exceção, responda as seguintes questões:
1.  Qual a diferença na leitura através de um objeto BufferedInputStream para umInputStream
(incluindo suas subclasses)?
	R: Quando nao se usa o BufferedInputStream como mediador da leitura, esta será feita byte a 
	byte, fazendo com que a execucao do programa fique mais longa. Com o BufferedInputStream, um
	"pedaco" maior do arquivo é carregado para a memoria e a leitura ocorre sobre o buffer, o que,
	de forma gera é mais eficiente do que invocar múltiplas vezes o sistema operacional para 
	realizar a leitura sobre o arquivo.
2.  A classe DataOutputStream tem alguns métodos para escrita, com as assinaturas descritas abaixo.
Esses métodos dão throw em exceções do tipo IOException.  Por que esse tipo de exceção é
jogada? Em que contextos faz sentido jogar uma exceção do tipoIOException?
	public final void writeInt(int i) throws IOException;
	public final void writeFloat(float f) throws IOException;
	public final void writeByte(int b) throws IOException;
	public final void writeChar(int i) throws IOException;
...;
	Em java, exceções como FileNotFoundException herdam de IOException, dado que operacoes sobre
	arquivos e sobre dispositivos sao abstraidas de modo semelhante, logo faz sentido que os metodos
	que trabalhan com streams de entrada ou saida joguem exceções do tipo IO. Estas, devem ser jogadas
	quando há uma interrupcao ou falha em alguma operacao com dispositivos de entrada e saida, alguns
	exemplos são: um arquivo/diretório nao foi encontrado, tentaiva de leitura do arquivo após o término
	deste, etc.

3.  Explique a utilidade da interface Serializable, como ela pode ser usada com arquivos e cite
duas exceções que métodos dessa interface jogam.
	R: A interface Serializable tem a vantagem de que, como os objetos (cujas classses a implementam)
	sao salvos recursivamente, o relacionamento ente eles éh preservado.
	A interface Serializable nao possui métodos, apenas uma tag que indica para o compilador que
	a classe pode ser serializada.
	Excessões podem ser jogadas por métodos de classes que devem ser utilizadas para os procedimentos de
	salvar e recuperar os objetos como  ̈ObjectInputStream e  ObjectOutputStream, os quais podem gerar
 	por exemplo ClassNotFoundException e EOFException;
 **/

import carona.*;
import caronante.*;
import caroneiro.*;
import grupo.*;
import perfil.Perfil;
import usuario.Usuario;
import exception.SistemaCaronaExcecao;
import interfaces.Salvavel;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class Main {
	public static void main(String[] args) {

		//Cria 5 usuarios
		Usuario u[] = new Usuario [5];
		u[0] = new Usuario("Usuario 0", "usuario0@email.com", "senha0",true);
		u[1] = new Usuario("Usuario 1", "usuario1@email.com", "senha1",true);
		u[2] = new Usuario("Usuario 2", "usuario2@email.com", "senha2",true);
		u[3] = new Usuario("Usuario 3", "usuario3@email.com", "senha3",true);
		u[4] = new Usuario("Usuario 4", "usuario4@email.com", "senha4",true);
		
		//Cria 5 perfis associando perfil-usuario usuario-perfil
		Perfil p[] = new Perfil [5];
		p[0] = new Perfil('F',"00/00/00","cidade 0", "estado 0", "0000-0000", true, u[0]);
		p[1] = new Perfil('F',"10/10/10","cidade 1", "estado 0", "0000-0001", true, u[1]);
		p[2] = new Perfil('F',"20/20/20","cidade 2", "estado 0", "0000-0002", true, u[2]);
		p[3] = new Perfil('F',"30/20/30","cidade 3", "estado 0", "0000-0003", true, u[3]);
		p[4] = new Perfil('F',"40/40/40","cidade 4", "estado 0", "0000-0004", true, u[4]);
		u[0].setPerfil(p[0]);
		u[1].setPerfil(p[1]);
		u[2].setPerfil(p[2]);
		u[3].setPerfil(p[3]);
		u[4].setPerfil(p[4]);
		
		//cria perfil caronante fazendo a associacao entre eles
		Caronante caronante[] = new Caronante[5];
		caronante[0] = new Caronante(0,"genero 0", "000aaa", "carteira0","marca 0", "modelo 0",p[0]);
		caronante[1] = new Caronante(1,"genero 1", "001aaa", "carteira1","marca 1", "modelo 1",p[1]);
		caronante[2] = new Caronante(2,"genero 2", "002aaa", "carteira2","marca 2", "modelo 2",p[2]);
		caronante[3] = new Caronante(3,"genero 3", "003aaa", "carteira3","marca 3", "modelo 3",p[3]);
		caronante[4] = new Caronante(4,"genero 4", "004aaa", "carteira4","marca 4", "modelo 4",p[4]);
		p[0].setCaronante(caronante[0]);
		p[1].setCaronante(caronante[1]);
		p[2].setCaronante(caronante[2]);
		p[3].setCaronante(caronante[3]);
		p[4].setCaronante(caronante[4]);
		
		//cria perfil caroneiro fazendo a associacao entre eles
		Caroneiro caroneiro[] = new Caroneiro[5];
		caroneiro[0] = new Caroneiro(p[0], "cartao de credito 0");
		caroneiro[1] = new Caroneiro(p[1], "cartao de credito 1");
		caroneiro[2] = new Caroneiro(p[2], "cartao de credito 2");
		caroneiro[3] = new Caroneiro(p[3], "cartao de credito 3");
		caroneiro[4] = new Caroneiro(p[4], "cartao de credito 4");
		p[0].setCaroneiro(caroneiro[0]);
		p[1].setCaroneiro(caroneiro[1]);
		p[2].setCaroneiro(caroneiro[2]);
		p[3].setCaroneiro(caroneiro[3]);
		p[4].setCaroneiro(caroneiro[4]);
		
		//Criando um grupo publico e um grupo privado
		GrupoPublico gpu = new GrupoPublico("Novo grupo publico", "Descricao do grupo publico");//eh obrigatorio que o grupo tenha dono?
		GrupoPrivado ec017 = new GrupoPrivado(u[0], "EC017", "Grupo de estudantes de computacao");
		
		//u0 (dono do grupo ec017) adiciona novos membros
		System.out.println("Antes da adicao de novos membros em ec017");
		for(int i = 0; i <ec017.getMembros().size(); i++ ){
			System.out.println(ec017.getMembros().get(i).getUsuario().getNome());
		}
		
		//blocos de captura de excecao para capturar erros na insercao de novos usuarios no grupo
		try {
			u[0].adicionanrUsuarioAUmGrupo(u[1], ec017);
		}catch(SistemaCaronaExcecao erro) {
			System.out.println(erro);
		}
		try {
			u[0].adicionanrUsuarioAUmGrupo(u[2], ec017);
		}catch (SistemaCaronaExcecao erro){
			System.out.println(erro);
		}
	
		//Verifica a situacao dos gupos da adicao de novos membros
		System.out.println("Depois da adicao de novos membros em ec017");
		for(int i = 0; i <ec017.getMembros().size(); i++ ){
			System.out.println(ec017.getMembros().get(i).getUsuario().getNome());
		}
		
		System.out.println("Agora U2 tenta inserir um novo usuario u[4] no grupo privado ec017");
		try {
			u[2].adicionanrUsuarioAUmGrupo(u[4], ec017);
		}catch(SistemaCaronaExcecao erro){
			System.out.println(erro);
		}
		for(int i = 0; i <ec017.getMembros().size(); i++ ){
			System.out.println(ec017.getMembros().get(i).getUsuario().getNome());
		}
		
		//u2, u3 e u4 se adicionam no grupo gpu
		try {
			u[2].adicionarGrupo(gpu);
		}catch(SistemaCaronaExcecao erro) {
			System.out.println(erro);
		}
		try {
			u[3].adicionarGrupo(gpu);
		}catch(SistemaCaronaExcecao erro) {
			System.out.println(erro);
		}
		try {
			u[4].adicionarGrupo(gpu);
		}catch(SistemaCaronaExcecao erro) {
			System.out.println(erro);
		}
		
		System.out.println("\nAgora, u2, u3 e u4 se adicionam no grupo gpu");
		for(int i = 0; i <gpu.getMembros().size(); i++ ){
			System.out.println(gpu.getMembros().get(i).getUsuario().getNome());
		}
		CaronaPublica carona = (CaronaPublica) u[3].getPerfil().getCaronante().oferecerCaronaPublica();
		carona.adicionarGrupo(gpu);
		
		//8 Faca u0 tentar se retirar do grupo e imprima a saida
		System.out.println("Usuario u[0] tenta se retirar do grupo que eh dono");
		try{
			u[0].removerGrupo(gpu);
		}catch(SistemaCaronaExcecao ex){
			System.out.println("o usuario nao pode se retirar do grupo!\n");
		}
		
		//Faça  u2  oferecer  uma  carona  Privada  e  em  sequência  anunciar  ela  (inserí-la)  no  grupo  privado EC017;
		CaronaPrivada caronaU2 = u[2].getPerfil().getCaronante().oferecerCaronaPrivada();
		caronaU2.adicionarGrupo(ec017);
		
		// Faça u4 oferecer uma carona privada e em sequência tentar anunciar ela (inserí-la) no grupo privado EC017;
		CaronaPrivada caronaU4 = u[4].getPerfil().getCaronante().oferecerCaronaPrivada();
		caronaU4.adicionarGrupo(ec017);
		
		// Faça os usuários u0 e u1 pedirem a carona privada criada pelo usuário u2. Faça com que o u3 tente
		//pedir a mesma carona. Imprima o retorno dos métodos;
		//A saida do metodo depende da ocupacao mexima definida para a carona, como defeult esta 0
		caronaU2.setOcupacaoMaxima(3);											  //seta uma ocupacao maxima diferente de 0
		System.out.println("Com uma ocupcao maxima defina como 3, usuarios u0 u1 e u3 pedem\n" +
						   "a carona oferecida por u2, publicada em ec017.");
		System.out.println(u[0].getPerfil().getCaroneiro().pedirCarona(caronaU2));//deve ser true 
		System.out.println(u[1].getPerfil().getCaroneiro().pedirCarona(caronaU2));//deve ser true
		System.out.println(u[3].getPerfil().getCaroneiro().pedirCarona(caronaU2)+"\n");
		
		//Adicione os perfis dos usuários u0, u1 e u2 em uma lista, se já não fez; Ja fiz
		
		//Faça com que u0, u1 e u2 avaliem a carona privada criada por u2, e imprima as avaliações dos
		//perfis, na ordem colocada na lista (escolha valores das avaliações de forma que a lista não esteja
		//ordenada por avaliação);
		caronaU2.atribuirNotaCaroneiro(0, 3);
		caronaU2.atribuirNotaCaroneiro(1, 2);
		caronaU2.atribuirNotaCaronante(1.0f);
		System.out.println ("Avaliacao media de u0: " + u[0].getPerfil().getAvaliacao());
		System.out.println("Avaliacao media de u1: " + u[1].getPerfil().getAvaliacao());
		System.out.println("Avaliacao media de u2: " + u[2].getPerfil().getAvaliacao());
		Arrays.sort(p);
		System.out.println("Perfis da menor para a maior avaliacao");
		for(Perfil perfil : p){
			System.out.println("Perfil: " + perfil.getId());
		}
		
		//Imprime todos os usuarios
		System.out.println("\nESTADO DOS USUARIOS");
		for(Usuario usuario: u){
			System.out.println(usuario);
		}
		//Imprime todos os perfis
		System.out.println("\nESTADO DOS PERFIS");
		for(Perfil perfil:p){
			System.out.println(perfil);
		}
		//Imprime todos os caroneiros
		System.out.println("\nESTADO DOS CARONEIROS");
		for(Caroneiro c : caroneiro){
			System.out.println(c);
		}
		//Imprime todos os grupos
		System.out.println("\nESTADO DOS GRUPOS");
		for(Caronante c: caronante){
			System.out.println(c);
		}
		//Imprime todas as caronas
		System.out.println(caronaU2);
		System.out.println(caronaU4);
		
		/****************************************************************************************/
		/*SALVANDO O ESTADO ATUAL DO SISTEMA EM ARQUIVOS LOCALIZADOS NA RAIZ DA PASTA DO PROJETO*/
		/****************************************************************************************/
		
		String nomeArquivo = "";
		
		//coloca em conteudo a referencia para todos os objetos criados ate o momento
		Salvavel conteudo[] = new Salvavel[50];
		int i = 1;
		
		//coloca usuarios, perfils, caronantes e caroneiros
		for(i = 1; i <= u.length; i++){ 
			conteudo[i] = u[i-1];
			conteudo[i + 1*u.length] = p[i-1];
			conteudo[i + 2*u.length] = caronante[i-1];
			conteudo[i + 3*u.length] = caroneiro[i-1];
		}
		i = 4*u.length;
		//coloca os grupos privado e publico criados
		conteudo[i++] = ec017;
		conteudo[i++] = gpu;
		
		//coloca as instancias da classe GrupoUsuario
		for(int j = 0; i < ec017.getMembros().size(); j++){
			conteudo[i++] = ec017.getMembros().get(j);
		}
		for(int j = 0; i < gpu.getMembros().size(); j++){
			conteudo[i++] = gpu.getMembros().get(j);
		}
		
		//Caso os arquivos ja existam deleta
		String listaNomes [] = {"usuario.txt","perfil.txt", "grupoUsuario.txt","grupoPublico.txt",
								"grupoPrivado.txt","caroneiro.txt","caronante.txt"};
		for(String nome : listaNomes){
			File arquivo = new File(nome);
			if(arquivo.exists()){				//cria o arquivo se ele nao existir
				arquivo.delete();
			}
		}
		
		System.out.println("\n" + u.length);
		for(int j = 1; j < i; j ++){
			//System.out.println(conteudo[j].salvarParaArquivos());
			BufferedWriter out = null;
			if(conteudo[j] instanceof Usuario){
				nomeArquivo = "usuario.txt";
			}else if(conteudo[j] instanceof Perfil){
				nomeArquivo = "perfil.txt";
			}else if(conteudo[j] instanceof GrupoUsuario){
				nomeArquivo = "grupoUsuario.txt";
			}else if(conteudo[j] instanceof GrupoPublico){
				nomeArquivo = "grupoPublico.txt";
			}else if(conteudo[j] instanceof GrupoPrivado){
				nomeArquivo = "grupoPrivado.txt";
			}else if(conteudo[j] instanceof Caroneiro){
				nomeArquivo = "caroneiro.txt";
			}else if(conteudo[j] instanceof Caronante){
				nomeArquivo = "caronante.txt";
			}else{
				nomeArquivo = "";
				if(j < i-1) j++;
				else break;
			}
			
			try{
				//cria uma referencia para o arquivo
				File arquivo = new File(nomeArquivo);
				if(!arquivo.exists()){				//cria o arquivo se ele nao existir
					arquivo.createNewFile();
				}
				//Abre o stream de saida
				FileWriter fileWriter = new FileWriter(arquivo.getAbsoluteFile(), true);
				out = new BufferedWriter(fileWriter);
				if(conteudo[j] != null && conteudo[j].salvarParaArquivos() != null){
					//System.out.println(conteudo[j].salvarParaArquivos());
					out.append(conteudo[j].salvarParaArquivos());//escreve no arquivo de saida
					out.flush();
				}else{
					break;
				}
				out.flush();
				out.close();
				//System.out.println(u[0].salvarParaArquivos());
			}catch(FileNotFoundException ex){
				System.out.print("File not found");
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
	}
}//class