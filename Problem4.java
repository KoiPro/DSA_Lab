

public class Problem4 {
    public static void checkArray(int[] arr){
        if (arr == null || arr.length == 0){
            System.out.println("array is empty or not found");
            return;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j <= high; j++){
            if (arr[j] > pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i + 1;
    }

    public static void sortDescendOrderQuickSort(int[] arr, int low, int high){
        if ( low < high){
            int pi = partition(arr, low, high);
            sortDescendOrderQuickSort(arr, low, pi - 1);
            sortDescendOrderQuickSort(arr, pi + 1, high);
        }
    }

    public static void CompareAdjValue(int[] arr){
        checkArray(arr);
        boolean sorted = true;
        for(int i = 0; i < arr.length - 1; i ++){
            if (arr[i] < arr[i + 1]){
                sorted = false;
                break;
            }
        }
        if(sorted){
            System.out.println("the array is sorted");
        }
        else{
            System.out.println("The array is not sorted");
        }
    }



    public static void CopySortedCompare(int arr[]){
        checkArray(arr);
        int[] sorted = arr.clone();
        sortDescendOrderQuickSort(sorted, 0, sorted.length - 1);
        boolean arr_sorted = true;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != sorted[i]){
                arr_sorted = false;
                break;
            }
        }
        if(arr_sorted){
            System.out.println("Is already sorted");
        }
        else{
            System.out.println("The array is not sorted yet");
        }
    }

    public static void detectDisorder(int[] arr){
        int disorder = 0;
        for(int i = 0; i < arr.length - 1; i ++){
            if(arr[i] < arr[i+1]){
                disorder++;
            }
        }
        if (disorder == 0){
            System.out.println("the array is sorted");
        }
        else{
            System.out.println("Number of disorder:" + disorder);
        }
    }

    public static void main(String args[]) throws Exception{
        int myArr[] = {7, 5, 4, 3, 2, 1};
        int myUnOrderArr[] = {9, 5, 3, 1, 5, 6};
        detectDisorder(myArr);
    }
    
}