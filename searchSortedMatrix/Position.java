package searchSortedMatrix;

public class Position {
	int row, col;
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public String toString() {
		return "(" + this.row + ", " + this.col + ")";
	}
	public boolean isBefore(Position point) {
		// TODO Auto-generated method stub
		
		return this.row <= point.row && this.col <= point.col;
	}
	public boolean isOutOfBound(int[][] matrix) {
		return row >= matrix.length || col >= matrix[0].length || row < 0  || col < 0;
		//return false;
	}
}
