package homework;

public class Swamp
{
	private boolean[][] swamp;
	
	
	//private int [][] swampWithMud;

	public Swamp(int rows, int cols, double probLand)
	{	
		swamp = new boolean[rows][cols];
		//swampWithMud = new int[rows][cols];

		
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++) swamp[r][c] = (Math.random() < probLand);
		}
	}
	
	public int getCols()
	{
		return swamp[0].length;
	}
	
	public int getRows()
	{
		return swamp.length;
	}
	
	public boolean land(int r, int c)
	{
		return (r >= 0) && (r < swamp.length) && (c >= 0) && (c < swamp[0].length) && swamp[r][c];
	}
	
	public boolean[][] getBoard(){
		return swamp;
	}
	
	
	public String toString()
	{
		String ris = "Swamp:\n";
		
		for (int r = 0; r < swamp.length; r++)
		{
			ris += "    ";
			
			for (int c = 0; c < swamp[0].length; c++) ris += (swamp[r][c] ? "* " : "o ");
			
			ris += "\n";
		}
		
		return ris;
	}
	
}

