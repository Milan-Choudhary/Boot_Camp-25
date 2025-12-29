import java.util.*;

public class Factorial {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        //From 0 to n
        int n = input.nextInt();
        int num = 1;
        int ans = fib(n,num);

        System.out.println(ans);

        input.close();
    }

    public static int fib(int n,int num){

        if(n <= 1){
            return num;
        }

        return fib(n - 1,num*n);        
    }

}
