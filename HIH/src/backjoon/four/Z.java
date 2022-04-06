package backjoon.four;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.*;
public class Z {
    public static int cnt=0;
    public static int array[][];
    public static int dx[]={0,1,0,-1};
    public static int dy[]={1,0,-1,0};
    public static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        array= new int[n][n];
        incert(array,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("i = " + i+' ');
                System.out.print("j = " + j+' ');

                System.out.print("array : "+array[i][j]+' ' );
            }
            System.out.println();
        }

    }
    public static void incert(int arr[][], int size){
        size=n;
        System.out.println("size = " + Math.pow(size,size));
        if(Math.pow(size,size)==cnt) {
            System.out.println("size = " + size);
            return;
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                try {
                    System.out.println("cnt = " + cnt);
                    arr[i][j]=cnt;
                    cnt++;
                }catch (ArrayIndexOutOfBoundsException e){

                    continue;
                }


            }
        }

            incert(arr,size);

    }

   /* public static int Pow(int n) {
        for(int i=0;i<n;i++){
            n *=n;
        }
        System.out.println("n = " + n);
        return n;
    }*/
}
