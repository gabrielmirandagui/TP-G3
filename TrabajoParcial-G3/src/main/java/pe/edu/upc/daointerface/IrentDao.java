package pe.edu.upc.daointerface;

import java.util.List;

import pe.edu.upc.entity.Rent;

public interface IrentDao {

	public List<Rent> list();

	public void insert(Rent rent);

	public void delete(int idRent);

	public void modificar(Rent r);

}
