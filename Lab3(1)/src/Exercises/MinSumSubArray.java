package Exercises;

public class MinSumSubArray {
    public static int MinSum(int [] arr, int target){
        if (arr == null || arr.length == 0) return 0;
        int left = 0;
        int current_sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0; right < arr.length; right++){
            current_sum += arr[right];
            while (current_sum >= target){
                int windowLength = right - left + 1;
                if (windowLength < minLength){
                    minLength = windowLength;
                }
                current_sum -= arr[left];
                left++;
            }
       }
       return (minLength == Integer.MAX_VALUE)? 0:minLength;
    }

    public static void main(String arg[]){
        int[] arr1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        int min = MinSum(arr1, target1);
        System.out.println("Minimum length (target=7): " + min); 
    }
}
