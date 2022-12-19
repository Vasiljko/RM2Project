package proj;

import java.awt.GridLayout;
import java.awt.Panel;

public class GridBase extends Panel{
	public GridBase(int rows, int cols)
	{
		super(new GridLayout(rows, cols, 3, 3));
		
		
		Graphs g = new Graphs[rows][cols];
		for(int i = 0; i < rows;i++)
		{
			for(int j = 0; j < cols;j++)
			{
				g[i][j] = new Graph();
			}
		}
		/*
		addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e)
			{
				if(selektovana != null)
					selektovana.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
				if(e.getSource() instanceof Parcela)
				{
					selektovana = (Parcela)e.getSource();
					selektovana.setFont(new Font(Font.SANS_SERIF, Font.BOLD,50));
					repaint();
				}
			}
		});*/
	}
}
