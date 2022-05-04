package backjoon.use_bit;
import java.util.Scanner;
import java.math.*;
public class Every_Permutation {
    public static int arr[][];
    public static void main(String[] args) {
        int n;

        Scanner sc=new Scanner(System.in);

    }
    public static void find_Permutation(int n){
        int sum = 0;
        for(int i=n;i>0;i--){
            sum*=i;
        }
        for(int i=1;i<=sum;i++){

        }
    }
}
/*
* 배열 [i - 1]< array [ i ]와 같은 가장 큰 인덱스 i를 찾습니다.
(i가 존재하지 않는 경우, 이것은 이미 마지막 치환입니다.)

j i i 및 array [ j ]> array [ i - 1 ]의 가장 큰 인덱스 j를 찾습니다.

어레이[j]와 어레이[i - 1]를 스왑합니다.

배열[i]부터 시작하는 접미사를 반대로 바꿉니다.
*/