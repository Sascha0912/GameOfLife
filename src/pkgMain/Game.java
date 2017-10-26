package pkgMain;

import java.util.Arrays;

public class Game
{
	public static void log(String str)
	{
		System.out.println(str);
	}

	public static void main(String[] args)
	{
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("Bitte Zeilen eingeben:"); int rows =
		 * sc.nextInt(); System.out.println("Bitte Spalten eingeben:"); int
		 * columns = sc.nextInt(); sc.close(); final long timeStart =
		 * System.currentTimeMillis();
		 */
		final long timeStart = System.currentTimeMillis();
		Field f = new Field(20, 20);
		f.fill();
		f.display();
		boolean[][] b = null;
		while (!Arrays.equals(f.field, b))
		{
			log("done");
			b = f.field.clone();
			f.step();
			f.display();

		}
		final long timeEnd = System.currentTimeMillis();
		System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Millisek.");

	}

}
