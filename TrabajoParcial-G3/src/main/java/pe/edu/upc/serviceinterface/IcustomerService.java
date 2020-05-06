package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Customer;

public interface IcustomerService {
	Integer insert(Customer customer) throws Exception;

	Integer update(Customer customer) throws Exception;

	Integer delete(Customer customer) throws Exception;

	List<Customer> getAll() throws Exception;

	Optional<Customer> getOne(Customer customer) throws Exception;

	List<Customer> findCustomerByName(String name) throws Exception;

	Optional<Customer> findCustomerByDni(String dni) throws Exception;

}