package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class Expression {
    public static void main(String[] args) {
        String expression="100-200*300-500+20";
        String expression1="50*6-3*2";
        ArrayList<String> calc=new ArrayList<>();
        ArrayList<String> calc1=new ArrayList<>();
        calc.add("*");calc.add("+");calc.add("-");
        calc1.add("-");calc1.add("*");
        System.out.println(solution(expression,calc));
    }


    public static String[][] solution(String s,ArrayList<String> arr){
        String result[][] = new String[3][10];
        String temp[]= new String[0];
        String temp1[] = new String[0];
        String temp2[]= new String[0];
        temp=s.split("\\-");
        for(int i=0; i<temp.length;i++){
            System.out.println("temp = " + temp[i]);}
     //   temp1.clone(temp);
        temp1=s.split("\\+");
        for(int i=0; i<temp1.length;i++){
            System.out.println("temp1 = " + temp1[i]);}
        temp=s.split("\\*");
        temp2=temp1;
        for(int i=0; i<temp2.length;i++){
            System.out.println("temp2 = " + temp2[i]);}

        return result;
    }
}
