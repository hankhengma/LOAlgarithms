import java.util.*;

public class MergeIntervals {
	static class Interval implements Comparable<Interval> {
		int start;
		int end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e) { start = s; end = e;}
		
		@Override
		public int compareTo(Interval interval) {
			return this.start < interval.start ? -1 : this.start == interval.start ? 0 : 1;
		}
	}

	
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}

		LinkedList<Interval> merged = new LinkedList<>();
		Collections.sort(intervals);
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
