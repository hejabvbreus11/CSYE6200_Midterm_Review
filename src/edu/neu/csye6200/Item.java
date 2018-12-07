package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.neu.csye6200.api.AbstractItemAPI;

public class Item extends AbstractItemAPI implements Comparable<Item> {
//	private Integer id;
//	private String name;
//	private Double price;
	public Integer id;
	public String name;
	public Double price;

	public Item() {
		super();
		init (1, "item", 1.0);
	}

	public Item(Integer id, String name, Double price) {
		super();
		init(id, name, price);
	}

	public void init(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String info() {
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(id.toString()).append("] ")
		.append(" $").append(price.toString())
		.append(" ").append(name);
		return sb.toString();
	}

	@Override
	public Integer getIntegerKey() {
		return 1;
	}
	
	@Override
	public Double getDoubleKey() {
		return 1.0;
	}

	@Override
	public String getStringKey() {
		return "";
	}

	
	/*
	 * Fill in the blank to complete the code segment.
	 * Use a single stream and lambdas to sort Items by price:
	 * 1. lowest price first;
	 * 2. exclude any item which cost greater than $3;
	 * 3. display resulting list on console, horizontally on a single line separated by a single space.
	 */
	public void sortItems() {
		List<Item> list = new ArrayList<>(Arrays.asList(
				new Item(3, "OJ", 1.49),
				new Item(1, "Bread", 2.49),
				new Item(2, "Milk", 3.49),
				new Item(6, "Cheese", .89),
				new Item(4, "Cookies", 12.49),
				new Item(5, "Coffee", 7.49),
				new Item(9, "Tea", 5.49),
				new Item(7, "Rice", 4.49),
				new Item(8, "Apples", .99)
					));
		list.stream().sorted().forEach( (s) -> System.out.print(s + " ") );
		System.out.println();
		
		// fill in the blanks to complete sortItems() code:
		//list.stream().[a]( [b] ).[c]( [d] ).[e]( [f] );
		
		// ANSWERS
		// [a]
		// \s*filter\s*
		// [b]
		// \s*\(\s*o\s*\)\s*\-\>\s*o\.getPrice\s*\(\s*\)\s*\<\s*3\s*
		// [c]
		// \s*sorted\s*
		// [d]
		// \s*\(\s*o1\s*\,\s*o2\s*\)\s*\-\>\s*o1\.getPrice\s*\(\s*\)\.compareTo\s*\(\s*o2\.getPrice\s*\(\s*\)\s*\)\s*
		// [e]
		// \s*forEach\s*
		// [f]
		// \s*\(\s*o\s*\)\s*\-\>\s*System\.out\.print\s*\(\s*o\s*\+\s*\" "\s*\)\s*
		// [g]
		//                [a]     [b]                     [c]          [d]                                           [e]       [f]
		//list.stream().filter((o) -> o.getPrice() < 3).sorted((o1,o2) -> o1.getPrice().compareTo(o2.getPrice())).forEach( (s) -> System.out.print(s + " ") );
		list.stream().filter( o -> o.getPrice() < 3).sorted((o1,o2) -> o1.getPrice().compareTo(o2.getPrice())).forEach( o -> System.out.print(o + " ") );
		System.out.println();
	}
	
	
//
//	/**
//	 * Implementation of Comparable interface
//	 * Sort by price (from low price to highest price)
//	 */
//	@Override
//	public int compareTo(Item o) {
//		return this.getPrice().compareTo(o.getPrice());  // lo to hi
//	}

	/**
	 * Implementation of Comparable interface
	 * Sort by price (from low price to highest price)
	 */
	@Override
	public int compareTo(Item object) {
		return this. getName (). compareTo (object. getName ());  // lo to hi
	}
	
	@Override
	public String toString() {
		return "Item " + this.info();
	}
}
/*
 * Given the following code fragment, 
 * Fill in the multiple blanks to complete the visible code
 * so that Item objects will sort by name (e.g. natural order or by default).
 *
 * 
public class Item extends AbstractItemAPI [a]  [b]< [c] > {
	public Integer id;
	public String name;
	public Double price;

	public Item() {
		super();
		init (1, "item", 1.0);
	}

	public Item(Integer id, String name, Double price) {
		super();
		init(id, name, price);
	}

	public void init(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
 *
 *
@[d]
public [e] [f]( [g] object) {
	return this.[h]().[i](object.[j]());
}
 *
 *
 * ANSWERS:
[a]
\s*implements\s*
[b]
\s*Comparable\s*
[c]
\s*Item\s*
[d]
\s*@Override\s*
[e]
\s*int\s*
[f]
\s*compareTo\s*

[g]
\s*Item\s*

[h]
\s*getName\s*
[i]
\s*compareTo\s*
[j]
\s*getName\s*
 *
 * Feedback:
That is correct!
Sorry, that is not correct.
 *
 */