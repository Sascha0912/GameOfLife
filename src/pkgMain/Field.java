package pkgMain;

import java.awt.Color;
import java.util.Random;

public class Field
{

	boolean[][] field;
	Zeichenblatt z;

	public Field(int rows, int columns)
	{

		this.field = new boolean[rows][columns];
		z = new Zeichenblatt(600, 600);
		z.benutzerkoordinaten(0, 0, 20, 20);

		z.setHintergrundFarbe(Color.WHITE);
		z.setVordergrundFarbe(Color.BLACK);

	}

	public Field(int rows, int columns, boolean[][] field)
	{

		this.field = new boolean[rows][columns];

		for (int i = 0; i < field.length; i++)
		{

			for (int j = 0; j < field[i].length; j++)
			{

				this.field[i][j] = field[i][j];
			}

		}
	}

	public void fill()
	{

		Random random = new Random();

		for (int i = 0; i < field.length; i++)
		{

			for (int j = 0; j < field[i].length; j++)
			{

				if (random.nextInt(2) == 1)
				{
					field[i][j] = true;
				}
			}

		}
	}

	public void step()
	{

		boolean[][] help = new boolean[field.length][field[0].length];

		for (int i = 0; i < field.length; i++)
		{

			for (int j = 0; j < field[i].length; j++)
			{

				help[i][j] = field[i][j];
			}

		}

		for (int i = 0; i < field.length; i++)
		{

			for (int j = 0; j < field[i].length; j++)
			{

				int neighbors = 0;

				if (field[Math.floorMod(i - 1, field.length)][j])
				{
					neighbors++;
				}
				if (field[Math.floorMod(i + 1, field.length)][j])
				{
					neighbors++;
				}
				if (field[Math.floorMod(i - 1, field.length)][Math.floorMod(j - 1, field[i].length)])
				{
					neighbors++;
				}
				if (field[Math.floorMod(i + 1, field.length)][Math.floorMod(j - 1, field[i].length)])
				{
					neighbors++;
				}
				if (field[Math.floorMod(i - 1, field.length)][Math.floorMod(j + 1, field[i].length)])
				{
					neighbors++;
				}
				if (field[Math.floorMod(i + 1, field.length)][Math.floorMod(j + 1, field[i].length)])
				{
					neighbors++;
				}
				if (field[i][Math.floorMod(j - 1, field[i].length)])
				{
					neighbors++;
				}
				if (field[i][Math.floorMod(j + 1, field[i].length)])
				{
					neighbors++;
				}

				// live or die

				if (neighbors < 2 && field[i][j])
				{
					help[i][j] = false; // 1)

				}
				else if (neighbors > 3 && field[i][j])
				{
					help[i][j] = false; // 3)

				}
				else if (neighbors == 3 && !field[i][j])
				{
					help[i][j] = true; // 4)

				}

			}

		}

		for (int i = 0; i < field.length; i++)
		{

			for (int j = 0; j < field[i].length; j++)
			{

				field[i][j] = help[i][j];
			}

		}

	}

	public void display()
	{
		int x = 19;
		int y = 19;

		for (int i = 0; i < field.length; i++)
		{
			x = 0;
			for (int j = 0; j < field[i].length; j++)
			{

				if (field[i][j])
				{
					z.rechteck(x, y, 1.0, 1.0);
					z.anzeigen();
					z.pause(1);
				}
				else
				{
					// nichts malen
				}
				x++;
			}
			y--;
		}

	}

}
