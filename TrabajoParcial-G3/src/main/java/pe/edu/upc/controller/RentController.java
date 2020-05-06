package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Rent;
import pe.edu.upc.serviceinterface.IrentService;

@Named
@RequestScoped
public class RentController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IrentService rService;
	
	private String mensaje;
	
	private Rent r;
	List<Rent> listaRent;
	///////////////////
	
	@PostConstruct
	public void init() {
		this.listaRent = new ArrayList<Rent>();
		this.r=new Rent();
		
		this.listRenta();
	}

	public void modificar() {
		try {
			rService.modificar(this.r);
			cleanRent();
			this.listRenta();

		} catch (Exception e) {
			e.getMessage();
		}
	}
	public String Modifpre(Rent ia) {
		this.setR(ia);
		return "rentMod.xhtml";
		
	}

	public String newRent() {
		this.setR(new Rent());
		return "rent.xhtml";
	}
	
	public void insert() {
		try {
			rService.insert(r);
			cleanRent();
			this.listRenta();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listRenta() {
		try {
			listaRent = rService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void cleanRent() {
		this.init();
	}
	/////////////////
	
	
	public IrentService getrService() {
		return rService;
	}
	public void setrService(IrentService rService) {
		this.rService = rService;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Rent getR() {
		return r;
	}
	public void setR(Rent r) {
		this.r = r;
	}
	public List<Rent> getListaRent() {
		return listaRent;
	}
	public void setListaRent(List<Rent> listaRent) {
		this.listaRent = listaRent;
	}

}
