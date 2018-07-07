package janelas;
import usuario.Usuario;
import dados.BaseDados;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class JanelaCadastro extends JFrame {
	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JTextField txtLoginUsuario;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastro frame = new JanelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaCadastro() {
		setTitle("CaronasMC302: Naomi Takemoto. RA: 184849");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblB = new JLabel("Bem Vind@! Faça o seu casastro no sistema!");
		lblB.setBounds(85, 32, 263, 15);
		panel.add(lblB);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setToolTipText("Digite seu nome completo!");
		txtNomeUsuario.setBounds(234, 76, 114, 19);
		panel.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setBounds(234, 116, 114, 19);
		panel.add(txtLoginUsuario);
		txtLoginUsuario.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(95, 78, 55, 15);
		panel.add(lblNome);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(95, 118, 55, 15);
		panel.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(95, 156, 55, 15);
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setDropMode(DropMode.INSERT);
		passwordField.setToolTipText("Digite sua senha!");
		passwordField.setBounds(234, 154, 114, 19);
		panel.add(passwordField);
		
		JButton btnCriarUsuario = new JButton("Criar Usuario");
		btnCriarUsuario.setBounds(234, 199, 114, 25);
		panel.add(btnCriarUsuario);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, panel, lblB}));
		btnCriarUsuario.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				//Le informacao dos text fields
				String nome = txtNomeUsuario.getText();
				String login = txtLoginUsuario.getText();
				String senha = new String (passwordField.getPassword());
				
				//Cria novo objeto do tipo usuario e adiciona na base de dados
				Usuario usuario = new Usuario(nome, login, senha, true);
				BaseDados.usuarios[BaseDados.indexUsuario] = usuario;
				BaseDados.usuarioAtual = usuario;
				BaseDados.indexUsuario += 1;
				
				JanelaPerfil janela = new JanelaPerfil();
				janela.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
	}
}
