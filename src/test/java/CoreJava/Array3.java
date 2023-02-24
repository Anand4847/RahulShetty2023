package CoreJava;

public class Array3 {

	
	public static void main(String[] args) {
		
		
		int arr[] = new int[2];
		arr[0] = 1;
		arr[1] = 3;
		

		// Simple for loop
for (int i= 0 ; i<arr.length; i++)
	
{
	
	System.out.println(arr[i]);
}
		
// Enhanced for loop
for (int s : arr)

{
	
	System.out.println(s);
}
	}
}
