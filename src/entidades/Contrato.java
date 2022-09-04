package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

	private Integer number;
	private Date date;
	private Double totalValue;
	
	private List<Parcela> parcelas = new ArrayList<>();
	
	public Contrato(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void addParcela(Parcela parcela) {
		parcelas.add(parcela);
	}

	public void removeParcela(Parcela parcela) {
		parcelas.remove(parcela);
	}
}