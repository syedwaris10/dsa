package com.graph;

import java.util.*;

public class TopoSort {

    static int[] topoSort(int V, ArrayList<List<Integer>> adj)
    {
        int[] ans = new int[V];
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for (List<Integer> l : adj) {
            indegree[l.get(1)]++;
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }


        int j = 0;
        while (!q.isEmpty()) {
            Integer node = q.remove();

            ans[j++] = node;

            for (Integer child : adj.get(node)) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    q.add(child);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> adj = new ArrayList<>();
        List<Integer> l1 = Arrays.asList(3, 0);
        List<Integer> l2 = Arrays.asList(1, 0);
        List<Integer> l3 = Arrays.asList(2, 0);
        adj.add(l1);
        adj.add(l2);
        adj.add(l3);
    //    List<Integer> l4 = Arrays.asList(3, 0);
        TopoSort.topoSort(4, adj);
    }
}
