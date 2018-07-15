package searchSortedMatrix;

public class SortedMatrixSearchInefficient {
	public Position searchMatrix(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[0].length - 1;
		while(row < matrix.length && col >= 0) {
			if(target == matrix[row][col]) {
				return new Position(row, col);
			} else if(target < matrix[row][col]) {
				col--;
			} else {
				row++;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = 
			{ { 1, 2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13, 14, 15,16}
			};
		System.out.println(new SortedMatrixSearchInefficient().searchMatrix(matrix, -1));
	}

}
