package homework;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.ActionsFunction;
import aima.core.search.framework.ResultFunction;


public class SwampFunctionFactory {
	private static ActionsFunction _actionsFunction = null;
	private static ResultFunction _resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == _actionsFunction) {
			_actionsFunction = new SwampActionsFunction();
		}
		return _actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == _resultFunction) {
			_resultFunction = new SwampResultFunction();
		}
		return _resultFunction;
	}

	private static class SwampActionsFunction implements ActionsFunction {
		
		public Set<Action> actions(Object state) {
			if(state == null){
				return new LinkedHashSet<Action>();
			}
			
			
			SwampState currentstate = (SwampState) state;
			Set<Action> actions = new LinkedHashSet<Action>();
			SwampEnvironmentState cs = currentstate.getEnvironment().getEnvState();
			
			SwampEnvironment currentState = new SwampEnvironment(currentstate);
			currentState.setEnvState(cs);

			//SwampEnvironment currentState = currentstate.getEnvironment();	
			
			
			//manage the initial state
			if(currentstate.getRow()==-1 && currentstate.getColumn()==-1){
				for(SwampState s : currentState.getInitialStates(currentState)){
					if(s == null){
						return new LinkedHashSet<Action>();
					}
					ActionOfAgent action = new ActionOfAgent("First Action " + s.getRow(), s.getRow(),s.getColumn());
					currentState.addInitialAction(action);
					actions.add(action);
				}				
				return actions;
			}
			
			
			
			if (currentState.canMoveAgent(SwampEnvironment.UP)) {
				actions.add(SwampEnvironment.UP);
			}
			if (currentState.canMoveAgent(SwampEnvironment.DOWN)) {
				actions.add(SwampEnvironment.DOWN);
			}
			if (currentState.canMoveAgent(SwampEnvironment.LEFT)) {
				actions.add(SwampEnvironment.LEFT);
			}
			if (currentState.canMoveAgent(SwampEnvironment.RIGHT)) {
				actions.add(SwampEnvironment.RIGHT);
			}
			if (currentState.canMoveAgent(SwampEnvironment.LEFTUP)) {
				actions.add(SwampEnvironment.LEFTUP);
			}
			if (currentState.canMoveAgent(SwampEnvironment.RIGHTUP)) {
				actions.add(SwampEnvironment.RIGHTUP);
			}
			if (currentState.canMoveAgent(SwampEnvironment.LEFTDOWN)) {
				actions.add(SwampEnvironment.LEFTDOWN);
			}
			if (currentState.canMoveAgent(SwampEnvironment.RIGHTDOWN)) {
				actions.add(SwampEnvironment.RIGHTDOWN);
			}
			//System.out.println("state: "+ currentState.getCurrentStateAgent().getRow() + " "+ currentState.getCurrentStateAgent().getColumn());
			//System.out.println("List of Actions: " + actions); 
			return actions;
		}
	}

	private static class SwampResultFunction implements ResultFunction {
		
		public Object result(Object s, Action a) {
			SwampState currentstate = (SwampState) s;
			SwampEnvironmentState envState = currentstate.getEnvironment().getEnvState();
			
			SwampEnvironment currentEnv = new SwampEnvironment(currentstate);
			currentEnv.setEnvState(envState);

			
			if(SwampEnvironment.INITIALACTIONS.contains(a)){
				currentEnv.moveAtFirstState(((ActionOfAgent)a).getRow(), ((ActionOfAgent)a).getCol());
				//System.out.println("first states: " + currentEnv.getCurrentStateAgent());
				return currentEnv.getCurrentStateAgent();
			}
			if (SwampEnvironment.UP.equals(a)
					&& currentEnv.canMoveAgent(SwampEnvironment.UP)) {
				currentEnv.moveAgentUp();
				return currentEnv.getCurrentStateAgent();
			} else if (SwampEnvironment.DOWN.equals(a)
					&& currentEnv.canMoveAgent(SwampEnvironment.DOWN)) {
				currentEnv.moveAgentDown();
				return currentEnv.getCurrentStateAgent();
			} else if (SwampEnvironment.LEFT.equals(a)
					&& currentEnv.canMoveAgent(SwampEnvironment.LEFT)) {
				currentEnv.moveAgentLeft();
				return currentEnv.getCurrentStateAgent();
			} else if (SwampEnvironment.RIGHT.equals(a)
					&& currentEnv.canMoveAgent(SwampEnvironment.RIGHT)) {
				currentEnv.moveAgentRight();
				return currentEnv.getCurrentStateAgent();
			} else if (SwampEnvironment.LEFTUP.equals(a)
					&& currentEnv.canMoveAgent(SwampEnvironment.LEFTUP)) {
				currentEnv.moveAgentLeftUp();
				return currentEnv.getCurrentStateAgent();
			} else if (SwampEnvironment.RIGHTUP.equals(a)
					&& currentEnv.canMoveAgent(SwampEnvironment.RIGHTUP)) {
				currentEnv.moveAgentRightUp();
				return currentEnv.getCurrentStateAgent();
			} else if (SwampEnvironment.LEFTDOWN.equals(a)
					&& currentEnv.canMoveAgent(SwampEnvironment.LEFTDOWN)) {
				currentEnv.moveAgentLeftDown();
				return currentEnv.getCurrentStateAgent();
			} else if (SwampEnvironment.RIGHTDOWN.equals(a)
					&& currentEnv.canMoveAgent(SwampEnvironment.RIGHTDOWN)) {
				currentEnv.moveAgentRightDown();
				return currentEnv.getCurrentStateAgent();
			}

			// The Action is not understood or is a NoOp
			// the result will be the current state.
			return s;
		}
	}
}