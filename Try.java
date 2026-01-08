import java.util.*;

public class Try {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        rev(num,0);

        input.close();

    }

    public static void rev(int n,int sum){

        if(n == 0){
            System.out.println(sum);
            return;
        }

        System.out.println(n);

        rev(n-1,sum+n);

        System.out.println(n);
        
    }
    
}
