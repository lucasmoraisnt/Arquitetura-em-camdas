package model;

public class Cliente {
	private int id;
	private String nome;
	private int idade;
	private String email;
	private ContaBancaria Conta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ContaBancaria getConta() {
		return Conta;
	}
	public void setConta(ContaBancaria conta) {
		Conta = conta;
	}
	
	public Cliente(){
		
	}
	
	public Cliente(int id, String nome, int idade, String email, ContaBancaria conta){
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.Conta = conta;
	}
	
	public void AtualizarEmail(String novoEmail) {
		
	}
	
	public String exibirNomeIdade() {
		return nome+idade;		
	}
	
	public ContaBancaria DadosConta() {
		return Conta;
		
	}
}	

