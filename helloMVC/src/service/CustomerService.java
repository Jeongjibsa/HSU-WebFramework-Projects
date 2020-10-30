package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Customer;

public class CustomerService {
	private Map<String, Customer> customerMap;

	public CustomerService() {
		customerMap = new HashMap<String, Customer>();

		addCustomer(new Customer("jisung", "1234"));

	}

	private void addCustomer(Customer customer) {
		customerMap.put(customer.getId(), customer);

	}

	public Customer findCustomer(String id) {
		if (id != null)
			return (customerMap.get(id.toLowerCase()));
		else
			return null;

	}
	
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<Customer>(customerMap.values());
		
		return customerList;
	}
}
