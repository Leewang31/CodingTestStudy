package bj.dp;

import java.util.Scanner;

public class Sugar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int tr = 0; tr * 3 <= num; tr++) {
            for (int fv = num / 5; fv >= 0; fv--) {
                if (num == fv * 5 + tr * 3) {
                    System.out.println(fv + tr);
                    return ;
                }
            }
        }

    }
}
