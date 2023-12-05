package day3Challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	
    public final static HashMap<Character,Integer> priorities = new HashMap<Character,Integer>();
    
    static {
    	setPriorities();
    }
	
	public static void main (String[] args) {
		System.out.println(priorities);
		
		String rucsack1 = "vJrwpWtwJgWrhcsFMMfFFhFp";
		String rucsack2 = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL";
		String rucsack3 = "PmmdzqPrVvPwwTWBwg";
		String rucsack4 = "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn";
		String rucsack5 = "ttgJtRGJQctTZtZT";
		String rucsack6 = "CrZsJsPPZsGzwwsLwLmpwMDw";

		List<Character> items= new ArrayList<>();
	//	String rucsack = "ttgJtRGJQctTZtZT";
		items.addAll(commonItems(rucsack1));
		items.addAll(commonItems(rucsack2));
		items.addAll(commonItems(rucsack3));
		items.addAll(commonItems(rucsack4));
		items.addAll(commonItems(rucsack5));
		items.addAll(commonItems(rucsack6));
	//System.out.println(commonItems(rucsack1));
		System.out.println("Common items are "+items);
		System.out.println("Sum of priorities is " +  sumPriorities(items));
				
	}
	
	public static int sumPriorities(List<Character> chars) {
		int sum = 0;
		for (char x : chars){
			sum += priorities.get(x);
		}
		return sum;
		
	}
	
	public static void setPriorities() {
		int priority = 0;
		for(char ch='a'; ch <= 'z';ch++) {
			priority++;
			priorities.put(ch, priority);
			
		}
		
		for(char ch='A'; ch <= 'Z';ch++) {
			priority++;
			priorities.put(ch, priority);
			
		}
		
	}
	
	
	public static List<Character> convertStringToCharList(String str){
		List<Character> chars = new ArrayList<Character>();
		
		for(char ch:str.toCharArray()) {
			chars.add(ch);
		}
		return chars;
		
	}

	public static Set commonItems(String rucsack) {

		int len = rucsack.length();

		Set<Character> set = new HashSet<Character>(Set.copyOf(convertStringToCharList(rucsack)));
//			Set<String> set1 = new HashSet<String> ( Set.copyOf(Arrays.asList(rucsack.substring(0, rucsack.length()/2))));
		Set<Character> set1 = new HashSet<Character>(
				Set.copyOf(convertStringToCharList(rucsack.substring(0, rucsack.length() / 2))));
//			Set<String> set2 =  new HashSet<String> ( Set.copyOf(Arrays.asList(rucsack.substring(rucsack.length()/2, rucsack.length()))
		Set<Character> set2 = new HashSet<Character>(
				Set.copyOf(convertStringToCharList(rucsack.substring(rucsack.length() / 2, rucsack.length()))));

		// Set<String> set1_copy = Set.copyOf(set1);
		System.out.println(set1);
		System.out.println(set2);
		set2.retainAll(set1);

	//	System.out.println(set2);
		return set2;

	}

}
