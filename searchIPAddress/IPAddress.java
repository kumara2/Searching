package searchIPAddress;

import java.util.*;

public class IPAddress {
	public boolean findMissingIP(Iterable<Integer> sequence) {
		int NUM_OF_BUCKETS = 1 << 16;
		Iterator<Integer> s = sequence.iterator();
		int[] buckets = new int[NUM_OF_BUCKETS];
		while(s.hasNext()) {
			int index = s.next() >>> 16;
		buckets[index]++;
		}
		int i = 0;
		for(i = 0; i < NUM_OF_BUCKETS; i++) {
			if(buckets[i] < NUM_OF_BUCKETS) {
				break;
			}
		}
		int[] bitArray= new int[NUM_OF_BUCKETS];
		s = sequence.iterator();
		while(s.hasNext()) {
			int num = s.next();
			int index = num >>> 16;			
			if (index == i) {
				int last16bits = (NUM_OF_BUCKETS - 1) & num;
				int bucketNumber = last16bits / 32;
				int bucketPosition = last16bits % 32;
				bitArray[bucketNumber] = 1 << bucketPosition;
			}
		}
		for(int j = 0; j < NUM_OF_BUCKETS; j++) {
			if(bitArray[j] != ~0) {
				for(int k = 0; k < 32; k++) {
					if((bitArray[j] & (1 << k) ) == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
