package proj;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Project extends JFrame{
	private ProjectBase projectBase = new ProjectBase();
	private static int numberOfGraphs = 7;
	public static Graph[] graphs = new Graph[numberOfGraphs];
	
	private void addGraph(int i, String h) {
		List<Double> p = new ArrayList<Double>();
		p.add(0.0);
		p.add(0.0);
    	graphs[i] = new Graph(p, h);
    	graphs[i].showGui();
	}
	
	private void populateWindow()
	{
		/*public class OptionPaneExample {  
			JFrame f;  
			OptionPaneExample(){  
			    f=new JFrame();   
			    String name=JOptionPane.showInputDialog(f,"Enter Name");      
			}  
			public static void main(String[] args) {  
			    new OptionPaneExample();  
			}  
			}  */
		JFrame f = new JFrame();
		Integer interval = Integer.parseInt(JOptionPane.showInputDialog(f, "Enter value"));
		projectBase.setInterval(interval);
		
    	addGraph(0,"cpmCPUTotal5sec");
    	addGraph(1,"cpmCPUTotal1min");
    	addGraph(2,"cpmCPUTotal5min");

    	addGraph(3,"ciscoMemoryPoolUsed.1");
    	addGraph(4,"ciscoMemoryPoolUsed.2");
    	addGraph(5,"ciscoMemoryPoolFree.1");
    	addGraph(6,"ciscoMemoryPoolFree.2");

		
		/*while(true) {
    		try {
        		Thread.sleep(4000);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	Double dp = (new Random()).nextDouble() * 10;
        	System.out.println("dp = "+dp);
        	for(int i=0;i<5;i++)graphs[i].addData(dp);
	        //g.pack();

        	//g.repaint();
    	}*/
		
		/*List<Double> p = new ArrayList<Double>();
    	p.add(1.0);
    	p.add(2.0);
    	p.add(3.0);
    	Graph g = new Graph(p);
    	g.showGui();*/

    	/*while(true) {
    		try {
        		Thread.sleep(4000);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        	Double dp = (new Random()).nextDouble() * 10;
        	System.out.println("dp = "+dp);
        	g.addData(dp);
	        //g.pack();

        	//g.repaint();
    	}*/
		//topPanel.add(dugmeDodaj);
		//add(topPanel, BorderLayout.NORTH);
	}
	
	public Project() {
		populateWindow();
		ProjectBase p = new ProjectBase();
		Thread t = new Thread(p);	
		t.start();
		//projectBase = new ProjectBase();
		//projectBase.doIt();
		//setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		Project p = new Project();
		
		
		/*ProjectBase projectBase = new ProjectBase();
		Thread t = new Thread(projectBase);
		t.start();*/
	}
}
