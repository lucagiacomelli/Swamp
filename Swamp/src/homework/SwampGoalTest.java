package homework;

import java.util.ArrayList;
import java.util.List;
import aima.core.search.framework.GoalTest;

public class SwampGoalTest implements GoalTest{
	Swamp swamp;
	List<SwampState> goals = new ArrayList<SwampState>();
	SwampEnvironment environment;
	
	private static boolean finito = false;
	
	//import the number of rows and columns for adding GoalStates to environments
	
	public SwampGoalTest(SwampEnvironment s){
		environment = s;
		for(int i=0; i<s.getBoard().getRows(); i++){
			if(s.getBoard().land(i,  s.getBoard().getCols()-1)){
				SwampState se = new SwampState(s,i, s.getBoard().getCols()-1);
				goals.add(se);
			}
		}
	}
	
	public boolean getFinito(){
		return finito;
	}
	
	public static void setFinito(boolean f){
		finito = f;
	}
	
	@Override
	public boolean isGoalState(Object state) {
		SwampState State = (SwampState)state;
		
		for(SwampState se: goals){
			if(State.equals(se)){
				//System.out.println("final state: "+State.getRow()+" "+ State.getColumn());
				return true;
			}
		}
		
		if(State.getRow() != -1 && State.getColumn() != -1){
			short actions = State.getEnvironment().getEnvState().getActionAtXY(State.getRow(), State.getColumn());
			
			if(!finito){
				if(State.getParents().size() == actions){
					State.getEnvironment().getEnvState().setStateNull(State.getRow(), State.getColumn());
				}
			} 
		}		
		return false;
	}
	
	public List<SwampState> getGoalStates(){
		return goals;
	}

}
