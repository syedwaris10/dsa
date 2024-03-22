package com.cardinalhealth;


/**
 * Write a program using recursion to determine whether the given input String is a palindrome or not.
 */
public class Test {
    static String s;

    //String str , int i = 0, j = len - 1
    public static boolean check(int i, int j) {
        if (i >= j) return true;

        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }

        if (!check(i + 1, j - 1)) {
            return false;
        }
        return true;
    }


    /**
     * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
     * For example, in an array A:
     *
     * Example :
     *  prefi -      0, -7, -6, -1, 1, -3, 0
     * Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
     * suffix =     9   8   3   1    -1   3,  ,0
     * Output: 3
     * 3 is an equilibrium index, because:
     * A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
     *
     * Input: A[] = {1, 2, 3}
     * Output: -1
     *
     * Write a function int equilibrium(int[] arr, int n); that given a sequence arr[] of size n, returns an equilibrium index (if any) or -1 if no equilibrium indexes exist
     * @param// args
     */

    public static int equilibrium(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 0;
        prefix[1] = prefix[0];
        for (int i = 2; i < nums.length; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 2];
        }
        suffix[nums.length - 1] = 0;
        suffix[nums.length - 2] = nums[nums.length - 1];
        for (int i = nums.length - 3; i >= 0; i--) {
            suffix[i] = nums[i + 1] + suffix[ i + 2];
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefix[i] == suffix[i]) {
                return i;
            }
        }
        return -1;
    }


    /**
     * A Magic Number is a number which is equal to the product of the sum of all digits of a number and reverse of the sum. This is also known as Ramanujan Number or Taxicab Number. For Example, 1729 is a Magic Number.
     * Sum of all digits is 19, the reverse of the Sum is 91, and Product of these numbers 19 * 91 is equal to the original number (19 * 91 = 1729).
     * In this program, let’s print the Ramanujan Number
     * @param args
     */

    public static boolean magicNumber(int num) {
        String value = String.valueOf(num);
        int sum = 0;
        int n1 = num;
        while (n1 != 0) {
            sum += n1 % 10;
            n1 = n1 / 10;
        }

        System.out.println(sum);
        int n = sum;
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 +  n% 10;
            n = n / 10;
        }
        System.out.println(rev);

        return (sum * rev) == num;

    }
    public static void main(String[] args) {
//        Test.s = "abba";
//        boolean ans = check(0, s.length() - 1);
//        System.out.println(ans);
//        int res = equilibrium(new int[]{-7, 1, 5, 2, -4, 3, 0});
//        System.out.println(res);

        boolean b =magicNumber(1729);
        System.out.println(b);

    }

}
