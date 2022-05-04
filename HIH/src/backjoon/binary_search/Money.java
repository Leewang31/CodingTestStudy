package backjoon.binary_search;
import java.util.Scanner;
public class Money {
    public static int n,m,k;
    public static int[] money_Array;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        m= sc.nextInt();
        money_Array=new int[m];

        for(int i=0;i<m;i++){
            money_Array[i]=sc.nextInt();
        }


    }
}
