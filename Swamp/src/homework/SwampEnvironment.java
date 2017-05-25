package homework;

import java.util.ArrayList;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.Agent;
import aima.core.agent.EnvironmentState;
import aima.core.agent.Percept;
import aima.core.agent.impl.AbstractEnvironment;
import aima.core.agent.impl.DynamicAction;

public class SwampEnvironment extends AbstractEnvironment{
	Swamp swampBoard;
	SwampWithMud swampWithMud;
	SwampState currentState;
	SwampEnvironmentState environmentState;
	
	
	public static List<Action> INITIALACTIONS = new ArrayList<Action>();

	public static Action LEFT = new DynamicAction("Left");
	public static Action RIGHT = new DynamicAction("Right");

	public static Action UP = new DynamicAction("Up");
	public static Action DOWN = new DynamicAction("Down");
	
	public static Action LEFTUP = new DynamicAction("Left Up");
	public static Action RIGHTUP = new DynamicAction("Right Up");

	public static Action LEFTDOWN = new DynamicAction("Left Down");
	public static Action RIGHTDOWN = new DynamicAction("Right Down");
	
	
	
	public SwampEnvironment(Swamp board){
		if(board.getClass().equals(SwampWithMud.class)){
			swampWithMud = (SwampWithMud)board;
		}
		swampBoard = board;
		//currentState = new SwampState(this, -1,-1);
	}
	
	public SwampEnvironment(SwampState s){
		currentState = s;
		swampBoard = s.getBoard();
	}
	
	
	public SwampState getInitialState(){
		SwampState initial = new SwampState(this,-1,-1);
		return initial;
	}
	
	
	@Override
	public EnvironmentState getCurrentState() {
		return environmentState;
	}

	@Override
	public EnvironmentState executeAction(Agent agent, Action action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Percept getPerceptSeenBy(Agent anAgent) {
		// TODO Auto-generated method stub
		return null;
	}

	public Swamp getBoard() {
		return swampBoard;
	}
	
	public SwampWithMud getBoardWM(){
		return swampWithMud;
	}
	
	
	public SwampState getCurrentStateAgent(){
		return currentState;
	}
	
	public void setCurrentStateAgent(SwampState s){
		currentState = s;
	}
	
	
	
	
	
	
	
	public SwampEnvironmentState getEnvState(){
		return environmentState;
	}
	
	public void setEnvState(SwampEnvironmentState es){
		environmentState = es;
	}
	
	
	public void moveAgentRight(){
		SwampState parent = currentState;
		currentState = environmentState.getStateAtXY(currentState.getRow(),currentState.getColumn()+1);
		currentState.addParent(parent);
	}
	
	public void moveAgentLeft(){
		SwampState parent = currentState;
		currentState = environmentState.getStateAtXY(currentState.getRow(),currentState.getColumn()-1);
		currentState.addParent(parent);

	}
	
	public void moveAgentUp(){
		SwampState parent = currentState;
		currentState = environmentState.getStateAtXY(currentState.getRow()-1, currentState.getColumn());
		currentState.addParent(parent);

	}
	
	public void moveAgentDown(){
		SwampState parent = currentState;
		currentState = environmentState.getStateAtXY(currentState.getRow()+1, currentState.getColumn());
		currentState.addParent(parent);
	}
	
	public void moveAgentRightUp(){
		SwampState parent = currentState;
		currentState = environmentState.getStateAtXY(currentState.getRow()-1, currentState.getColumn()+1);
		currentState.addParent(parent);
	}
	
	public void moveAgentRightDown(){
		SwampState parent = currentState;
		currentState = environmentState.getStateAtXY(currentState.getRow()+1, currentState.getColumn()+1);
		currentState.addParent(parent);
	}
	
	public void moveAgentLeftUp(){
		SwampState parent = currentState;
		currentState = environmentState.getStateAtXY(currentState.getRow()-1, currentState.getColumn()-1);
		currentState.addParent(parent);
	}
	
	public void moveAgentLeftDown(){
		SwampState parent = currentState;
		currentState = environmentState.getStateAtXY(currentState.getRow()+1, currentState.getColumn()-1);
		currentState.addParent(parent);
	}
	
	
	
	public void moveAtFirstState(int r, int c){
		currentState = environmentState.getStateAtXY(r,c);
	}
	
	
	public List<SwampState> getInitialStates(SwampEnvironment swamp){
		List<SwampState> initials = new ArrayList<SwampState>();
		int rows = swamp.getBoard().getRows();
		for(int i=0; i<rows; i++){
			if(swamp.getBoard().land(i,0)){
				SwampState s = environmentState.getStateAtXY(i,0);
				initials.add(s);
			}
		}
		return initials;
	}
	
	
	
	public boolean canMoveAgent(Action where){
		//System.out.println("STATO CORRENTE: " + currentState);
		
		if (where.equals(LEFT)){
				try{
					return environmentState.getStates()[currentState.getRow()][currentState.getColumn()-1] != null;
				}
				catch(Exception e){
					return false;
				}
			}
			else if (where.equals(RIGHT)){
				try{
					return environmentState.getStates()[currentState.getRow()][currentState.getColumn()+1] != null;
				}
				catch(Exception e){
					return false;
				}			}
			else if (where.equals(UP)){
				try{
					return environmentState.getStates()[currentState.getRow()-1][currentState.getColumn()] != null;
				}
				catch(Exception e){
					return false;
				}			}
			else if (where.equals(DOWN)){
				try{
					return environmentState.getStates()[currentState.getRow()+1][currentState.getColumn()] != null;
				}
				catch(Exception e){
					return false;
				}
			}
			else if (where.equals(RIGHTUP)){
				try{
					return environmentState.getStates()[currentState.getRow()-1][currentState.getColumn()+1] != null;
				}
				catch(Exception e){
					return false;
				}
			}	
			else if (where.equals(LEFTUP)){
				try{
					return environmentState.getStates()[currentState.getRow()-1][currentState.getColumn()-1] != null;
				}
				catch(Exception e){
					return false;
				}
			}
			else if (where.equals(RIGHTDOWN)){
				try{
					return environmentState.getStates()[currentState.getRow()+1][currentState.getColumn()+1] != null;
				}
				catch(Exception e){
					return false;
				}
			}
			else if (where.equals(LEFTDOWN)){
				try{
					return environmentState.getStates()[currentState.getRow()+1][currentState.getColumn()-1] != null;
				}
				catch(Exception e){
					return false;
				}
			}
				
			else return false;
	}
	
	public void addInitialAction(DynamicAction a){
		INITIALACTIONS.add(a);
	}
	
	
}