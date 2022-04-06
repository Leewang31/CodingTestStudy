package backjoon.four;
import java.util.Scanner;
public class Bath_small {
    public static int arr[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int y=sc.nextInt();
        arr=new int[5][5];


    }
    public static void tile(int n, int x, int y){
        if(n==1){
            for(int i=2;i>=1;i--){
                for(int j=1;j<=2;j++){
                    if(i!=y||j!=x) System.out.println(1);
                    else System.out.println(-1);
                }
                if(i==1) System.out.print("\b");
                else System.out.println();

                    }
                }
        if (n == 2) {

            for (int i = 0; i < 5; i++) { for (int j = 0; j < 5; j++) { arr[i][j] = 0; } }


            
            for (int i = 4; i >= 1; i--) {
                for (int j = 1; j <= 4; j++) {
                    if (i >= j + 2) { arr[i][j] = 4; continue; }
                    if (i <= 3 - j) { arr[i][j] = 1; continue; }
                    if (i <= j - 2) { arr[i][j] = 2; continue; }
                    if (i >= 7 - j) { arr[i][j] = 3; continue; }
                    arr[i][j] = 5;
                }
            }

            arr[y][x] = -1;

            if (y >= x + 2) { arr[3][2] = 4; }
            if (y <= 3 - x) { arr[2][2] = 1; }
            if (y <= x - 2) { arr[2][3] = 2; }
            if (y >= 7 - x) { arr[3][3] = 3; }

            for (int i = 4; i >= 1; i--) {
                for (int j = 1; j <= 4; j++) {
                    if (i != y || j != x) System.out.print( arr[i][j]+" ");
                    else System.out.print(arr[i][j]+' ');

                }
                if (i == 1) System.out.print('\b');
                else System.out.println();
            }
        }
    }
            }






