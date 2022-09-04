package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Parcela;
import services.ContratoDeServico;
import services.PaypalService;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite dados de contrato:");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contrato contrato = new Contrato(number, date, totalValue);
		
		System.out.print("Digite o número de parcelas: ");
		int n = sc.nextInt();
		
		ContratoDeServico contratoDeServico = new ContratoDeServico(new PaypalService());
		
		contratoDeServico.processContract(contrato, n);
		
		System.out.println("Parcelas:");
		for (Parcela x : contrato.getParcelas()) {
			System.out.println(x);
		}
		
		sc.close();
	}
}