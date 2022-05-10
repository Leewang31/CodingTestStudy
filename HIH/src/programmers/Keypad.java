package programmers;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Keypad {
    public static void main(String[] args) {
        int[] numbers={7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String s="left";
        System.out.println(solution(numbers,s));

    }
    public static String solution(int []arr, String s){
        int left=10;
        int right=12;
        int sub1=0;
        int sub2=0;
        String sol;
        //상하는 3크기 차이
        //좌우 1크기 차이
        //대각선으로는 2크기 차이
        ArrayList<String> result=new ArrayList<>();
        for(int i=0;i<arr.length;i++){

            if(arr[i]==0) arr[i]=11;
            if(arr[i]==1||arr[i]==4||arr[i]==7){
                result.add("L");
                left=arr[i];
            }
            else if(arr[i]==3||arr[i]==6||arr[i]==9){
                result.add("R");
                right=arr[i];
            }
            else if(arr[i]==2||arr[i]==5||arr[i]==8||arr[i]==11){
                sub1=abs(left-arr[i])/3+abs(left-arr[i])%3;
                sub2=abs(right-arr[i])/3+abs(right-arr[i])%3;

                if(sub1<sub2){
                    result.add("L");
                    left=arr[i];
                }
                else if(sub1>sub2){
                    result.add("R");
                    right=arr[i];
                }
                else if(sub1==sub2){
                    if(s.equals("left")){
                        result.add("L");
                        left=arr[i];
                    }
                    else if(s.equals("right")){
                        result.add("R");
                        right=arr[i];
                    }
                }



            }
           /* System.out.println("i = " + i);
            System.out.println("ㄴarr[i] = " + arr[i]);
            System.out.println("left = " + left);
            System.out.println("right = " + right);
            System.out.println("ㄴsub1 = " + sub1);
            System.out.println("ㄴsub2 = " + sub2);*/

        }


        return result.toString();
    }
}
