package week3.day2.assignments;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {

		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
//		Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		

//		get the length of the array		
		int length=input.length;
		System.out.println(length);

//		sort the array	
		
		List<String> lst=new ArrayList<String>();
		for(int i=0;i<=length-1;i++)
		{
		lst.add(input[i]);
		}
		Collections.sort(lst);
		System.out.println("Sort list:"+lst);

//		Iterate it in the reverse order
		
		for(int j=length-1;j>=0;j--)
		{
//			print the array		
//			Required Output: Wipro, HCL , CTS, Aspire Systems
			System.out.println("Reverse order: " +lst.get(j));
		}
		
	

		

	}

}
