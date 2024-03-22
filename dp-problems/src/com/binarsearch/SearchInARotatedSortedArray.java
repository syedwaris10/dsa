package com.binarsearch;

public class SearchInARotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums[0] < nums[nums.length - 1]) return binarySearch(0, nums.length - 1, target, nums);

        int pivot = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                pivot = i;
                break;
            }
        }

        int key = binarySearch(0, pivot - 1, target, nums);
        if (key == -1) {
            return binarySearch(pivot + 1, nums.length - 1, target, nums);
        }
        return key;

    }
    private int binarySearch(int left, int right, int target, int[] nums) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if(target > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        SearchInARotatedSortedArray searchInARotatedSortedArray = new SearchInARotatedSortedArray();
        searchInARotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 3);
    }
}
