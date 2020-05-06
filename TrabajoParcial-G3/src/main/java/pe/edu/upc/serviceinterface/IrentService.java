package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Rent;

public interface IrentService {

	public List<Rent> list();

	public void insert(Rent rent);

	public void modificar(Rent r);

	void delete(int idRent);

}
