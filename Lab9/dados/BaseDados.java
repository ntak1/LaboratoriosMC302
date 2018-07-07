package dados;

import usuario.Usuario;

public class BaseDados {
	//Base de dados visivel em todas as outras classes
	public static Usuario usuarios[] = new Usuario[50];
	public static int indexUsuario = 0;
	public static Usuario usuarioAtual;
	

}
