public class LongestConsecutiveSequenceArray {

    public int minInHashSet(HashSet<Integer> set) {
        int min = Integer.MAX_VALUE;
        for (int i : set) {
            if (min > i) min = i;
        }
        return min;
    }

    public int maxInHashSet(HashSet<Integer> set) {
        int max = Integer.MIN_VALUE;
        for (int i : set) {
            if (max < i) max = i;
        }
        return max;
    }

    public int longestConsecutive(final int[] array) {

        HashSet<Integer> set = new HashSet<>();
        for (Integer number : array) {
            set.add(number);
        }

        int min = minInHashSet(set);
        int max = maxInHashSet(set);

        int consecCount = 1;
        int maxByFar = 1;

        int prev = min;
        for (int i = min + 1; i <= max; i++) {
            if (set.contains(i)) {
                consecCount++;
                if (maxByFar < consecCount) maxByFar = consecCount;
            } else {
                consecCount = 0;
            }
        }
        return maxByFar;
    }
}
