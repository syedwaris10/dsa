package com.stack;

import java.util.*;
public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution.nextGreaterElement(new int[]{7, 12, 1, 20}, 4);
    }
}