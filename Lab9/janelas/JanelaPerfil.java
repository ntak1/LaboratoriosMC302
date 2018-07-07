/*Nome: Naomi Takemoto RA: 184849
 *Laboratorio 09
 **/

package janelas;
import grupo.Grupo;
import grupo.GrupoPrivado;
import grupo.GrupoPublico;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;

import javax.swing.JOptionPane;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;

import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;


import caronante.Caronante;
import caroneiro.Caroneiro;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import dados.BaseDados;
import exception.SistemaCaronaExcecao;

import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

import perfil.Perfil;

import usuario.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPerfil extends JFrame {
	//contentPane (base)
	private JPanel contentPane;    
	//JTextFields
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtDataNascimento;
	private JTextField txtLatitudeEncontro;
	private JTextField txtLatitudeDestino;
	private JTextField txtLongitudeEncontro;
	private JTextField txtLongitudeDestino;
	private JTextField txtHoradiaEncontro;
	private JTextField txtValor;
	private JTextField txtTempoHabilitacao;
	private JTextField txtGeneroMusicalFavorito;
	private JTextField txtPlacaVeiculo;
	private JTextField txtCarteiraMotorista;
	private JTextField txtMarcaVeiculo;
	private JTextField txtModeloVeiculo;
	private JTextField txtGenero;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtTelefone;
	private JPasswordField passwordField;
	private JTextField txtDescricaoGrupo;
	private JTextField txtNomeGrupo;
	private JTextField txtCartaoCredito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPerfil frame = new JanelaPerfil();
					frame.setVisible(true);
					//frame.setSize(600, 650);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o frame (construtor)
	 */
	public JanelaPerfil() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Adiciona o JTabbedPane para das efeito de abas
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 0, 583, 672);
		contentPane.add(tabbedPane);
		
		//Cria os Jpanels para cada uma das abas a serem exibidas
		JPanel jPanelUsuarioPerfil = new javax.swing.JPanel();
		JPanel jPanelPerfilCaroneiro = new javax.swing.JPanel();       
		JPanel jPanelPerfilCaronante = new javax.swing.JPanel();
		final JPanel jPanelGrupos = new javax.swing.JPanel();
		JPanel jPanelOferecerCarona = new javax.swing.JPanel();
		
		
		/******************************************************************
		 * Aba de Informacoes gerais:
		 *Dados basicos do Usuario e Perfil, permite edicao das informacoes
		 ******************************************************************
		 **/
		//Nome
		tabbedPane.add("Informacoes gerais", jPanelUsuarioPerfil);
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(12, 27, 55, 15);
		txtNome = new JTextField(BaseDados.usuarioAtual.getNome());
		txtNome.setBounds(98, 25, 145, 19);
		txtNome.setColumns(10);
		
		//Email
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(12, 54, 55, 15);
		txtEmail = new JTextField(BaseDados.usuarioAtual.getEmail());
		txtEmail.setBounds(98, 56, 145, 19);
		txtEmail.setColumns(10);
		
		//Genero
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(12, 81, 55, 19);
		
		//Cidade
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(12, 112, 55, 15);
		
		//Estado
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(12, 150, 55, 15);
		
		//Telefone
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(12, 177, 55, 15);
		
		//Data de Nascimento
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(261, 27, 126, 15);
		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(390, 25, 114, 19);
		txtDataNascimento.setColumns(10);
		
		//Fumante
		JLabel lblNewLabel = new JLabel("Fumante");
		lblNewLabel.setBounds(274, 83, 55, 15);
		final JRadioButton rdbtnSim = new JRadioButton("sim");
		rdbtnSim.setBounds(390, 79, 55, 23);
		final JRadioButton rdbtnNao = new JRadioButton("nao");
		rdbtnNao.setBounds(449, 79, 55, 23);
		
		
		//Lista as caronas ja oferecidas pelo usuario

		DefaultListModel <String>  listaStrCaronasOferecidas= new DefaultListModel<String>();
		if(BaseDados.usuarioAtual.getPerfil() != null && BaseDados.usuarioAtual.getPerfil().getCaronante() != null){
			for(int i = 0; i < BaseDados.usuarioAtual.getPerfil().getCaronante().getCaronas().size(); i++){
				listaStrCaronasOferecidas.addElement("" + BaseDados.usuarioAtual.getPerfil().getCaronante().getCaronas().get(i).getCarona());
			} 
		}else{
			listaStrCaronasOferecidas.addElement("Nenhuma carona oferecida ate o momento!");
		}
		JList listCaronasOferecidas = new JList( listaStrCaronasOferecidas);
		listCaronasOferecidas.setBounds(47, 245, 488, 161);

		
		//Adiciona os componentes no Panel
		jPanelUsuarioPerfil.setLayout(null);
		jPanelUsuarioPerfil.add(lblNome_1);
		jPanelUsuarioPerfil.add(txtNome);
		jPanelUsuarioPerfil.add(lblEmail);
		jPanelUsuarioPerfil.add(txtEmail);
		jPanelUsuarioPerfil.add(lblGenero);
		jPanelUsuarioPerfil.add(lblCidade);
		jPanelUsuarioPerfil.add(lblEstado);
		jPanelUsuarioPerfil.add(lblTelefone);
		jPanelUsuarioPerfil.add(lblDataDeNascimento);
		jPanelUsuarioPerfil.add(txtDataNascimento);
		jPanelUsuarioPerfil.add(lblNewLabel);
		jPanelUsuarioPerfil.add(rdbtnSim);
		jPanelUsuarioPerfil.add(rdbtnNao);
		jPanelUsuarioPerfil.add(listCaronasOferecidas);
		
		
		//Labels
		JLabel lblCaronasOferecidas = new JLabel("Caronas oferecidas");
		lblCaronasOferecidas.setBounds(12, 218, 114, 15);
		jPanelUsuarioPerfil.add(lblCaronasOferecidas);
		
		JLabel lblCaronasPedidas = new JLabel("Caronas Pedidas");
		lblCaronasPedidas.setBounds(12, 415, 108, 15);
		jPanelUsuarioPerfil.add(lblCaronasPedidas);
		
		//Lista de caronas oferecidas
		JList listCaronasPedidas = new JList();
		listCaronasPedidas.setBounds(42, 442, 493, 173);
		jPanelUsuarioPerfil.add(listCaronasPedidas);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(98, 81, 145, 19);
		jPanelUsuarioPerfil.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(98, 110, 145, 19);
		jPanelUsuarioPerfil.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(98, 148, 145, 19);
		jPanelUsuarioPerfil.add(txtEstado);
		txtEstado.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(98, 175, 145, 19);
		jPanelUsuarioPerfil.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JButton btnEditarInformaoesGerais = new JButton("Editar informaçoes");
		btnEditarInformaoesGerais.setBounds(390, 189, 145, 25);
		jPanelUsuarioPerfil.add(btnEditarInformaoesGerais);
		btnEditarInformaoesGerais.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//Le infomacao dos text fields
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				char genero = txtGenero.getText().charAt(0);
				String cidade = txtCidade.getText();
				String estado = txtEstado.getText();
				String telefone = txtTelefone.getText();
				String dataNascimento = txtDataNascimento.getText();
				String cartao = txtCartaoCredito.getText();
				
				boolean fumante = false;
				if(rdbtnSim.isSelected()){
					fumante = true;
				}
				
				//Cria um perfil para o usuario, caso ele não tenha um
				BaseDados.usuarioAtual.setNome(nome);
				BaseDados.usuarioAtual.setEmail(email);
				if(BaseDados.usuarioAtual.getPerfil() == null){
					Perfil perfil = new Perfil(genero, dataNascimento, cidade, estado, telefone, fumante, BaseDados.usuarioAtual);
					BaseDados.usuarioAtual.setPerfil(perfil);
				}else{
					Perfil perfil = BaseDados.usuarioAtual.getPerfil();
					perfil.setSexo(genero);
					perfil.setCidade(cidade);
					perfil.setEstado(estado);
					perfil.setFumante(fumante);
					perfil.setTelefone(telefone);
					perfil.setUsuario(BaseDados.usuarioAtual);
					if(cartao != null && perfil.getCaroneiro() == null){
						Caroneiro caroneiro = new Caroneiro();
						caroneiro.setCartaoDeCredito(cartao);
						caroneiro.setPerfil(perfil);
						perfil.setCaroneiro(caroneiro);
					}else if(cartao != null){
						perfil.getCaroneiro().setCartaoDeCredito(cartao);
					}
				}
				
				JOptionPane.showMessageDialog(null,"Edicao completada com sucesso", "Confirmacao",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(274, 112, 55, 15);
		jPanelUsuarioPerfil.add(lblNewLabel_3);
		
		passwordField = new JPasswordField(BaseDados.usuarioAtual.getSenha());
		passwordField.setBounds(390, 110, 114, 19);
		jPanelUsuarioPerfil.add(passwordField);
		
		JLabel lblCartaoDeCredito = new JLabel("cartao de credito");
		lblCartaoDeCredito.setBounds(274, 150, 97, 15);
		jPanelUsuarioPerfil.add(lblCartaoDeCredito);
		
		txtCartaoCredito = new JTextField();
		txtCartaoCredito.setBounds(390, 148, 114, 19);
		jPanelUsuarioPerfil.add(txtCartaoCredito);
		txtCartaoCredito.setColumns(10);
	
		
		/****************************************************************************************
		 * Aba: Informacoes do Perfil Caronante
		 * Descricao: lista todas as propriedaddes do caronante, que podem ser visualizadas e/ou
		 * editadas caso necessario.
		 * *************************************************************************************
		 * */
		JLabel lblNewLabel_1 = new JLabel("Informacoes caronante");
		tabbedPane.add("Informacoes caronante", jPanelPerfilCaronante);
		jPanelPerfilCaronante.setLayout(null);
		
		JLabel lblTempoDeHabilitacao = new JLabel("Tempo de habilitacao");
		lblTempoDeHabilitacao.setBounds(24, 28, 121, 29);
		jPanelPerfilCaronante.add(lblTempoDeHabilitacao);
		
		JLabel lblGeneroMusicalFavorito = new JLabel("Genero Musical Favorito");
		lblGeneroMusicalFavorito.setBounds(24, 69, 150, 15);
		jPanelPerfilCaronante.add(lblGeneroMusicalFavorito);
		
		JLabel lblPlacaVeiculo = new JLabel("Placa Veiculo");
		lblPlacaVeiculo.setBounds(24, 107, 137, 15);
		jPanelPerfilCaronante.add(lblPlacaVeiculo);
		
		JLabel lblNewLabel_2 = new JLabel("Carteira Motorista");
		lblNewLabel_2.setBounds(24, 149, 150, 15);
		jPanelPerfilCaronante.add(lblNewLabel_2);
		
		JLabel lblMarcaDoVeiculo = new JLabel("Marca do Veiculo");
		lblMarcaDoVeiculo.setBounds(24, 190, 137, 15);
		jPanelPerfilCaronante.add(lblMarcaDoVeiculo);
		
		JLabel lblModeloDoVeiculo = new JLabel("Modelo do Veiculo");
		lblModeloDoVeiculo.setBounds(24, 229, 121, 15);
		jPanelPerfilCaronante.add(lblModeloDoVeiculo);
		
		txtTempoHabilitacao = new JTextField();
		txtTempoHabilitacao.setBounds(279, 33, 114, 19);
		jPanelPerfilCaronante.add(txtTempoHabilitacao);
		txtTempoHabilitacao.setColumns(10);
		
		txtGeneroMusicalFavorito = new JTextField();
		txtGeneroMusicalFavorito.setBounds(279, 67, 114, 19);
		jPanelPerfilCaronante.add(txtGeneroMusicalFavorito);
		txtGeneroMusicalFavorito.setColumns(10);
		
		txtPlacaVeiculo = new JTextField();
		txtPlacaVeiculo.setBounds(279, 105, 114, 19);
		jPanelPerfilCaronante.add(txtPlacaVeiculo);
		txtPlacaVeiculo.setColumns(10);
		
		txtCarteiraMotorista = new JTextField();
		txtCarteiraMotorista.setBounds(279, 147, 114, 19);
		jPanelPerfilCaronante.add(txtCarteiraMotorista);
		txtCarteiraMotorista.setColumns(10);
		
		txtMarcaVeiculo = new JTextField();
		txtMarcaVeiculo.setBounds(279, 188, 114, 19);
		jPanelPerfilCaronante.add(txtMarcaVeiculo);
		txtMarcaVeiculo.setColumns(10);
		
		txtModeloVeiculo = new JTextField();
		txtModeloVeiculo.setBounds(279, 227, 114, 19);
		jPanelPerfilCaronante.add(txtModeloVeiculo);
		txtModeloVeiculo.setColumns(10);
		
		//Editar informacaoes do usuario/caroneiro/caronante
		JButton btnEditarInformacoes = new JButton("Editar Informacoes");
		btnEditarInformacoes.setBounds(355, 305, 160, 25);
		jPanelPerfilCaronante.add(btnEditarInformacoes);
		 btnEditarInformacoes.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0){
				//le os campos de texto
				int tempo = Integer.parseInt(txtTempoHabilitacao.getSelectedText());
				String generoMusicalFavorito = txtGeneroMusicalFavorito.getText();
				String placaVeiculo = txtPlacaVeiculo.getText();
				String carteiraMotorista = txtCarteiraMotorista.getText();
				String marcaVeiculo = txtMarcaVeiculo.getText();
				String modeloVeiculo = txtModeloVeiculo.getText();
				
				//cria um perfil de caronante se nao existe
				if(BaseDados.usuarioAtual.getPerfil() == null){
					BaseDados.usuarioAtual.setPerfil(new Perfil());
				}
				if(BaseDados.usuarioAtual.getPerfil().getCaronante() == null){
					BaseDados.usuarioAtual.getPerfil().setCaronante(new Caronante(tempo, generoMusicalFavorito,
							placaVeiculo, carteiraMotorista, marcaVeiculo, modeloVeiculo,BaseDados.usuarioAtual.getPerfil()));

				}else{
					Caronante caronante = BaseDados.usuarioAtual.getPerfil().getCaronante();
					caronante.setCarteiraMotorista(carteiraMotorista);
					caronante.setGeneroMusicalFavorito(generoMusicalFavorito);
					caronante.setMarcaVeiculo(marcaVeiculo);
					caronante.setModeloVeiculo(modeloVeiculo);
					caronante.setPlacaVeiculo(placaVeiculo);
					caronante.setTempoHabilitacao(tempo);
				}
				//faz o relacionamento
				/*
				 * 
				 * Em construcao ....
				 * 
				 * */
			}
		 });

		
		/**************************************************************************************
		 * Aba grupos:
		 * O usuario pode visualizar a lista de grupos em que participa e
		 * caso deseje pode criar um novo grupo
		 * ************************************************************************************
		 * */
		tabbedPane.add("Grupos", jPanelGrupos);//aba Grupos
		jPanelGrupos.setLayout(null);
		
		JLabel lblListaDeGrupos = new JLabel("Lista de grupos");
		lblListaDeGrupos.setBounds(40, 72, 140, 15);
		jPanelGrupos.add(lblListaDeGrupos);
		
		//Exibe a lista de grupos que o usuario participa
		JLabel lblSelecioneEEntre = DefaultComponentFactory.getInstance().createTitle("Estes são os grupos dos quais participa:");
		lblSelecioneEEntre.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblSelecioneEEntre.setBounds(92, 23, 386, 31);
		jPanelGrupos.add(lblSelecioneEEntre);
		
		//Jlist que exibira os grupos em que o usuario participa
		DefaultListModel <String>  listaStrGrupos = new DefaultListModel<String>();
		if(BaseDados.usuarioAtual.getGrupos()!= null){
			for(int i = 0; i < BaseDados.usuarioAtual.getGrupos().size(); i++){
				listaStrGrupos.addElement("Nome: " + BaseDados.usuarioAtual.getGrupos().get(i).getGrupo().getNome());
			} 
		}else if (BaseDados.usuarioAtual.getGrupos() == null || BaseDados.usuarioAtual.getGrupos().size() == 0){
			listaStrGrupos.addElement("Nenhum Grupo no momento!");
			System.out.println("Nenhum Grupo no momento!");
		}
		
		JList<String> listGrupos = new JList<String>(listaStrGrupos);
		listGrupos.setLayoutOrientation(JList.VERTICAL);
		listGrupos.setBounds(40, 114, 499, 149);
		jPanelGrupos.add(listGrupos);
		
		//O usuario pode selecionar um grupo, caso aperte o botao sair do grupo, este devera
		//ser excluido da lista de grupos e o usuario em questao deve ser excluido da lista de
		//usuarios do grupo.
		JButton btnSairGrupo = new JButton("Sair do grupo selecionado");
		btnSairGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSairGrupo.setBounds(314, 282, 236, 25);
		jPanelGrupos.add(btnSairGrupo);
		
		
		//Criando um novo Grupo
		JLabel lblCrieOSeu = new JLabel("Crie o seu proprio Grupo Publico ou privado !");
		lblCrieOSeu.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblCrieOSeu.setBounds(92, 329, 365, 25);
		jPanelGrupos.add(lblCrieOSeu);
		
		JLabel lblNomeDoGrupo = new JLabel("Nome do Grupo");
		lblNomeDoGrupo.setBounds(40, 392, 104, 15);
		jPanelGrupos.add(lblNomeDoGrupo);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(40, 455, 76, 15);
		jPanelGrupos.add(lblDescricao);
		
		txtDescricaoGrupo = new JTextField();
		txtDescricaoGrupo.setBounds(144, 453, 395, 67);
		jPanelGrupos.add(txtDescricaoGrupo);
		txtDescricaoGrupo.setColumns(10);
		
		txtNomeGrupo = new JTextField();
		txtNomeGrupo.setBounds(144, 390, 395, 19);
		jPanelGrupos.add(txtNomeGrupo);
		txtNomeGrupo.setColumns(10);
		
		JButton btnCriar = new JButton("Criar ");
		btnCriar.setBounds(441, 551, 98, 25);
		jPanelGrupos.add(btnCriar);
		
		final JRadioButton rdbtnPublico = new JRadioButton("Publico");
		rdbtnPublico.setBounds(144, 552, 121, 23);
		jPanelGrupos.add(rdbtnPublico);
		
		final JRadioButton rdbtnPrivado = new JRadioButton("Privado");
		rdbtnPrivado.setBounds(282, 552, 121, 23);
		jPanelGrupos.add(rdbtnPrivado);
		
		//Tratando o botao criarGrupo
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				//le os campos nome e descricao
				String nome = txtNomeGrupo.getText();
				String descricao = txtDescricaoGrupo.getText();
				if(nome != null && descricao != null){
					//Cria um novo objeto do tipo grupo
					Grupo grupo;
					if(rdbtnPublico.isSelected()){
						grupo = new GrupoPublico(nome, descricao);
						try{
							BaseDados.usuarioAtual.adicionarGrupo((GrupoPublico)grupo);
						}catch(SistemaCaronaExcecao ex){
							ex.printStackTrace();
						}
					}else if(rdbtnPrivado.isSelected()){
						grupo = new GrupoPrivado(BaseDados.usuarioAtual, nome, descricao);
						try{
							BaseDados.usuarioAtual.adicionanrUsuarioAUmGrupo(BaseDados.usuarioAtual, (GrupoPrivado)grupo);
						}catch(Exception ex){
							ex.printStackTrace();
						}
					}else{
						return;
					}
					JOptionPane.showMessageDialog(null, "Grupo Criado com Sucesso!");					
				}
			}
		});
		
		
		
		/************************************************************************************************
		 * Aba: oferecer carona
		 * Descricao: um usuario Caronante pode oferecer uma carona e publica-la num grupo a que pertence
		 * **********************************************************************************************
		 * */
		
		tabbedPane.add("Oferecer Carona", jPanelOferecerCarona);
		jPanelOferecerCarona.setLayout(null);
		
		txtLatitudeEncontro = new JTextField();
		txtLatitudeEncontro.setBounds(73, 70, 114, 19);
		jPanelOferecerCarona.add(txtLatitudeEncontro);
		txtLatitudeEncontro.setColumns(10);
		
		JLabel lblLatitude = new JLabel("Latitude e Longitude de Encontro");
		lblLatitude.setBounds(36, 43, 212, 15);
		jPanelOferecerCarona.add(lblLatitude);
		
		JLabel lblLatitudeELogitude = new JLabel("Latitude e Logitude do Destino");
		lblLatitudeELogitude.setBounds(36, 106, 190, 15);
		jPanelOferecerCarona.add(lblLatitudeELogitude);
		
		txtLatitudeDestino = new JTextField();
		txtLatitudeDestino.setBounds(73, 133, 114, 19);
		jPanelOferecerCarona.add(txtLatitudeDestino);
		txtLatitudeDestino.setColumns(10);
		
		txtLongitudeEncontro = new JTextField();
		txtLongitudeEncontro.setBounds(284, 70, 114, 19);
		jPanelOferecerCarona.add(txtLongitudeEncontro);
		txtLongitudeEncontro.setColumns(10);
		
		txtLongitudeDestino = new JTextField();
		txtLongitudeDestino.setBounds(284, 133, 114, 19);
		jPanelOferecerCarona.add(txtLongitudeDestino);
		txtLongitudeDestino.setColumns(10);
		
		JLabel lblHoraEDia = new JLabel("Hora e Dia do Encontro");
		lblHoraEDia.setBounds(36, 178, 137, 15);
		jPanelOferecerCarona.add(lblHoraEDia);
		
		txtHoradiaEncontro = new JTextField();
		txtHoradiaEncontro.setBounds(73, 205, 114, 19);
		jPanelOferecerCarona.add(txtHoradiaEncontro);
		txtHoradiaEncontro.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(36, 255, 55, 15);
		jPanelOferecerCarona.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(73, 282, 114, 19);
		jPanelOferecerCarona.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnCriarNovaCarona = new JButton("Criar Nova Carona");
		btnCriarNovaCarona.setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
		btnCriarNovaCarona.setForeground(Color.DARK_GRAY);
		btnCriarNovaCarona.setBounds(368, 346, 137, 25);
		jPanelOferecerCarona.add(btnCriarNovaCarona);
		
		JLabel lblOcupacaoMaxima = new JLabel("Ocupacao Maxima");
		lblOcupacaoMaxima.setBounds(289, 178, 120, 15);
		jPanelOferecerCarona.add(lblOcupacaoMaxima);
		
		JMenu mnVagas = new JMenu("Vagas");
		mnVagas.setBounds(284, 205, 81, 19);
		jPanelOferecerCarona.add(mnVagas);
		
		JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("1");
		mnVagas.add(radioButtonMenuItem);
		
		JRadioButtonMenuItem radioButtonMenuItem_1 = new JRadioButtonMenuItem("2");
		mnVagas.add(radioButtonMenuItem_1);
		
		JRadioButtonMenuItem radioButtonMenuItem_2 = new JRadioButtonMenuItem("3");
		mnVagas.add(radioButtonMenuItem_2);
		
		JRadioButtonMenuItem radioButtonMenuItem_3 = new JRadioButtonMenuItem("4");
		mnVagas.add(radioButtonMenuItem_3);
		
		JRadioButtonMenuItem radioButtonMenuItem_4 = new JRadioButtonMenuItem("5");
		mnVagas.add(radioButtonMenuItem_4);
		
		JRadioButtonMenuItem radioButtonMenuItem_5 = new JRadioButtonMenuItem("6");
		mnVagas.add(radioButtonMenuItem_5);
		
		JRadioButtonMenuItem radioButtonMenuItem_6 = new JRadioButtonMenuItem("7");
		mnVagas.add(radioButtonMenuItem_6);
		
		JRadioButtonMenuItem radioButtonMenuItem_7 = new JRadioButtonMenuItem("8");
		mnVagas.add(radioButtonMenuItem_7);
		
	}
}
