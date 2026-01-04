import java.util.*;

public class MinimumWaysToTarget {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int target = input.nextInt();
        int n = input.nextInt();

        int[] num = new int[n];

        for(int i = 0; i<n; i++){
            num[i] = input.nextInt();
        }

        int min_ways = compute(target,num,0);

        System.out.println(min_ways);

        input.close();
    }

    public static int compute(int t,int[] num,int i){

        if(t == 0){
            return 0;
        }

        if(i == num.length || t < 0){
            return Integer.MAX_VALUE;
        }

        int take = 1 + compute(t-num[i], num, i);
        int not_take = compute(t, num, i+1);

        return Math.min(take,not_take);


    }
}
