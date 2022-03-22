package bj.recursion;

import java.util.Scanner;

public class Star {
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        String star[][] = new String[1][1];
        star[0][0]="*";
        if(size ==0){
            System.out.println(star[0][0]);
            return ;
        }
        printstar(0, 1, star);
        return;
    }

    private static void printstar(int cnt, int num, String[][] star) {
        if (size == cnt) {
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++) {
                    System.out.print(star[i][j]);
                }
                System.out.println();
            }
            return;
        }
        cnt++;
        star(cnt,star);
    }
    private static void star(int cnt,String[][] star) {
        int newNum = 1;
        for(int i = 0; i<cnt; i++)
            newNum *= 2;
        int halfNum = newNum/2;
        String newStar[][] = new String[newNum][newNum];
        for(int i=0;i<newNum;i++)
            for(int j=0;j<newNum;j++){
                if(i<halfNum&&j<halfNum)
                    newStar[i][j]=star[i][j];
                if(i<halfNum&&j>=halfNum)
                    newStar[i][j]=star[i][j-halfNum];
                if(i>=halfNum&&j<halfNum)
                    newStar[i][j]=star[i-halfNum][j];
                if(i>=halfNum&&j>=halfNum)
                    newStar[i][j]=" ";
            }
        printstar(cnt,newNum,newStar);
    }
}