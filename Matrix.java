// https://math.stackexchange.com/questions/500397/calculate-points-of-koch-curve

public class Matrix 
{
	//Data fields
	private int rows;
	private int cols;
	private double[][] vals;
	
	
	//Constructor
	public Matrix(double[][] values) throws MatrixException 
	{
		vals = values;
		rows = vals.length;
		cols = vals[0].length;
	}
	
	
	//toString for debugging purposes
	public String toString() 
	{
		String str = "";
		for (int row = 0; row < rows; row++) 
		{
			for (int col = 0; col < cols; col++) 
			{
				str = str + " " + vals[row][col] + " ";
			}
			
			str = str + "\n";
		}
		
		return str;
	}
	
	
	//Getter methods
	public int getRows() 
	{
		return rows;
	}
	
	public int getCols() 
	{
		return cols;
	}
	
	public double getValueAt(int row, int col) 
	{
		return vals[row][col];
	}
	
	
	//Method to add two matrices 
	public Matrix add(Matrix B) throws MatrixException 
	{
		//If matrices cannot be added, throw exception
		if (rows != B.getRows() || cols != B.getCols())
			throw new MatrixException("Matrices not compatible for addition");
		
		//Instantiate a variable to hold the values of the new matrix
		double[][] newVals = new double[rows][cols];
		
		//Loop through the matrix, adding accordingly
		for (int row = 0; row < rows; row++) 
		{
			for (int col = 0; col < cols; col++) 
			{
				newVals[row][col] = vals[row][col] + B.getValueAt(row, col);			
			}
		}
		
		//Returns a new matrix in the form of the sum of the two input matrices
		return new Matrix(newVals);
	}
	
	
	//Method to multiply a matrix by a given scalar 'c'
	public Matrix sMult(double c) throws MatrixException 
	{
		//Instantiate a variable to hold the values of the new matrix
		double[][] newVals = new double[rows][cols];
		
		//Loop through the matrix, multiplying each entry by the scalar
		for (int row = 0; row < rows; row++) 
		{
			for (int col = 0; col < cols; col++) 
			{
				newVals[row][col] = vals[row][col]*c;		
			}
		}
		
		//Returns a new matrix in the form of the matrix multiplied by the input scalar
		return new Matrix(newVals);
	}
	
	
	//Method to multiply two matrices
	public Matrix mult(Matrix B) throws MatrixException 
	{
		//If matrices cannot be multiplied, throw exception
		if (cols != B.getRows())
			throw new MatrixException("Matrices not compatible for multiplication");
		
		//Instantiate a variable to hold the values of the new matrix
		double[][] newVals = new double[rows][B.getCols()];
		double newValue = 0;
		
		//Loops through the matrices, multiplying accordingly
		for (int row = 0; row < rows; row++) 
		{
			for (int col = 0; col < B.getCols(); col++) 
			{
				newValue = 0;
				for (int productCounter = 0; productCounter < cols; productCounter++) 
				{
						newValue += vals[row][productCounter]*B.getValueAt(productCounter, col);
				}
				newVals[row][col] = newValue;
			}
		}
		
		//Returns a new matrix in the form of the product of the two input matrices
		return new Matrix(newVals);
	}
	
}
