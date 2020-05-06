package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IrentDao;
import pe.edu.upc.entity.Rent;

public class RentDaoImpl implements IrentDao, Serializable{


	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "TrabajoParcial-G3")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Rent rent) {
		try {
			em.persist(rent);
		} catch (Exception e) {
			System.out.println("Error insert DAOImpl");
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rent> list() {
		List<Rent> lista = new ArrayList<Rent>();
		try {
			Query q = em.createQuery("select i from Alquiler i");
			lista = (List<Rent>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar DAOImpl");
		}
		return lista;
	}

	@Override
	public void delete(int idRent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Rent r) {
		// TODO Auto-generated method stub
		
	}

}
