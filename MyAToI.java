/*************
transfer a string to integer
case 1: null or empty string
case 2: leading space;
case 3: sign +/-
case 4: tailing space;
case 5: overflowing int;
case 6: overflowing Long;

todo:
case 7: 8E2;
case 8: 8^2;
*************/
public class MyAToI {
	public int convertor(String str) {
		// deal with case 1;
		if (str == null || str.length() == 0) {
			return 0;
		}

		int len = str.length();
		int i = 0;

		// deal with leading space: case 2;
		while (i < len && str.charAt(i) == ' ') {
			i++;
		}
		// deal with space: case 3;
		boolean positive = true;
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			positive = (str.charAt(i) == '+');
			i++;
		}

		long sum = 0;
		while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			sum = 10 * sum + (str.charAt(i) - '0');
			if (sum > (long)Integer.MAX_VALUE + 1) {
				break;
			}
			i++;
		}
		sum >= 0 ? sum : -sum;

		if (sum > (long)Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		if (sum < (long)Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int)sum;
	}
}