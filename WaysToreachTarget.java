import java.util.*;

public class WaysToreachTarget {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int target = input.nextInt();
        int n = input.nextInt();

        int[] num = new int[n];

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            num[i] = input.nextInt();
        }

        for(int i = 0; i<n; i++){
           System.out.print(num[i] + " ");
        }

        System.out.println();

        int res = compute(target,num,0,list,0);

        System.out.println(res);

        input.close();
    }

    public static int compute(int t,int[] num,int i,ArrayList<Integer> list,int c){

        if(t == 0){
            for(int k = 0; k<list.size(); k++){
                System.out.print(list.get(k) + " ");
            }
            
            System.out.println("->");
            //return 1;
            return 1;

        }

        if(t < 0){
            return 0;
        }

        // if(i == num.length){
        //     return 0;
        // }

        // list.add(num[i]);
        // int take = compute(t-num[i],num,i,list);
        // list.remove(list.size() - 1);
        // int not_take = compute(t,num,i+1,list);

        int ans = 0;

        for(int start = i; start < num.length; start++){
            if(start > i && num[start] == num[start - 1]){
                continue;
            }
            list.add(num[start]);
            ans += compute(t-num[start],num,start,list,ans);
            list.remove(list.size()-1);
        }

        return ans;
    }
    
}
