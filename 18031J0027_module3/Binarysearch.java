import java.util.Scanner;
 
class Binarysearch
{
  public static void main(String args[])
  {
    int i, f, l, m, n, s, array[];
 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter n:");
    n = sc.nextInt();
    array = new int[n];
 
    System.out.println("Enter numbers:");
 
 
    for (i = 0; i < n; i++)
      array[i] = sc.nextInt();
 
    System.out.println("Enter value to search");
    s=sc.nextInt();
 
    f=0;
    l=n-1;
    m=(f + l)/2;
 
    while(f<=l)
    {
      if(array[m]<s)
        f=m+1;    
      else if(array[m]==s )
      {
        System.out.println(s+" found at index"+(m + 1));
        break;
      }
      else
         l = m - 1;
 
      m = (f + l)/2;
   }
   if (f > l)
      System.out.println(s + "not there");
  }
}
