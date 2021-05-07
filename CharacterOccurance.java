package week3.day2.assignments;

import java.util.HashMap;
import java.util.Map;

public class CharacterOccurance {

	public static void main(String[] args) {
		String input="welcome to Selenium automation";
		char[] c=input.toCharArray();
		
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(char ch:c)
		{
			if(map.containsKey(ch)) {
				map.put(ch,map.get(ch)+1);
			}else
			{
				map.put(ch, 1);
			}
		}
		System.out.println(map);
	}

}
