package backjoon.use_bit;
import java.util.Scanner;
/*
* 내 생각 알고리즘
* 비용을 기간으로 나눔
* 그 비율을 오름차순 정렬 및 기간과 퇴사 기간 비교
* 기간이 퇴사 비교와 같아지거나 더 커지면
* 더 클 경우 마지막 들어온 애 아웃 후 더해서 출력
* 기간이 같을 경우 브레이크 후 출력
* 실패점 : 정렬이 안됨
* if문으로 조건 ㅈㄴ수정해도 안됨..
* 삼성보다 홍석 도와줘줘* */

public class Free {
    public static int day_Arr[];
    public static int cost_Arr[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int day=sc.nextInt();
        cost_Arr=new int[day];
        day_Arr=new int[day];
        for(int i=0;i<day;i++){
            day_Arr[i]=sc.nextInt();
            cost_Arr[i]=sc.nextInt();
        }
        Sum(day_Arr,cost_Arr,day);

    }
    public static void Sum(int d_Arr[],int c_Arr[],int size){
        int sum[]=new int[size];
        int tmp=0;
        for(int i=0;i<size;i++){

            sum[i]=c_Arr[i]/d_Arr[i];
        }
        sum=c_sort(d_Arr,c_Arr,size);
        for(int i=0;i<size;i++){
            tmp+=sum[i];
        }
        System.out.println(tmp);
    }
    public static int[] c_sort(int d_arr[],int c_arr[],int size) {
        int minIndex = 0;

        int cnt=0;

        for (int i = 0; i < c_arr.length; i++) {

            for (int j = i + 1; j < c_arr.length; j++) {
                try {
                    if (c_arr[size] > 1&&i==size-1) {
                        System.out.println("1번 종료뮨");
                        break;
                    }
                    if (cnt >= size) {
                        System.out.println("2번 종료문");
                        break;
                    }
                    if (c_arr[minIndex] > c_arr[j]){
                        minIndex = j;
                        cnt += d_arr[i];
                        System.out.println(cnt);
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    continue;
                }
            }

            int tmp = c_arr[i];
            c_arr[i] = c_arr[minIndex];
            c_arr[minIndex] = tmp;
        }
        for(int i=0;i<size;i++) System.out.println(c_arr[i]);
        return c_arr;
    }

}