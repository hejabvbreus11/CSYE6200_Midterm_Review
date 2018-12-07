package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.neu.csye6200.api.AbstractItemAPI;
import edu.neu.csye6200.api.AbstractPersonAPI;
import edu.neu.csye6200.api.AbstractStoreAPI;

public class Store extends AbstractStoreAPI {
	int id;
	String name;
	private List<AbstractPersonAPI> employees;
	private List<AbstractPersonAPI> customers;
	private List<AbstractItemAPI> inventory;
	
	private void init(int id, String name) {
		this.id = id;
		this.name = name;
		this.employees = new ArrayList<>();
		this.customers = new ArrayList<>();
		this.inventory = new ArrayList<>();
	}
	
	public Store() {
		super();
		init(1, "Default Store");
	}

	public Store(int id, String name) {
		super();
		init(id, name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addEmployee(AbstractPersonAPI employee) {
		this.employees.add(employee);
	}

	public void addCustomer(AbstractPersonAPI student) {
		this.customers.add(student);
	}

	public void addItem(AbstractItemAPI item) {
		this.inventory.add(item);
	}
	
	public String getEmployeesInfo() {
		StringBuilder info = new StringBuilder("Employees: ");
		info.append(this.employees.size() + " employees employed.\n");
		for (AbstractPersonAPI employee : employees) {
			info.append(employee.toString() + "\n");
		}
		return info.toString();
	}
	
	public void showEmployees() {
		System.out.println(this.getEmployeesInfo());
	}
	@Override
	public String getInventoryInfo() {
		StringBuilder info = new StringBuilder("Inventory: ");
		info.append(this.inventory.size() + " items in inventory.\n");
		for (AbstractItemAPI item : this.inventory) {
			info.append(item.toString() + "\n");
		}
		return info.toString();
	}
	
	public void clearInventory() {
		this.inventory.clear();
	}
	
	public void sortInventory() {
		this.inventory.sort(null);
	}
	
	public void showInventory() {
		System.out.println(this.getInventoryInfo());
	}
	
	public String getCustomerInfo() {
		StringBuilder info = new StringBuilder("Customers: ");
		info.append(this.customers.size() + " customers enrolled.\n");
		for (AbstractPersonAPI student : this.customers) {
			info.append(student.toString() + "\n");
		}
		return info.toString();
	}
	
	public void showCustomers() {
		System.out.println(this.getCustomerInfo());
	}

	@Override
	public String toString() {
		StringBuilder info = new StringBuilder("[" + this.getId() +"] " + this.getName() + " \n");
		info.append(this.getEmployeesInfo());
		info.append(this.getCustomerInfo());
		info.append(this.getInventoryInfo());
		return info.toString();
	}
	
	@Override
	public void show() {
		System.out.println(toString());
	}

	public static void demo() {
		
	}
}
