package com.graph;

import java.util.*;

public class CountAllPossiblePaths {

    public int isPossible(int[][] paths)
    {
        int[] indegree = new int[paths.length];

        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                if (paths[i][j] == 1) {
                    indegree[j]++;
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] % 2 != 0) {
                return 0;
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        CountAllPossiblePaths countAllPossiblePaths = new CountAllPossiblePaths();
        int ans = countAllPossiblePaths.isPossible(new int[][]{{0,1,1, 0}, {1, 0, 1, 1}, {1, 1, 0, 0},{0, 1, 0, 0}});
        System.out.println(ans);
    }
}
