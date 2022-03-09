package backjoon;
import javax.swing.*;
import java.util.Scanner;
public class HIH2839 {

    public static final int FIVE_WEIGHT = 5;
    public static final int THREE_WEIGHT = 3;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int cnt=0;
        int sugar=input.nextInt();

        while(sugar>0){
            if(sugar% FIVE_WEIGHT ==0){
                sugar-=FIVE_WEIGHT;
                cnt++;
            }
            sugar-= THREE_WEIGHT;
            cnt++;
        }

        System.out.println((cnt>2)?cnt : -1);
    }
}
