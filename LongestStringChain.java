import java.util.*;

public class LongestStringChain {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int len = input.nextInt();

        String[] words = new String[len];

        for(int i = 0; i<len; i++){
            words[i] = input.next();
        }

        for(int i = 0; i<len; i++){
            System.out.println(words[i]);
        }



        input.close();
    }
}
