import java.util.Arrays;

public class SortInSpecifiedOrder {
    public static void main(String[] args) {
        SortInSpecifiedOrder sol = new SortInSpecifiedOrder();
        int[] a = {2,1,2,5,7,1,9,3};
        int[] b = {2,1,3};
        sol.sortSpecial(a,b);
        System.out.println(Arrays.toString(a));
    }
    public int[] sortSpecial(int[] a, int[] b) {
        // assumption: a and b are not null;
        if (a.length == 0 || b.length == 0) {
            if (a.length == 0) {
                return a;
            } else {
                return b;
            }
        }
        int index = 0;
        int slow = 0;

        sortSpecialHelper(a, b, index, slow);
        return a;
    }

    private void sortSpecialHelper(int[] a, int[] b, int index, int slow) {
        int fast = slow;
        if (index >= b.length) {
            return;
        }

        while (fast < a.length) {
            if (a[fast] != b[index]) {
                fast++;
            } else {
                swap(a, slow++, fast++);
            }
        }
        sortSpecialHelper(a, b, index + 1, slow);
        // need post-process
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}