package pkgMain;

import java.util.Scanner;

public class Game {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte Zeilen eingeben:");
		int rows = sc.nextInt();
		System.out.println("Bitte Spalten eingeben:");
		int columns = sc.nextInt();
		sc.close();
		final long timeStart = System.currentTimeMillis();
		//boolean[][] b = {{true,true,false,false,false},{true,true,false,false,false},{false,false,true,true,false},{false,false,true,true,false},{false,false,false,false,false}};
		Field f = new Field(rows, columns);
		
		//System.out.println(Math.floorMod(0-1, 5));
		
		f.fill();
		f.display();
		f.step();
		f.display();
		f.step();
		f.display();
		f.step();
		f.display();
		f.step();
		f.display();
		
		final long timeEnd = System.currentTimeMillis();
		
		System.out.println("Laufzeit des Algorithmus: " + (timeEnd - timeStart) + " Millisek.");
		
		
	}
	
}
