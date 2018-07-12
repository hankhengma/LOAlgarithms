public class KthSmallestInTwoSortedArray {
	// assumption: acsending sorted
	public int kth(int[] a, int[] b, int k) {
		PriorityQueue<Integer> min = new ProrityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				if (n1.equals(n2)) {
					return 0;
				}
				return n1 < n2 ? -1 : 1;
			}
		});

		int aIndex = 0;
		int bIndex = 0;


		while (k > 0 && aIndex < a.length && bIndex < b.length) {
			if (a[aIndex] < b[bIndex]) {
				aIndex++;
			} else {
				bIndex++;
			}
			--k;
		}
		return Math.min(a[aIndex - 1], b[bIndex - 1]);
	}

	public int kthI(int[] a, int[] b, int k) {
		// using binary search as the two arrays have been sorted.
		if (a == null || b == null || a.length == 0 || b.length == 0 || k <= 0) {
			return Integer.MIN_VALUE;
		}
		int aleft = 0;
		int bleft = 0;
		return kthIHelper(a, b, aleft, bleft, k);
	}

	private int kthIHelper(int[] a, int[] b, int aleft, int bleft, int k) {
		// base case:
		if (aleft >= a.length) {
			return b[bleft + k - 1];
		}
		if (bleft >= b.length) {
			return a[aleft + k - 1];
		}
		if (k == 1) {
			return Math.min(a[aleft], b[bleft]);
		}

		int aMid = aleft + k / 2 - 1;
		int bMid = bleft + k / 2 - 1;

		int aMidVal = a[aMid];
		int bMidVal = b[bMid];

		if (aMidVal <= bMidVal) {
			return kthIHelper(a, b, aMid + 1, bleft, k - k / 2);
		} else {
			return kthIHelper(a, b, aleft, bMid + 1, k - k / 2);
		}
	}

}
/************************************
a 1 3 5 7
b 2 4 6 8
k = 3 (result = 3)

k/2 = 1;

3 5 7;
2;

k = 1 / 2 = 0;
3 5 7;

