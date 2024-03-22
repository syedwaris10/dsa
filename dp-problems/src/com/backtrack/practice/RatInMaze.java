package com.backtrack.practice;

import java.util.ArrayList;

public class RatInMaze {
    static ArrayList<String> ans = new ArrayList<>();
    public static ArrayList<String> findPath(int[][] arr, int n) {
        helper(0, 0, n, arr, "");
        System.out.println(ans);
        return ans;
    }

    private static void helper(int row, int col, int n, int[][] arr, String str) {
        if (row == n - 1 && col == n - 1) {
            ans.add(str);
            return;
        }

        if (row < 0 || col < 0 || row >= n || col >= n || arr[row][col] == 0) {
            return;
        }

        arr[row][col] = 0;

        helper(row - 1, col, n, arr, str + "U");
        helper(row + 1, col, n, arr, str + "D");
        helper(row, col + 1, n, arr, str + "R");
        helper(row, col - 1, n, arr, str + "L");

        arr[row][col] = 1;

    }

    public static void main(String[] args) {
        RatInMaze.findPath(new int[][]{{1, 0, 0, 0},{1,1,0,1},{1,1,0,0},{0,1,1,1}}, 4);
    }
}
