package programmers;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Keypad {
    public static void main(String[] args) {
        int[] numbers={7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String s="left";
        System.out.println(solution(numbers,s));

    }
    public static String solution(int []numbers, String hand){
        int left=10;
        int right=12;
        int sub1;
        int sub2;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numbers.length;i++){

            if(numbers[i]==0) numbers[i]=11;
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                sb.append("L");
                left=numbers[i];
            }
            else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                sb.append("R");
                right=numbers[i];
            }
            else {
                sub1=abs(left-numbers[i])/3+abs(left-numbers[i])%3;
                sub2=abs(right-numbers[i])/3+abs(right-numbers[i])%3;

                if(sub1<sub2){
                    sb.append("L");
                    left=numbers[i];
                }
                else if(sub1>sub2){
                    sb.append("R");
                    right=numbers[i];
                }
                else {
                    if(hand.equals("left")){
                        sb.append("L");
                        left=numbers[i];
                    } else{
                        sb.append("R");
                        right=numbers[i];
                    }
                }
            }
        }
        return sb.toString();
    }
}
