package homework.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;





public class SwampFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField fieldRighe;
	public JTextField fieldColonne;
	public JTextField fieldLand;
	public JTextField fieldMud;
	public JTextArea printArea;
	
	private JToolBar toolbar;
	JComboBox<Object> combo = new JComboBox<Object>();
	JComboBox<Object> combo2 = new JComboBox<Object>();

	
	
	
	public SwampFrame(){
		super("Swamp Application");
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    
	    combo.addItem("Swamp");
		combo.addItem("Swamp with mud");
		combo.addActionListener(new ListenerSwampFrame(this));
		combo.setVisible(true);
		
		combo2.addItem("Astar");
		combo2.addItem("IDS");
		combo2.addActionListener(new ListenerSwampFrame(this));
		combo2.setVisible(true);
		
	    toolbar = new JToolBar();
		toolbar.setFloatable(false);
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(combo);
		toolbar.add(combo2);
		
		
		JPanel panelPrintArea = new JPanel();
		
	    printArea = new JTextArea(40,100);
	    Font font = new Font("Monaco", Font.PLAIN, 11);
	    printArea.setFont(font);
	    printArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(printArea);
		
		panelPrintArea.add(scrollPane);
	    
		//combos.add(combo);
	    
		JPanel panelSelectors = new JPanel();
		
	    
	    JPanel prima = new JPanel(new BorderLayout());
	    
	    JLabel label = new JLabel("rows");
	    label.setForeground(Color.BLUE);
	    fieldRighe = new JTextField(4);
	    
	    prima.add(label, BorderLayout.NORTH);
	    prima.add(fieldRighe, BorderLayout.SOUTH);

	    
	    
	    
	    JPanel seconda = new JPanel(new BorderLayout());
	    JLabel label2 = new JLabel("columns");
	    label2.setForeground(Color.BLUE);
	    fieldColonne = new JTextField(4);

	    seconda.add(label2, BorderLayout.NORTH);
	    seconda.add(fieldColonne, BorderLayout.SOUTH);
	    
	    JPanel terza = new JPanel(new BorderLayout());
	    JLabel label3 = new JLabel("probability land");
	    label3.setForeground(Color.BLUE);
	    fieldLand = new JTextField(4);
	    
	    terza.add(label3, BorderLayout.NORTH);
	    terza.add(fieldLand, BorderLayout.SOUTH);
	    
	    JPanel quarta = new JPanel(new BorderLayout());
	    JLabel label4 = new JLabel("probability mud");
	    label4.setForeground(Color.BLUE);
	    fieldMud = new JTextField(4);
	    fieldMud.setEditable(false);
	    
	    quarta.add(label4, BorderLayout.NORTH);
	    quarta.add(fieldMud, BorderLayout.SOUTH);
	    
	    panelSelectors.add(prima);
	    panelSelectors.add(seconda);
	    panelSelectors.add(terza);
	    panelSelectors.add(quarta);
	    
	    
	    
	    JPanel panelButtons = new JPanel();
	    JButton buttonStart = new JButton("Start");
	    buttonStart.addActionListener(new ListenerSwampFrame(this));
	    
	    JButton buttonClear = new JButton("Clear");
	    buttonClear.addActionListener(new ListenerSwampFrame(this));
	    
	    panelButtons.add(buttonStart);
	    panelButtons.add(buttonClear);
	    
	    JPanel pannelloCenter = new JPanel(new BorderLayout());
	    pannelloCenter.add(panelSelectors, BorderLayout.NORTH);
	    pannelloCenter.add(panelButtons, BorderLayout.CENTER);
	    
	    
	    

	    this.getContentPane().add(toolbar, BorderLayout.NORTH);
	    this.getContentPane().add(pannelloCenter, BorderLayout.CENTER);
	    this.getContentPane().add(panelPrintArea, BorderLayout.SOUTH);
	    
	    
	    
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);

	    
	}

}
