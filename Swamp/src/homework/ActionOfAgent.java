package homework;

import aima.core.agent.impl.DynamicAction;

public class ActionOfAgent extends DynamicAction{
	private int row;
	private int col;
	
	public ActionOfAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public ActionOfAgent(String name, int r, int c){
		super(name);
		row = r;
		col = c;
	}

	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	@Override
	public boolean isNoOp() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
