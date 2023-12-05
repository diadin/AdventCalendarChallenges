package adventDay1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calibration {

	public static int getCalibration(String filename, String method) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
		int calibration = 0;
		while (sc.hasNext()) {
			String aString = sc.next();
			calibration += getCalibrationline(aString, method);
		}
		return calibration;
	}
	
	public static String transform(String s) {
		String newString = new String(s);
		String [] words = {"one","two","three","four","five","six","seven","eight","nine"};
		int[]  indexes = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 
				Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
		int minimIndex = Integer.MAX_VALUE;
		int value = 0;
		for (int i=0; i< words.length; i++) {
			indexes[i] = newString.indexOf(words[i]);//returns -1 if not found
			if (indexes[i] >=0){
			   minimIndex= Math.min(minimIndex, indexes[i]);
			   if (minimIndex == indexes[i])
			           value = i;
			}
		}
		if (minimIndex< Integer.MAX_VALUE) {
	     	newString = newString.replace(words[value], String.valueOf(value+1));
	     	newString = transform(newString);
		}

		return newString;
	}

	public static int getCalibrationline(String ss, String method) {
		String s = ss;
		if (method.contentEquals("2")) {
	         s = transform(ss);	
		}

	//	String s = ss;
		
		int calibration = 0;
		
		char[] array = s.toCharArray();

		if (array == null && array.length < 2)
			return 0;

		List<Character> digits = new ArrayList<Character>();

		for (int i = 0; i < array.length; i++) {
			if (Character.isDigit(array[i])) {
				digits.add(array[i]);
			}
		}
		if (digits.size() ==0)
			return 0;

		String calibration2 = Character.getNumericValue(digits.get(0)) + ""
				+ Character.getNumericValue(digits.get(digits.size() - 1));
		calibration = Integer.valueOf(calibration2);
	//	System.out.println(ss+ " > getCalibration(" + s + ") =" + calibration2);
		return calibration;
	}

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("-- First day, part 1 --");
		System.out.println(getCalibration("src/adventDay1/sample1.txt",/*method */"1"));
		System.out.println(getCalibration("src/adventDay1/input.txt",/*method */"1"));
		System.out.println("-- First day, part 2 --");
		System.out.println(getCalibration("src/adventDay1/sample2.txt",/*method */"2"));
		System.out.println(getCalibration("src/adventDay1/input.txt",/*method */"2"));

	}

}
