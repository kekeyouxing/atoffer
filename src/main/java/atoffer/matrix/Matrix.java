package atoffer.matrix;

public class Matrix {
	public void printMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int start = 0;
		while(rows>start*2 && cols>start*2) {
			printCycle(matrix, rows, cols, start);
			start++;
		}
	}

	private void printCycle(int[][] matrix, int rows, int cols, int start) {
		
		int endX = rows-start-1;
		int endY = cols-start-1;
		
		for(int i=start; i<=endY; i++) {
			System.out.print(matrix[start][i]+" ");
		}
		
		if(endX>start) {
			for(int i=start+1; i<=endX; i++) {
				System.out.print(matrix[i][endY]+" ");
			}
		}
		if(start<endY) {
			for(int i=endY-1; start<=i; i--) {
				System.out.print(matrix[endX][i]+" ");
			}
		}
		if(endX>start) {
			for(int i=endX-1; i>start; i--) {
				System.out.print(matrix[i][start]+" ");
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] data = new int[][] {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		Matrix matrix = new Matrix();
		matrix.printMatrix(data);
		
	}
}
