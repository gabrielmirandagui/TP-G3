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
public class ProductController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/////////////////
	@Inject
	private IproductService pService;
	private IcategoryproductService tService;
	private CategoryProduct t;
	private String mensaje;
	private Product p;
	List<Product> listaProduct;
	List<CategoryProduct> listaCategory;

	////////////////
	@PostConstruct
	public void init() {
		this.p=new Product();
		this.t=new CategoryProduct();
		this.listaProduct = new ArrayList<Product>();
        this.listaCategory = new ArrayList<CategoryProduct>();
        this.setT(new CategoryProduct());
        this.listProduct();
        this.listCategory();
	}
	
	////////////////
	
	public void listProduct() {
		try {
			listaProduct = pService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	 public void listCategory() {
	        try {
	            listaCategory = tService.list();
	        } catch (Exception e) {
	            e.getMessage();
	        }
	    }
	public String newProduct() {
		this.setP(new Product());
		return "product.xhtml";
	}
	
    public void insert() {
    	 mensaje = "No se insertoeliminó";
    	try {
            pService.insert(p);
            cleanProduct();
            this.listProduct();
        } catch (Exception e) {
            e.getMessage();
           
        }
    }
    public void cleanProduct() {
        this.init();
    }
	public void delete(Product pd) {
		try {
			pService.delete(pd.getIdProduct());
			listProduct();
			mensaje = "Se eliminó correctamente";
		} catch (Exception e) {
			e.getMessage();
			mensaje = "No se eliminó";
		}
	}
	
	public void findByName() {
        try {
            if (p.getDescriptionProduct().isEmpty()) {
                this.listProduct();
            } else {	
                listaProduct = this.pService.finByNameProduct(this.getP());
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

	public void modificar() {
        try {
            pService.modificar(this.p);
            cleanProduct();
            this.listProduct();
        } catch (Exception e) {
            e.getMessage();
        }
    }
	
    public String Modifpre(Product pd) {
        this.setP(pd);
        return "productMod.xhtml";
        
    }
	/////////////////////////////

	public IproductService getpService() {
		return pService;
	}

	public void setpService(IproductService pService) {
		this.pService = pService;
	}

	public IcategoryproductService gettService() {
		return tService;
	}

	public void settService(IcategoryproductService tService) {
		this.tService = tService;
	}

	public CategoryProduct getT() {
		return t;
	}

	public void setT(CategoryProduct t) {
		this.t = t;
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

	public List<Product> getListaProduct() {
		return listaProduct;
	}

	public void setListaProduct(List<Product> listaProduct) {
		this.listaProduct = listaProduct;
	}

	public List<CategoryProduct> getListaCategory() {
		return listaCategory;
	}

	public void setListaCategory(List<CategoryProduct> listaCategory) {
		this.listaCategory = listaCategory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
