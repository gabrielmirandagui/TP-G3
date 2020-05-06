package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.CategoryProduct;

public interface IcategoryproductDao {
	public void insert(CategoryProduct category);

	public List<CategoryProduct> list();

	public void delete(int idCategory);

}