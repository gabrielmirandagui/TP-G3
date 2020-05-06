package pe.edu.upc.entity;

import java.sql.Date;

public class Voucher {
	private int idVoucher;
	private Date dateVoucher;
	public int getIdVoucher() {
		return idVoucher;
	}
	public void setIdVoucher(int idVoucher) {
		this.idVoucher = idVoucher;
	}
	public Date getDateVoucher() {
		return dateVoucher;
	}
	public void setDateVoucher(Date dateVoucher) {
		this.dateVoucher = dateVoucher;
	}

	
}
