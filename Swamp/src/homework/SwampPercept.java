package homework;

import aima.core.agent.Percept;

public class SwampPercept implements Percept{
	private int row, column;
	private Swamp swamp;
	
	public SwampPercept(Swamp s, int r, int c){
		swamp = s;
		row = r;
		column = c;
	}
	
	public boolean getLand(){
		return swamp.land(row, column);
	}
}
