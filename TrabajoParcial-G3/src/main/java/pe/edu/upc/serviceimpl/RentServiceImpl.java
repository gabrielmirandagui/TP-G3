package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.daointerface.IrentDao;
import pe.edu.upc.entity.Rent;
import pe.edu.upc.serviceinterface.IrentService;

@Named
@RequestScoped
public class RentServiceImpl implements IrentService, Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private IrentDao rD;
	
	
	@Override
	public List<Rent> list() {
		return rD.list();
	}

	@Override
	public void insert(Rent rent) {
		try {
			rD.insert(rent);
		} catch (Exception e) {
			System.out.println("Error en el service al registrar una reserva");
		}
		
	}
	@Override
	public void delete(int idRent) {
		rD.delete(idRent);
		
	}
	@Override
	public void modificar(Rent r) {
		// TODO Auto-generated method stub
		rD.modificar(r);
	}
	
}
