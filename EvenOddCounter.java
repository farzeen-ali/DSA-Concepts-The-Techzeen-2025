public class EvenOddCounter {
    public static void countEvenOdd(int[] arr){
        int evenCount = 0;
        int oddCount = 0;

        for (int number : arr){
            if(number % 2 == 0){
                evenCount++;
            }
            else {
                oddCount++;
            }
        }
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
    public static void main(String[] args) {
        int[] values = {3, 6, 9, 12, 15, 18};
        countEvenOdd(values);
    }
}
