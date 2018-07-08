public class CommonElements {
	// sorted no duplicate int array;
	public static void main(String[] args) {
        CommonElements sol = new CommonElements();
        int[] a = {1,2,3,4,5};
        int[] b = {1,3,5};
        int[] result = sol.common(a,b);
        System.out.println(Arrays.toString(result));
    }
    // two sorted ascending with no duplication;
    public int[] common(int[] a, int[] b) {
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return null;
        }

        int aFast = 0; // a's current pointer;
        int aSlow = 0; // use a's part as the result;
        int bIndex = 0;

        while (aFast < a.length && bIndex < b.length) {
            if (a[aFast] == b[bIndex]) {
                a[aSlow++] = a[aFast++];
                bIndex++;
            } else if (a[aFast] < b[bIndex]) {
                ++aFast;
            } else {
                ++bIndex;
            }
        }
        return Arrays.copyOfRange(a, 0, aSlow);
    }
}