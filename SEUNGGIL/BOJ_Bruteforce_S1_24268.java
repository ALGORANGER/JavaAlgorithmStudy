import java.io.*;
import java.util.*;

public class BOJ_Bruteforce_S1_24268{
    static boolean counter[];
    static int dfsInt[];
    static List<Integer> data;
    static int year;
    public static void dfs(int index, int want){
        if(index == want){
            if(dfsInt[0] != 0){
                data.add(toDecimal(want));
            }
        }else{
            for(int i = 0; i < want; i++){
                if(index == 0 && i == 0)
                    continue;
                if(!counter[i]){
                    dfsInt[index]= i;
                    counter[i] = true;
                    dfs(index+1, want);
                    counter[i] = false;
                }
            }
        }
    }

    public static int toDecimal(int base){
        int result = 0;

        for (int i : dfsInt) {
            result *= base;
            result += i;
        }
        return result;
    }
    public static void main(String[] args){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s[] = reader.readLine().split(" ");
            data = new ArrayList<>();
            year = Integer.parseInt(s[0]);
            int base = Integer.parseInt(s[1]);

            counter = new boolean[base];
            dfsInt = new int[base];
            dfs(0,base);
            for(Integer i : data){
                if(i > year){
                    System.out.println(i);
                    return;
                }
            }
            System.out.println("-1");

        } catch (Exception e) {
        }
    }
}