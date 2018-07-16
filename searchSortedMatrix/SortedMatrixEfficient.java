package searchSortedMatrix;

public class SortedMatrixEfficient {
	
	public Position search(int[][] matrix, int target) {
		int diag = Math.min(matrix.length, matrix[0].length);
		Position end = new Position(matrix.length-1, matrix[0].length-1);
		return search(matrix, target, new Position(0, 0), end);
		//return null;
	}

	private Position search(int[][] matrix, int target, Position start, Position end) {
		// TODO Auto-generated method stub
		if(start.isOutOfBound(matrix) || end.isOutOfBound(matrix) || !start.isBefore(end)) {
			return null;
		}
		int dLen = Math.min(end.col-start.col, end.row - start.row);
		Position mid = binarySearch(matrix, start, new Position(start.row+dLen, start.col+dLen), target);
		if(!mid.isOutOfBound(matrix) && matrix[mid.row][mid.col] == target) {
			return mid;
		}
		return partitionAndSearch(matrix, start, end, mid, target);
		//return null;
	}

	private Position partitionAndSearch(int[][] matrix, Position start, Position end, Position mid, int target) {
		Position upStart = new Position(start.row, mid.col);
		Position upEnd = new Position(mid.row-1, end.col);
		Position upResult = search(matrix, target, upStart, upEnd);
		if(upResult != null) {
			return upResult;
		}
		Position downStart = new Position(mid.row, start.col);
		Position downEnd = new Position(end.row, mid.col-1);		
		return search(matrix, target, downStart, downEnd);
	}

	private Position binarySearch(int[][] matrix, Position start, Position end, int target) {
		int dLen = Math.min(end.col-start.col, end.row - start.row);
		Position low = new Position(start.row, start.col);
		Position hi = new Position(low.row + dLen, low.col + dLen);
		while(low.isBefore(hi)) {
			Position mid = new Position((low.row + hi.row)/2, (low.col + hi.col)/2);
			if(matrix[mid.row][mid.col] == target) {
				return mid;
			} else if(matrix[mid.row][mid.col] > target) {
				hi.row = mid.row - 1;
				hi.col = mid.col - 1;
			} else {
				low.row = mid.row + 1 ;
				low.col = mid.col + 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = 
			{ 		{ 1, 2, 3, 4},
					{ 5, 6, 7, 8},
					{9, 10, 11,12},
					{13,14, 15,16},
					{34,36, 38, 49}
			};
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.println("Searching : " + matrix[i][j] + " : " + new SortedMatrixEfficient().search(matrix, matrix[i][j]));
			}
		}
		System.out.println( new SortedMatrixEfficient().search(matrix, 18));
	}

}
