package com.dp.practice;

import java.util.Arrays;

public class TripletSum {
    static int A[];
    static int X;
    static int n;
    static Boolean[][] memo;
    public static boolean find3Numbers(int A[], int n, int X) {
        // Solution.A = A;
        // Solution.X = X;
        // Solution.n = n;
        // Solution.memo = new Boolean[n][X + 1];
        // return check(0, 3, 0);

        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                if (sum == X) {
                    return true;
                }

                if (sum > X) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return false;

    }

//    private static boolean check(int index, int count, int sum) { //recursive approach gives 2^n in worst case
//        if (sum == X && count == 0) return true;
//        if (count == 0) return false;
//        if (sum > X) return false;
//        if (index >= n) return false;
//        if (memo[index][sum] != null) {
//            return memo[index][sum];
//        }
//        if (check(index + 1, count - 1, sum + A[index]) || check(index + 1, count, sum)) {
//            return  memo[index][sum] = true;
//        }
//        return memo[index][sum] = false;
//    }
}
