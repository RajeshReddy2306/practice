import java.io.*;
import java.util.Scanner;
class Node
{
    int value;
    Node link;
}

class Stack
{
    Node top;
    public Stack()
    {
        top = null;
    }
    public void push(int item) 
    {
        Node n = new Node();
        n.value = item;
        n.link = top;
        top = n;
    }
    public int pop()
    {
       int item;
        item = top.value;
        Node n = top;
        n = null;
        top = top.link;
        return item;
    }
    public void display()
    {
        Node n = top;
        System.out.print("(top)");
        while (n != null) {
            System.out.print(" ->" + n.value);
            n = n.link;
        }
        System.out.println();
    }
}

class Queue 
{
    Node front, rear;
    Stack s1 = new Stack();
    Stack s2 = new Stack();
    public Queue() {
    }
    public void add(int item)
    {
        while (s2.top != null)
            s1.push(s2.pop());
        s1.push(item);
        rear = s1.top;
        while (s1.top != null)
            s2.push(s1.pop());
        front = s2.top;
    }
    public int remove()
    {
        int item = s2.pop();
        front = s2.top;
        return item;
    }
    public void display()
    {
        Node n = s2.top;
        System.out.print("(front)");
        while (n != null) {
            System.out.print(" <-" + n.value);
            n = n.link;
        }
        System.out.println(" <-(rear)");
    }
}


public class Solution1
{
    public static void main(String[] args) //throws IOException
    {
        
        int n, m, i;
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        while(sc.hasNext())
        {
        Queue q = new Queue();
        Queue q1 = new Queue();
        String a=sc.nextLine();
    	int g=0;
    	String[] b=a.split(" ");
    	n=Integer.parseInt(b[0]);
    	m=Integer.parseInt(b[1]);
        for (i = 0; i < n; i++)
            q.add(i);
        Node node = q.front;
        int l, k = 0;
        while (k != n - 1) {
            for (i = 0; i< m-1; i++)
                q.add(q.remove());
            l = q.remove();
            q1.add(l);
            k++;
        }
        
        	while (q1.front != null)
            System.out.print(q1.remove() + " ");
        	l=q.remove();
            q1.add(l);
            System.out.print(q1.remove());
            System.out.println("");
    }
        
    }
}