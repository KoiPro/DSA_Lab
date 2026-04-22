package Exercises;

public class TwoSum {   // ✅ must be public
    public static boolean twoSum(int[] arr, int target) {
        if (arr == null || arr.length < 2) return false;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 8, 9};
        int target = 15;
        boolean result = TwoSum.twoSum(arr, target);
        System.out.println("Pair exists? " + result);
    }
}