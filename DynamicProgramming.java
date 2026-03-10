public class DynamicProgramming {
//    0 1 1 2 3 5 8
    public static int fibonacci(int n){
//        base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
//        F(5) = F(4) + F(3)
//        F(4) = F(3) + F(2)
//        F(3) = F(2) + F(1)
//        2^n => O(n)
//        return fibonacci(n - 1) + fibonacci(n-2);

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
     int n = 6;
     int result = fibonacci(n);
        System.out.println("Fibonacci Number at position: "  + n + " is: " + result);
    }
}
