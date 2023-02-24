package CoreJava;

import java.util.ArrayList;

public class Arraylist2 {

	public static void main(String[] args) {

		ArrayList<String> a = new ArrayList<String>();
		a.add("Anand");
		a.add("Soni");
		a.add("Bansi");

		// Enhanced for loop

		for (String b : a) {
			System.out.println(b);
		}
		
		System.out.println("************************");

		// Simple for loop

		for (int i = 0; i < a.size(); i++)

		{

			System.out.println(a.get(i));
		}
		System.out.println("************************");		
		// items present in arraylist
		
		System.out.println(a.contains("Anand"));
		System.out.println(a.contains("Anandi"));

		
	}

}
