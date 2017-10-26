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
		final long timeStart = System.currentTimeMillis();
		Field f = new Field(20, 20);
		f.fill();
		f.display();
		boolean[][] b = new boolean[20][20];
		while (!Arrays.equals(f.field, b))
		{
			log("done");
			for (int i = 0; i < b.length; i++)
			{
				for (int j = 0; j < b[i].length; j++)
				{
					b[i][j] = f.field[i][j];
				}
			}
			f.step();
			f.display();
		}
		final long timeEnd = System.currentTimeMillis();
		System.out.println("Laufzeit: " + (timeEnd - timeStart) + " Millisek.");

	}

	public static boolean areAllTrue(boolean[] array)
	{
		for (boolean b : array)
			if (!b)
				return false;
		return true;
	}
}
