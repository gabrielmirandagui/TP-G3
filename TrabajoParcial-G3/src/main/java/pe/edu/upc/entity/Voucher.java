package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Voucher")
public class Voucher implements Serializable{
	//Esta sera mi clave unica
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVoucher;
	
	
	private Date dateVoucher;
	
	//uno a muchos con ID Person
	@ManyToOne
	@JoinColumn(name = "idPerson", nullable = false)
	private Person idPerson;
	
	//uno a muchos con ID IdTypepay
	@ManyToOne
	@JoinColumn(name = "idTypepay", nullable = false)
	private TypePay Ctypepay;
	
	
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