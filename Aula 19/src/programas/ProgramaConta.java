package programas;

import java.sql.Connection;
import model.Cliente;
import model.ContaBancaria;
import service.ClienteService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramaConta {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		int i, opcao = 0, idade = 0, id=0, excluir, escolha, cadas;
		String nome = null, email = null, agencia, numero, conf;
		double saldo;
		
		System.out.printf("===> Sistema de Cadastro de Clientes <===\n\n");
        System.out.printf("Escolha uma opcao:\n");
        System.out.printf(	"1 - Cadastrar cliente \n" 
        					+ "2 - Atualizar Cliente \n"
        					+ "3- Excluir Cliente \n"
        					+ "4- Listar Cliente \n"
        					+ "5- Listar Cliente \n");
        try {
        	System.out.printf("Digite a opcao desejada: ");
            opcao = ler.nextInt();
        }catch(InputMismatchException e) {
        	System.out.println("ERRO! Digite um n�mero desejado!");
        }
        
		ContaBancaria cb = new ContaBancaria();
		ClienteService cs = new ClienteService();
		
		if(opcao == 1) {
			for(i=1; i<5;i++) {
				Cliente c = new Cliente();
				
				c.setId(i);
				
				System.out.printf("Digite o nome do cliente: ");
				nome = ler.next();
				c.setNome(nome);
				
				System.out.printf("Digite sua idade: ");
				idade = ler.nextInt();
				c.setIdade(idade);
				
				System.out.printf("Digite seu email: ");
				email = ler.next();
				c.setEmail(email);
				
				cs.InserirCliente(c);
				
				System.out.printf("Voce tem uma conta bancaria? S/N");
				conf = ler.next().toUpperCase();
				
				if(conf.equals("S")) {
					
					System.out.printf("Digite a agencia do seu banco: ");
					agencia = ler.next();
					cb.setAgencia(agencia);
					
					System.out.printf("Digite o n�mero da sua conta: ");
					numero = ler.next();
					cb.setNumero(numero);
					
					System.out.printf("Digite o saldo da sua conta: ");
					saldo = ler.nextDouble();
					cb.setSaldo(saldo);
					
					cs.InserirConta(cb, c);
				}else if(conf.equals("n")){
					System.out.println("Programa fechado");
				}
			}
		}else if(opcao == 2) {
			System.out.printf("Digite o id do cliente: ");
			id = ler.nextInt();
			
			Cliente c = new Cliente(id, nome, idade, email, cb);
				
			System.out.printf("Digite o novo email: ");
			email = ler.next();
				
			c.setEmail(email);
			cs.AtualizarCliente(c);
				
			System.out.printf("Deseja atualizar a agencia do seu banco? S/N");
			conf = ler.next().toUpperCase();
				
			if (conf.equals("S")) {
				System.out.printf("Digite sua nova agencia: ");
				agencia = ler.next();
				
				cb.setAgencia(agencia);
				cs.AtualizarConta(cb, c);
				
			}else {
				System.out.println("Programa fechado");
			}
			
		}else if(opcao == 3) {
			System.out.printf("Digite o id do cliente a ser exclu�do: ");
			excluir = ler.nextInt();
			
			cs.ExcluirConta(excluir);
			cs.ExcluirCliente(excluir);
			
		}else if(opcao == 4) {
			cs.ListarCliente();
			
		}else if(opcao == 5) {
			System.out.printf("Digite o id do cliente: ");
			escolha = ler.nextInt();
			
			cs.ListarCliente(escolha);
		}
	}
}
