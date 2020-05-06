package pe.edu.upc.entity;

import java.sql.Date;

public class Rent {

	private int idRent;
	private int amountRent;
	private Date startdateRent;
	private  Date enddateRent;
	private int quantityRent;
	
	public int getIdRent() {
		return idRent;
	}
	public void setIdRent(int idRent) {
		this.idRent = idRent;
	}
	public int getAmountRent() {
		return amountRent;
	}
	public void setAmountRent(int amountRent) {
		this.amountRent = amountRent;
	}
	public Date getStartdateRent() {
		return startdateRent;
	}
	public void setStartdateRent(Date startdateRent) {
		this.startdateRent = startdateRent;
	}
	public Date getEnddateRent() {
		return enddateRent;
	}
	public void setEnddateRent(Date enddateRent) {
		this.enddateRent = enddateRent;
	}
	public int getQuantityRent() {
		return quantityRent;
	}
	public void setQuantityRent(int quantityRent) {
		this.quantityRent = quantityRent;
	}
	
}
