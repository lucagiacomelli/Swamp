package homework.gui;

import homework.Main;
import homework.Swamp;
import homework.SwampAgent;
import homework.SwampEnvironment;
import homework.SwampEnvironmentState;
import homework.SwampFunctionFactory;
import homework.SwampGoalTest;
import homework.SwampState;
import homework.SwampStepCostFunction;
import homework.SwampWithMud;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import aima.core.search.framework.Problem;
import aima.core.search.framework.Search;
import aima.core.search.framework.SearchAgent;


public class ListenerSwampFrame implements ActionListener {

	  private SwampFrame frame;

	
	 public ListenerSwampFrame(SwampFrame sf){
		 frame = sf;
	 }
	  
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().getClass().equals(JComboBox.class)){
			JComboBox comboBox = (JComboBox)e.getSource();
			//System.out.println("ho cliccato la combo box");

			if(comboBox.getSelectedItem().equals("Swamp with mud")){
				frame.fieldMud.setEditable(true);
			}
			else if(comboBox.getSelectedItem().equals("Swamp")){
				frame.fieldMud.setEditable(false);
			}
		}
		else if(e.getSource().getClass().equals(JButton.class)){
			JButton button = (JButton)e.getSource();
			if(button.getText().equals("Clear")){
				frame.printArea.setText("");
			}
			else{
				
				try{
					int righe = Integer.parseInt(frame.fieldRighe.getText());
					int colonne = Integer.parseInt(frame.fieldColonne.getText());
					double prob = Double.parseDouble(frame.fieldLand.getText());
					double probMud =0;
					
					
					if(frame.combo.getSelectedItem().equals("Swamp with mud")){
						probMud = Double.parseDouble(frame.fieldMud.getText());
					}
					
					
					if(frame.combo.getSelectedItem().equals("Swamp with mud") && (probMud <0 || probMud >1)){
						JOptionPane.showMessageDialog(null, "Probability mud must be between 0 and 1!");
					}
					else if(righe<=0){
						JOptionPane.showMessageDialog(null, "Number of rows must be greather than zero!");
					}
					else if(colonne<=0){
						JOptionPane.showMessageDialog(null,"Number of columns must be less than zero zero!");
					}
					else if(prob<0 || prob>1){
						JOptionPane.showMessageDialog(null, "Probability land must be between 0 and 1!");
					}
					else{
						
						//frame.printArea.append("Passati i controlli \n");
						Swamp swamp = new Swamp(righe,colonne,prob);
						SwampWithMud swampWM = new SwampWithMud(righe, colonne, prob, probMud);
						    	
						Search IDSsearch = Main.SEARCH_ALGOS.get(0);
						Search search = Main.SEARCH_ALGOS.get(1);
						
						
						
						if(frame.combo.getSelectedItem().equals("Swamp")){
							
							frame.printArea.append("\n\n######################### SWAMP ##########################\n\n");

							
							if(frame.combo2.getSelectedItem().equals("Astar")){
								
								frame.printArea.append("######################### Astar ##########################\n\n");

								
								//instantiate the first problem 
						    	SwampEnvironment environment = new SwampEnvironment(swamp);  
						    	environment.setEnvState(new SwampEnvironmentState(environment));
						    	environment.getEnvState().printActions();

						    	SwampState initial = Main.getInitialState(environment);
						    	environment.setCurrentStateAgent(initial);
								SwampGoalTest st = new SwampGoalTest(environment);	
								SwampGoalTest.setFinito(false);
								
								
								frame.printArea.append(environment.getBoard().toString() + "\n");
					    		
								double inizio = System.currentTimeMillis();
								Problem problem = new Problem(
										initial,
										SwampFunctionFactory.getActionsFunction(),
										SwampFunctionFactory.getResultFunction(),
										st);
								SwampAgent agent;

								try {
									agent = new SwampAgent(problem, search);
									environment.addAgent(agent);
									
									//System.out.println("finito Astar");
									
									frame.printArea.append("\n-------STATISTICS Astar -------" + Main.getStatistics((SearchAgent)agent) + "\n");
									double fine = System.currentTimeMillis();
									frame.printArea.append("Tempo impiegato: " + (fine-inizio));
									
								} catch (Exception ex) {
									// TODO Auto-generated catch block
									ex.printStackTrace();
								}	
							}
							
							
							else{
							
						    	SwampEnvironment environment = new SwampEnvironment(swamp);  
						    	environment.setEnvState(new SwampEnvironmentState(environment));
						    	environment.getEnvState().printActions();

						    	SwampState initial = Main.getInitialState(environment);
						    	environment.setCurrentStateAgent(initial);
								SwampGoalTest st = new SwampGoalTest(environment);	
								SwampGoalTest.setFinito(false);
								
								
								frame.printArea.append("######################### IDS ##########################\n\n");

								
								frame.printArea.append(environment.getBoard().toString() + "\n");
					    		
								Problem problem = new Problem(
										initial,
										SwampFunctionFactory.getActionsFunction(),
										SwampFunctionFactory.getResultFunction(),
										st);
								SwampAgent agent;
								agent = new SwampAgent(problem, search);
								environment.addAgent(agent);
								Main.getStatistics((SearchAgent)agent);
								environment = new SwampEnvironment(swamp);  
						    	environment.setEnvState(new SwampEnvironmentState(environment));
						    	environment.getEnvState().printActions();

						    	initial = Main.getInitialState(environment);
						    	environment.setCurrentStateAgent(initial);
								st = new SwampGoalTest(environment);					
								
								double inizio = System.currentTimeMillis();

								
								problem = new Problem(
										initial,
										SwampFunctionFactory.getActionsFunction(),
										SwampFunctionFactory.getResultFunction(),
										st);
								
								try {
									agent = new SwampAgent(problem, IDSsearch);
									environment.addAgent(agent);
									
									//System.out.println("finito IDS");
									
									frame.printArea.append("\n-------STATISTICS IDS -------" + Main.getStatistics((SearchAgent)agent) + "\n");
									double fine = System.currentTimeMillis();
									frame.printArea.append("Tempo impiegato: " + (fine-inizio));
									
								} catch (Exception ex) {
									// TODO Auto-generated catch block
									ex.printStackTrace();
								}	
							}	
						}
						
						if(frame.combo.getSelectedItem().equals("Swamp with mud")){
							frame.printArea.append("\n\n##################### SWAMP WITH MUD ########################\n\n");

							if(frame.combo2.getSelectedItem().equals("Astar")){
						    	
								frame.printArea.append("########################## Astar ############################\n\n");

						    	//instantiate the first problem with mud
						    	SwampEnvironment environment2 = new SwampEnvironment(swampWM);
						    	SwampEnvironmentState es2 = new SwampEnvironmentState(environment2);
						    	environment2.setEnvState(es2);
						    	environment2.getEnvState().printActions();

						    	SwampState initial2 = Main.getInitialState(environment2);
						    	environment2.setCurrentStateAgent(initial2);
						    	SwampGoalTest st2 = new SwampGoalTest(environment2);
								SwampGoalTest.setFinito(false);
								
								double inizio = System.currentTimeMillis();

								
						    	Problem problem2 = new Problem(
										initial2,
										SwampFunctionFactory.getActionsFunction(),
										SwampFunctionFactory.getResultFunction(),
										st2, new SwampStepCostFunction());   
						    	
						    	
						    	
						    	frame.printArea.append(environment2.getBoard().toString());
								try {
									SwampAgent agent;
									agent = new SwampAgent(problem2, search);
									environment2.addAgent(agent);
									
									frame.printArea.append("\n-------STATISTICS Astar -------" + Main.getStatistics((SearchAgent)agent) + "\n");
									double fine = System.currentTimeMillis();
									frame.printArea.append("Tempo impiegato: " + (fine-inizio));
									
								} catch (Exception ex) {
									// TODO Auto-generated catch block
									ex.printStackTrace();
								}	
								
							}
							else{
								frame.printArea.append("########################## IDS ############################\n\n");

								SwampEnvironment environment2 = new SwampEnvironment(swampWM);
						    	SwampEnvironmentState es2 = new SwampEnvironmentState(environment2);
						    	environment2.setEnvState(es2);
						    	environment2.getEnvState().printActions();

						    	SwampState initial2 = Main.getInitialState(environment2);
						    	environment2.setCurrentStateAgent(initial2);
						    	SwampGoalTest st2 = new SwampGoalTest(environment2);
								SwampGoalTest.setFinito(false);


						    	Problem problem2 = new Problem(
										initial2,
										SwampFunctionFactory.getActionsFunction(),
										SwampFunctionFactory.getResultFunction(),
										st2, new SwampStepCostFunction());   
								SwampAgent agent;
								agent = new SwampAgent(problem2, search);
								environment2.addAgent(agent);
								Main.getStatistics((SearchAgent)agent);
									
								
								//instantiate the second problem with mud
								environment2 = new SwampEnvironment(swampWM);
						    	es2 = new SwampEnvironmentState(environment2);
						    	environment2.setEnvState(es2);
						    	environment2.getEnvState().printActions();

						    	initial2 = Main.getInitialState(environment2);
						    	environment2.setCurrentStateAgent(initial2);
						    	st2 = new SwampGoalTest(environment2);

								double inizio = System.currentTimeMillis();

						    	
						    	problem2 = new Problem(
										initial2,
										SwampFunctionFactory.getActionsFunction(),
										SwampFunctionFactory.getResultFunction(),
										st2, new SwampStepCostFunction());   
						    	
						    	frame.printArea.append(environment2.getBoard().toString());
								try {
									agent = new SwampAgent(problem2, IDSsearch);
									environment2.addAgent(agent);
									
									frame.printArea.append("\n-------STATISTICS IDS -------" + Main.getStatistics((SearchAgent)agent) + "\n");
									double fine = System.currentTimeMillis();
									frame.printArea.append("Tempo impiegato: " + (fine-inizio));
									
								} catch (Exception ex) {
									// TODO Auto-generated catch block
									ex.printStackTrace();
								}
							}
							
						}
						
					}
					
				}
				catch(Exception ex){
					//ex.printStackTrace();

					JOptionPane.showMessageDialog(null, "Fields not filled in correctly!");
				}
				
			}
	
		}		
	}

}
