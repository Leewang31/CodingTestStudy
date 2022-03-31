package bj.divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ThueMorse {
    private static double N;
    private static List<String> list;
    private static List<String> tp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Double.parseDouble(reader.readLine());
        list = new ArrayList<>();
        tp = new ArrayList<>();
        thusmorse(0);
        System.out.println(list.get((int)N));
    }

    private static void thusmorse(double cnt) {
        if(list.isEmpty()){
            list.add("0");
            cnt++;
        }
        if(cnt<N){
            for(int i=0;i<list.size();i++){
                if(list.get(i) == "0")
                    tp.add("1");
                else
                    tp.add("0");
            }
            for(int i = 0;i<tp.size();i++){
                list.add(tp.get(i));
            }
            tp.clear();
            thusmorse(cnt*2);
        }
    }
}

//메모리 초과 해결 방법을 모르겠당 