package ContaCorrente;

import java.util.Scanner;

public class Menu {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		CadastroCC cc = new CadastroCC();
		
		boolean condicaoLop = cc.getCondicaoLop();
		String op;
		 
		
		
		while(condicaoLop) {
			try {
				System.out.println("\n"+"Entre com a opção desejada: \n"
						+ "1_Saque \n"
						+ "2_Depoisitar \n"
						+ "3_Saldo em tela \n"
						+ "4_Verificar cheque especial \n"
						+ "5_sair ");
				op = input.nextLine();
				
				switch (op) {
				 case "1": {
					cc.Saque();
					break;
				}case "2": {
					cc.Depositar();
					break;
				}case"3": {
					cc.ConsultarSaldo();
					break;
				}case "4": {
					cc.ConsultarChequeEspecial();
					break;
				}case "5": {
					System.out.println("\nObrigado por usar o programa");
					condicaoLop = false;
					break;
				}
				default:
					System.out.println("\n"+"Entre com um número válido.\n ");
				}
				
				
				
				
			}catch (Exception e) {
				System.out.println("Dado incorreto.");
			}
			
			
		}
		
		
		
		input.close();
	}
	
}
