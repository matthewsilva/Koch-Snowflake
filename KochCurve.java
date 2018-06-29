import java.util.ArrayList;

public class KochCurve
{
	private int iterations;
	private Matrix A;
	private Matrix B;
	private Points points;
	
	//KochCurve Constructor
	public KochCurve(int myIterations) throws MatrixException
	{
		iterations = myIterations;
		
		//Instantiate a new array of matrices
		ArrayList<Matrix> matrixList = new ArrayList<Matrix>();
		
		//Instantiate a new 2x1 vector to hold initial points of matrix A
		double[][] aVals = new double[2][1];
		aVals[0][0] = 50;
		aVals[1][0] = 300;
		this.A = new Matrix(aVals);
		
		//Instantiate a new 2x1 vector to hold initial points of matrix B
		double[][] bVals = new double[2][1];
		bVals[0][0] = 650;
		bVals[1][0] = 300;
		this.B = new Matrix(bVals);
		
	}
	
	
	//Getters
	public Matrix getMatrixA()
	{
		return A;
	}
	
	public Matrix getMatrixB()
	{
		return B;
	}
	
	public int getIterations()
	{
		return iterations;
	}
	
	public void incrementIteration()
	{
		iterations++;
	}
	
	
		
	//Recursive method to derive necessary points
	public ArrayList<Matrix> kochRecursive(Matrix P1, Matrix P5, int myIterations) throws MatrixException
	{
		
		if (myIterations == 0)
			return new ArrayList<Matrix>();
		else 
		{
			//Instantiate an arrayList of Matrices to hold coordinates
			ArrayList<Matrix> coords = new ArrayList<Matrix>();	
									
			 //Point 2 is derived by: P2 = (2(P1) + P5)) / 3
			Matrix P2 = ((P1.sMult(2)).add(P5)).sMult(1.0/3.0); 
			System.out.println("2P1 + P5 / 3 = " + ((P1.sMult(2)).add(P5)).sMult(1.0/3.0));
			System.out.println("P2 = " + P2);
			
			//Point 4 is derived by: (P1 + 2(P5)) / 3
			Matrix P4 = ((P5.sMult(2)).add(P1)).sMult(1.0/3.0);
			System.out.println("P4 = " + P4);
			
			//Point 3 is derived by: P3 = P2 + R(P4 - P2)
			//where R is the rotation matrix
			Matrix P3 = P2.add(rotateCC(((P4.add(P2.sMult(-1)))), 360));
			System.out.println("P3 =" + P3);
			System.out.println("P4 - P2 = " + P4.add(P2.sMult(-1)));
			
			System.out.println("\n Iterations = " + this.iterations);
			
			//
			coords.add(P1);
			coords.addAll(kochRecursive(P1, P2, myIterations - 1));
			coords.add(P2);
			coords.addAll(kochRecursive(P2, P3, myIterations - 1));
			coords.add(P3);
			coords.addAll(kochRecursive(P3, P4, myIterations - 1));
			coords.add(P4);
			coords.addAll(kochRecursive(P4, P5, myIterations - 1));
			coords.add(P5);			
			
			return coords;		
		}
	}
	
	/*
	 * Create a rotation matrix used to rotate through an angle given
	 * by the parameter 'angle'
	 */
	private static Matrix rotateCC(Matrix A, double angle) throws MatrixException 
	{
		//Degree -> rad conversion
		angle = angle/(Math.PI)*180;
		
		//Instantiate an empty 2x2 array
		double[][] rVals = new double[2][2];
		
		
		//Create the rotation matrix by filling points with trig functions
		rVals[0][0] = Math.cos(angle);
		System.out.println(rVals[0][0]);		

		rVals[0][1] = (-1)*(Math.sin(angle));
		System.out.println(rVals[0][1]);
		
		rVals[1][0] = Math.sin(angle);
		System.out.println(rVals[1][0]);
		
		rVals[1][1] = Math.cos(angle);
		System.out.println(rVals[1][1]);
		
		
		//Create the rotation matrix using values defined above
		Matrix R = new Matrix(rVals);
		
		//Multiply given matrix 'A' by newly defined rotation matrix
		//Returns product
		return R.mult(A);
	}
	
	
	
}