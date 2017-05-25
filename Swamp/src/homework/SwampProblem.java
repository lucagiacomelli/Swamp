package homework;

import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.State;
import aima.core.search.framework.GoalTest;
import aima.core.search.framework.Problem;
import aima.core.search.framework.ResultFunction;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): page 66.<br>
 * <br>
 * A problem can be defined formally by five components: <br>
 * <ul>
 * <li>The <b>initial state</b> that the agent starts in.</li>
 * <li>A description of the possible <b>actions</b> available to the agent.
 * Given a particular state s, ACTIONS(s) returns the set of actions that can be
 * executed in s.</li>
 * <li>A description of what each action does; the formal name for this is the
 * <b>transition model, specified by a function RESULT(s, a) that returns the
 * state that results from doing action a in state s.</b></li>
 * <li>The <b>goal test</b>, which determines whether a given state is a goal
 * state.</li>
 * <li>A <b>path cost</b> function that assigns a numeric cost to each path. The
 * problem-solving agent chooses a cost function that reflects its own
 * performance measure. The <b>step cost</b> of taking action a in state s to
 * reach state s' is denoted by c(s,a,s')</li>
 * </ul>
 */

public class SwampProblem extends Problem{
	private State initialState;
	private List<Action> listActions;
	private ResultFunction resultFunction;
	private GoalTest goalTest;
	
	
	public SwampProblem(State iS, List<Action> lista, ResultFunction rf, GoalTest gt){
		initialState = iS;
		listActions = lista;
		resultFunction = rf;
		goalTest = gt;
	}
	
	
	public State getInitialState(){
		return initialState;
	}
	
	public List<Action> getListActions(){
		return listActions;
	}
	
	public ResultFunction getResultFunction(){
		return resultFunction;
	}
	
	public GoalTest getGoalTest(){
		return goalTest;
	}
	
	
}
