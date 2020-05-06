package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IproductDao;
import pe.edu.upc.entity.Product;

public class ProductDaoImpl implements IproductDao, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "TrabajoParcial-G3")
	private EntityManager em;

	@Transactional
	@Override
	public void delete(int idProduct) {
		Product ia = new Product();
		try {
			ia = em.getReference(Product.class, idProduct);
			em.remove(ia);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Transactional
	public void insert(Product product) {
		try {
			em.persist(product);
		} catch (Exception e) {
			System.out.println("Error insert DAOImpl");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> list() {
		List<Product> lista = new ArrayList<Product>();
		try {
			Query q = em.createQuery("select i from Producto i");
			lista = (List<Product>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar DAOImpl");
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> finByNameProduct(Product pd) {
		List<Product> lista = new ArrayList<Product>();
		try {
			Query q = em.createQuery("from Product i where i.descriptionProduct like ?1");
			q.setParameter(1, "%" + pd.getDescriptionProduct() + "%");
			lista = (List<Product>) q.getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void modificar(Product pd) {
		try {
			em.merge(pd);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}