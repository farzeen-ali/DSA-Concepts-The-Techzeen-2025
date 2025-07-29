import java.util.Arrays;

public class ArrayReverser {
    public static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5};
        reverseArray(data);
        System.out.println("Reversed Array: " + Arrays.toString(data));
    }
}
