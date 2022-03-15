package bj.dp;

import java.util.Scanner;

public class Sugar {

    public static final int FIRST_NUM = 3;
    public static final int SECOND_NUM = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int x = 0; x * FIRST_NUM <= num; x++) {
            for (int y = num / SECOND_NUM; y >= 0; y--) {
                if (num == y * 5 + x * 3) {
                    System.out.println(y + x);
                    return ;
                }
            }
        }

    }
}
