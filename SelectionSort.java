public class SelectionSort {
    public static void selection(int[] marks){
        int n = marks.length;

        for(int i = 0; i < n - 1; i++){
          int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(marks[j] < marks[minIndex]){
                    minIndex = j;
                }
            }
            int temp = marks[minIndex];
            marks[minIndex] = marks[i];
            marks[i] = temp;
        }
    }
    public static void printArray(int[] arr){
        for(int value: arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] marks = {75, 68, 90, 85, 33};

        System.out.println("Before Sorting: ");
        printArray(marks);

        selection(marks);
        System.out.println("After Sorting: ");
        printArray(marks);
    }
}
