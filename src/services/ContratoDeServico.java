package services;

import java.util.Calendar;
import java.util.Date;

import entidades.Contrato;
import entidades.Parcela;

public class ContratoDeServico {

	private ServicoDePagamentoOnline servicoDePagamentoOnline;
	
	public ContratoDeServico(ServicoDePagamentoOnline servicoDePagamentoOnline) {
		this.servicoDePagamentoOnline = servicoDePagamentoOnline;
	}
	
	public void processContract(Contrato contrato, int months) {
		double basicQuota = contrato.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contrato.getDate(), i);
            double updatedQuota = basicQuota + servicoDePagamentoOnline.interest(basicQuota, i);
            double fullQuota =  updatedQuota + servicoDePagamentoOnline.paymentFee(updatedQuota);
            contrato.addParcela(new Parcela(date, fullQuota));
        }
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}