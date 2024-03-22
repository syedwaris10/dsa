package com.dp.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Frog {

    public boolean canReach(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            if (i + arr[i] >= arr.length - 1)  return true;
            if (arr[i] == 0) return false;
            if (arr[i + arr[i]] != 0) {
                i = i + arr[i];
            } else {
                arr[i] = arr[i] - 1;
            }
        }

        return true;
    }

    boolean sameFreq(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        set = new HashSet<>(map.values());
        int count = 0;
        int val = -1;
        for (int value: map.values()) {
            if (val != value) {
                count++;
                val = value;

            }
        }
        return count == 1;

    }

    public static void main(String[] args) {
        Frog frog = new Frog();
       // boolean ans = frog.canReach(new int[]{1, 0, 1});
//        boolean ans = frog.sameFreq("xyyz");
//        System.out.println(ans);
//
//        StringTokenizer stringTokenizer = new StringTokenizer("ab+cd e", "+ ");
//        while (stringTokenizer.hasMoreTokens()) {
//            System.out.println(stringTokenizer.nextToken());
//        }
//        Map<Character, Integer> map = new HashMap<>();

        String s = "01";
        int r = 2;
        Map<Character, String> m = new HashMap<>();
        m.put('0', "01");
        m.put('1', "10");

        while (r > 0) {
            for (int i = 0; i < s.length(); i = i+2) {
                s =  s.substring(0, i) + m.get(s.charAt(i)) + s.substring(i + 1, s.length());
            }
            r--;
        }
      //  StringJoiner stringJoiner = new StringJoiner();
     //   System.out.println(stringTokenizer.toString());

        frog.shorten("zfbgfxhgcmhj,kjkj324576896765432456798676");

    }

    public void shorten(String url) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
    }
}
// 1, 5, 0, 0, 0, 0