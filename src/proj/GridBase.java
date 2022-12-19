package proj;

import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

public class GridBase extends Panel{
	public static Graph[][] graphs;
	public GridBase(int rows, int cols, List<Integer>[][] values)
	{
		super(new GridLayout(rows, cols, 1, 1));
		
		
		graphs = new Graph[rows][cols];
		
		for(int i = 0; i < rows;i++)
		{
			for(int j = 0; j < cols;j++)
			{
				graphs[i][j] = new Graph(new ArrayList<Double>());
				graphs[i][j].showGui();
				this.add(graphs[i][j]);
				//g[i][j] = new Graph(values[i][j]);
				//this.add(new Graph(values[i][j]));
				//g[i][j].createAndShowGui();
				//System.out.println(i+" "+j);
				//this.add(new TravnataPovrs());
			}
		}
	}
}
