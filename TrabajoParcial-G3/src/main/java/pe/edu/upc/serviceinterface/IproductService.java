package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Product;

public interface IproductService {
	public void delete(int idProduct);
	public List<Product> list();
	public void insert(Product p);
	public void modificar(Product p);
	public List<Product> finByNameProduct(Product p);
}
