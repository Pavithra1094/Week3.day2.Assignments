package week3.day2.assignments;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ReverseMap {

	public static void main(String[] args) {
		
		Map<Integer, String> Employee = new TreeMap<Integer,String>(Collections.reverseOrder());
		Employee.put(100, "Hari");
		Employee.put(101,"Naveen");
		Employee.put(102, "Sam");
		Employee.put(104, "Balaji");
		
		System.out.println(Employee.size());
		
		System.out.println(Employee);
	}

}