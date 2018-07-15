package missingAndDuplicate;

class Result {
	int miss, dup;
	Result(int m, int d) {
		this.miss = m;
		this.dup = d;
	}
	public String toString() {
		return "Miss " +this.miss + " Duplicate " + this.dup;
	}
}

public class MissAndDuplicate {
	public Result findNumbers(int[] array) {
		int missXORDup = 0;
		for(int i = 0; i < array.length; i++) {
			missXORDup ^= array[i];
			missXORDup ^= i;
		}
		//find least significant bit where the bits vary
		int diffBit = missXORDup & (~(missXORDup-1));
		//find missing or duplicate number
		int missOrDup = 0;
		for(int i = 0; i < array.length; i++) {
			if((diffBit & array[i]) != 0) {
				missOrDup ^= array[i];
			}
			if((diffBit & i) != 0) {
				missOrDup ^= i;
			}
		}
		for(int a: array) {
			if(missOrDup == a) {
				return new Result(missXORDup ^ missOrDup, missOrDup);
			}
		}
		return new Result(missOrDup, missXORDup ^ missOrDup);		
	}
	public static void main(String[] args) {
		MissAndDuplicate s= new MissAndDuplicate();
		int[] array = {5,4,0,3,1,3,6};
		System.out.println(s.findNumbers(array));
	}
}
