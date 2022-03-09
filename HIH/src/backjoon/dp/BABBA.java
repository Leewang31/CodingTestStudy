package backjoon.dp;

import java.util.Scanner;

/**
 * TODO
 * 1차원 배열로 바꾸기
 * 피보나치수 공부
 */
public class BABBA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a,b=0;
        int k= input.nextInt();
        int Array[][]=new int [2][45];
        Array[0][0]=0;
        Array[0][1]=1;
        Array[1][0]=1;
        Array[1][1]=1;
        Array[0][2]=1;
        Array[1][2]=2;
        Array[0][3]=1;
        Array[0][4]=3;
        Array[1][3]=3;
        Array[1][4]=5;

        for(int i=5; i<=k; i++){
            Array[0][i]=Array[1][i-1];
            Array[1][i]=Array[1][i-1]+Array[0][i-1];

        }
        System.out.println(Array[0][k-1]+" "+Array[1][k-1]);
    }
}
