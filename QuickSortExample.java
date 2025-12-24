public class QuickSortExample {
//    quick sort function
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
//            left sub-array
            quickSort(arr, low, pivotIndex - 1);
//            right sub-array
            quickSort(arr, pivotIndex + 1, high);
        }
    }
//    partition function
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1; // -1
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            }
        }
//        [5,3,2,8,7] => [2,3,5,7,8]
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void printArray(int[] arr){
        for(int value: arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] marks = {38, 27, 43, 10, 82, 9};
        System.out.println("Before Sorting: ");
        printArray(marks);
        quickSort(marks, 0, marks.length - 1);
        System.out.println("After Sorting: ");
        printArray(marks);
    }
}
