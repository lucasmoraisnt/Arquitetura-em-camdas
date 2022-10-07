package service;

import java.sql.ResultSet;
import dao.Dao;
import model.Produtos;

public class ProdutosService {
	public void InserirProduto(Produtos u) {
		String query = String.format("insert into t_produtos (id,nome,preco,qtd)values(%s,'%s','%2f','%s')", u.getId(), u.getNome(), u.getPreco(), u.getQtd());
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void AtualizarProduto(Produtos u) {
		String query = String.format("update t_produtos set preco = '%2f' where id = %s", u.getPreco(), u.getId());
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void ExcluirProdutos(int id) {
		String query = String.format("delete from t_produtos where id = %s", id);
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void ListaProdutos() {
		String query = "select * from t_produtos";
		
		ResultSet rs = Dao.SelectCommand(query);
		
		try {
			while(rs.next()) {
				System.out.print(rs.getString("id")+" ");
				System.out.printf(rs.getString("nome")+" ");
				System.out.printf(rs.getString("preco")+" ");
				System.out.printf(rs.getString("qtd")+" ");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void ListaProdutos(int id) {
		String query = String.format("select * from t_produtos where id = '%s'", id);
		
		ResultSet rs = Dao.SelectCommand(query);
		
		try {
			while(rs.next()) {
				System.out.print(rs.getString("id")+" ");
				System.out.printf(rs.getString("nome")+" ");
				System.out.printf(rs.getString("preco")+" ");
				System.out.printf(rs.getString("qtd")+" ");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
