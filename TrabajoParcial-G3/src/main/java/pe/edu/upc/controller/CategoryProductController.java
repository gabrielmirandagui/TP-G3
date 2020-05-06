package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.CategoryProduct;
import pe.edu.upc.entity.Product;
import pe.edu.upc.serviceinterface.IcategoryproductService;
import pe.edu.upc.serviceinterface.IproductService;

@Named
@RequestScoped
public class CategoryProductController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IcategoryproductService cService;
	@Inject
	private IproductService pService;
	
	private String mensaje;
	private Product p;
	private CategoryProduct c;
	List<CategoryProduct> listaCategory;
	List<Product> listaProduct;

	// constructor
	@PostConstruct
	public void init() {
		this.listaCategory = new ArrayList<CategoryProduct>();
		this.listaProduct = new ArrayList<Product>();
		this.c = new CategoryProduct();
		this.p=new Product();
		this.listCategory();
		this.listProduct();
	}

	// Metodos
	public String newCategory() {
		this.setC(new CategoryProduct());
		return "type.xhtml";
	}

	public void insert() {
		try {
			pService.insert(p);
			cleanProductCategory();
			this.listProduct();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listCategory() {
		try {
			listaCategory = cService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listProduct() {
		try {
			listaProduct = pService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public void cleanProductCategory() {
		this.init();
	}

	public void delete(CategoryProduct ti) {
		try {
			pService.delete(ti.getIdCategory());
			listProduct();
			mensaje = "se eliminó correctamente";
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se eliminó";

		}
	}
//////////////////////////////
	public IcategoryproductService getcService() {
		return cService;
	}

	public void setcService(IcategoryproductService cService) {
		this.cService = cService;
	}

	public IproductService getpService() {
		return pService;
	}

	public void setpService(IproductService pService) {
		this.pService = pService;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public CategoryProduct getC() {
		return c;
	}

	public void setC(CategoryProduct c) {
		this.c = c;
	}

	public List<CategoryProduct> getListaCategory() {
		return listaCategory;
	}

	public void setListaCategory(List<CategoryProduct> listaCategory) {
		this.listaCategory = listaCategory;
	}

	public List<Product> getListaProduct() {
		return listaProduct;
	}

	public void setListaProduct(List<Product> listaProduct) {
		this.listaProduct = listaProduct;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}