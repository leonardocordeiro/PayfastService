package br.com.caelum.payfast.modelo;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Payment {
	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
