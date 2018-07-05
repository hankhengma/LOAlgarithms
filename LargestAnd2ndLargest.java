import java.util.*;

public class LargestAnd2ndLargest {
    public static void main(String[] args) {
        LargestAnd2ndLargest sol = new LargestAnd2ndLargest();
        int[] array = {1,2,3,4,5};
        int[] result = sol.findLarge(array);
        System.out.println(Arrays.toString(result));
    }
    static class Element {
        int value;
        List<Integer> compared;
        Element(int value) {
            this.value = value;
            this.compared = new ArrayList<>();
        }
    }

    public int[] findLarge(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        Element[] elements = convert(array);
        int length = array.length;

        while (length > 1) {
            compare(elements, length);
            length = (length + 1) / 2;
        }
        return new int[]{elements[0].value, largest(elements[0].compared)};
    }

    private void swap(Element[] elements, int left, int right) {
        Element temp = elements[left];
        elements[left] = elements[right];
        elements[right] = temp;
    }

    private Element[] convert(int[] array) {
        int length = array.length;
        Element[] result = new Element[length];
        for (int i = 0; i < length; i++) {
            result[i] = new Element(array[i]);
        }
        return result;
    }

    private int largest(List<Integer> compared) {
        int largest = Integer.MIN_VALUE;
        for (Integer num : compared) {
            largest = Math.max(largest, num);
        }
        return largest;
    }

    private void compare(Element[] elements, int length) {
        for (int i = 0; i < length / 2; i++) {
            if (elements[i].value < elements[length - 1 - i].value) {
                swap(elements, i, length - 1 - i);
            }
            elements[i].compared.add(elements[length - 1 - i].value);
        }
    }
}
