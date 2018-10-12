import java.util.*;

 class steque
 {
	LinkedList<Integer> ll=new LinkedList<Integer>();
	

	 void push(int data) 
	 {
	   ll.add(data);
	}

	public  void pop() 
	{
	  ll.remove();
	}
	public void enqueue(int data)
	{
		
		ll.addLast(data);
	}
	public String display()
	{

		if (ll.isEmpty())
		{
		
			return "[]";
		}
		String st = "[" + ll.get(0);
		for (int i = 1; i < ll.size(); i++) 
		{
			st = st + ", " + ll.get(i);
		}
		st = st + "]";
		
		return st;
	}
 }
 class Solution
 {
	 public static void main(String args[])
	 {
		 int n, i, data;
			String s;
			Scanner scan = new Scanner(System.in);
			n = scan.nextInt();
			data=scan.nextInt();
			steque d = new steque();
			d.push(data);
			d.enqueue(data);
			d.pop();
			System.out.println(d.display());		
	 }}