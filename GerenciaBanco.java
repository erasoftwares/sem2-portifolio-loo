package com.mycompany.gerenciabanco;

import java.util.Scanner;

/**
 *
 * @author edmar
 */
public class GerenciaBanco {
        public static final String MSG01 = "Saldo atualizado:";
        public static final short VEZES = 80;
	public static void main(String[] args) {

		//Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account;
		int nOpcao = 1;
                
		System.out.print("Seu nome: ");
		String nome = sc.next();
		System.out.print("Seu sobrenome: ");
		String sobrenome = sc.next();
		System.out.print("Infome o CPF:");
		long cpf = sc.nextLong();

		account = new Account(nome, sobrenome, cpf);

		while (nOpcao != 0) {
                        System.out.println("=".repeat(VEZES));
			System.out.println("Consultar saldo [1]");
			System.out.println("Fazer deposito  [2]");
			System.out.println("Efetuar saque   [3]");
			System.out.println("Sair            [0]");
                        System.out.println("=".repeat(VEZES));
			nOpcao = sc.nextInt();

			switch (nOpcao) {
			case 1: {
                            System.out.println(account);
                            break;
			}
			case 2: {
                            System.out.print("Informe o valor de deposito: ");
                            double depositValue = sc.nextDouble();
                            account.deposit(depositValue);
                            System.out.println(account);
                            break;
			}
			case 3: {
                            System.out.println();
                            System.out.print("Entre o valor do saque: ");
                            double withdrawValue = sc.nextDouble();
                            account.withdraw(withdrawValue);
                            System.out.println(account);
                            break;
			}
			case 0: {
                            System.out.println("");
                            System.out.println("<< Operacao finalizada, ate a proxima! >>");
                            System.out.println("");
                            break;
			}
			default:
                            System.out.println("");
                            System.out.println("<< Selecao invalida >>");
                            System.out.println("");
                            break;
			}
		}
		sc.close();
	}  
        
	public static class Account {
		private String nome;
		private String sobrenome;
		private long cpf;
		private double balance;

		public Account(String nome, String sobrenome, long cpf) {
                    this.nome = nome;
                    this.sobrenome = sobrenome;
                    this.cpf = cpf;
		}
		
		public void deposit(double amount) {
                    balance += amount;
		}

                public double getSaldo(){
                    return balance;
                }
		public void withdraw(double amount) {
                    if (getSaldo()< amount) {
                        System.out.println("");
                        System.out.println("<<< Saldo insuficiente! >>>");
                        System.out.println("");
                    } else {
                        balance -= amount;
                    }
		}

		@Override
		public String toString() {
                    return "Cliente : " + sobrenome + ", " + nome + ", Saldo: $ " + String.format("%.2f", getSaldo());
		}
	}        
    
}
