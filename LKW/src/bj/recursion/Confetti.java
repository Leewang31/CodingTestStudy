package bj.recursion;

import java.util.Scanner;

public class Confetti {
    static int N;
    static int White;
    static int Blue;
    static int[][] Color;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Color = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                Color[i][j] = sc.nextInt();
            }
        cut(0, 0, N);
        System.out.println(White);
        System.out.println(Blue);
    }

    private static void cut(int startY, int startX, int size) {
        if (check(startY, startX, size) == true){
            if(Color[startY][startX]==0)
                White++;
            if(Color[startY][startX]==1)
                Blue++;
            return ;
        }
        size /=2 ;
        cut(startY,startX,size);
        cut(startY+size,startX,size);
        cut(startY,startX+size,size);
        cut(startY+size,startX+size,size);
    }

    private static boolean check(int startY, int startX, int size) {
        int firstColor = Color[startY][startX];
        for (int i = startY; i < startY+size; i++)
            for (int j = startX; j < startX+size; j++) {
                if (firstColor != Color[i][j])
                    return false;
            }
        return true;
    }
}
