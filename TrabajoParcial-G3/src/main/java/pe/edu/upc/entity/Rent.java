package pe.edu.upc.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Alquiler")
public class Rent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRent;

	private int amountRent;
	private Date startdateRent;
	private Date enddateRent;
	private Date registerdateRent;
	private Product productRent;
	private int quantityRent;
	private Voucher vou;
	

	//////////////////
	public Rent(int idRent, int amountRent, Date startdateRent, Date enddateRent, Date registerdateRent,
			int quantityRent, Voucher vou) {
		super();
		this.idRent = idRent;
		this.amountRent = amountRent;
		this.startdateRent = startdateRent;
		this.enddateRent = enddateRent;
		this.registerdateRent = registerdateRent;
		this.quantityRent = quantityRent;
		this.vou = vou;
	}
	
	public Rent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//////////////////////



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

	public Date getRegisterdateRent() {
		return registerdateRent;
	}

	public void setRegisterdateRent(Date registerdateRent) {
		this.registerdateRent = registerdateRent;
	}

	public int getQuantityRent() {
		return quantityRent;
	}

	public void setQuantityRent(int quantityRent) {
		this.quantityRent = quantityRent;
	}

	public Voucher getVou() {
		return vou;
	}

	public void setVou(Voucher vou) {
		this.vou = vou;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product getProductRent() {
		return productRent;
	}

	public void setProductRent(Product productRent) {
		this.productRent = productRent;
	}

}
