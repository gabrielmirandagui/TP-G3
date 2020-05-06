package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.CategoryProduct;

public interface IcategoryproductService {
	public void insert(CategoryProduct Category);

	public List<CategoryProduct> list();

	public void delete(int idCategory);
}