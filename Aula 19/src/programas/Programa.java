package programas;

import model.Usuario;
import service.UsuarioService;


public class Programa {

	public static void main(String[] args) {
		Usuario a = new Usuario(10, "Joseffe B. Oliveira");
		
		UsuarioService.InserirUsuario(a);
		a.setNome("Joseffe Macgyver!");
		
		UsuarioService.AtualizarUsuario(a);
		
		UsuarioService.ExcluirUsuario(7);
		
		UsuarioService.ExcluirUsuario(8);
		
		UsuarioService.ExibirUsuarios();
		
		UsuarioService.ExibirUsuario(9);
		}
}
