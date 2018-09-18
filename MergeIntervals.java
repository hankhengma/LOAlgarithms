import java.util.*;

public class MergeIntervals {
	static class Interval {
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e) { start = s; end = e;}
	}

	static class newComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			return i1.start < i2.start ? -1 : i1.start == i2.start ? 0 : 1;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}

		LinkedList<Interval> merged = new LinkedList<>();

		for (Interval interval : intervals) {
			if (merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			} else {
				merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			}
		}
		return merged.
	}
}