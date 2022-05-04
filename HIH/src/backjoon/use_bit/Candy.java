package backjoon.use_bit;
import java.util.Scanner;
public class Candy {
    public static char candy_Array[][];
    public static int cnt=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        candy_Array=new char[n][n];
        for(int i=0;i<n;i++){
            candy_Array[i]=sc.nextLine().toCharArray();
        }
        sort(candy_Array,n);
        System.out.println();
        System.out.println(cnt);
    }
    public static void sort(char[][] Arr, int size){
        char tmp;

        for(int i=0;i<size;i++){
            cnt=1;
            for(int j=0;j<size;j++){
                try{
                    if(Arr[i][j]!=Arr[i+1][j]){
                        tmp=Arr[i][j];
                        Arr[i][j]=Arr[i+1][j];
                        Arr[i+1][j]=tmp;
                        if(Arr[i][j]==Arr[i][j+1]) cnt++;
                    }
                    else if(Arr[i][j]!=Arr[i][j+1]){
                        tmp=Arr[i][j];
                        Arr[i][j]=Arr[i][j+1];
                        Arr[i][j+1]=tmp;
                        if(Arr[i][j]==Arr[i+1][j]) cnt++;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }

        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
               try{ //System.out.print(Arr[i][j]+' ');
               }
               catch (ArrayIndexOutOfBoundsException e){
                   continue;
               }
            }
          //  System.out.println();
        }
    }
    //같은 열이나 행에 있는 값들이 같으면 그 값이 뭔지에 따라 cnt를 증가
    // 정렬할 때 마다 탐색 최대 값이 된다면 return
    public static void search_Candy(char[][] Arr,int size){
        int x=0;
        char tmp;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(Arr[i][j]!=Arr[i][j+1]){
                    tmp=Arr[i][j+1];
                   // Arr[i][j]=

                }
            }
        }

    }
}
/*
* 알고리즘은 아래와 같습니다.

1. 양 옆을 바꾸고 제일 길게 먹을 수 있는 사탕의 길이를 파악합니다.

i) 가로로 제일 긴 사탕

ii) 세로로 제일 긴 사탕

iii) i)와 ii) 중 긴 사탕의 길이를 선택합니다.

2. 위 아래를 바꾸고 제일 길게 먹을 수 있는 사탕의 길이를 파악합니다.

i) 가로로 제일 긴 사탕

ii) 세로로 제일 긴 사탕

iii) 마찬가지로 i)와 ii) 중 긴 사탕의 길이를 선택합니다.

3. 1과 2에서 구한 길이 중 더 긴 값을 출력합니다



출처: https://jaimemin.tistory.com/1068 [꾸준함]*/