package CoreJava;

public class Arraylist3 {

	public static void main(String[] args) {

		String s = "Rahul Shetty Academy";
		String[] splitString = s.split("Shetty");

//		System.out.println(splitString[0]);
// System.out.println(splitString[1]);

		System.out.println(splitString[1].trim());
		
		for (int i=0 ; i<s.length(); i++)
			
		{
			
			System.out.println(s.charAt(i));
		}

	}

}
