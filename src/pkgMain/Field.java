package pkgMain;

import java.util.Random;

public class Field
{

	boolean[][] field;

	public Field(int rows, int columns)
	{

		this.field = new boolean[rows][columns];
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

	/*
	 * public void fillBlinkerSechsMalSechs() { field[0][0] = false; field[0][1]
	 * = false; field[0][2] = false; field[0][3] = false; field[0][4] = false;
	 * field[0][5] = false; field[1][0] = false; field[1][1] = true; field[1][2]
	 * = true; field[1][3] = false; field[1][4] = false; field[1][5] = false;
	 * field[2][0] = false; field[2][1] = true; field[2][2] = true; field[2][3]
	 * = false; field[2][4] = false; field[2][5] = false; field[3][0] = false;
	 * field[3][1] = false; field[3][2] = false; field[3][3] = true; field[3][4]
	 * = true; field[3][5] = false; field[4][0] = false; field[4][1] = false;
	 * field[4][2] = false; field[4][3] = true; field[4][4] = true; field[4][5]
	 * = false; field[5][0] = false; field[5][1] = false; field[5][2] = false;
	 * field[5][3] = false; field[5][4] = false; field[5][5] = false; }
	 */
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
				else if ((neighbors == 2 || neighbors == 3) && field[i][j])
				{
					// continue living // 2)

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

		for (int i = 0; i < field.length; i++)
		{

			for (int j = 0; j < field[i].length; j++)
			{

				if (field[i][j])
				{
					System.out.print("O ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("_________________________");
	}

}
