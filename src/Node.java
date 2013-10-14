
public class Node {

	private int key;
	private String name;
	
	
	public Node(int key, String name) throws NodeException
	{
		this.name = name;
		this.key = key; 
		if(name.length()<3)
		{
			throw new NodeException("name");
		}
		if(key<1 || key>9999)
		{
			throw new NodeException("key");
		}
	}


	public int getKey() {
		return key;
	}


	public String getName() {
		return name;
	}
	
	
}
