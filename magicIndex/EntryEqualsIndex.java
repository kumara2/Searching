package magicIndex;

public class EntryEqualsIndex {
	public int findIndex(int[] array, int start, int end) {
		if(start > end) {
			return -1;
		}
		int mid = start + (end-start)/2;
		if(mid == array[mid]) {
			return mid;
		}
		int leftIndex = Math.min(mid-1, array[mid]);
		int left = findIndex(array, start, leftIndex);
		if(left >= 0) {
			return left;
		}
		int rightIndex = Math.max(mid+1, array[mid]);
		return findIndex(array, rightIndex, end);
		//return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-10, -5, 2,2,2,3,4,7,9,12,13};
		System.out.println(new EntryEqualsIndex().findIndex(array, 0, array.length-1));
	}

}
