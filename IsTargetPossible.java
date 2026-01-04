import java.util.*;

public class IsTargetPossible {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int target = input.nextInt();

        int n = input.nextInt();

        int[] num = new int[n];

        for(int i = 0; i<n; i++){
            num[i] = input.nextInt();
        }

        boolean res = compute(target,num,0);

        System.out.println(res);

        input.close();

    }

    public static boolean compute(int t,int[] num,int i){

        if(i == num.length){
            return false;
        }

        if(t == 0){
            return true;
        }

        if(t < 0){
            return false;
        }

        return (compute(t-num[i],num,i) || compute(t,num,i+1));

        
    }
}
