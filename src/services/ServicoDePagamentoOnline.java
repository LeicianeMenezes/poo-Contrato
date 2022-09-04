package services;

public interface ServicoDePagamentoOnline {

	double paymentFee(double amount);
	double interest(double amount, int months);
}