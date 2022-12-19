package proj;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

public class Project extends JFrame{
	private ProjectBase projectBase = new ProjectBase();
	private static int numberOfGraphs = 7;
	public static Graph[] graphs = new Graph[numberOfGraphs];
	private void populateWindow()
	{
		//plac = new Plac(redovi, kolone);
		//gridBase = new GridBase(1, 1, projectBase.changes);
		/*List<Double> p = new ArrayList<Double>();
    	p.add(1.0);
    	p.add(2.0);
    	p.add(3.0);
    	Graph g = new Graph(p);
    	g.showGui();
    	*/
		/*setBounds(700, 200, 1500, 1000);
		setResizable(false);
		setTitle("Energetski sistem");
		
		add(gridBase, BorderLayout.CENTER);*/
		for(int i=0;i<numberOfGraphs;i++) {

			List<Double> p = new ArrayList<Double>();
			p.add(0.0);
			p.add(0.0);
	    	graphs[i] = new Graph(p);
	    	graphs[i].showGui();

		}
		
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
