package edu.neu.csye6200;

public class Customer extends Person {
	private Double income;	// annual income in thousands of dollars

	public Customer() {
		super();
		this.income = 24.0;
	}

	public Customer(int id, String firstName, String lastName, int age, double income) {
		super(id, firstName, lastName, age);
		this.income = income;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
	
	@Override
	public String toString() {
		StringBuilder info = new StringBuilder(super.toString());
		info.append(", is a customer with an annual gross income of: $").append(this.getIncome()).append(" K");
		return info.toString();
	}
}
