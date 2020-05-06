package pe.edu.upc.daointerface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Customer;

public interface IcustomerDao {
	Integer insert(Customer customer) throws Exception;

	Integer update(Customer customer) throws Exception;

	Integer delete(Customer customer) throws Exception;

	List<Customer> findAll() throws Exception;

	Optional<Customer> findById(Customer customer) throws Exception;

	List<Customer> findByName(String name) throws Exception;

	Optional<Customer> findByDni(String dni) throws Exception;
}