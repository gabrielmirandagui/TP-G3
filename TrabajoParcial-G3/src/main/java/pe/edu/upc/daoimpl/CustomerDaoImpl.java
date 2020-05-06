package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import pe.edu.upc.daointerface.IcustomerDao;
import pe.edu.upc.entity.Customer;

@Named
public class CustomerDaoImpl implements IcustomerDao, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "TrabajoParcial-G3")
	private EntityManager em;

	public Integer insert(Customer t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	public Integer update(Customer t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	public Integer delete(Customer t) throws Exception {
		em.remove(t);
		return 1;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAll() throws Exception {
		List<Customer> customers = new ArrayList<Customer>();

		Query q = em.createQuery("SELECT c FROM Customer c");
		customers = (List<Customer>) q.getResultList();
		return customers;
	}

	@SuppressWarnings("unchecked")
	public Optional<Customer> findById(Customer t) throws Exception {

		Customer customerFound = new Customer();

		List<Customer> customers = new ArrayList<Customer>();
		Query q = em.createQuery("FROM Customer c where c.id = ?1");
		q.setParameter(1, t.getId());

		customers = (List<Customer>) q.getResultList();

		if (customers != null && !customers.isEmpty()) {
			customerFound = customers.get(0);
		}

		return Optional.of(customerFound);

	}

	public List<Customer> findByName(String name) throws Exception {
		return em.createQuery("from Customer where name like :name", Customer.class)
				.setParameter("name", "%" + name + "%").getResultList();
	}

	public Optional<Customer> findByDni(String dni) throws Exception {
		Customer customer;
		TypedQuery<Customer> customerExist = em.createQuery("Select c from Customer c  where c.dni =:dni",
				Customer.class);
		customerExist.setParameter("dni", dni);
		customer = customerExist.getSingleResult();

		return Optional.of(customer);
	}

}