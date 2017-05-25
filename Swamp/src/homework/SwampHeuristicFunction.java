package homework;

import aima.core.search.framework.HeuristicFunction;

public class SwampHeuristicFunction implements HeuristicFunction{

	
	@Override
	public double h(Object state) {
		SwampState currentState = (SwampState) state;
		int retVal = 0;
		retVal = currentState.getBoard().getCols() - currentState.getColumn();
	
		return retVal;
	}
	

	
	/*
	public double h(Object state) {
		SwampState currentState = (SwampState) state;
		int retVal = 0;
		retVal = currentState.getEnvironment().getBoard().getCols() - currentState.getColumn();
	
		return retVal;
	}
	
	*/
	
	/*
	public double h(Object state) {
		EightPuzzleBoard board = (EightPuzzleBoard) state;
		int retVal = 0;
		for (int i = 1; i < 9; i++) {
			XYLocation loc = board.getLocationOf(i);
			retVal += evaluateManhattanDistanceOf(i, loc);
		}
		return retVal;

	}
	*/
}
