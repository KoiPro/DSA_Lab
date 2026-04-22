package Exercises;

public class RemovDup {
    public static int RemoveDup(int[] arr){
        if (arr == null || arr.length == 0) return -1;
        int write = 0;
        for(int read = 1; read < arr.length; read++){
            if(arr[write] != arr[read]){
                write++;
                arr[write] = arr[read];
            }
        }
        return write + 1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int count = RemoveDup(arr);
        System.out.println("Number of dup:" + count);
        System.out.println("Array after remove:");
        for(int i = 0; i < count; i++){
            System.out.print(" " + arr[i]);
        }
    }
    
}

