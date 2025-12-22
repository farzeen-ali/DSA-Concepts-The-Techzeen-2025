public class MergeSortExample {
    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
//            int mid = (left+right)/2; bad practice
            int mid = left + (right - left)/2;

//            left half
            mergeSort(arr, left, mid);

//            right half
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }
//    merge function
    private static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++){
            L[i] = arr[left + i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
//        copy remaining elements
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void printArray(int[] arr){
        for (int value: arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
    int[] marks = {38, 27, 43, 10, 82, 9};

        System.out.println("Before Sorting: ");
        printArray(marks);

        mergeSort(marks, 0, marks.length-1);
        System.out.println("After Sorting: ");
        printArray(marks);
    }
}
