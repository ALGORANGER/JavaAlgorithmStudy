import java.util.*;
import java.io.*;

public class BOJ_Brute_S3_1244 {
    static boolean[] result;
    static int n;

    static void changeMulti(int m){
        for (int i = 1; i*m <= n; i++) {
            result[i*m] = !result[i*m];
        }
    }

    static void changeReflect(int m){
        int start = m;
        int end = m;

        while(start > 0 && end <= n && result[start] == result[end]){
            start--;
            end++;
        }
        start++;
        end--;

        for (int i = start; i <= end; i++) {
            result[i] = !result[i];
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(re.readLine());

        StringTokenizer token = new StringTokenizer(re.readLine());
        result = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            result[i] = token.nextToken().charAt(0) == '1' ? true : false;
        }

        int stuCnt = Integer.parseInt(re.readLine());

        for (int i = 0; i < stuCnt; i++) {
            token = new StringTokenizer(re.readLine());
            switch(token.nextToken().charAt(0)){
                case '1':
                    changeMulti(Integer.parseInt(token.nextToken()));
                    break;
                case '2':
                    changeReflect(Integer.parseInt(token.nextToken()));
                    break;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        int ansLength = 0;
        for (int i = 1; i <= n; i++) {
            ans.append(result[i] ? 1 : 0);
            ansLength++;
            if(ansLength == 20){
                ans.append('\n');
                ansLength = 0;
            }else{
                ans.append(' ');
            }
        }
        System.out.print(ans);
        re.close();
    }
}
