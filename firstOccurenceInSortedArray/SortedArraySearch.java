package firstOccurenceInSortedArray;


public class SortedArraySearch {
	
	public  int binarySearch(int[] array, int target, int start, int end) {
		if(start > end ) {
			return -1;
		}
		int mid = start + (end-start)/2;
		if(array[mid] == target) {
			if(mid > 0 && array[mid-1] == target) {
				return binarySearch(array, target, start, mid-1);
			} else {
				return mid;
			}
		} else if(target < array[mid]) {
			return binarySearch(array, target, start, mid-1);
		} else {
			return binarySearch(array, target, mid+1, end);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedArraySearch ex = new SortedArraySearch();
		int[] array1 = {5,5,6,6,7,7,7,8,9,9};
		int[] array2 = {5,5,5,5,5,5,5,5};
		int[] array3 = {5,5,5,5,5,5,5,5,5};
		int[] array4 = {5,5,6,6,7,7,7,7,8,9,9};
		System.out.println(ex.binarySearch(array1, 7, 0, array1.length-1));
		System.out.println(ex.binarySearch(array2, 5, 0, array2.length-1));
		System.out.println(ex.binarySearch(array3, 5, 0, array3.length-1));
		System.out.println(ex.binarySearch(array2, 7, 0, array2.length-1));
		System.out.println(ex.binarySearch(array4, 7, 0, array4.length-1));
		System.out.println(ex.binarySearch(array4, 9, 0, array4.length-1));
		
	}

}
