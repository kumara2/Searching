package mazeSearchAllDirection;

import java.util.Objects;

public class Position implements Comparable<Position>{
	int row, col;
	int val;
	Position(int r, int c, int v) {
		row = r;
		col = c;
		val = v;
	}
	public boolean equals(Object ob) {
		if(ob == null || !(ob instanceof Position)) {
			return false;
		}
		Position p = (Position) ob;
		return p.row == row && p.col == col;
	}
	public int hashCode() {
		return Objects.hash(row, col, val);		
	}
	public int compareTo(Position p) {
		if(this.equals(p)) {
			return 0;
		}
		if(this.val < p.val) {
			return -1;
		} else if(this.val > p.val) {
			return 1;
		}
		return this.row != p.row ? (this.row - p.row) : (this.col - p.col);
		//return 0;
	}
	public String toString() {
		return "(" + row+ ", " + col + ") -> " + val + " ";
	}
}
