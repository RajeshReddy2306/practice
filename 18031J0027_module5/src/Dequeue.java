import java.util.*; 
class Node1 {
	int data;
	Node1 next;
	public int data;
	public int data;
	public int data;
	public Node1(int data)
	{
		this.data=data;
		this.next=null;
	}

}
 

 

  class Operations {
 	Node1 head;
 public void pushRight(int num)
 {
 	Node1 n=new Node1(num);
 	if(head==null)
 	{
 		head=n;
 	}
 	if(head.next==null)
 	{
 		head.next=n;
 	}
 	Node1 temp=head;
 	while(temp.next!=null)
 	{
 		temp=temp.next;
 	}
 	temp.next=n;
 }
 public void pushLeft(int num)
 {
 	Node1 n=new Node1(num);
 	if(head==null)
 	{
 		head=n;
 	}
 	else
 	{
 	n.next=head;
 	n=head;
 	}
 }
 public int popRight()
 {
 	if(head==null)
 	{
 		System.out.println("list is empty");
 		return -1;
 	}
 	if(head.next==null)
 	{
 		int x=head.data;
 		head=null;
 		return x;
 	}
 	else
 	{
 	Node1 temp=head;
 	while(temp.next.next!=null)
 	{
 		temp.next=temp;
 	}
 	int x=temp.next.data;
 	temp.next=null;
 	return x;
 	}
 }
 public int popLeft()
 {
 	if(head==null)
 	{
 		System.out.println("list is empty");
 		return -1;
 	}
 	if(head.next==null)
 	{
 		int x=head.data;
 		head=null;
 		return x;
 	}
 	else
 	{
 	int x=head.data;
 	head=head.next;
 	return x;
 	}
 }
 public int size()
 {
 	Node1 temp=head;
 	int count=0;
 	while(temp!=null)
 	{
 		temp=temp.next;
 		count++;
 	}
 	
 	return count;
 }
 public void display()
 {
 	Node1 temp=head;
 	LinkedList<Integer> l=new LinkedList<Integer>();
 	while(temp!=null)
 	{
 		int x=temp.data;
 		l.add(x);
 	}
 	System.out.println(l);
 }
 }



  class Dequeue {
 	public static void main(String[] args)
 	{
 		Scanner sc=new Scanner(System.in);
 		int  num=0;
 		Operations o=new Operations();
 		int n=sc.nextInt();
 		//int n1=n;
 		while(sc.hasNext())
 		{
 		String input=sc.nextLine(); 
         String[] arrOfStr = input.split(" ");
         String element1 = arrOfStr[0];
         System.out.println(element1);
         if(arrOfStr.length>1)
         {
          String element2 = arrOfStr[1];
          num=Integer.parseInt(element2);
          System.out.println(num);
         }
         switch(element1)
         {
 		case "pushLeft":o.pushLeft(num);
 		break;
 		case "pushRight":o.pushRight(num);
 		break;
 		case "popLeft":System.out.println(+o.popLeft());
 		break;
 		case "popRight":System.out.println("["+o.popRight()+"]");
 		break;
 		case "size":System.out.println(o.size());
 		break;
         }
         
         if(n==0)
         {
         break;
         }
         n--;
         System.out.println("n---"+n);
 		}
 		
 	}

 }
