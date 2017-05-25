package homework;

import homework.gui.SwampFrame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;
import aima.core.search.framework.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;



public class Main
{
		
	/** List of supported search algorithm names. */
	public static List<String> SEARCH_NAMES = new ArrayList<String>();
	/** List of supported search algorithms. */
	public static List<Search> SEARCH_ALGOS = new ArrayList<Search>();
	
	public static void addSearchAlgorithm(String name, Search algo) {
		SEARCH_NAMES.add(name);
		SEARCH_ALGOS.add(algo);
	}

	static {
		addSearchAlgorithm("Iterative Deepening Search",
				new IterativeDeepeningSearch());
		addSearchAlgorithm("AStar Search (MisplacedTileHeursitic)",
				new AStarSearch(new TreeSearch(), new SwampHeuristicFunction()));	
	}
	
	
	public static void main (String[] args)
	{
		SwampFrame swampFrame = new SwampFrame();
	}
	
	
	/** A state external to the board */
	
	public static SwampState getInitialState(SwampEnvironment se){
		SwampState initial = new SwampState(se,-1,-1);
		return initial;
	}
	
	
	/** Provides a text with statistical information about the last run. */
	public static String getStatistics(SearchAgent agent) {
		
		StringBuffer result = new StringBuffer();
		Properties properties = agent.getInstrumentation();
		Iterator<Object> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			
			if(key.equals("pathCost")){
				if(property.equals("0") || property.equals("0.0")){
					SwampGoalTest.setFinito(false);
					result.append("\nFAILURE: THERE NOT EXIST A SAFE PATH");
					break;
				}
				else{
					SwampGoalTest.setFinito(true);
				}
			}
			result.append("\n" + key + " : " + property);
		}
		return result.toString();
	}


	
	
}