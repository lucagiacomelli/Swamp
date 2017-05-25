package homework;

import java.util.HashSet;
import java.util.Set;

import aima.core.agent.State;

public class SwampState implements State{

	private int row;
	private int column;
	private Swamp board;
	private SwampEnvironment environment;
	private int azioniIniziali=5;
	
	private Set<SwampState> parents;
	
	
	private SwampWithMud boardWM;
	
	public SwampState(SwampEnvironment b, int r, int c){
		if(b.getClass().equals(SwampWithMud.class)){
			boardWM = (SwampWithMud)b.getBoard();
		}
		environment = b;
		board = b.getBoard();
		row = r;
		column = c;
		parents = new HashSet<SwampState>();
		
		
	}
	
	
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			SwampState s = (SwampState)o;
			if(s.getBoard().getClass().equals(SwampWithMud.class)){
				
				//System.out.println("Sono in Swamp With Mud!!!");
				return this.getEnvironment().equals(s.getEnvironment()) &&
						this.getColumn()== s.getColumn() && this.getRow()==s.getRow();
			}
			return this.getEnvironment().equals(s.getEnvironment()) && 
					this.getColumn()== s.getColumn() && this.getRow()==s.getRow();
		}
		return false;
	}
	
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	
	
	public Swamp getBoard(){
		return board;
	}
	
	
	
	public SwampWithMud getBoardWM(){
		return boardWM;
	}
	
	
	public SwampEnvironment getEnvironment(){
		return environment;
	}
	
	
	public Set<SwampState> getParents(){
		return parents;
	}
	
	public void addParent(SwampState s){
		parents.add(s);
	}
	
	
	
	public int getInitialActions(){
		return azioniIniziali;
	}
	
	
	public String toString(){
		return this.getRow() + " " + this.getColumn();
	}

}
