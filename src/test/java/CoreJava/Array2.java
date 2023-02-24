package CoreJava;

import java.util.Arrays;
import java.util.List;

public class Array2 {
	
	public static void main(String[] args) {
		
		
		// Printing string values
		
	 String [] name = {"Anand", "Sangita", "Bansilal"};
	 
	 {
	
//		 for (int i=0 ; i<name.length; i++)
//	
//		 System.out.println(name[i]);
		 
	 }
	 
	 // Printing in diff way
	 
	 String[]  arr= new String[2];
	 
	 arr[0] = "Anand1";
	 arr[1] = "Sangita1";
	 
//	 for (int i=0 ; i<arr.length; i++)
//		 
//	 {
//		 
//		 System.out.println(arr[i]);
//	 }
	 
	 
	 // Enhanced for loop
	 
	 for (String s : arr)
	 
	 {
		 
	//	 System.out.println(s);
		 
	 }
	 
	 // Converting array to arraylist
	 
      List<String> nameArrayList = Arrays.asList(name);
      System.out.println(nameArrayList.contains("Sangita"));
	 
	 
	}

}
