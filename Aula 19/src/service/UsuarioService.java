package service;

import java.sql.ResultSet;
import dao.Dao;
import model.Usuario;

public class UsuarioService {
	public static void InserirUsuario(Usuario u) {
		
			String query = String.format("insert into t_usuario (id,nome)values(%s,'%s')", u.getId(), u.getNome());
			
			Dao.InsertUpdateDeleteCommand(query);
		}
	
		public static void AtualizarUsuario(Usuario u) {
			
			String query = String.format("update t_usuario set nome = '%s'where id = %s", u.getNome(), u.getId());
			
			Dao.InsertUpdateDeleteCommand(query);
		}
		
		public static void ExcluirUsuario(int id) {
			
			String query = String.format("delete from t_usuario where id =%s", id);
			
			Dao.InsertUpdateDeleteCommand(query);
		}
		
		public static void ExibirUsuarios() {
			
			String query= "select * from t_usuario";
			
			ResultSet rs = Dao.SelectCommand(query);
		
			try {
				while(rs.next()){	
					System.out.print(rs.getString("id")+" ");
					System.out.println(rs.getString("nome"));
				}
			}
			
			catch (Exception e){
				System.out.println(e);
				}
			}
		
		public static void ExibirUsuario(int id) {
			
			String query = String.format("select * from t_usuario where id= %s", id);
			
			ResultSet rs = Dao.SelectCommand(query);
		
			try {
				while(rs.next()){
					System.out.print(rs.getString("id")+" ");
					System.out.println(rs.getString("nome"));
				}
			}
			
			catch (Exception e){
				System.out.println(e);
			}
		}
	}
