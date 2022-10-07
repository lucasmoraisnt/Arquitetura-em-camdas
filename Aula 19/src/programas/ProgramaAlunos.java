package programas;

import java.sql.Connection;
import model.Alunos;
import service.AlunosService;
import java.util.Scanner;

public class ProgramaAlunos {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		AlunosService as = new AlunosService();
		
		int opcao;
		String nome = null;
		int ra = 0;
		String curso = null;
		int i = 1;
		int excluir;
		int escolha;
		
		System.out.println("Escolha uma das opções abaixo\n\n");
		System.out.printf("1- Cadastrar alunos\n"
				+ "2- Atualizar aluno\n"
				+ "3- Excluir aluno\n"
				+ "4- Listar alunos\n"
				+ "5- Listar um aluno\n\n"
				+ "Digite aqui: ");
		opcao = ler.nextInt();
		
		if(opcao == 1) {
			for(i=1; i<3;i++) {
				System.out.printf("Digite o nome do aluno: ");
				nome = ler.next();
				
				System.out.printf("Digite o ra do aluno: ");
				ra = ler.nextInt();
				
				System.out.printf("Digite o curso do aluno: ");
				curso = ler.next();
				
				Alunos a = new Alunos(i, nome, ra, curso);
				as.InserirAlunos(a);
			}
			
		}else if(opcao == 2) {
			System.out.printf("Digite o id do aluno: ");
			i = ler.nextInt();
			
			Alunos a = new Alunos(i, nome, ra, curso);
			as.InserirAlunos(a);
			
			System.out.printf("Altere o nome: ");
			nome = ler.next();
			
			a.setNome(nome);
			as.AtualizarAlunos(a);
			
		}else if(opcao == 3) {
			System.out.printf("Escolha o id do aluno a ser excluído: ");
			excluir = ler.nextInt();
			
			as.ExcluirAlunos(excluir);
			
		}else if(opcao == 4) {
			as.ListaAlunos();
			
		}else if(opcao == 5) {
			System.out.printf("Digite o ra do aluno: ");
			escolha = ler.nextInt();
			
			as.ListaAlunos(escolha);
		}
	}
}
