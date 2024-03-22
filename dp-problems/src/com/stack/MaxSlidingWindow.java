package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) return nums;

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            nge(dq, nums, i, k);
        }

        int j = 0;
        ans[j++] = nums[dq.peekFirst()];

        for (int i = 1; i < nums.length; i++) {
            nge(dq, nums, i, k);
            ans[j++] = nums[dq.peekFirst()];
        }
        return ans;
    }

    private void nge(Deque<Integer> dq, int[] nums, int i, int k) {
        while (!dq.isEmpty() && nums[dq.peek()] < nums[i]) {
            dq.removeLast();
        }

        dq.addLast(i);
        if (dq.peekFirst() < i + 1 - k) {
            dq.removeFirst();
        }

    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
