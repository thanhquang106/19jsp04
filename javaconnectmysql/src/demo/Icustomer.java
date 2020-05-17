package demo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import demo.customer;

public class Icustomer {
	public List<customer> ShowCustomer(Statement st) throws SQLException;
	public void addCustomer(customer customer, Statement st) throws SQLException;
	public void updateCustomer(customer customer,Statement st) throws SQLException;
	public void deleteCustomer(String NAME,Statement st) throws SQLException;
	public List<customer> findCustomerByName(String NAME,Statement st ) throws SQLException;

}
