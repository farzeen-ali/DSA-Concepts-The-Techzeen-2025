public class Recursion {
    public static int factorial(int n){
//        base case
        if(n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1); // recursive call
    }

    public static int sumNatural(int n){
        if(n == 1){
            return 1;
        }
        return n + sumNatural(n - 1);
    }
    public static void main(String[] args) {
        System.out.println("Factorial of 5 is: " + factorial(5));
        System.out.println("Sum of 5 is: " + sumNatural(5));
    }
}
