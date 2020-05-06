package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IcategoryproductDao;
import pe.edu.upc.entity.CategoryProduct;

public class CategoryProductDaoImpl implements Serializable, IcategoryproductDao {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "TrabajoParcial-G3")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(CategoryProduct category) {
		try {
			em.persist(category);
		} catch (Exception e) {
			System.out.println("Error al insertar tipo");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryProduct> list() {
		List<CategoryProduct> lista = new ArrayList<CategoryProduct>();
		try {
			Query q = em.createQuery("from CategoryProduct c");
			lista = (List<CategoryProduct>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar categoria");
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int idCategory) {
		CategoryProduct ca = new CategoryProduct();
		try {
			ca = em.getReference(CategoryProduct.class, idCategory);
			em.remove(ca);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}