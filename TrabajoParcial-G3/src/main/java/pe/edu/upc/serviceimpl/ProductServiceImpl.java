package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import pe.edu.upc.daointerface.IproductDao;
import pe.edu.upc.entity.Product;
import pe.edu.upc.serviceinterface.IproductService;

public class ProductServiceImpl implements IproductService, Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private IproductDao pD;
	@Override
	public void delete(int idProduct) {
		pD.delete(idProduct);		
	}

	@Override
	public List<Product> list() {	
		return pD.list();
	}

	@Override
	public void insert(Product pd) {
		 try {
	            pD.insert(pd);
	        } catch (Exception e) {
	            System.out.println("Error en el service al insertar un producto");
	        }		
	}

	@Override
	public void modificar(Product pd) {
		pD.modificar(pd);        
		
	}

	@Override
	public List<Product> finByNameProduct(Product pd) {
		 return pD.finByNameProduct(pd);
	}
	

}
