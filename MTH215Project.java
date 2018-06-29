import java.awt.BorderLayout;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.JButton;


import java.lang.Math;

public class MTH215Project extends JPanel
{
	//Main Method
	public static void main(String args[]) throws MatrixException 
	{		
		

		//...

		Scanner in = new Scanner(System.in);
		Timer timer = null;
		JButton button = new JButton("Iterate");
		JFrame frame = new JFrame("Koch Curve");
		System.out.print("Enter the desired number of iterations: ");
		int iterations = in.nextInt();
		ArrayList<Matrix> matrixList;
		KochCurve test = new KochCurve(iterations);
		Points points = new Points();
		
		matrixList = test.kochRecursive(test.getMatrixA(), test.getMatrixB(), test.getIterations());
		test.incrementIteration();
		
		
		frame.add(new MTH215Project(), BorderLayout.CENTER);
		frame.add(button, BorderLayout.SOUTH);
		frame.setSize(700, 700);
		points.setCoords(matrixList);
		frame.add(points);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//Render the koch curve via a number of recursive iterations
		//Defined in method call
		//matrixList = test.kochRecursive(test.getMatrixA(), test.getMatrixB(), test.getIterations());	
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
	}
}


/*
frame.addMouseListener(new MouseAdapter() 
{
	@Override
	public void mousePressed(MouseEvent e)
	{
		iterations++;
		System.out.println("Iterations = " + iterations);
	}
});
*/



