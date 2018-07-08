public class CommonElementsInThreeSortedArrays {
	public List<Integer> commonElements(int[] a, int[] b, int[] c) {
		if (a.length == 0 || b.length == 0 || c.length == 0) {
			return null;
		}

		int aIndex = 0;
		int bIndex = 0;
		int cIndex = 0;
		List<Integer> common = new ArrayList<>();
		while (aIndex < a.length && bIndex < b.length && cIndex < c.length) {
			if (a[aIndex] == b[bIndex] && b[bIndex] == c[cIndex]) {
				common.add(a[aIndex]);
				++aIndex;
				++bIndex;
				++cIndex;
			} else if (a[aIndex] <= b[bIndex] && b[bIndex] <= c[cIndex]) {
				++aIndex;
			} else if (b[bIndex] <= a[aIndex] && a[aIndex] <= c[cIndex]) {
				++bIndex;
			} else {
				++cIndex;
			}
		}
		return common;
	}

	static class Elements {
        int value;
        int indexOfArrays;
        int indexInArray;
        Elements(int value, int indexOfArrays, int indexInArray) {
            this.value = value;
            this.indexOfArrays = indexOfArrays;
            this.indexInArray = indexInArray;
        }
    }



    public List<Integer> commonII(int[] a, int[] b, int[] c, int k) {
        if (a.length == 0 || b.length == 0 || c.length == 0) {
            return null;
        }
        List<Integer> common = new ArrayList<>();
        Elements[] array = new Elements[k];
        for (int i = 0; i < k; i++) {
            array[i] = new Elements(a[0], i, 0);
        }


        int max = Integer.MIN_VALUE;
        PriorityQueue<Elements> min = new PriorityQueue<>(k, new Comparator<Elements>() {
            @Override
            public int compare(Elements o1, Elements o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        for (int i = 0; i < k; i++) {
            if (array[i].value > max) {
                max = array[i].value;
            }
            min.add(array[i]);
        }

        return common;
    }
}
