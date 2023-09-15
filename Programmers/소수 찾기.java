import java.util.*;
class Solution {
    static int answer;
    static String[] str;
    static boolean[] v;
    static Set<Integer> set;
    public int solution(String numbers) {

        answer = 0;

        str = numbers.split("");
        set = new HashSet<>();
        v = new boolean[numbers.length()];

        // for(int i=0; i<numbers.length(); i++){
        //     System.out.print(str[i]+" ");
        // }

        per(0,"");
        decimal(set);


        return answer;
    }

    static public void per(int index, String num){

        if(!num.equals("")) {
            // System.out.println(num);
            // decimal(num);
            set.add(Integer.parseInt(num));
        }

        for(int i=0; i<str.length; i++){
            if(!v[i]){
                v[i] = true;
                per(index+1, num+str[i]);
                v[i] = false;
            }
        }
    }

    static public void decimal(Set<Integer> set) {

        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            int numder = (int)iter.next();
            System.out.println(numder);
            boolean flag = false;
            if(numder <= 1) flag = true;



            for(int i=2; i<=Math.sqrt(numder); i++){
                if(numder%i == 0){
                    flag = true;
                }
            }
            if(!flag) answer++;
        }
    }
}