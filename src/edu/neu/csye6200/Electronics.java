package edu.neu.csye6200;

public class Electronics extends Item implements Comparable<Item> {

	public Electronics() {
		super(2, "Electronics", 1.49);
	}

	public Electronics(Integer id, String name, Double price) {
		super(id, name, price);
	}
	
	@Override
	public String info() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ").append("I am Electronics");
		return sb.toString();
	}

	@Override
	public String toString() {
		return super.info() + this.info();
	}
	@Override
	public int compareTo(Item object) {
		return this.getPrice().compareTo(object.getPrice());  // lo to hi
	}
}
