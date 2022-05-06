package programmers;
import java.util.ArrayList;
import java.util.Scanner;
public class Crane_game {
    public static int x,y;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        x=sc.nextInt();y=sc.nextInt();
        int [][]board=new int[x][y];
        ArrayList<Integer> moves=new ArrayList<>();
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                board[i][j]=sc.nextInt();
            }
        }
        Moves(board,moves);
    }
    public static void Moves(int[][] arr,ArrayList<Integer> arr2){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w_cnt=0;
        int cnt=0;
        while(true){
            if(n==0) break;
            cnt=0;
            n= sc.nextInt();
            for(int i=0;i<arr[n].length;i++){
                try{
                    if(arr[n][i]==0) cnt++;
                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
            arr2.add(arr[n][cnt]);
            arr[n][cnt]=0;
            for(int i=0;i< arr2.size();i++){
                try{
                    if(arr2.get(i)==arr2.get(i+1)){
                        arr2.remove(i);
                        arr2.remove(i+1);
                        w_cnt+=2;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        System.out.println(w_cnt);
    }
}
