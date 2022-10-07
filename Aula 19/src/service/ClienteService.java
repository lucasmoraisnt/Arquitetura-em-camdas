package service;

import java.sql.ResultSet;
import dao.Dao;
import model.Cliente;
import model.ContaBancaria;

public class ClienteService {
	
	public void InserirCliente(Cliente u) {
		String query = String.format("insert into t_cliente (id,nome,idade,email)values(%s,'%s','%s','%s')", u.getId(), u.getNome(), u.getIdade(), u.getEmail());
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	public void InserirConta(ContaBancaria c, Cliente u) {
		String query = String.format("insert into t_conta_banca (id,agencia,numero,saldo)values(%s,'%s','%s','%2f')", u.getId(), c.getAgencia(), c.getNumero(), c.getSaldo());
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void AtualizarCliente(Cliente u) {
		String query = String.format("update t_cliente set email = '%s' where id = %s", u.getEmail(), u.getId());
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	public void AtualizarConta(ContaBancaria c, Cliente u) {
		String query = String.format("update t_conta_banca set agencia = '%s' where id = %s", c.getAgencia(), u.getId());
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void ExcluirCliente(int id) {
		String query = String.format("delete from t_cliente where id = %s", id);
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	public void ExcluirConta(int id) {
		String query = String.format("delete from t_conta_banca where id = %s", id);
		
		Dao.InsertUpdateDeleteCommand(query);
	}
	
	public void ListarCliente() {
		String query = "select * from t_cliente";
		String queryC = "select * from t_conta_banca";
		
		ResultSet rs = Dao.SelectCommand(query);
		ResultSet rsc = Dao.SelectCommand(queryC);
		
		try {
			while(rs.next()) {
				System.out.print(rs.getString("id")+" ");
				System.out.printf(rs.getString("nome")+" \n");
				System.out.printf(rs.getString("idade")+" anos\n");
				System.out.printf(rs.getString("email")+" \n\n");
			}
			while(rsc.next()) {
				System.out.print(rsc.getString("id")+" \n");
				System.out.printf(rsc.getString("agencia")+" \n");
				System.out.printf(rsc.getString("numero")+" \n");
				System.out.printf(rsc.getString("saldo")+" \n\n");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	public void ListarCliente(int id) {
		String query = String.format("select * from t_cliente where id = %s", id);
		
		ResultSet rs = Dao.SelectCommand(query);
		
		try {
			while(rs.next()) {
				System.out.print(rs.getString("id")+" ");
				System.out.printf(rs.getString("nome")+" ");
				System.out.printf(rs.getString("idade")+" ");
				System.out.printf(rs.getString("email")+" ");
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		String queryC = String.format("select * from t_conta_banca where id = %s", id);
		
		ResultSet rsc = Dao.SelectCommand(queryC);

		try {
			while(rsc.next()) {
				System.out.printf(rsc.getString("agencia")+" ");
				System.out.printf(rsc.getString("numero")+" ");
				System.out.printf(rsc.getString("saldo")+" ");
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
