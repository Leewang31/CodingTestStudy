import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int rm = -1;
        Loop1:
        for(int tr=0;tr*3<=num;tr++){
            Loop2:
            for(int fv = num/5;fv>=0;fv--){
                if (num == fv*5+tr*3){
                    rm =fv + tr;
                    break Loop1;
                }
            }
        }
        System.out.println(rm);
    }
}