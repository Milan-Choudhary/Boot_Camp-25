import java.util.*;

public class ReverseString {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        String s = input.next();

        String ans = compute(s,s.length()-1,"");

        System.out.println(ans);

        input.close();
    }

    public static String compute(String s,int i,String ans){

        if(i < 0){
            // System.out.println(s);
            // System.out.println(ans);
            return ans;
        }

        return compute(s,i-1,ans += s.charAt(i));
    }
}
