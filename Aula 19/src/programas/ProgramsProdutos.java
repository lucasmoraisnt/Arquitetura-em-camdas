package programas;

import java.sql.Connection;
import model.Produtos;
import service.ProdutosService;
import java.util.Scanner;

public class ProgramsProdutos {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ProdutosService ps = new ProdutosService();
		
		int opcao;
		String nome = null;
		double preco = 0;
		int qtd = 0;
		int i = 1;
		int excluir;
		int escolha;
		
		System.out.println("Escolha uma das opções abaixo\n\n");
		System.out.printf("1- Cadastrar produtos\n"
				+ "2- Atualizar produto\n"
				+ "3- Excluir produto\n"
				+ "4- Listar produtos\n"
				+ "5- Listar um produto\n\n"
				+ "Digite aqui: ");
		opcao = ler.nextInt();
	
		if(opcao == 1) {
			for(i=1; i<3; i++) {
				System.out.printf("Digite o nome do produto: ");
				nome = ler.next();
				
				System.out.printf("Digite o preço do produto: ");
				preco = ler.nextDouble();
				
				System.out.printf("Digite a quantidade em estoque: ");
				qtd = ler.nextInt();
				
				Produtos a = new Produtos(i, nome, preco, qtd);
				ps.InserirProduto(a);
			}
			
		}else if(opcao == 2) {
			System.out.printf("Digite o id do produto que você pretende alterar: ");
			i = ler.nextInt();
			
			Produtos a = new Produtos(i, nome, preco, qtd);
			ps.InserirProduto(a);
			
			System.out.printf("Digite o novo valor do produto: ");
			preco = ler.nextDouble();
			
			a.setPreco(preco);
			ps.AtualizarProduto(a);
			
		}else if(opcao == 3) {
			System.out.printf("Escolha o id a ser excluído: ");
			excluir = ler.nextInt();
			
			ps.ExcluirProdutos(excluir);
			
		}else if(opcao == 4) {
			ps.ListaProdutos();
			
		}else if(opcao == 5) {
			System.out.printf("Digite o id do produto: ");
			escolha = ler.nextInt();
			
			ps.ListaProdutos(escolha);
		}
		
	}
}
