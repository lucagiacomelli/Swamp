package homework;

public class SwampWithMud extends Swamp{
	
	
	private char [][] swampWithMud;
		
	public SwampWithMud(int rows, int cols, double probLand, double probMud) {
		super(rows, cols, probLand);
		swampWithMud = new char[rows][cols];
		
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++) {
				boolean isMud =  (Math.random() < probMud);
				if(super.getBoard()[r][c] && isMud){
					swampWithMud[r][c] = '2';
				}
				else if(super.getBoard()[r][c] && !isMud){
					swampWithMud[r][c] = '1';
				}
				else swampWithMud[r][c] = '0';
			}
		}
	}
	
	
	//create a "Swamp with mud" with the same structure of "Swamp"
	public SwampWithMud(int rows, int cols, double probLand, double probMud, Swamp s) {
		super(rows, cols, probLand);
		swampWithMud = new char[rows][cols];

		
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < cols; c++) {
				boolean isMud =  (Math.random() < probMud);
				if(super.getBoard()[r][c] && isMud){
					swampWithMud[r][c] = '2';
				}
				else if(super.getBoard()[r][c] && !isMud){
					swampWithMud[r][c] = '1';
				}
				else swampWithMud[r][c] = '0';
			}
		}
		
	}
	
	public String printSwamp(){
		return super.toString();
	}
	
	public boolean isMud(int r, int c){
		return swampWithMud[r][c]=='2' ? true : false;
	}
	
	public boolean landNoMud(int r, int c){
		return swampWithMud[r][c]=='1' ? true : false;
	}
	
	
	public String toString()
	{
		String ris = "Swamp with mud:\n";
		
		for (int r = 0; r < swampWithMud.length; r++)
		{
			ris += "    ";
			
			for (int c = 0; c < swampWithMud[0].length; c++) {
				if(swampWithMud[r][c] == '2'){
					ris += "≈ ";	
				}
				else if(swampWithMud[r][c] == '1'){
					ris += "* ";
				}
				else ris += "o "; 

				
			}
			ris += "\n";
		}
		
		return ris;
	}

}
