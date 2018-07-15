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
}
