class Node
{
	int data;
	Node next;
	public Node(int data)
	{
		this.data=data;
		next=null;
	}
	public void displayNode()
	{
		System.out.print(data+" ");
	}
	
}
class QueueLinkedlist
{
	Node first=null;
	public void insert(int data)
	{
		Node n=new Node(data);
		if(first==null)
		{
			first=n;
			return;
		}
		Node temp=first;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=n;		
	}
	public Node remove()
	{
		Node temp1=first;
		first=first.next;
		return temp1;
	}
	public void display()
	{
		Node temp1=first;
		while(temp1!=null)
		{
			temp1.displayNode();
			temp1=temp1.next;
		}
	}



public static void main(String[] args) {
		
QueueLinkedlist qll=new QueueLinkedlist();
System.out.println("inserted elements:");
qll.insert(100);
qll.insert(200);
qll.insert(300);
qll.insert(400);
qll.insert(500);
qll.display();
System.out.println("\nafter deleted elemensts:");
qll.remove();
qll.remove();
qll.remove();
qll.display();
	}

}
