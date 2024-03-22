package com.dp.practice;

import java.util.*;

public class KnihtDialers {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer>  visited = new HashSet<>();
    int mod = 100000007;
    int count;
    public int knightDialer(int n) {
        if (n == 1) return 10;
        map.put(0, Arrays.asList(4, 6));
        map.put(1, Arrays.asList(6, 8));
        map.put(2, Arrays.asList(7, 9));
        map.put(3, Arrays.asList(4, 8));
        map.put(4, Arrays.asList(0, 3, 9));
        map.put(6, Arrays.asList(0, 7, 1));
        map.put(7, Arrays.asList(2, 6));
        map.put(8, Arrays.asList(1, 3));
        map.put(9, Arrays.asList(4, 2));

        for (int i = 0; i < 10; i++) {
            dfs(i, i, n);
        }
      //  dfs(1, 1, n);
        return count % mod;

    }

    private void dfs(int i, int num, int n) {
        if (n == 1) {
            //if (!visited.contains(num % mod)) {
               // System.out.println(num);
              //  visited.add(num);
                count = (1 + count) % mod;
           // }

            return;
        }

        if (i == 5) {
            return;
        }

        for (int v: map.get(i)) {
            dfs(v, (num * 10 + v) % mod, n - 1);
        }

    }

    public int test() {
        try {
            int a = 10 / 0;
        }

        catch (ArithmeticException e) {

            return 2;
        }

        finally {
            System.out.println("hi");
        }

        return 3;
    }

    public static void main(String[] args) {
        KnihtDialers knihtDialers = new KnihtDialers();
//        int ans = knihtDialers.knightDialer(22);
//        System.out.println(ans);

        int ans = knihtDialers.test();
        System.out.println(ans);
    }
}
