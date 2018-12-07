package edu.neu.csye6200.api;

import java.util.List;

import edu.neu.csye6200.Item;

public abstract class AbstractItemFactoryAPI {
	public abstract Item getObject();
	public abstract Item getObject(List<String> args);
	public abstract Item getObject(int id, String name, Double price);

}
