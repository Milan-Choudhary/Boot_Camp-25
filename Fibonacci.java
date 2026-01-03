import java.util.*;

public class Fibonacci {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] dp = new int[n+1];

        System.out.println(fib(n,dp));

        input.close();
    }

    public static int fib(int n,int[] dp){

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        dp[n] =  fib(n-1,dp) + fib(n-2,dp);

        return dp[n];
    }
}
