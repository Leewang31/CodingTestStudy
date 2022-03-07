import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] dp = new long[81];
        dp[1]=4;
        dp[2]=6;
        for(int i=3;i<=num;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[num]);
    }
}