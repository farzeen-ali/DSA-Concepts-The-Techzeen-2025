import java.util.Arrays;

public class ArrayInsertion {
    public static void main(String[] args) {
//        int[] arr = {10,20,30}; // size = 3
        int value = 5;
//        Insert at beginning
//        int[] newArr = new int[arr.length + 1]; // size = 4
//        newArr[0] = value; // O(1)
//
//        for (int i = 0; i < arr.length; i++){
//            newArr[i + 1] = arr[i]; // 5, 10, 20, 30
//        }
//        System.out.println(Arrays.toString(newArr));

//        Insertion at end
//        int[] newArr = new int[arr.length + 1];
//
//        for(int i = 0; i < arr.length; i++){
//            newArr[i] = arr[i]; // 10,20,30 (0,1,2)
//        }
//        newArr[arr.length] = value; // 5 (3)
//        System.out.println(Arrays.toString(newArr));

//        Insertion at any index
        int[] arr = {10,20,30,40}; // 4
        int index = 2; // 10, 20, 30

        int[] newArr = new int[arr.length + 1]; // 5
        for (int i = 0; i < index; i++){
            newArr[i] = arr[i]; // 10 (0), 20 (1)
        }
        newArr[index] = value; // 5 (2)
        for (int i = index; i < arr.length; i++){
            newArr[i + 1] = arr[i]; // 30, 40 (3, 4)
        }
        System.out.println(Arrays.toString(newArr));
    }
}
