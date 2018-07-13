public class MaximumValuesOfSizeKSlidingWindows {
	public List<Integer> maxWindows(int[] array, int k) {
		if (k.length == 0 || k < 1) {
			return null;
		}

		List<Integer> result = new ArrayList<>();
		//store the index;
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < array.length; i++) {
			while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
				deque.pollLast();
			}
			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				// check if the deque is within the sliding window size;
				deque.pollFirst();
			}
			deque.offerLast(i);
			if (i >= k - 1) {
				result.add(array[deque.peekFirst()]);
			}
		}
		return result;
	}
}


/************************
0 1 2 3 4 5 6 7 8
1 3 2 5 8 9 4 7 3
-----
{(7,7), (3,8)}

3, 5, 8, 9 , 9, 9 7,


{(7,7) (3,8)}

example: k = 3;
d f{}l
i = 0 <1,0>
d{<1,0>}

i = 1 <3,1>
since 3 is larger than 1 and the index is larger which means <3,1> is newer and larger than <1,0>, so deque pollFirst() and offerLast();
d{<3,1>}

i = 2 <2,2>
2 is smaller than 3 then just offerLast();
d{<3,1> <2,2>}

i = 3 <5,3>
5 is larger than 2 so deque.pollLast();
d{<3,1>}
5 is larger than 3 so deque.pollLast() and deque.offerLast(<5,3>);
d{<5,3>}

i = 4
{<8,4>}

i = 5
{<9,5>}

i = 6 <4,6>
{<9,5>, <4,6>}

i = 7 <7,7>
{<9,5>, <7,7>}

i = 8 <3,8>
{<9,5>, <7,7>, <3,8>}
but <9,5> is out of the sliding window so need to pop it out; deque.pollFirst();
{<7,7>, <3,8>}

for each sliding window just need to record the leftmost elements as the final result