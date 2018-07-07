/*Nome Naomi Takemoto
 *Ra:184849
 *TurmaB
 *
 *Observacoes: o layout das janelas foi construido com o auxilido do plugin windowBuilder
 *
 *Questoes:
 *
 *1.  Quais as principais diferenças entre Swing e AWT?
 *	R:Em AWT, os componentes são baseados na plataforma, ou seja é
 *	dependete do sistema operacional em que esta rodando. Nesse
 *	sentido ocorrem problemas diferentes em plataformas diferentes o
 *	que diminui a portabilidade do sistema que eh construido com 
 *	AWT. Alem disso, o conjunto de componetes disponiveis eh extrema-
 *	mente simples e com o passar do tempo se mostrou nao ser suficiente.
 *	Swing, por sua vez aumentou em numero e em complexidade os compo-
 *	nentes que estao disponiveis. Sendo estes baseados em Java, o
 *	que possibilita maior portabilidade. Os problemas que surgirem
 *	entao sao os mesmos para todas as plataformas.
 * 
 *2.  Qual a vantagem de se usar um RootPaneContainer?
 *	R: Quando se usa um rootPaneContainer os componentes nao sao adicionados dire-
 *	tamente ao container top-level e sim ao content-pane.
 *
 *3.  Quando temos um JDialog visível o que ocorre com as outras janelas do sistema?
 *	R: Se o dialogo for modal o usuario nao podera acessar as demais janelas da aplicacao
 *	enquanto ele estiver aberto.
 *
 *4.  Explique as diferenças entre BorderLayout, BoxLayout, FlowLayout e GridLayout.  Quais deles
 *você usou na criação das janelas? Por quê?
 *	BorderLayout: posiciona os componetes em 5 grandes areas (norte,
 *	sul, leste e oeste). Quando ha redimensionamento as extremidades
 *	nao sao alteradas.
 *	Boxlayout: coloca cada componente em uma linha, respeitando o 
 *	tamanho máximo e dicas de alinhamento.
 *	FlowLayout: coloca componentes na mesma linha, indo para a pŕoxima
 *	quando nao houver mais espaco.
 *	GridLayout: coloca os componentes em celulas de tamanho exatamente
 *	iguais uns aos outros, cada celula, quando tem um componente
 *	é preechida completamente.
 *	Não usei nenhum dos posicionamentos acima. Utilizei o layout absoluto, pois
 *  facilita a implementacao, apesar de nao ser apropriado para aplicacoes que 
 *  se pretendem responsivas.
 *
 *5.  Explique  o  que  é  uma  função  callback.   Como  são  implementadas  em  Java?   Não  use  código,
 *explique com suas palavras.
 *	R: Em um paralelo com iterrupcoes de herdware/software que ocorrem em
 *	um computador, uma funcao de callback eh como um tratador de interrupcoes.
 *	Por exemplo, quando um botao eh acionado, uma acao deve ser tomada em resposta,
 *	a acao que deve ser tomada  esta coficada na funcao de callback
 *
 *6.  Explique com suas palavras como cada nível do framework MVC seria tratado na sua implementa-
 *ção do sistema.
 *	R:Model: sao as classes que processam//organizam os dados mas nao os coletam
 *	do meio externo.
 *	View: seriam as classes do pacote janela, que fazem a comunicacao
 *	com o usuario, coletando e disponibilizando os dados cabiveis
 *	Controller:para este sistema poderia ser tomado como sendo a classe
 *	Main que faz o intermédio entre as classes de View e Model.
 *
 **/

import janelas.JanelaCadastro;


public class Main {
	public static void main(String[] args) {
		JanelaCadastro novaJanela = new JanelaCadastro();
		novaJanela.setVisible(true);
	}
}//class