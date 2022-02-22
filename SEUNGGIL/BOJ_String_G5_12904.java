import java.util.*;
import java.io.*;

public class BOJ_String_G5_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String s = re.readLine();
        String t = re.readLine();

        StringBuilder ans = new StringBuilder(t);

        while(s.length() <= ans.length()){
            if(s.equals(ans.toString())){
                System.out.print(1);
                return;
            }
            if(ans.charAt(ans.length()-1) == 'A'){
                ans.setLength(ans.length()-1);
            }
            else if(ans.charAt(ans.length()-1) == 'B'){
                ans.setLength(ans.length()-1);
                ans.reverse();
            }
        }

        System.out.print(0);
        re.close();
    }
}