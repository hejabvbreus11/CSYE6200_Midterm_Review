package edu.neu.csye6200;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import edu.neu.csye6200.api.AbstractItemAPI;
import edu.neu.csye6200.api.AbstractItemFactoryAPI;
import edu.neu.csye6200.api.AbstractPersonAPI;
import edu.neu.csye6200.patterns.BreadFactory;
import edu.neu.csye6200.patterns.ElectronicsFactory;
import edu.neu.csye6200.patterns.LiteBreadFactory;

public class Walmart extends Store {

	public Walmart() {
		super();
	}

	public Walmart(int id, String name) {
		super(id, name);
	}
	
	public void toXML() {
		try {
			toXML(this);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void toXML(Walmart walmart) throws JAXBException {
		System.out.println("Marshalling to XML: \n" + this);
		JAXBContext jaxbContext = JAXBContext.newInstance(Item.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(walmart, new File("walmart.xml"));
		marshaller.marshal(walmart, System.out);
	}
	
	public void fromXML() {
		try {
			fromXML("walmart.xml");
		} catch (FileNotFoundException | JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void fromXML(String fileName) throws JAXBException, FileNotFoundException {
		System.out.println("Unmarshalling '" +  fileName + "'");
		Item item = null;
		File file = new File(fileName);
		JAXBContext jaxbContext = JAXBContext.newInstance(Item.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		item = (Item) unmarshaller.unmarshal(file);
		System.out.println(item);
	}
	

	public static void demoNoFactory() {
		System.out.println("\n\t" + Walmart.class.getName() + ".demo() starting...");
		
		/**
		 * Walmart store controlling object
		 */
		Store walmart = new Walmart(77, "Walmart");

		/**
		 * Instantiate the Employee objects
		 */
		Employee e1 = new Employee(1, "Jim", "Peterson", 27, 14.25);
		Employee e2 = new Employee(1, "Janet", "Crane", 26, 13.55);
		List<AbstractPersonAPI> newEmployees = new ArrayList<>();
		newEmployees.add(e1);
		newEmployees.add(e2);

		/**
		 * Instantiate the Item objects
		 */
		AbstractItemAPI frenchBaguette = new Bread(2, "French Baguette", 1.69);
		AbstractItemAPI bagel = new Bread(3, "Bagel", .69);
		AbstractItemAPI pretzel = new Bread(4, "pretzel", .69);
		AbstractItemAPI saraLeeDelight = new Bread(5, "Sara Lee Delight", 1.49);
		List<AbstractItemAPI> newProducts = new ArrayList<>();
		newProducts.add(frenchBaguette);
		newProducts.add(bagel);
		newProducts.add(pretzel);
		newProducts.add(saraLeeDelight);

		/**
		 * Instantiate the Customer objects
		 */
		AbstractPersonAPI s1 = new Customer(1, "Dan", "Peters", 17, 84.600);
		AbstractPersonAPI s2 = new Customer(2, "Jane", "Seymore", 16, 38.2);
		List<AbstractPersonAPI> newCustomers = new ArrayList<>();
		newCustomers.add(s1);
		newCustomers.add(s2);
		
		/**
		 * Add Employees to Walmart store
		 */
		System.out.println("hiring " + newEmployees.size() + " new employees.");
		for (AbstractPersonAPI p : newEmployees) {
			walmart.addEmployee(p);
		}
		
		/**
		 * Add Products to Walmart store inventory
		 */
		System.out.println("adding " + newProducts.size() + " new products.");
		for (AbstractItemAPI p : newProducts) {
			walmart.addItem(p);
		}
		
		/**
		 * Add Customers to Walmart store rewards program
		 */
		System.out.println("adding " + newCustomers.size() + " new customers.");
		for (AbstractPersonAPI p : newCustomers) {
			walmart.addCustomer(p);
		}
		
		/**
		 * Show the state of Walmart store
		 */
		walmart.show();
		
		/**
		 * Sort Walmart store inventory by Item name
		 */
		System.out.println("Sort inventory by item name.");
		walmart.sortInventory();
		walmart.showInventory();
		

		/**
		 * Change inventory, to Health Bread Item objects
		 */
		walmart.clearInventory();
		newProducts.clear();
		
		AbstractItemAPI frenchBaguetteLite = new LiteBread(2, "French Baguette Lite", 1.69, 170.0);
		AbstractItemAPI bagelLite = new LiteBread(3, "Bagel Lite", .69, 240.0);
		AbstractItemAPI pretzelLite = new LiteBread(4, "pretzel Lite", .69, 149.0);
		AbstractItemAPI saraLeeDelightLite = new LiteBread(5, "Sara Lee Delight Lite", 1.49, 49.0);
		newProducts.add(frenchBaguetteLite);
		newProducts.add(bagelLite);
		newProducts.add(pretzelLite);
		newProducts.add(saraLeeDelightLite);
		System.out.println("adding " + newProducts.size() + " new products.");
		for (AbstractItemAPI p : newProducts) {
			walmart.addItem(p);
		}
		System.out.println("Sort inventory by item calories.");
		walmart.sortInventory();
		walmart.showInventory();

		
		System.out.println("\n" + walmart.getClass().getName() + ".demo() done!");
	}

	public static void demo() {
		System.out.println("\n\t" + Walmart.class.getName() + ".demo() starting...");
		
		{
			/**
			 * Walmart store controlling object
			 */
			Store walmart = new Walmart(77, "Walmart");

			/**
			 * Instantiate the Employee objects
			 */
			Employee e1 = new Employee(1, "Jim", "Peterson", 27, 14.25);
			Employee e2 = new Employee(1, "Janet", "Crane", 26, 13.55);
			List<AbstractPersonAPI> newEmployees = new ArrayList<>();
			newEmployees.add(e1);
			newEmployees.add(e2);

			/**
			 * Instantiate the Item objects
			 */
			AbstractItemAPI frenchBaguette = new Bread(2, "French Baguette", 1.69);
			AbstractItemAPI bagel = new Bread(3, "Bagel", .69);
			AbstractItemAPI pretzel = new Bread(4, "pretzel", .69);
			AbstractItemAPI saraLeeDelight = new Bread(5, "Sara Lee Delight", 1.49);
			List<AbstractItemAPI> newProducts = new ArrayList<>();
			newProducts.add(frenchBaguette);
			newProducts.add(bagel);
			newProducts.add(pretzel);
			newProducts.add(saraLeeDelight);

			/**
			 * Instantiate the Customer objects
			 */
			AbstractPersonAPI s1 = new Customer(1, "Dan", "Peters", 17, 84.600);
			AbstractPersonAPI s2 = new Customer(2, "Jane", "Seymore", 16, 38.2);
			List<AbstractPersonAPI> newCustomers = new ArrayList<>();
			newCustomers.add(s1);
			newCustomers.add(s2);
			
			/**
			 * Add Employees to Walmart store
			 */
			System.out.println("hiring " + newEmployees.size() + " new employees.");
			for (AbstractPersonAPI p : newEmployees) {
				walmart.addEmployee(p);
			}
			
			/**
			 * Add Products to Walmart store inventory
			 */
			System.out.println("adding " + newProducts.size() + " new products.");
			for (AbstractItemAPI p : newProducts) {
				walmart.addItem(p);
			}
			
			/**
			 * Add Customers to Walmart store rewards program
			 */
			System.out.println("Enrolling " + newCustomers.size() + " new students.");
			for (AbstractPersonAPI p : newCustomers) {
				walmart.addCustomer(p);
			}
			
			/**
			 * Show the state of Walmart store
			 */
			walmart.show();
			
			/**
			 * Sort Walmart store inventory by Item name
			 */
			System.out.println("Sort inventory by item name.");
			walmart.sortInventory();
			walmart.showInventory();
			

			/**
			 * Change inventory, to Health Bread Item objects
			 */
			walmart.clearInventory();
			newProducts.clear();
			
			AbstractItemAPI frenchBaguetteLite = new LiteBread(2, "French Baguette Lite", 1.69, 170.0);
			AbstractItemAPI bagelLite = new LiteBread(3, "Bagel Lite", .69, 240.0);
			AbstractItemAPI pretzelLite = new LiteBread(4, "pretzel Lite", .69, 149.0);
			AbstractItemAPI saraLeeDelightLite = new LiteBread(5, "Sara Lee Delight Lite", 1.49, 49.0);
			newProducts.add(frenchBaguetteLite);
			newProducts.add(bagelLite);
			newProducts.add(pretzelLite);
			newProducts.add(saraLeeDelightLite);
			System.out.println("adding " + newProducts.size() + " new products.");
			for (AbstractItemAPI p : newProducts) {
				walmart.addItem(p);
			}
			System.out.println("Sort inventory by item calories.");
			walmart.sortInventory();
			walmart.showInventory();
		}
		{
			/**
			 * Walmart store controlling object
			 */
			Store walmart = new Walmart(77, "Walmart");
			/**
			 * Instantiate the Item Factory
			 * and the Item objects
			 */
			AbstractItemFactoryAPI factory = new BreadFactory();
			List<AbstractItemAPI> newProducts = new ArrayList<>();
			newProducts.add(factory.getObject(2, "French Baguette", 1.69));
			newProducts.add(factory.getObject(3, "Bagel", .69));
			newProducts.add(factory.getObject(4, "pretzel Lite", .89));
			newProducts.add(factory.getObject(5, "Sara Lee Delight", 1.49));
			System.out.println("adding " + newProducts.size() + " new products.");
			for (AbstractItemAPI p : newProducts) {
				walmart.addItem(p);
			}
			System.out.println("Sort inventory by item Item number.");
			walmart.sortInventory();
			walmart.showInventory();
		}
		{
			/**
			 * Walmart store controlling object
			 */
			Store walmart = new Walmart(77, "Walmart");
			/**
			 * Instantiate the Item Factory
			 * and the Item objects
			 */
			AbstractItemFactoryAPI factory = new LiteBreadFactory();
			List<AbstractItemAPI> newProducts = new ArrayList<>();
			newProducts.add(factory.getObject(Arrays.asList("1","French Baguette Lite","1.69","270.0")));
			newProducts.add(factory.getObject(Arrays.asList("2","Bagel Lite","1.29","170.0")));
			newProducts.add(factory.getObject(Arrays.asList("3","pretzel Lite",".89","149.0")));
			newProducts.add(factory.getObject(Arrays.asList("4","Sara Lee Delight Lite","1.49","49.0")));
			System.out.println("adding " + newProducts.size() + " new products.");
			for (AbstractItemAPI p : newProducts) {
				walmart.addItem(p);
			}
			System.out.println("Sort inventory by item calories.");
			walmart.sortInventory();
			walmart.showInventory();
		}
		{
			/**
			 * Walmart store controlling object
			 */
			Store walmart = new Walmart(77, "Walmart");
			/**
			 * Instantiate the Item Factory
			 * and the Item objects
			 */
			AbstractItemFactoryAPI factory = new ElectronicsFactory();
			List<AbstractItemAPI> newProducts = new ArrayList<>();
			newProducts.add(factory.getObject(200, "Sharp Flat Screen TV", 899.99));
			newProducts.add(factory.getObject(300, "Apple iPad mini", 499.99));
			newProducts.add(factory.getObject(400, "BlueRay player", 99.99));
			newProducts.add(factory.getObject(500, "HP Laptop", 299.99));
			System.out.println("adding " + newProducts.size() + " new products.");
			for (AbstractItemAPI p : newProducts) {
				walmart.addItem(p);
			}
			System.out.println("Sort inventory by item PRICE.");
			walmart.sortInventory();
			walmart.showInventory();
		}

		
		System.out.println("\n" + Walmart.class.getName() + ".demo() done!");
	}
}
