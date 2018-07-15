package integerSquareRoot;

public class IntegerSquareRoot {
	
	public int squareRoot(int num) {
		if(num < 0) {
			return -1;
		}
		long start = 0;
		long end = num;
		while(start <= end) {
			long mid = start + (end-start)/2;
			long midSqr = mid*mid;
			if(midSqr == num) {
				return (int)mid;
			} else if(midSqr < num) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		return (int)start-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 50; i++) {
			System.out.println(i + " =  " + new IntegerSquareRoot().squareRoot(i));
		}
		
	}

}
