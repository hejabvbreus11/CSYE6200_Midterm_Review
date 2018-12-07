package edu.neu.csye6200;

public class LiteBread extends Bread implements Comparable<Item> {
	private Double calories;
	public LiteBread() {
		super(2, "HealthyBread", 1.49);
		this.calories = 0.0;
	}

	public LiteBread(Integer id, String name, Double price, Double calories) {
		super(id, name, price);
		this.calories = calories;
	}
	
	@Override
	public Double getDoubleKey() {
		return this.getCalories();
	}
	
	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	/**
	 * Implementation of Comparable interface
	 * Sort by name 
	 */
	@Override
	public int compareTo(Item o) {
		return this.getCalories().compareTo(o.getDoubleKey());
	}

	@Override
	public String info() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ").append("I am Lite bread");
		sb.append(" and only ").append(this.getDoubleKey()).append(" calories");
		return sb.toString();
	}
}
