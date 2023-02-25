
    /*
    Problem Statement
    -----------------
    Given a matrix of size m*2, each row is an interval on the number line.
    Return a matrix of size n*2 (n<=m) where, again each row is an interval on 
    the number line but this time compressed with the overlapping intervals
    merged.
    
    Time Complexity  : O(m) m=rows
    Space Complexity : O(1)
     */
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<int[]>();
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
