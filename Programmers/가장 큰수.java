import java.util.*;
class Solution {

    // static public int fofo (String so1, String so2, int n){
    //     int fo1 = so1.charAt(n) - '0';
    //     int fo2 = so2.charAt(n) - '0';
    //     if(fo1==fo2) {
    //         return fofo(so1,so2,n++);
    //     } else if(fo1>fo2) {
    //         return -1;
    //     } else {
    //         return 1;
    //     }
    // }

    public String solution(int[] numbers) {
        String answer = "";

        Integer[] sorted = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {

//                 // Solution1.
//                 // 자릿수 구하기.
//                 int c1 = (int)(Math.log10(o1)+1);
//                 int c2 = (int)(Math.log10(o2)+1);

//                 // 맨 앞자리 수 구하기.
//                 String so1 = Integer.toString(o1);
//                 String so2 = Integer.toString(o2);
//                 int n =0;
//                 int fo1 = so1.charAt(0) - '0';
//                 int fo2 = so2.charAt(0) - '0';

//                 if(o1 == o2) return 0;
//                 else {
//                     if(c1==c2) {
//                         if(fo1>fo2) return -1;
//                         else if(fo1<fo2) return 1;
//                     } else {
//                         if(fo1>fo2) return -1;
//                         else if(fo1<fo2) return 1;
//                         else {
//                             return fofo(so1, so2, n);
//                         }
//                     }
//                 }

//                 return 0;


                // Solution2.
                String so1 = Integer.toString(o1);
                String so2 = Integer.toString(o2);

                int sum1 = Integer.parseInt(so1+so2);
                int sum2 = Integer.parseInt(so2+so1);

                return sum2-sum1;
            }
        });

        boolean flag = true;
        for(Integer number : sorted) {
            if(flag && number==0){
                answer = "0";
                break;
            } else flag = false;
            answer += Integer.toString(number);
        }


        return answer;
    }
}