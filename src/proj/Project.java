package proj;

import java.awt.Frame;

public class Project extends Frame{
	
	private void populateWindow()
	{
		plac = new Plac(redovi, kolone);
		setBounds(700, 200, 500, 500);
		setResizable(false);
		setTitle("Energetski sistem");
		
		add(plac, BorderLayout.CENTER);
	
		topPanel.add(dugmeDodaj);
		add(topPanel, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		ProjectBase projectBase = new ProjectBase();
		Thread t = new Thread(projectBase);
		t.start();
	}
}
