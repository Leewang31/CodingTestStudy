package bj.divide;

import java.util.Scanner;

public class Z {
    private static int[][] arr;
    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int size = (int) Math.pow(2, N);
        arr = new int[size][size];
        moveZ(0,0,N);
        System.out.println(arr[r][c]);
    }

    private static void moveZ(int r, int c, int num) {
        if(num == 0) return;
        if(num == 1){
            for(int i=r;i<2+r;i++){
                for(int j=c;j<2+c;j++){
                    arr[i][j]=cnt;
                    cnt++;
                }
            }
        return;
        }
        int pt = (int) Math.pow(2, num-1);
        moveZ(r,c,num-1);
        moveZ(r,c+pt,num-1);
        moveZ(r+pt,c,num-1);
        moveZ(r+pt,c+pt,num-1);
    }

}