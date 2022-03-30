package bj.bruteforce;


import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Scanner;

public class Set {
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[20];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;
        int ck[] = new int[20];
        for (int i = 0; i < arr.length; i++)
            ck[i] = 0;

        for (int i = 0; i < N; i++) {
            String st = sc.next();
            switch (st) {
                case "add":
                    int addNum = sc.nextInt();
                    ck[addNum - 1] = 1;
                    break;
                case "remove":
                    int removeNum = sc.nextInt();
                    ck[removeNum - 1] = 0;
                    break;
                case "check":
                    int chckNum = sc.nextInt();
                    if (ck[chckNum - 1] == 1)
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "toggle":
                    int toggleNum = sc.nextInt();
                    if (ck[toggleNum - 1] == 1)
                        ck[toggleNum - 1] = 0;
                    else
                        ck[toggleNum - 1] = 1;
                    break;
                case "all":
                    for (int j = 0; j < arr.length; j++)
                        ck[j] = 1;
                    break;
                case "empty":
                    for (int j = 0; j < arr.length; j++)
                        ck[j] = 0;
                    break;

            }
        }
    }
}
