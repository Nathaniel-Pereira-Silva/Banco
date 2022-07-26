package ContaCorrente;
import java.util.Scanner;
import java.text.NumberFormat;

public class CadastroCC {
	static String numero;
	static boolean status = true;
	static boolean condicaoLop = true;
	static double limiteChequeEspecial= 500,saque=0,saldo=1000,deposito;
	
	
	static boolean saqueMaiorQueDinheiroEmContaEMenorQueLimite = saldo <= 0 && (saldo-saque) >= limiteChequeEspecial;
	
	
	
	
	Scanner input = new Scanner(System.in);
	static NumberFormat nf = NumberFormat.getCurrencyInstance();
	

	void RetornoSaldoNegativoPosSaque() {
		  
		System.out.println("\n"+"Foi feito um saque de "+nf.format(saque)+" reais."
				+" Seu saldo restante é de "+ nf.format(saldo) +".\n"
						+ "Você está usando cheque especial.");
		
		if(saldo == limiteChequeEspecial) {
			System.out.println("Você chegou no limite de seu cheque especial.");
		}
	}
	
	public void Saque() {
		
		System.out.println("Quantos você deseja sacar?");
		saque = input.nextDouble();
		
		if((saldo-saque) < 0) {//saque maior que o saldo
			
			if(status) {// Retornar true se possuir cheque especial
				
				if(saque <= (saldo + limiteChequeEspecial)) {
					saldo -=  saque;
					RetornoSaldoNegativoPosSaque();
				}else {
					System.out.println("Você só possui um saldo de "+nf.format((saldo + limiteChequeEspecial))+".\n"
							+ "Foi uma tentativa de saque de "+nf.format(saque)+", você não possui esse saldo.\n"+
							"Seu cheque especial de R$500,00 já foi usado.");
				}	
				
			}else{ //Não possui saldo para o saque, não possui cheque especial
				System.out.println("Você não possui saldo para o saque."
						+ "Seu cheque especial não está liberado.");
			}
			
		}else if((saldo-saque) >= 0){// Saldo positivo até mesmo após o saque
			saldo -=  saque;
			System.out.println("Foi realizado um saque de "+nf.format(saque)+".\n"
					+ "Você possui um saldo de "+nf.format(saldo)+".\n"
							+ "Seu cheque especial está em "+nf.format(limiteChequeEspecial));
		
		}else {//Saque maior que seu saldo e cheque especial
			System.out.println("\n"+"Seu saque de " +nf.format(saque)+ ", é maior que seu saldo "
					+ "e cheque especial.\n"
					+ "Saldo : "+nf.format(saldo)+"\n"
					+ "Cheque especial: "+nf.format(-(limiteChequeEspecial))+"\n"
					+ "Totalizando um saque de "+nf.format((saldo + (-(limiteChequeEspecial)))));
			
		}
				
	}
		
	public void Depositar(){
		//Depoisitar dinheiro
		System.out.println("\n"+"Qual o valor que você deseja depositar ? \n");
		deposito = input.nextDouble();
		
		saldo += deposito;
		System.out.println("Seu saldo é de "+nf.format(saldo)+".");
		
	}
	
	public void ConsultarChequeEspecial() {
		//Consultar saldo de cheque especial em tela
		if(status) {
			System.out.println("\n"+"Você possui cheque especial.");
		}else {
			System.out.println("\n"+"Você possui cheque especial de "+nf.format(limiteChequeEspecial)+".");
		}
		
	}
	
	public void ConsultarSaldo () {
		System.out.println("Seu saldo atual é de "+ nf.format(saldo)+".");
	}

	boolean getCondicaoLop() {
		return condicaoLop;
	}

	public void setCondicaoLop(boolean condicaoLop) {
		CadastroCC.condicaoLop = condicaoLop;
	}
}
