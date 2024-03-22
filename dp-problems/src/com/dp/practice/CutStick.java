package com.dp.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CutStick {
    private List<List<Integer>> perm = new ArrayList<>();
    private int[] cuts;
    private List<Integer> list;
    private int k;
    public int minCost(int n, int[] cuts) {
        this.cuts = cuts;
        int minCost = Integer.MAX_VALUE;
        List<Integer> curr = new ArrayList<>();
        for (int cut: cuts) {
            curr.add(cut);
        }
        permute(0, curr);
        System.out.println(perm);
        for (List<Integer> list: perm) {
            this.k = 0;
            this.list = list;//perm.get(11);
            int cost = getMinCost(0, n, 0);
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);
        return minCost;
    }

    private int getMinCost(int i, int j, int k) {
        if (i == j) return 0;
        if (k >= list.size()) return 0;

        int sum = 0;
        if (list.get(k) > i && list.get(k) < j) {
            //found
            sum += j - i + getMinCost(i, list.get(k), k + 1) + getMinCost(list.get(k), j, k + 1);
        } else {
            sum += getMinCost(i, j, k + 1);
        }

        return sum;
    }

    private void permute(int index, List<Integer> list) {
        if (index == cuts.length) {
            perm.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, i, index);
            permute(index + 1, list);
            Collections.swap(list, i, index);
        }

    }

    public static void main(String[] args) {
        CutStick cutStick = new CutStick();
        cutStick.minCost(7, new int[]{1,3, 5, 4});
    }

}
