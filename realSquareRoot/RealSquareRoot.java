package realSquareRoot;


public class RealSquareRoot {
	private enum ORDERING {
		SMALLER, EQUAL, LARGER;
	}
	public static void main(String[] args) {
		System.out.println( new RealSquareRoot().squareRoot(0.25));
		for(int i = 0; i < 100; i++) {
			System.out.println(i + " =  " + new RealSquareRoot().squareRoot(i));
		}
	}

	private double squareRoot(double num) {
		double low = 0.0;
		double high = 0.0;
		if(num < 1.0) {
			low = num;
			high = 1.0;
		} else {
			low = 1.0;
			high = num;
		}
		while(compare(low, high) == ORDERING.SMALLER) {
			double mid = (low + high)/2.0;
			double midSqr = mid * mid;
			if(compare(num, midSqr) == ORDERING.EQUAL) {
				return mid;
			} else if(compare(midSqr, num) == ORDERING.SMALLER) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return low;
	}
	private ORDERING compare(double a, double b) {
		double EPSILON = 0.00001;
		double diff = (a - b)/b;
		if(diff < -EPSILON) {
			return ORDERING.SMALLER;
		} else if(diff > EPSILON) {
			return ORDERING.LARGER;
		} else {
			return ORDERING.EQUAL;
		}
	}
}
