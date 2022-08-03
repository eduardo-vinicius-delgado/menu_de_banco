package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int repeticao = 0, escolha;
		double saldo = 0.0, saldoAux, deposito, saque;

		System.out.println("Bem-vindo ao banco UniJava");
		System.out.println("---------------------------");
		System.out.println("No momento não possuimos sistema de senhas, mas prometemos uma conta segura!\n");

		while (repeticao != 5) {
			System.out.println("Escolha uma das opções a seguir: ");
			System.out.println("1 - Saldo \n2 - Depósito \n3 - Saque \n4 - Ver tarifa \n5 - Sair");
			escolha = sc.nextInt();
			switch (escolha) {
			case 1:
				System.out.printf("Saldo = R$ %.2f\n\n", saldo);
				break;
			case 2:
				System.out.printf("\nDigite o valor que deseja depositar: ");
				deposito = sc.nextDouble();
				if (deposito > 0) {
					saldo += deposito;
					System.out.println("Valor depositado!\n");
				} else {
					System.out.println("Não é possível depositar um valor negativo! Entenda sentido de DEPOSITO\n");
					deposito = 0;
				}
				break;
			case 3:
				System.out.printf("\nDigite o valor que deseja sacar: ");
				saque = sc.nextDouble();
				saldoAux=saldo;
				saldo = (saldo-saque>=0)? saldo-saque : saldo;
				if (saldo != saldoAux || saque==0) {
					saldo -= saque;
					System.out.println("Valor sacado!\n");
				} 
				else {
					System.out.println("Não trabalhamos com credito para saldo negativo! Favor consultar o concorrente se ainda o quiser!\n");
				}
				break;
			case 4:
				System.out.println("Tarifa: R$2.00 por consulta!\n");
				saldo -= 2.00;
				break;
			case 5:
				System.out.println("Saindo....");
				System.out.println("Obrigado por usar o UniJava!");
				repeticao = 5;
				break;
			default:
				System.out.println("Opção Invalida! Leia direito as opções!\n");
			}
		}
		sc.close();
	}

}
