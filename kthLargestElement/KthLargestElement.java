package kthLargestElement;


import java.util.Arrays;

class CountHelper {
	int lessThan;
	int equalTo;
}

public class KthLargestElement {
	public static int findKthLargest(int[] array, int k) {
		if(array == null || array.length < k) {
			return -1;
		}
		return findKthLargest(array, k, 0, array.length-1);
	}
	private static int findKthLargest(int[] array, int k, int start, int end) {
		int pivot = start + (int)(Math.random() * (end - start + 1));
		
		CountHelper count = partition(array, pivot, start, end);
		if( k >= start + count.lessThan && k < start + count.lessThan + count.equalTo ) {
			return array[start + count.lessThan + count.equalTo - 1];
		} else if( k < start + count.lessThan + count.equalTo){
			return findKthLargest(array, k, start, start + count.lessThan );
		} else {
			return findKthLargest(array, k, start + count.lessThan + count.equalTo , end);
		}
		
		
	}
	private static CountHelper partition(int[] array, int pivot, int start, int end) {
		swap(array, pivot, end);
		int val = array[end];
		CountHelper c = new CountHelper();
		c.equalTo = 1;
		int i = start-1, j = start;
		while(j < end) {
			if(array[j] <= val) {
				if(array[j] == val) {
					c.equalTo++;
				} else {
					c.lessThan++;
				}
				i++;
				swap(array, i, j);
			} 
			j++;
		}
		i++;
		swap(array, i, end);
		return c;
	}
	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2, 57, 45, 53, 6 ,69, 17, 4 ,67, 78, 96, 19, 84, 86, 64, 76, 91, 79, 35,19, 19,19,19 };
		System.out.println(findKthLargest(array, 3));
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}

}
