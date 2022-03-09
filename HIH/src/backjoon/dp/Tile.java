package backjoon.dp;

import java.util.Scanner;

/**
 * TODO
 * ArrayException 고치기
 * 초기값 최소화화 */
public class Tile {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int Array[]={1,1,2,3,5,8};
        int n;
        int sum;
        n=input.nextInt();
        for(int i= 6;i<n;i++){
            Array[i]=Array[i-1]+Array[i-2];
        }
        sum=(Array[n-1]+(Array[n-2]+Array[n-1]))*2;
        System.out.println(sum);
    }
}
