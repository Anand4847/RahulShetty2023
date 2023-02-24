package Selenium;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Counts2 {
	
@Test

public void count2() {
		
		
		ArrayList<String> names= new ArrayList<String>();
		
		names.add("Anand");
		names.add("Amit");
		names.add("Soni");
		names.add("Vaibhav");
		names.add("Anand");
		int count = 0;
		
		for (int i=0 ;i<names.size();i++)
			
		{
		String actual = names.get(i);
            
		
			if (actual.startsWith("A"))
			{
				count++;
			}
		
		
				
		}
		System.out.println(count);
		}

@Test

public void count3()

{
	
	
	ArrayList<String> names= new ArrayList<String>();
	
	names.add("Anand");
	names.add("Amit");
	names.add("Soni");
	names.add("Vaibhav");
	names.add("Anand");
	
	long name = names.stream().filter(s->s.startsWith("A")).count();
	
	
	System.out.println(name);
}

@Test

public void count4()

{
	// print all the names with length greater than 4
	
	ArrayList<String> names= new ArrayList<String>();
	
	names.add("Anand");
	names.add("Amit");
	names.add("Soni"); 
	names.add("Vaibhav");
	names.add("Anandi");
	
names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
System.out.println("\t");
names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));	

}


}

