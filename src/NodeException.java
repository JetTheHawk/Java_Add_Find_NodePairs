
public class NodeException extends Exception {

	public NodeException(String arg)
	{
		if(arg=="key"){
			System.out.println("the key must be between 1 and 9999");
		}
		else if(arg=="name"){
			System.out.println("name must have at least 3 characters in it.");
		}
	}
}
