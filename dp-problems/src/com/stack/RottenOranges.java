package com.stack;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int time = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] arr = q.remove();
                grid[arr[0]][arr[1]] = 2;
                if (arr[0] + 1 < grid.length && grid[arr[0] + 1][arr[1]] == 1) {
                    q.add(new int[]{arr[0] + 1, arr[1]});
                }

                if (arr[0] - 1 >= 0 && grid[arr[0] - 1][arr[1]] == 1) {
                    q.add(new int[]{arr[0] - 1, arr[1]});
                }

                if (arr[1] + 1 < grid[0].length && grid[arr[0]][arr[1] + 1] == 1) {
                    q.add(new int[]{arr[0], arr[1] + 1});
                }

                if (arr[1] - 1 >= 0 && grid[arr[0]][arr[1] - 1] == 1) {
                    q.add(new int[]{arr[0], arr[1] - 1});
                }
                size--;
            }
            time++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return time == 0 ? 0: time - 1;
    }

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        rottenOranges.orangesRotting(new int[][]{{2, 2}, {1, 1},{0, 0}, {2, 0}}); //[[2,2],[1,1],[0,0],[2,0]]
    }
}
