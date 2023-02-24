package Selenium;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.mongodb.connection.Stream;

public class Counts1 {

	// @Test

	public void Count1() {

		// Count the number of names starts with alphabet A

		ArrayList<String> names = new ArrayList<String>();

		names.add("Anand");
		names.add("Ankita");
		names.add("Bhumika");
		names.add("Ankit");
		names.add("Pratik");
		names.add("Priyank");
		names.add("Sandeep");

		int count = 0;

		for (int i = 0; i < names.size(); i++)

		{

			String actual = names.get(i);

			if (actual.startsWith("A")) {

				count++;
			}

		}
		System.out.println(count);

	}

	@Test

	public void Javastream()

	{

		ArrayList<String> names = new ArrayList<String>();

		names.add("Manish");
		names.add("Anand");
		names.add("Soni");
		names.add("Aryan");
		names.add("Ajay");

		// Count the number of names starts with alphabet A using java stream concept

		long counts = names.stream().filter(s -> s.startsWith("A")).count();

		System.out.println(counts);

	}

}
