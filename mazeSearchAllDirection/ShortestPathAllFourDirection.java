package mazeSearchAllDirection;


import java.util.*;

public class ShortestPathAllFourDirection {
	public int findShortestPath(int[][] matrix) {
		if(matrix == null || matrix.length <= 0 && matrix[0].length <= 0) {
			return Integer.MAX_VALUE;
		}
		Position[][] costMatrix = new Position[matrix.length][matrix[0].length];
		TreeSet<Position> q = new TreeSet<Position>();
		HashSet<Position> map = new HashSet<Position>();
		intializeCostMatrixToInfinity(costMatrix, q);
		System.out.println(q.remove(costMatrix[0][0]));
		costMatrix[0][0].val = matrix[0][0];
		q.add(costMatrix[0][0]);
		Position current =  q.pollFirst();
		Position stop = costMatrix[matrix.length-1][matrix[0].length-1];
		while(current != null && current != stop ) {
			Position right = current.col+1 < matrix[0].length ? costMatrix[current.row][current.col+1] : null;
			if(right != null && !map.contains(right) && matrix[current.row][current.col+1] != Integer.MAX_VALUE && right.val > current.val + matrix[current.row][current.col+1]) {
				right.val = current.val + matrix[current.row][current.col+1];
				q.remove(right);
				q.add(right);
			}
			Position left = current.col-1 >= 0 ? costMatrix[current.row][current.col-1] : null;
			if(left != null && !map.contains(left) && matrix[current.row][current.col-1] != Integer.MAX_VALUE &&left.val > current.val + matrix[current.row][current.col-1]) {
				left.val = current.val + matrix[current.row][current.col-1];
				q.remove(left);
				q.add(left);
			}
			Position up = current.row-1 >= 0 ? costMatrix[current.row-1][current.col] : null;
			if(up != null && !map.contains(up) && matrix[current.row-1][current.col] != Integer.MAX_VALUE && up.val > current.val + matrix[current.row-1][current.col]) {
				up.val = current.val + matrix[current.row-1][current.col];
				q.remove(up);
				q.add(up);
			}
			Position down = current.row+1 < matrix.length ? costMatrix[current.row+1][current.col] : null;
			if(down != null && !map.contains(down) && matrix[current.row+1][current.col] != Integer.MAX_VALUE && down.val > current.val + matrix[current.row+1][current.col]) {
				down.val = current.val + matrix[current.row+1][current.col];
				q.remove(down);
				q.add(down);
			}
			map.add(current);
			current = q.pollFirst();
		}
		print(costMatrix);
		if(current == stop) {
			return current.val;
		}
		return Integer.MAX_VALUE;
	}
	private void print(Position[][] costMatrix) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < costMatrix.length; i++) {
			for(int j = 0; j < costMatrix[0].length; j++) {
				System.out.print(costMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	private void intializeCostMatrixToInfinity(Position[][] costMatrix, TreeSet<Position> q) {
		for(int i = 0; i < costMatrix.length; i++) {
			for(int j = 0; j < costMatrix[0].length; j++) {
				costMatrix[i][j] = new Position(i, j, Integer.MAX_VALUE);
				q.add(costMatrix[i][j]);
			}
		}
		//costMatrix[0][0].val = 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix =   {
				{1, 30, 4,5,5,8},
				{1, 10, 5,1,1,1},
				{1, 10, 10,10,50,1},
				{1,1,1,1,1,1}
		}; 
		System.out.println(new ShortestPathAllFourDirection().findShortestPath(matrix));
	}

}
