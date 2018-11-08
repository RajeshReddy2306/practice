import java.util.NoSuchElementException;

import java.util.Stack;

import java.util.Scanner;

class Book  {
	String name;
	String author;
	double price;
	
	Book(String name,String author,double price)
	{
		this.author=author;
		this.name=name;
		this.price=price;
	}

	public int compareTo(Book key) {
		if(this.name.equals(key.name))
		{
			return 0;
		}
		else if(this.name.compareTo(key.name)>0)
		{
			return 1;
		}
		else
		return -1;
	}
	
}
class Node
{
	Book key;
	int value;
	Node left,right;
	int size;
	Node(Book key,int value,int size)
	{
		this.key=key;
		this.value=value;
		this.size=size;
	}
	
}
 class BST
{
	Node root;
	
	int n=0;
	public void put(Book Key,int value)
	{
		root=put(root,Key,value);
	}
	private Node put (Node x, Book key, int value)
	{
		if(x==null)
		{
			return new Node(key,value,1);
		}
		if(key.name.compareTo(x.key.name)<0)
		{
			x.left=put(x.left,key,value);
		}
		else if(key.name.compareTo(x.key.name)>0)
		{
			x.right=put(x.right,key,value);
		}
		else
		{
			x.value=value;
			root.size=1+size(x.left)+size(x.right);
		}
		return x;
	}
	public int get(Node x, Book key) { 
	if (x == null) {
		
		return 0;}
	int cmp =compare(key,x.key) ;  
	if (cmp < 0) 
	return get(x.left, key);     
	else if (cmp > 0) 
	return get(x.right, key);   
	else return x.value; 
	}


	public int compare(Book a,Book b)
	{
		if(a.name.compareTo(b.name)>0)
	{
		return 1;
				
	}
		else if(a.name.compareTo(b.name)<0)
		{
			return -1;
		} 
		else
		{
			return 0;
		}

	}
	Book floor(String k)
	{
		Node x=floor(root,k);
		if(x==null)
			return null;
		return x.key;
	}
	Node floor(Node x,String k)
	{
		if(x==null)
			return null;
		int cmp=k.compareTo(x.key.name);
		if(cmp==0)
			return x;
		if(cmp<0)
			return floor(x.left,k);
		Node t=floor(x.right,k);
		if(t!=null)
			return t;
		else
			return x;
	}
	public Book select(int k) 
	{
	  
		Node x = select(root, k);
	    return x.key;
	} 
	 Node select(Node x, int k) {
	     
	    while(x!=null)
	    {
	   
	    int t = size(x.left); 
	    if      (t > k) return select(x.left,  k); 
	    else if (t < k) return select(x.right, k-t-1); 
	    else            return x; 
		}
	    return null;
	 }
	public Book min()
	{
		if(isEmpty())
			throw new NoSuchElementException("calls min() with empty symbol table");
		return min(root).key;
	}
	private Node min(Node x)
	{ 
	    if (x.left == null) 
	    	return x; 
	    else
	    	return min(x.left); 
	}
	public Book max()
	{
		if(isEmpty())
			throw new NoSuchElementException("calls max() with empty symbol table");
		return max(root).key;
	}
	private Node max(Node x)
	{
		if(x.right==null)
			return x;
		else
			return max(x.right);
	}
	private boolean isEmpty() {
		return false;
	}
	Book ceiling(String key)
	{
		 Node x = ceiling(root, key);
	     if (x == null) return null;
	     else return x.key;
	}
	private Node ceiling(Node x,String k)
	{
		if(x==null)
			return null;
		int cmp=k.compareTo(x.key.name);
		if(cmp==0)
			return x;
		if(cmp<0)
		{
			Node t=ceiling(x.left,k);
		   if(t!=null)
			   return t;
		   else return x;
		}
		return ceiling(x.right,k);
	}
	public int rank(String key) {
	    if (key == null) throw new IllegalArgumentException("argument to rank() is null");
	    return rank(key, root);
	} 
	private int rank(String key, Node x) {
	    if (x == null) return 0; 
	    int cmp = key.compareTo(x.key.name); 
	    if      (cmp < 0) return rank(key, x.left); 
	    else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
	    else              return size(x.left); 
	}
	public int size() {
	    return size(root);
	}
	private int size(Node x) {
		//System.out.println(x.size);
	    if (x == null)
	    	return 0;
	    else return x.size;
	}
	public Iterable<Book> keys() {
	    if (isEmpty()) return new Stack<Book>();
	    return keys(min(), max());
	}
	public Iterable<Book> keys(Book lo, Book hi) {
	    if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
	    if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

	    Stack<Book> q = new Stack<Book>();
	    keys(root, q, lo, hi);
	    return q;
	} 
	private void keys(Node x, Stack<Book> q, Book lo, Book hi) { 
	    if (x == null) return; 
	    int cmplo = lo.compareTo(x.key); 
	    int cmphi = hi.compareTo(x.key); 
	    if (cmplo < 0) keys(x.left, q, lo, hi); 
	    if (cmplo <= 0 && cmphi >= 0) q.push(x.key); 
	    if (cmphi > 0) keys(x.right, q, lo, hi); 
	}
}



public class Solution {
public static void main(String arg[])
{BST bst=new BST();
	Scanner sc= new Scanner(System.in);
	while(sc.hasNext())
	{
		String str = sc.nextLine();
		String st[] = str.split(",");
		switch(st[0])
		{
			case "put":
			{
				Book b = new Book(st[1],st[2],Double.parseDouble(st[3]));
				int va=Integer.parseInt(st[4]);
				
				bst.put(b, va);
				break;
			}
			case "get":
			{
				Book b = new Book(st[1],st[2],Double.parseDouble(st[3]));
				int k=bst.get(bst.root,b);
				if(k==0)
				{
					System.out.println("null");
					
				}
				else
				{
					System.out.println(k);
				}
				
				
				break;
			}
			case "max":
				System.out.println(bst.max().name+", "+bst.max().author+", "+bst.max().price);
				break;
			case "min":
				System.out.println(bst.min().name+", "+bst.min().author+", "+bst.min().price);
				break;
			case "select":
				System.out.println(bst.select(Integer.parseInt(st[1])).name+", "+bst.select(Integer.parseInt(st[1])).author+", "+bst.select(Integer.parseInt(st[1])).price);
				break;
			case "floor":
				System.out.println(bst.floor(st[1]).name+", "+bst.floor(st[1]).author+", "+bst.floor(st[1]).price);
				break;
			case "ceiling":
				System.out.println(bst.ceiling(st[1]).name+", "+bst.ceiling(st[1]).author+", "+bst.ceiling(st[1]).price);
				break;
				
			}
		}
	}
	
	
	
}



