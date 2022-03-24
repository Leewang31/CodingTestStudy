package backjoon.return_method;
import java.util.Scanner;
public class Star {
    public static int cnt=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        print_Star(n);
    }
    public static void print_Star(int n){
        //1줄은 2^n만큼 출력
        //2줄은 2^(n-1)개의 출력 대신 공백 하나
        //3줄은 2^(n-2)개의 출력 대신 2개 붙고 공백 2개
        //4줄은 2^(n-3)개의 출력 대신 공백은 n개
        //5줄은 2^(n-1)개의 출력 대신 공백 x
        //6줄은 2^(n-2)개의 출력 대신 공백 1개
        //7줄은 2^(n-3)개의 출력
        if(Pow(2,n)==cnt) return;
        if(cnt==0){
            for(int i=Pow(2,n);i>0;i--){
                System.out.print('*');
            }

        }
        else if(cnt%2!=0){

            for(int i=Pow(2,n)-cnt;i>0;i--){
               if(i%(cnt+1)!=0) System.out.print('*');
               else System.out.print(' ');
            }
        }
        else {
            for(int i=Pow(2,n)-cnt;i>0;i--){
                //System.out.println(i);
                if(i%cnt==0&&i>cnt) {

                    for(int j=0;j<=n-cnt;j++){
                        System.out.print('*');
                    }
                }

                else
                    for(int j=0;j<n-cnt;j++){
                    System.out.print("  ");
                    }
            }
        }

        System.out.println();

        cnt++;
        print_Star(n);

    }
    public static int Pow(int n, int m){
        int x=n;
        for(int i=0;i<m-1;i++){
            n*=x;
        }
        return n;
    }
}
