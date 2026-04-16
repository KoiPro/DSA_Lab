import java.util.Arrays;

public class Problem3 {
    public static void Search1(int[] arr, int x){
        if (arr.length == 0 || arr == null){
            System.out.println("The array is empty");
        }
        int occurance = 0;
        boolean flag_find = false;
        int firstIndex = -1;
        for(int i = 0; i < arr.length; i ++){
            if (arr[i] == x){
                if(!flag_find){
                    firstIndex = i;
                    flag_find = true;
                }
                occurance++;
            } 
        }
            
        if (flag_find){
            System.out.println("First occurance index" + firstIndex);
            System.out.println("Number of occurace:" + occurance);
        }
        else{
            System.out.println("The target not found");
        }
    }

    public static void Search2(int[] arr, int x){
        boolean exist = false;
        int count = 0;
        int firstIndex = -1;
        for(int i = 0; i < arr.length - 1; i ++){
            if(arr[i] == x){
                exist = true;
                firstIndex = i;
                break;
            }
        }
        for(int j = 0; j < arr.length - 1; j ++){
            if(arr[j] == x){
                count++;
            }
        }
        if (exist){
            System.out.println("First found at:" + firstIndex);
            System.out.println("Number of found:" + count);
        }
        else{
            System.out.println("the value is not found");
        }
    }

    public static void Search3(int[] arr, int x){
        if (arr.length == 0 || arr == null){
            System.out.println("Array not found or empty");
        }
        
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        int index = Arrays.binarySearch(sorted , x);
        if (index < 0){
            System.out.println("target not found");
            return;
        }
        
        // It's a binary search since the array is sorted. Hence by binary search and find the first index, just need to scan from right to left to find the first index
        int firstIndex = index;
        while(firstIndex > 0 && sorted[firstIndex - 1] == x){
            firstIndex--;
        }

        int count = 0;
        int i  = firstIndex;
        while(i < sorted.length && sorted[i] == x){
            count++;
            i++;
        }

        System.out.println("Target" + x);
        System.out.println("First occurace:" + firstIndex);
        System.out.println("Count:" + count );
        System.out.println("Sorted array");
        for(int num: sorted)System.out.print(num + " ");
    }

    

    public static void main(String args[]) throws Exception{
        int myNum[] = {6, 123, 521, 124, 52, 16, 4, 6, 1, 5, 6};
        Search3(myNum, 123);

    }
    
    
}
