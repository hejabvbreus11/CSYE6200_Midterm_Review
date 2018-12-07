package edu.neu.csye6200.patterns;

import java.util.List;

import edu.neu.csye6200.Electronics;
import edu.neu.csye6200.Item;
import edu.neu.csye6200.LiteBread;
import edu.neu.csye6200.api.AbstractItemFactoryAPI;

public class ElectronicsFactory extends AbstractItemFactoryAPI {

	@Override
	public Item getObject() {
		return new Electronics();
	}

	@Override
	public Item getObject(int id, String name, Double price) {
		return new Electronics(id, name, price);
	}

	@Override
	public Item getObject(List<String> args) {
		int id = Integer.parseInt(args.get(0));
		String name = args.get(1);
		Double price = Double.parseDouble(args.get(2));
		return new Electronics(id, name, price);
	}

}
