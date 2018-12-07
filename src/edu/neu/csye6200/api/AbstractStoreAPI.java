package edu.neu.csye6200.api;

public abstract class AbstractStoreAPI {
	
	/**
	 * Given:
	 * 1. class AbstractStoreAPI
	 *
	 * Implement the following (100 TOTAL POINTS):
	 *
	 * 1. 10 POINTS for correct, executable, on-time submission of a zipped Eclipse workspace
	 * in the correct format,
	 * 		FOR EXAMPLE: workspace_dan_peters_o2_wlamart.zip:
	 * NOTE: all CONSOLE OUTPUT must be pasted into the end of the Driver class as a comment.
	 *
	 * 2. 20 POINTS: class Item.
	 * 3. 10 POINTS: class Electronics derived from class Item (Use Factory Design Pattern).
	 * 4. 10 POINTS: class Bread derived from class Item (Use Factory Design Pattern).
	 * 5. 10 POINTS: class LiteBread derived from class Bread (Use Factory Design Pattern).
	 *
	 * 6. 15 POINTS: class Store derived from AbstractStore
	 *  a. use the following partial implementation:
	 *  
	 *  	public void sortInventory() {
	 *  		this.inventory.sort(null);
	 *  	}
	 *  
	 *  	public void showInventory() {
	 *  		System.out.println(this.getInventoryInfo());
	 *  	}
	 *  
	 * 7. 25 POINTS: class Walmart derived from class Store (Use Factory Design Pattern).
	 * 	a. 5 points create a code block ( { ... } ) in the demo() method to add 4 Electronic items to Walmart and sort by Price (DO NOT USE COMPARATOR).
	 * 	a. 5 points create a code block ( { ... } ) in the demo() method to add 4 Bread items to Walmart and sort by Item number (DO NOT USE COMPARATOR).
	 * 	b. 15 points create a code block ( { ... } ) in the demo() method to add 4 HealthyBread items to Walmart and sort by Calories (DO NOT USE COMPARATOR).
	 *
	 * OR USE THE FOLLOWING WALMART DEMO partial implementation as an example:
	 * 
	 * 	public static void demo() {
	 * 	 System.out.println("\n\t" + Walmart.class.getName() + ".demo() starting...");
	 *   {
	 * 		Store walmart = new Walmart(77, "Walmart");
	 * 
	 * 		for (AbstractItemAPI p : newProducts) {
	 * 			walmart.addItem(p);
	 * 		}
	 * 		System.out.println("Sort inventory by item PRICE.");
	 * 		walmart.sortInventory();
	 * 		walmart.showInventory();
	 *   }
	 *   {
	 * 		Store walmart = new Walmart(77, "Walmart");
	 * 
	 * 		for (AbstractItemAPI p : newProducts) {
	 * 			walmart.addItem(p);
	 * 		}
	 * 		System.out.println("Sort inventory by item NUMBER.");
	 * 		walmart.sortInventory();
	 * 		walmart.showInventory();
	 *   }
	 *   {
	 * 		Store walmart = new Walmart(77, "Walmart");
	 * 
	 * 		for (AbstractItemAPI p : newProducts) {
	 * 			walmart.addItem(p);
	 * 		}
	 * 		System.out.println("Sort inventory by item CALORIES.");
	 * 		walmart.sortInventory();
	 * 		walmart.showInventory();
	 *   }
	 *   System.out.println("\n" + walmart.getClass().getName() + ".demo() done!");
	 * }
	 */	
	/**
	 * API
	 */
	public abstract void show();
	public abstract String getInventoryInfo();
	public abstract void sortInventory();
	public abstract void clearInventory();
	public abstract void showInventory();
}
