import java.util.Arrays;

public class ArrayDeletion {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Original Array: " + Arrays.toString(numbers));

//        Delete from start
//        numbers = deleteFromIndex(numbers, 0);
//        System.out.println("After Deleting first Value: " + Arrays.toString(numbers));

//        //        Delete from end
//        numbers = deleteFromIndex(numbers, numbers.length - 1);
//        System.out.println("After Deleting last Value: " + Arrays.toString(numbers));

        //        Delete from middle
        numbers = deleteFromIndex(numbers, 2);
        System.out.println("After Deletion at index 2: " + Arrays.toString(numbers));
    }
    public static int[] deleteFromIndex(int[] arr, int index){
        if(index < 0 || index >= arr.length) {
            System.out.println("Invalid Index");
            return arr;
        }
        int[] newArr = new int[arr.length - 1];
        for(int i = 0, j = 0; i < arr.length; i++){
            if(i == index ) continue; // skip
            newArr[j++] = arr[i];
        }
        return newArr;
    }

}
