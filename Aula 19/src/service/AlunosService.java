package service;

import java.sql.ResultSet;
import dao.Dao;
import model.Alunos;

public class AlunosService {
	
	public void InserirAlunos(Alunos u) {
		String query = String.format("insert into t_alunos (id,nome,ra,curso)values(%s,'%s', '%s', '%s')", u.getId(), u.getNome(), u.getRa(), u.getCurso());
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void AtualizarAlunos(Alunos u) {
		String query = String.format("update t_alunos set nome = '%s' where id = %s", u.getNome(), u.getId());
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void ExcluirAlunos(int id) {
		String query = String.format("delete from t_alunos where id = %s", id);
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void ListaAlunos() {
		String query = "select * from t_alunos";
		
		ResultSet rs = Dao.SelectCommand(query);
		
		try {
			while(rs.next()) {
				System.out.print(rs.getString("id")+" ");
				System.out.printf(rs.getString("nome")+" ");
				System.out.printf(rs.getString("ra")+" ");
				System.out.printf(rs.getString("curso")+" ");
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void ListaAlunos(int ra) {
		String query = String.format("select * from t_alunos where ra = %s", ra);
		
		ResultSet rs = Dao.SelectCommand(query);
		
		try {
			while(rs.next()) {
				System.out.print(rs.getString("id")+" ");
				System.out.printf(rs.getString("nome")+" ");
				System.out.printf(rs.getString("ra")+" ");
				System.out.printf(rs.getString("curso")+" ");
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
