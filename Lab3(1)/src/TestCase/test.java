package TestCase;

import Exercises.TwoSum;  // adjust import to actual class name

public class test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 8, 9};
        int target = 15;
        boolean result = TwoSum.twoSum(arr, target);
        System.out.println("Pair exists? " + result);
    }
}