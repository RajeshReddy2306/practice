

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

class Node {

	public String item;
	public Node next;

	public Node(String item) {
	    this.item = item;
	}

	public void displayNode() {
	    System.out.print(item);
	    System.out.print("  ");

	 }
	}
public class Solution {
private Node first;
private Node last;
public boolean isEmpty()
{
	return first==null;
}
public void enqueue(String item)
{
	Node oldlast=last;
	last=new Node(item);
	last.item=item;
	last.next=null;
	if(isEmpty())
	{
		first=last;
	}
	else
	{
		oldlast.next=last;
	}
}
public String dequeue()
{
	String item=first.item;
	first=first.next;
	if(isEmpty())
	{
		last=null;
	}
	return item;
}
void dispaly()
{
	Node current = first;
    while (current != null) {
        current.displayNode();
        current = current.next;
    }
}
public static void main(String args[])
{
	int n;
	Scanner sc=new Scanner(System.in);
	Solution q=new Solution();
	
	int d=sc.nextInt();
	for(int i=0;i<d;i++)
	{
		String s=sc.nextLine();
	}
}
}
