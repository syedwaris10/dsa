package com.binarsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NthRoot {
    public static int NthRoot(int n, int m) {
        int range = m / n;

        int left = 1, right = range;
        while (left <= right) {
            int mid = left + right / 2;
            int ans = (int)Math.pow(n, mid);
            if (ans == m) return mid;
            else if (ans > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(2);
        ll.add(3);

        List<Integer> list = new ArrayList<>();
        list.addAll(ll);
        System.out.println(list);
       // NthRoot.NthRoot(4, 69);
    }
}
