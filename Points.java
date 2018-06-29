import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Points extends JPanel 
{
	//Data fields
	private ArrayList<Matrix> coords;

	//Getter method
	public ArrayList<Matrix> getCoords() 
	{
		return coords;
	}
	
	//Setter method
	public void setCoords(ArrayList<Matrix> matrix) 
	{
		coords = matrix;
	}
	
	
	public void paintComponent(Graphics g) 
	{
		//Instantiates the graphics component as required
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(Color.blue);
	    
	    //Gets, and sets, the dimension 
	    Dimension size = getSize();
	    int w = size.width ;
	    int h = size.height;
	    
	    /*
	     * Defines the final coordinates in the array then mods the value by the
	     * dimension to ensure the coordinates remain within the panel.
	     */
	    double lastX = coords.get(0).getValueAt(0, 0) % w;
	    double lastY = coords.get(0).getValueAt(1, 0) % h;
	    
	    
	    //Draws the lines required to generate the koch curve
	    for (int i = 0; i < coords.size(); i++) 
	    {      
	      Random r = new Random();
	      double x = coords.get(i).getValueAt(0, 0) % w;
	      double y = coords.get(i).getValueAt(1, 0) % h;
	      
	      g2d.drawLine((int) lastX, (int) lastY, (int) x, (int) y);
	      lastX = x;
	      lastY = y;
	    }//End loop
	    
	}//End paintComponent
		  

}//end Points class