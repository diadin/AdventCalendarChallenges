package adventDay2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
	
	static Map<String, Integer> bag = Map.of("red", 12,"green", 13, "blue", 14);
	private static int sumGames;
	private static int minCubes;
	

	//  maximum of balls of each coulour in a game
	public static Hashtable<String,Integer> roundMax = new Hashtable<String,Integer> ();
	
	public static Hashtable<String,Integer> getRoundGame (String inputGame){
		Hashtable<String,Integer> roundmap = new Hashtable<String,Integer>();
		for( String str : inputGame.split(";")) {
		    for (String item:str.trim().split(",")) {
		    	 item = item.trim();
		         Integer cnt = Integer.parseInt(item.replaceAll("[^0-9]", ""));
		         String colour = item.replaceAll("\\d", "").trim();
		     //    System.out.println(item + " > "+ cnt+" >" + colour);
		         roundmap.put(colour, (roundmap.get(colour)==null)? cnt : Math.max(roundmap.get(colour), cnt));
		    }
		}
		return roundmap;
	}
	
	public static boolean isGamePossible(String gamedescription) {
		Map<String,Integer> map = getRoundGame(gamedescription);
		for (String key : map.keySet()) {
	        if (map.get(key)> bag.get(key))
	        	return false;
		}
		return true;
	}
	
	public static int computeMinCubes (String gamedescription) {
		Map<String,Integer> map = getRoundGame(gamedescription);
		int cube = 1;
		for (int value : map.values()) {
	        cube *= value;
		}
	//	System.out.println(">"+cube);
       return cube;
	}
	
	public static void processFile(String filename) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(filename));
	//	int sumGames = 0;
	//	int minCubes = 0;
		boolean isPossible = true;
		while (sc.hasNextLine()) {
			String aString = sc.nextLine();
			String gameName =  aString.split(":")[0].trim();
			String gameDescription =  aString.split(":")[1].trim();
		//	System.out.println(gameName.replaceAll("[^0-9]", ""));
			if (isGamePossible(gameDescription)) {
				sumGames += Integer.parseInt(gameName.replaceAll("[^0-9]", ""));				
			}
			minCubes += computeMinCubes(gameDescription);
			
		}
		sc.close();
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		processFile("src/adventDay2/input.txt");
        System.out.println("sumGames = "+ sumGames);
        System.out.println("minCubes = "+ minCubes);
	}

}
