public class ArrayBinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1; // 5
        while(start <= end){
            int mid = start + (end - start) / 2; // overflow
            if(arr[mid] == target) {
                return mid;
            }
            else if(target < arr[mid]){
                end = mid - 1; //left
            }
            else {
                start = mid + 1; //right
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] sortedArray = {10, 20, 30, 40, 50, 60};
        int target = 50;

        int result = binarySearch(sortedArray, target);
        System.out.println("Element Found at Index: " + result);
    }
}
