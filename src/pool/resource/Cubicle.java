package pool.resource;

public class Cubicle implements Resource {

	public String getDescription() {
		return "Cubicle";
	}

	public boolean equals(Object o) {
		if (o instanceof Cubicle)
			return true;
		return false;
	}
}
