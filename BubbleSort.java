public class BubbleSort {
    public static void bubbleSort(int[] heights){
        int n = heights.length;

        for(int i = 0; i < n - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < n - 1 - i; j++){
                if(heights[j] > heights[j+1]){
                    int temp = heights[j];
                    heights[j] = heights[j+1];
                    heights[j+1] = temp;

                    swapped = true;
                }
            }
        }
    }
    public static void printArray(int[] arr){
        for(int value: arr){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] studentHeights = {170, 150, 180, 160, 155};

        System.out.println("Before Sorting: ");
        printArray(studentHeights);

        System.out.println("After Sorting: ");
        bubbleSort(studentHeights);
        printArray(studentHeights);
    }
}
