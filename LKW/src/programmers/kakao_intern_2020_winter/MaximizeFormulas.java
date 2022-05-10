package programmers.kakao_intern_2020_winter;

import java.util.ArrayList;

public class MaximizeFormulas {
    public static ArrayList<String> number = new ArrayList<>();
    public static ArrayList<Character> operator = new ArrayList<>();
    public static int MAX = 0;
    public static Character[][] group = {
            {'*','+','-'},
            {'*','-','+'},
            {'+','*','-'},
            {'+','-','*'},
            {'-','+','*'},
            {'-','*','+'},
    };
    public static void main(String[] args) {
        String expression="100-200*300-500+20";
        String[] arrSt = expression.split("\\*|\\+|-" );

        for (int i =0 ; i <arrSt.length;i++){
            number.add(arrSt[i]);
        }
        for (int i =0 ; i<expression.length(); i++){
            if(expression.charAt(i)=='*'){
                operator.add('*');
            }
            else if(expression.charAt(i)=='+'){
                operator.add('+');
            }
            else if(expression.charAt(i)=='-'){
                operator.add('-');
            }
        }
        for (int i = 0;i<number.size();i++){
            System.out.println("number["+i+"] : "+number.get(i));
        }
        for (int i = 0;i<operator.size();i++){
            System.out.println("operator["+i+"] : "+operator.get(i));
        }
        System.out.println(Max());
//        System.out.println(solution(expression));
    }

    private static int Max() {
        for (int i =0; i<group.length;i++){
            for (int j=0;j<3;j++){
                for (int x=0;x< operator.size();x++){
                    if(group[i][j] == operator.get(x)){
                        
                    }
                }
            }
        }
        return 0;
    }

    private static long solution(String expression) {
        return 0;
    }
}

//실패