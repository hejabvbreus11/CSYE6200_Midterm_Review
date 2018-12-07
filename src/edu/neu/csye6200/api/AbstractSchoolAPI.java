package edu.neu.csye6200.api;


public abstract class AbstractSchoolAPI {
	
	/**
	 * Given:
	 * 1. class AbstractSchoolAPI
	 *
	 * Implement the following:
	 *
	 * NOTE: 10 POINTS for correct, executable, on-time submission of a zipped Eclipse workspace
	 * in the correct format,
	 * FOR EXAMPLE: workspace_dan_peters_o2_neu.zip:
	 * NOTE: all CONSOLE OUTPUT must be pasted into the end of the Driver class as a comment.
	 *
	 * 1. 35 POINTS: class Item.
	 * 2. 10 POINTS: class Electronics derived from class Item (Use Factory Design Pattern).
	 * 3. 10 POINTS: class Bread derived from class Item (Use Factory Design Pattern).
	 * 4. 10 POINTS: class LiteBread derived from class Bread (Use Factory Design Pattern).
	 *
	 * 5. 15 POINTS: class Store derived from AbstractStore
	 *  a. use the following partial implementation:
	 *  
	 *  	public void sortInventory() {
	 *  		this.inventory.sort(null);
	 *  	}
	 *  
	 *  	public void showRoster() {
	 *  		System.out.println(this.getInventoryInfo());
	 *  	}
	 *  
	 * 6. 10 POINTS: class Neu derived from class School (Use Factory Design Pattern).
	 * 	a. create a demo1() method to add 4 Electronic items to Walmart and sort by Price (DO NOT USE COMPARATOR).
	 * 	a. create a demo2() method to add 4 Bread items to Walmart and sort by Item number (DO NOT USE COMPARATOR).
	 * 	b. create a demo3() method to add 4 HealthyBread items to Walmart and sort by Calories (DO NOT USE COMPARATOR).
	 *
	 * OR USE THE FOLLOWING NEU DEMO partial implementation as an example:
	 * 
	 * 	public static void demo() {
	 * 	 System.out.println("\n\t" + Neu.class.getName() + ".demo() starting...");
	 *   {
	 * 		Store Neu = new Neu(77, "Neu");
	 * 
	 * 		for (AbstractItemAPI p : newProducts) {
	 * 			walmart.addItem(p);
	 * 		}
	 * 		System.out.println("Sort inventory by item PRICE.");
	 * 		walmart.sortInventory();
	 * 		walmart.showRoster();
	 *   }
	 *   {
	 * 		Store walmart = new Walmart(77, "Walmart");
	 * 
	 * 		for (AbstractItemAPI p : newProducts) {
	 * 			walmart.addItem(p);
	 * 		}
	 * 		System.out.println("Sort inventory by item NUMBER.");
	 * 		walmart.sortInventory();
	 * 		walmart.showRoster();
	 *   }
	 *   {
	 * 		Store walmart = new Walmart(77, "Walmart");
	 * 
	 * 		for (AbstractItemAPI p : newProducts) {
	 * 			walmart.addItem(p);
	 * 		}
	 * 		System.out.println("Sort inventory by item CALORIES.");
	 * 		walmart.sortRoster();
	 * 		walmart.showRoster();
	 *   }
	 *   System.out.println("\n" + walmart.getClass().getName() + ".demo() done!");
	 * }
	 */	
	/**
	 * API
	 */
	public abstract void show();
	public abstract String getRosterInfo();
	public abstract void sortRoster();
	public abstract void clearRoster();
	public abstract void showRoster();
}
