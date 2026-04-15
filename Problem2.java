import java.util.Stack;

public class Problem2 {
    public static void approach1(int[] arr){
        if(arr.length == 0 || arr == null){
            System.out.println("Array empty");
            return;
        }
        int[] newArr = new int[arr.length];
        for (int i= 0; i < arr.length; i++){
            newArr[i] = arr[arr.length - 1 - i];
        }
        for(int value : newArr){
            System.out.println(value);
        }
    }
    public static void approach2(int[] arr){
        if(arr.length == 0 || arr == null){
            System.out.println("Array empty");
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        int temp;
        while (left < right){
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for (int count : arr){
            System.out.println(count);
        }
    }
    public static void approach3(int[] arr){
        Stack<Integer> s = new Stack<>();
        for(int num : arr){
            s.push(num);
        }
        for (int j= 0; j < arr.length; j++){
            arr[j] = s.pop();
        }
    }
    public static void main(String[] arg) throws Exception{
        int TestArr[] = {5, 4, 3, 2, 1};
        approach3(TestArr);
    }
}
