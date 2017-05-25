package homework;

import java.util.HashSet;
import java.util.Set;

import aima.core.agent.EnvironmentState;

public class SwampEnvironmentState implements EnvironmentState{
	
	private SwampEnvironment swamp;
	private Set<SwampState> esplorati;
	SwampState [][] states;
	private short[][] actions;
		
	public SwampEnvironmentState(SwampEnvironment s){
		swamp = s;
		esplorati = new HashSet<SwampState>();
		states = new SwampState[s.getBoard().getRows()][s.getBoard().getCols()];
		actions = new short[states.length][states[0].length];
		
		for(int i=0; i<states.length; i++){
			for(int j=0; j<states[0].length; j++){
				
				if(s.getBoard().land(i, j)){
					states[i][j] = new SwampState(s, i,j);
				}
				else{
					states[i][j] = null;
				}
			}
		}
	}
	
	public SwampState[][] getStates(){
		return states;
	}
	
	public void setStateNull(int r, int c){
		states[r][c] = null;

		//System.out.println("--------settato stato nullo------");
		//System.out.println(printStates());
	}
	
	public String printStates(){
		String res = "";
		for(int i=0; i<states.length; i++){
			for(int j=0; j<states[0].length; j++){
				if(states[i][j] == null){
					res += "--  ";
				}
				else{
					res += states[i][j].toString() + "  ";
				}
			}
			res += "\n";
		}
		return res;
	}
	
	
	public String printActions(){
		String res = "";
		for(int i=0; i<states.length; i++){
			for(int j=0; j<states[0].length; j++){
				res += (short)SwampFunctionFactory.getActionsFunction().actions(states[i][j]).size() + " ";
				actions[i][j] = (short)SwampFunctionFactory.getActionsFunction().actions(states[i][j]).size();
			}
			res += "\n";
		}
		return res;
	}
	
	
	
	
	
	
	public SwampState getStateAtXY(int r, int c){
		if(r >= states.length || c >= states[0].length){
			System.out.println("ERRORE: INDICI FUORI DAI LIMITI");
			return null;
		}
		return states[r][c];
	}
	
	public short getActionAtXY(int r, int c){
		return actions[r][c];
	}
	
	
	public Set<SwampState> getExplored(){
		return esplorati;
	}
	
	public Swamp getBoard(){
		return swamp.getBoard();
	}
	
	
}
