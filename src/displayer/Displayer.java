package displayer;

public class Displayer {

	static protected Displayer displayer = null;

	public Displayer() {

	}

	public static Displayer getDisplayer() {
		if (displayer == null)
			displayer = new Displayer();
		return displayer;
	}

	public void display(String message) {
		System.out.print(message);
	}
}
