import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(intervals[i][1], current[1]);
            } else {
                merged.add(current);
                current = intervals[i];
            }
        }

        merged.add(current);
        return merged.toArray(new int[merged.size()][]);
    }

    public void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeIntervals merger = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        
        System.out.println("Original Intervals:");
        merger.printIntervals(intervals);

        int[][] mergedIntervals = merger.mergeOverlappingIntervals(intervals);

        System.out.println("Merged Intervals:");
        merger.printIntervals(mergedIntervals);
    }
}
