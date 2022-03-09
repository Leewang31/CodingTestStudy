package backjoon;
import java.util.Scanner;

public class HIH1301 {
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
