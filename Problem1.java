public class Problem1 {
    public static void approach1(int[] arr){
        if (arr.length == 0 || arr == null){
            System.out.println("Array empty");
            return;
        }
        int min = arr[0];
        int max = arr[0];
        double sum = 0;
        for (int count : arr){
            sum += count;
            if(count > max) max = arr[count];
            if(count < min) min = arr[count];
        }
        double average = sum / arr.length;
        System.out.println("Sum:" + sum);
        System.out.println("Max:" + max);
        System.out.println("Min:" + min);
        System.out.println("Average:" + average);
    }

    public static void approach2(int[] arr){
        if (arr == null || arr.length == 0){
            System.out.println("array empty");
            return;
        }
        int min = arr[0];
        int max = arr[0];
        double sum = 0;
        // sum
        for (int num : arr){
            sum += num;
        }
        //average
        double average = sum / arr.length;
        //max
        for (int count : arr){
            if (count > max) max = count;
        }
        // min
        for (int value : arr){
            if (value < min) min = value;
        }
        System.out.println("Sum" + sum);
        System.out.println("Average" + average);
        System.out.println("Max" + max);
        System.out.println("Min" + min);
    }

    public static void approach3(int arr[]){
        int temp; 
        double sum = 0;
        // sort
        for (int i = 0; i < arr.length - 1; i++){
            for ( int x = 0; x < arr.length - 1 - i; x++){
                if(arr[x] > arr[x+1]){
                    temp = arr[x];
                    arr[x] = arr[x+1];
                    arr[x+1] = temp;
                }
            }
        }
        for (int num : arr){
            sum += num;
        }
        double average = sum /arr.length;
        System.out.println("Max" + arr[arr.length - 1]);
        System.out.println("Min" + arr[0]);
        System.out.println("Average" + average);
    }

    public static void main(String[] args) throws Exception {
        int myNum[] = {4, 3, 2, 6, 1};
        approach3(myNum);
    }
}
