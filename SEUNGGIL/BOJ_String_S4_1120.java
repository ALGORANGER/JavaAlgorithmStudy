import java.util.*;
import java.io.*;

public class BOJ_String_S4_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(re.readLine());
        String a = token.nextToken();
        String b = token.nextToken();
        
        int same = Integer.MAX_VALUE;
        for (int i = 0; i < (b.length() - a.length() + 1); i++) {
            int result = 0;
            for (int j = 0; j < a.length(); j++) {
                if(a.charAt(j) != b.charAt(j+i)){
                    result++;
                }
            }
            same = Integer.min(same, result);
        }
        System.out.print(same);
        re.close();
    }
}
