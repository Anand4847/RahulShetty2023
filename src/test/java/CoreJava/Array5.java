package CoreJava;

public class Array5 {
	
	public static void main(String[] args) {
		
		
	int[] arr = {1,2,4,6,7,8,4,3,5,7,100};
	
	{
		for (int i=0 ; i<arr.length ; i++)
	
		if (arr[i] %2 == 0)
		
		{
	
			System.out.println(arr[i]);
			
		}
		
		else
			
		{
			
			System.out.println(arr[i] + " is not a multiple of 2");
		}
	}
	
	}

}
