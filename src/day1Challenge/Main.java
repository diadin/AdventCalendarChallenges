package day1Challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> elfs = new ArrayList<Integer>();
				
		// reading from console the array of elfs
		elfs = readElfsList();
		System.out.println("Lista este ");
		elfs.forEach(e -> System.out.println(e+ ";"));
	
		System.out.println("Maximum calories carried by elfs is "+ 	elfs.stream().mapToInt(x->x).max());
		// display the element containg the biggest number

	}

	private static List readElfsList() {
		
		System.out.println("Fill in the calories for each elf!");
		
		List elfs = new ArrayList<Integer>();
		
		Scanner sc = new Scanner (System.in);
//		int calories;
//		String line = "";
//		int sum = 0;
//		int count = 0;
//		System.out.println("delimitator = "+sc.delimiter().toString());
//		
//		while(sc.hasNext() ) {
//			sum = 0;
//			calories = 0;
//		
//			while (sc.hasNextInt()) {
//				calories = sc.nextInt();
//				System.out.println(calories);
//				sum += calories;
//				if (calories =='\n' ||calories.) {
//					System.out.println(calories +" enter ca int");			
//				}
//				else {
//					System.out.println(calories + "element ca int");
//				}
//			}
//			line = sc.next();
//			System.out.println("next character");
//			
//			if ((line.charAt(0) == '\n') || (line.charAt(0) == 'q')) {
//				System.out.println("adding element");
//				elfs.add(sum);
//				count++;
//			}
//
//			if (line.charAt(0) == 'q') break;
//		}
		int calories = 0;
		int sumCalories = 0;
		
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			
			if(!line.isEmpty()) {
			//	System.out.println("linia nu este goala "+line);
//				while (sc.hasNextInt()) {
//			    	calories = sc.nextInt();
//			    	sumCalories += calories;
//				}
				try {
					calories = Integer.parseInt(line);
					sumCalories += calories;
				}
				catch(NumberFormatException e) {
					System.out.println("numberformatexception");
				}
			//	System.out.println("sumCalories "+sumCalories);
				if(line.charAt(0)=='q') {
					if (sumCalories!= 0) {
						   elfs.add(sumCalories);
					}
					break;
				}
			}
			else {
			//	System.out.println("linia este goala");
				if (sumCalories!= 0) {
				   elfs.add(sumCalories);
				   sumCalories = 0 ;
				}
			}
		}
		
	

		sc.close();
		return elfs;
	}

}
