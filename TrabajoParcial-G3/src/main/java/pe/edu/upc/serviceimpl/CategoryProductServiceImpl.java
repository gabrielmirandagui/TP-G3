package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IcategoryproductDao;
import pe.edu.upc.entity.CategoryProduct;
import pe.edu.upc.serviceinterface.IcategoryproductService;

@Named
@RequestScoped
public class CategoryProductServiceImpl implements Serializable, IcategoryproductService {

	private static final long serialVersionUID = 1L;
	@Inject
	private IcategoryproductDao cDao;

	@Override
	public List<CategoryProduct> list() {
		// TODO Auto-generated method stub
		return cDao.list();
	}

	@Override
	public void delete(int idCategory) {
		cDao.delete(idCategory);
	}

	@Override
	public void insert(CategoryProduct Category) {
		cDao.insert(Category);
		
	}

}