package exception;

public class ActionFinishedException extends Exception {

	/* Class version, it is used to check if the server and the client have the same version of this class */ 
	private static final long serialVersionUID = 6977697629844113444L;

	public ActionFinishedException() {
		System.out.println("This action is finished");
	}

}
