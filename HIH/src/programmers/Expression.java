package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class Expression {
    public static void main(String[] args) {
        String expression="100-200*300-500+20";
        String expression1="50*6-3*2";
        System.out.println(solution(expression));
    }


    public static String[][] solution(String s){
        String result[][] = new String[3][10];
        String temp1[] = new String[0];
        String temp2[]= new String[0];

        String[] temp = s.split("\\-");
        for(int i=0; i<temp.length;i++){
            System.out.println("temp = " + temp[i]);
        }

        temp1=s.split("\\+");
        for(int i=0; i<temp1.length;i++){
            System.out.println("temp1 = " + temp1[i]);
        }

        temp=s.split("\\*");
        temp2=temp1;
        for(int i=0; i<temp2.length;i++){
            System.out.println("temp2 = " + temp2[i]);
        }

        return result;
    }
}
