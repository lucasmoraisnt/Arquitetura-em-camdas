package model;

public class Alunos {
	private int id;
	private String nome;
	private int ra;
	private String curso;
	
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
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	Alunos(){
		
	}
	
	public Alunos(int id, String nome, int ra, String curso){
		this.id = id;
		this.nome = nome;
		this.ra = ra;
		this.curso = curso;
	}
}
