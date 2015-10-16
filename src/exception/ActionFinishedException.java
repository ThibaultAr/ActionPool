package exception;

public class ActionFinishedException extends Exception {

	private static final long serialVersionUID = 6977697629844113444L;

	public ActionFinishedException(){
		System.out.println("This action is finished");
	}
	
}
