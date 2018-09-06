public class Split {
	public int split(int num) {
		int[] m = new int[num + 1];
		m[0] = 0;
		m[1] = 1;
		m[2] = 2;
		m[3] = 3;

		for (int i = 4; i <= num; i++) {
			m[i] = i;
			for (int j = 1; j * j <= i; j++) {
				m[i] = Math.min(m[i],m[num - j]);
			}
		}
		return m[num];
	}
}