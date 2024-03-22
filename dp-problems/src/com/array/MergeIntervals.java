package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int i = 1;
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {return a[0] - b[0]; });
        while (i < intervals.length) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i - 1] = null;
            }
            i++;
        }

        for (int[] interval: intervals) {
            if (interval != null) {
                l.add(Arrays.asList(interval[0], interval[1]));
            }
        }

        int[][] res = new int[l.size()][2];
        int j = 0;
        for(List<Integer> list: l) {
            res[j][0] = list.get(0);
            res[j][1] = list.get(1);
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
