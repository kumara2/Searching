package minAndMax;
import java.util.*;

public class MinMaxArray {
	public MinMax findMinAndMax(List<Integer> array) {
		if(array == null || array.size() <= 0) {
			return null;
		}
		MinMax result = new MinMax(array.get(0), array.get(0));
		// even or odd lengths
		for(int i = 0; i < array.size(); i = i + 2) {
			int a = array.get(i);
			int b = i+1 >= array.size() ? array.get(i) : array.get(i+1);
			if(a > b) {
				result.max = Math.max(a, result.max);
				result.min = Math.min(b,  result.min);
			} else {
				result.max = Math.max(b, result.max);
				result.min = Math.min(a,  result.min);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> array = new ArrayList<Integer>();
		for(int i = 0; i < 19; i++) {
			int b = new Random().nextInt(100);
			System.out.print (b + " " );
			array.add(b);
		}
		array.set(18, -1);
		System.out.println();
		MinMax sol = new MinMaxArray().findMinAndMax(array);
		System.out.println(sol.min + " " + sol.max);
	}
}
