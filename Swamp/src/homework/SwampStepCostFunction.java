package homework;

import aima.core.agent.Action;
import aima.core.search.framework.StepCostFunction;

public class SwampStepCostFunction implements StepCostFunction{

	
	@Override
	public double c(Object s, Action a, Object sDelta) {
		
		int retVal = 1;
		SwampState successorState = (SwampState)sDelta;
		if(successorState.getBoard().getClass().equals(SwampWithMud.class)){
			if(successorState.getRow() == -1 && successorState.getColumn() == -1){
				retVal = 1;
			}
			else if(successorState.getEnvironment().getBoardWM().isMud(successorState.getRow(), successorState.getColumn())){
				//System.out.println("-------------INCONTRATO UN MUD---------");
				retVal = 5;
			}
			else if(successorState.getEnvironment().getBoardWM().landNoMud(successorState.getRow(), successorState.getColumn())){
				retVal = 1;
			}
		}	
		return retVal;
	}
}
