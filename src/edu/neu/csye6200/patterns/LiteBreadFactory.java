package edu.neu.csye6200.patterns;

import java.util.List;

import edu.neu.csye6200.Item;
import edu.neu.csye6200.LiteBread;
import edu.neu.csye6200.api.AbstractItemFactoryAPI;

public class LiteBreadFactory extends AbstractItemFactoryAPI {

	@Override
	public Item getObject() {
		return new LiteBread();
	}

	@Override
	public Item getObject(int id, String name, Double price) {
		return new LiteBread(id, name, price, 0.0);
	}

	@Override
	public Item getObject(List<String> args) {
		int id = Integer.parseInt(args.get(0));
		String name = args.get(1);
		Double price = Double.parseDouble(args.get(2));
		Double calories = Double.parseDouble(args.get(3));;
		return new LiteBread(id, name, price, calories);
	}

}
