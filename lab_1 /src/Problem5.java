public class Problem5 {
    public static void checkArray(int[] arr){
        if(arr.length == 0 || arr == null){
            System.out.println("Array is not found or empty");
            return;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }

    public static int partition(int[] arr, int low, int high){
        int i = low - 1;
        int pivot = arr[high];
        for(int j= low; j <= high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap( arr, i+ 1, pivot);
        return i + 1;
    }

    public static void QuickSort(int[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }  
    }

    public static void SortAndScan(int arr[]){
        checkArray(arr);
        QuickSort( arr, 0, arr.length);
        int sec_best = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 1; i--){
            if(arr[i] > arr[i - 1]){
                sec_best = arr[i - 1];
                break;
            }
        }
        System.out.println("the second most value" + sec_best);
    }

    public static void ScanBestAndSec(int[] arr){
        int best = arr[0];
        int sec = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > best){
                sec = best;
                best = arr[i];
            }
            else if(arr[i] > sec && arr[i] != best){
                sec = arr[i];
            }
        }
        if (sec == Integer.MIN_VALUE){
            System.out.println("There's no second largest value");
        }
        else{
            System.out.print("Largest:" + best);
            System.out.println("Second best" + sec);
        }
    }

    public static void main(String args[]) throws Exception{
        int Arr[] = {6, 2, 5, 213,5, 12, 4};
        ScanBestAndSec(Arr);
    }
}
