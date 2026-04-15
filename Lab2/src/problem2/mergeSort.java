package problem2;

public class mergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;    //Get middle index
            mergeSortHelper(arr, temp, left, mid);  //Sort left half
            mergeSortHelper(arr, temp , mid + 1, right);    //Sort right half
            merge(arr, temp, left, mid, right);    //Merge sorted halves
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for(int i = left; i <= right; i++){
            temp[i] = arr[i];
        }

        int i = left; //left subarray index
        int j= mid + 1; //right subarray index
        int k = left; //merged array index

        while(i <= mid && j <= right){
            if(temp[i] <= temp[j]){
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid){
            arr[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 16, 23, 4, 42, 8};
        mergeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
