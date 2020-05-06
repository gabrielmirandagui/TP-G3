package pe.edu.upc.daoimpl;

//Implemto todoooo
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.daointerface.IvoucherDao;
import pe.edu.upc.entity.Voucher;

public class VoucherDaoImpl implements IvoucherDao, Serializable {

	private static final long serialVersionUID = 1L;

	//Cual es el nombre del proyecto
	@PersistenceContext(unitName = "TrabajoParcial-G3")
	private EntityManager em; //El em ayuda a trabajar en la BD
	
	@Transactional
	@Override
	public void insert(Voucher i) {
		try {
			em.persist(i);
		} catch (Exception e) {

			System.out.println("Error en DAO insert librosImpl");
		}
	}

	//Suprimir errores
	@SuppressWarnings("unchecked")
	
	@Override
	//lista el voucher
	public List<Voucher> list() {
		List<Voucher> lista = new ArrayList<Voucher>();
		try {
			Query q = em.createQuery("from Voucher i");
			lista = (List<Voucher>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error en DAO list libroImpl");
		}
		return lista;
	}
}
