public class Power {
	public long power(int a, int b) {
		if (a == 0) {
			return 0;
		}

		if ( b == 0) {
			return 1;
		}

		if ( b % 2 == 0) {
			return power(a, b / 2) * power(a, b / 2);
		}
		else {
			return a*power(a, b / 2) * power(a, b / 2);
		}
	}
}