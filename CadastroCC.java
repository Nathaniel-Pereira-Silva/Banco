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
				+" Seu saldo restante � de "+ nf.format(saldo) +".\n"
						+ "Voc� est� usando cheque especial.");
		
		if(saldo == limiteChequeEspecial) {
			System.out.println("Voc� chegou no limite de seu cheque especial.");
		}
	}
	
	public void Saque() {
		
		System.out.println("Quantos voc� deseja sacar?");
		saque = input.nextDouble();
		
		if((saldo-saque) < 0) {//saque maior que o saldo
			
			if(status) {// Retornar true se possuir cheque especial
				
				if(saque <= (saldo + limiteChequeEspecial)) {
					saldo -=  saque;
					RetornoSaldoNegativoPosSaque();
				}else {
					System.out.println("Voc� s� possui um saldo de "+nf.format((saldo + limiteChequeEspecial))+".\n"
							+ "Foi uma tentativa de saque de "+nf.format(saque)+", voc� n�o possui esse saldo.\n"+
							"Seu cheque especial de R$500,00 j� foi usado.");
				}	
				
			}else{ //N�o possui saldo para o saque, n�o possui cheque especial
				System.out.println("Voc� n�o possui saldo para o saque."
						+ "Seu cheque especial n�o est� liberado.");
			}
			
		}else if((saldo-saque) >= 0){// Saldo positivo at� mesmo ap�s o saque
			saldo -=  saque;
			System.out.println("Foi realizado um saque de "+nf.format(saque)+".\n"
					+ "Voc� possui um saldo de "+nf.format(saldo)+".\n"
							+ "Seu cheque especial est� em "+nf.format(limiteChequeEspecial));
		
		}else {//Saque maior que seu saldo e cheque especial
			System.out.println("\n"+"Seu saque de " +nf.format(saque)+ ", � maior que seu saldo "
					+ "e cheque especial.\n"
					+ "Saldo : "+nf.format(saldo)+"\n"
					+ "Cheque especial: "+nf.format(-(limiteChequeEspecial))+"\n"
					+ "Totalizando um saque de "+nf.format((saldo + (-(limiteChequeEspecial)))));
			
		}
				
	}
		
	public void Depositar(){
		//Depoisitar dinheiro
		System.out.println("\n"+"Qual o valor que voc� deseja depositar ? \n");
		deposito = input.nextDouble();
		
		saldo += deposito;
		System.out.println("Seu saldo � de "+nf.format(saldo)+".");
		
	}
	
	public void ConsultarChequeEspecial() {
		//Consultar saldo de cheque especial em tela
		if(status) {
			System.out.println("\n"+"Voc� possui cheque especial.");
		}else {
			System.out.println("\n"+"Voc� possui cheque especial de "+nf.format(limiteChequeEspecial)+".");
		}
		
	}
	
	public void ConsultarSaldo () {
		System.out.println("Seu saldo atual � de "+ nf.format(saldo)+".");
	}

	boolean getCondicaoLop() {
		return condicaoLop;
	}

	public void setCondicaoLop(boolean condicaoLop) {
		CadastroCC.condicaoLop = condicaoLop;
	}
}
