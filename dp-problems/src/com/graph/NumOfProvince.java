package com.graph;

import java.util.*;

public class NumOfProvince {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    map.putIfAbsent(i, new ArrayList<>());
                    map.putIfAbsent(j, new ArrayList<>());

                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }


        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i);
            }
        }
        return count;
    }


    private void dfs(int src) {
        if (visited.contains(src)) {
            return;
        }

        visited.add(src);
        if (map.get(src) == null) {
            return;
        }

        for (Integer child: map.get(src)) {
            if (visited.contains(child)) {
                continue;
            }

            dfs(child);
        }
    }

    public static void main(String[] args) {
        NumOfProvince numOfProvince = new NumOfProvince();
        //[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        int ans = numOfProvince.findCircleNum(new int[][]{{1,0,0,1}, {0,1,1,0}, {0,1,1,1},{1,0,1,1}});
        System.out.println(ans);
    }
}
