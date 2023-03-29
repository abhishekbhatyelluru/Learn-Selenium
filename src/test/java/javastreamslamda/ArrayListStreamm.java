//116

package javastreamslamda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.util.Strings;

public class ArrayListStreamm {
	
	@Test(priority = 1)
	public void normal()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhi");
		names.add("Ram");
		names.add("Adi");
		names.add("Adiyogi");
		names.add("sachin");
	    int count=0;
		for(int i=0;i<names.size();i++)
		{
			String actual=names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
		System.out.println("************************");
	}
	
	
	@Test(priority = 2)
	public void streamFilter()
	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhi");
		names.add("Ram");
		names.add("Adi");
		names.add("Adiyogi");
		names.add("sachin");
		
		//Step 1= Convert list into stream
		//Step 2=Use filter
		//Step 3=declare one variable(here "s")
		//Then declare action( here action is s.startsWith("A")) )
		//Last step terminate to get output(Here "count")
		//  -> is a lamda operator 
		Long c=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		//Print the names that have length greater than 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		
		System.out.println("************************");
	}
	
	//Another method
	
	@Test(priority = 3)
	public void streamlist()
	{
		Long c = Stream.of("Abhi","Ram","Adi","Adiyogi","Sachin").filter(s->s.startsWith("A")).count();
		System.out.println(c);
	
		
		System.out.println("************************");
	}
	
	@Test(priority = 4)
	public void streammap()
	{
		//print the name with last letter as "i" with uppercase
		Stream.of("Abhi","Ram","Adi","Adiyogi","Sachin").filter(s->s.endsWith("i")).map(s->s.toUpperCase())
        .forEach(s->System.out.println(s));
		
		System.out.println("************************");
	}
	
	@Test(priority = 5)
	public void streamsort()
	{
		//Print names with start as "a" with uppercase and sorted
		List<String> names =Arrays.asList("Alii","Ram","Abhi","Adiyogi","Sachin");  //storing in array and converting array to list
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		System.out.println("************************");
		
	}
	
	@Test(priority = 6)
	public void streammerge()
	{
		List<String> names1 =Arrays.asList("Alii","Ram","Abhi","Adiyogi","Sachin");
		List<String> names2 =Arrays.asList("men","testing","java","python","dev");
		
		Stream<String> newstream=Stream.concat(names1.stream(), names2.stream());
		newstream.sorted().forEach(s->System.out.println(s));
		
		System.out.println("************************");
		
	}
	
	@Test(priority = 7)
	public void strammatch()
	{
		//Check "java" is present in the list
		List<String> nam =Arrays.asList("men","testing","java","python","dev");
	    Boolean flag =	nam.stream().anyMatch(s->s.equalsIgnoreCase("java"));
	    Assert.assertTrue(flag);
	    System.out.println("************************");
	}
	@Test(priority = 8)
	public void streamcollect()
	{
		//converting the stream output to the list
		List<String> name =Arrays.asList("men","testing","java","python","dev");
	    List<String> ls = name.stream().map(s->s.toUpperCase()).collect(Collectors.toList()); 
		System.out.println(ls.get(0));
		
		
		System.out.println("************************");
	}
	
	@Test(priority = 9)
	public void streamunique()
	{
		//Print the unique value in this array and sort the array
		List<Integer> intlist=Arrays.asList(3,2,2,5,7,8,9,8,6);
		intlist.stream().distinct().forEach(s->System.out.println(s));  
		//"forEach" is used to print all the elements
		//If we need to print perticular element then use "collector" and convert to list and print
		
		System.out.println("......");
		
		//Printing the third element
		List<Integer> sortlist = intlist.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortlist.get(2));
		
		System.out.println("************************");
	}

}

