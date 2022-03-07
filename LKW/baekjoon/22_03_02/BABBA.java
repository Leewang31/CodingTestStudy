import java.util.Scanner;

public class Mai
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int A=0;
        int B=1;
        int tp;
        for (int i = 2; i <= num; i++) {
            tp=B;
            B=A+tp;
            A=tp;
        }
        System.out.println(A+B);
    }
}
