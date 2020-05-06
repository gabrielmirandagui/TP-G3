package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Voucher;
import pe.edu.upc.serviceinterface.IvoucherService;

@Named
@RequestScoped
public class VoucherController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IvoucherService vService;

	private String mensaje;

	private Voucher v;

	List<Voucher> listaVoucher;

	@PostConstruct
	public void init() {
		this.listaVoucher = new ArrayList<Voucher>();

		this.v = new Voucher();

		this.listVoucher();
	}

	public String newVoucher() {
		this.setV(new Voucher());
		return "voucher.xhtml";
	}

	// esto limpia
	public void cleanVoucher() {
		this.init();
	}

	public void insert() {
		try {
			vService.insert(v);
			cleanVoucher();
			this.listVoucher();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void listVoucher() {
		// TODO Auto-generated method stub
		try {
			listaVoucher = vService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public IvoucherService getvService() {
		return vService;
	}

	public void setvService(IvoucherService vService) {
		this.vService = vService;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Voucher getV() {
		return v;
	}

	public void setV(Voucher v) {
		this.v = v;
	}

	public List<Voucher> getListaVoucher() {
		return listaVoucher;
	}

	public void setListaVoucher(List<Voucher> listaVoucher) {
		this.listaVoucher = listaVoucher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
