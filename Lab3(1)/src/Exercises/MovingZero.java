package Exercises;

public class MovingZero {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void ZeroMove(int[] arr){
        if(arr == null || arr.length == 0) return;
        int write = 0;
        for(int read = 0; read < arr.length; read++){
            if(arr[read] != 0){
                if (read != write){
                    swap(arr, write, read);
                }
                write++;
            }
        }
    }

    public static void main(String arg[]){
        int arr[] = {1,0,3,0,0,5,0,6,0,9};
        ZeroMove(arr);
        for(int num: arr){
            System.out.print(num + ", ");
        }
    }
}
