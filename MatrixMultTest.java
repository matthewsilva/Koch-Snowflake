public class MatrixMultTest 
{
	/*
	 * Various tests during development to ensure matrix multiplication is 
	 * functioning correctly.
	 */
	public static void main(String args[]) throws MatrixException 
	{
		//Test 1
		double[][] aVals = new double[1][2];
		aVals[0][0] = 6;
		aVals[0][1] = 4;
		Matrix A = new Matrix(aVals);
		double[][] bVals = new double[2][1];
		bVals[0][0] = 3;
		bVals[1][0] = 10;
		Matrix B = new Matrix(bVals);
		Matrix C = A.mult(B);
		System.out.println(C);
		C = C.sMult(5);
		System.out.println(C);
		C = C.add(C);
		System.out.println(C);
		
		//Test 2
		aVals = new double[2][3];
		aVals[0][0] = 6;
		aVals[0][1] = 4;
		aVals[0][2] = 1;
		aVals[1][0] = 5;
		aVals[1][1] = 9;
		aVals[1][2] = 2;
		A = new Matrix(aVals);
		bVals = new double[3][3];
		for (int i = 1; i < 4; i++) 
		{
			for (int j = 5; j < 8; j++) 
			{
				bVals[i - 1][j - 5] = i + j;
			}
		}
		B = new Matrix(bVals);
		System.out.println(A);
		System.out.println(B);
		C = A.mult(B);
		System.out.println(C);
		System.out.println("Scalar mult test");
		C = C.sMult(5);
		System.out.println(C);
		System.out.println("Add test");
		C = C.add(C);
		System.out.println(C);	
	}
}
