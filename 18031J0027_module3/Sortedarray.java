
import java.util.*; 
  
class Sortedarray { 
      
    
    public static void sortedMerge(int arr1[], int arr2[], int arr3[],int n1,int n2) 
    { 
        Arrays.sort(arr1); 
        Arrays.sort(arr2); 
       
        int i = 0, j = 0, k = 0; 
        while (i < n1 && j < n2) { 
            if (arr1[i] <= arr2[j]) { 
                arr3[k] = arr1[i]; 
                i++; 
                k++; 
            } else { 
                arr3[k] = arr2[j]; 
                j++; 
                k++; 
            } 
        }     
          
        while (i < n1) 
        {  
            arr3[k] = arr1[i]; 
            i++; 
            k++; 
        }     
        while (j < n2)
        {   
            arr3[k] = arr2[j]; 
            j++; 
            k++; 
        } 
    } 
      
    
    public static void main(String[] args)  
    { 
    	Scanner sc=new Scanner(System.in);
		System.out.println("enter n1");
		int n1=sc.nextInt();
		System.out.println("enter n2");
		int n2=sc.nextInt();
		int []arr1=new int[n1];
		int []arr2=new int[n2];
		System.out.println("enter arr1 elements:");
		for(int i=0;i<n1;i++)
		{
			arr1[i]=sc.nextInt();
		}
		System.out.println("enter arr2 elements:");
		for(int j=0;j<n2;j++)
		{
			arr2[j]=sc.nextInt();
		}
        // Final merge list 
        int arr3[] = new int[n1+n2]; 
        sortedMerge(arr1, arr2, arr3, n1, n2); 
       
        System.out.print( "Sorted:"); 
        for (int i = 0; i < n1 + n2; i++) 
            System.out.print(arr3[i]);    
    } 
} 