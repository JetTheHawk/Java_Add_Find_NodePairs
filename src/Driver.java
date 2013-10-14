import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	/**
	 * Author:	Matthew Pistella
	 * Date: 	12/9/2010
	 * Desc:	This class has the user choose to add a new node, find a name of a node 
	 * based on its key, Display all the nodes each with its key and name, and to end the program.
	 * the add function uses a try catch block to make sure no invlid nodes are entered into the arraylist.
	 * 
	 */

	private Scanner in;
	private ArrayList<Node> nodes;
	
	
	public Driver()
	{
		nodes = new ArrayList<Node>();
		in = new Scanner(System.in);
		menu();
	}
	
	
	public void menu()
	{
		int choice;
		System.out.println("Enter 0 to terminate, 1 to add a new Node, 2 to find the name of key, or 3 to list all Nodes");
		choice = in.nextInt();
		while (choice != 0)
		{
			if (choice == 1)
			{
				add();
			}
			else if (choice == 2)
			{
				findName();
			}
			else if (choice == 3)
			{
				list();
			}
			else
			{
				System.out.println("You must enter either 0, 1, 2, or 3");
			}
			System.out.println("Enter 0 to terminate, 1 to add a new Node, 2 to find the name of key, or 3 to list all Nodes");
			choice = in.nextInt();
		}
	}
	
	public void add()
	{
		System.out.println("Enter Node key an int from 1-9999 and enter Node name at least 3 characters , use -1 -1 to terminate");
		String name;
		int key;
		key = in.nextInt();
		name = in.next();
		while (!(key==-1))
		{
			try{
				Node newNode  = new Node(key, name);
				nodes.add(newNode);
				}
			catch (InputMismatchException IMex)
			{
				System.out.printf("\nException: %s\n", IMex);
				in.nextLine();
				System.out.println("You must enter int then string. Please try again");

			}
			catch(NodeException Nodex)
			{
				System.out.printf("\nException: %s\n", Nodex);
				in.nextLine();
			}
			System.out.println("Enter Node key an int from 1-9999 and enter Node name at least 3 characters , use -1 -1 to terminate");
			key = in.nextInt();
			name = in.next();
		}
		
	}
	
	public void list()
	{
		for (int index=0;index<nodes.size();index++)
		{
			System.out.println("Key: " + nodes.get(index).getKey());
			System.out.println("Name: " + nodes.get(index).getName());
			
		}
	}
	
	public void findName()
	{
		System.out.println("Enter the key of the node to find its name");
		try
		{
			int ndKey = in.nextInt();
			for (int index=0;index<nodes.size();index++)
			{

				if(ndKey==nodes.get(index).getKey())
				{
					System.out.println("Node key: " + ndKey + " name: " + nodes.get(index).getName());
				}
			}
		}
		catch (InputMismatchException IMex)
		{
			System.out.printf("\nException: %s\n", IMex);
			in.nextLine();
			System.out.println("You must enter an int. Please try again");
			findName();
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Driver();

	}

}
