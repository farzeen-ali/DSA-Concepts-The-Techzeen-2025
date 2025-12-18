public class InsertionSort {
    public static void insertion(int[] marks){
        int n = marks.length;

        for(int i = 1; i < n; i++){
            int key = marks[i];
            int j = i - 1;

            while(j>=0 && marks[j] > key){
                marks[j + 1] = marks[j];
                j--;
            }
            marks[j+1] = key;
        }
    }
    public static void printArray(int[] arr){
        for(int value: arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] marks = {70, 60, 80, 50, 90};

        System.out.println("Before Sorting: ");
        printArray(marks);

        insertion(marks);
        System.out.println("After Sorting: ");
        printArray(marks);
    }
}
