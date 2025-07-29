public class MaxElementFinder {
    public static int findMax(int[] arr){
        if(arr.length == 0){
            throw new IllegalArgumentException("Array should not be empty!");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++ ) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = {15, 22, 8, 31, 19};
        int maxElement = findMax(numbers);
        System.out.println("Max Value in Your Array is: " + maxElement);
    }
}
