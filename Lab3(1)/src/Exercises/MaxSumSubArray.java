package Exercises;

public class MaxSumSubArray {
    public static int MaxSum(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        int current_sum = arr[0];
        int best_sum = arr[0];
        for(int length = 1; length < arr.length; length++){
            for(int window = 1; window < arr.length; window += length){
                current_sum += arr[window];
            }
            if(current_sum > best_sum){
                best_sum = current_sum;
            }
            current_sum = arr[0];
        }
        return best_sum;
    }

    public static void main(String arg[]) throws Exception{
        int[] arr = {0,5,-4,5,6,-7,-5,-1,4,5,9};
        int sum = MaxSum(arr);
        System.out.println("The max sum of the array: "+ sum);
    }
}
