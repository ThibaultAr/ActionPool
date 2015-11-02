package pool.resource;

public class Basket implements Resource {

	public String getDescription() {
		return "Basket";
	}

	public boolean equals(Object o) {
		if (o instanceof Basket)
			return true;
		return false;
	}
}
