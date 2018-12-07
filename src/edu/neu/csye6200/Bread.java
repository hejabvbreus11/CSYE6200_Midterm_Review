package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bread extends Item implements Comparable<Item> {
	public Bread() {
		super(2, "Bread", 1.49);
	}

	public Bread(Integer id, String name, Double price) {
		super(id, name, price);
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

	@Override
	public String info() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ").append("I am bread");
		return sb.toString();
	}

	@Override
	public String toString() {
		return super.info() + this.info();
	}
	
	/*
	 * The following inner classes:
	 * 
	 * 1. are static members of the Bread class
	 * 2. are accessible from the Bread class,
	 * 3. implement the Comparator interface
	 * 4. do NOT require an instantiated object.
	 * 
	 * NOTE: A static member of a class cannot access
	 * any object instance (i.e. non-static) members of the class.
	 * A static member is part of the class , is not part of any object and
	 * require an instantiated object to access any object instance member.
	 * (these static inner classes do not have to access any object instance members of the outer class.)
	 */
	public static class CompareById implements Comparator<Bread> {
		@Override
		public int compare(Bread o1, Bread o2) {
			return o1.getId().compareTo(o2.getId());
		}
	}
	public static class CompareByPrice implements Comparator<Bread> {
		@Override
		public int compare(Bread o1, Bread o2) {
			return o2.getPrice().compareTo(o1.getPrice());	// hi to lo
		}
	}
	
	public static class CompareByName implements Comparator<Bread> {
		@Override
		public int compare(Bread o1, Bread o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}
		
	}
	/**
	 * Implementation of Comparable interface
	 * Sort by name 
	 */
	@Override
	public int compareTo(Item o) {
		return this.getId().compareTo(o.getId());
	}
	
	public static void demo() {
		System.out.println("\n\t" + Bread.class.getName() + ".demo() starting...");
		List<Bread> list = new ArrayList<>();
		list.add(new Bread(1, "Rye", 1.10));
		list.add(new Bread(3, "Bagel", .89));
		list.add(new Bread(2, "English Muffin", 1.39));
		
		System.out.println("\n\t Sort Bread objects by increasing price.");
		Collections.sort(list);		// use Comparable interface
		list.forEach(System.out::println);
		
		System.out.println("\n\t Sort Bread objects by decreasing price.");
		list.sort(new Bread.CompareByPrice()); 	// use public static inner Comparator
		list.forEach(System.out::println);
		
		System.out.println("\n\t Sort Bread objects by ID.");
		list.sort(new Bread.CompareById()); 		// use public static inner Comparator
		list.forEach(System.out::println);
		
		System.out.println("\n\t Sort Bread objects by name.");
		list.sort(new Bread.CompareByName()); 		// use public static inner Comparator
		list.forEach(System.out::println);
		
		System.out.println("\n\t Sort Bread objects by name [anonymous inner class].");
		list.sort(new Comparator<Bread>() {

			@Override
			public int compare(Bread o1, Bread o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}); 		// use Comparator
		
		/*
		 * Java auto-boxing
		 */
		list.forEach(System.out::println);
		/*
		 * auto-box primative ints into Integer wrapper class
		 */
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,3,2));
		System.out.println("\n Add " + numbers.size() + " int literal values to add to Integer container to demonstrate Java Auto-Boxing.");
		numbers.forEach(System.out::println);
		int i = numbers.get(1);	// unbox int from Integer wrapper class
		System.out.println("int i has been umboxed from Integer list: int i = numbers.get(1); // i = " + i);
		numbers.sort(null);
		System.out.println("Sort Integer values in natural increasing order");
		numbers.forEach(System.out::println);
		System.out.println("\n" + Bread.class.getName() + ".demo() done!");
	}

	/**
	 * CONSOLE OUTPUT
	 * 

	edu.neu.csye6200.Bread.demo() starting...

	 Sort Bread objects by increasing price.
[3]  $0.89 Bagel I am bread
[1]  $1.1 Rye I am bread
[2]  $1.39 English Muffin I am bread

	 Sort Bread objects by decreasing price.
[2]  $1.39 English Muffin I am bread
[1]  $1.1 Rye I am bread
[3]  $0.89 Bagel I am bread

	 Sort Bread objects by ID.
[1]  $1.1 Rye I am bread
[2]  $1.39 English Muffin I am bread
[3]  $0.89 Bagel I am bread

	 Sort Bread objects by name.
[3]  $0.89 Bagel I am bread
[2]  $1.39 English Muffin I am bread
[1]  $1.1 Rye I am bread

	 Sort Bread objects by name [anonymous inner class].
[3] 	 $0.89 Bagel I am bread
[2]  $1.39 English Muffin I am bread
[1]  $1.1 Rye I am bread

 Add 3 int literal values to add to Integer container to demonstrate Java Auto-Boxing.
1
3
2
int i has been umboxed from Integer list: int i = numbers.get(1); // i = 3
Sort Integer values in natural increasing order
1
2
3

edu.neu.csye6200.Bread.demo() done!
	*
	*/
}
