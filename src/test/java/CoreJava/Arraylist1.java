package CoreJava;

import java.util.ArrayList;

public class Arraylist1 {

	
	public static void main(String[] args) {
		
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("Rahul");
		a.remove(0);
		a.add("Anand");
        a.indexOf(a);
        a.add(0, "Sangita");
//		System.out.println(a.get(0));
	//	System.out.println(a.get(1));
		System.out.println(a.remove(0));
	}
}
