import java.util.*;
import java.io.*;

public class BOJ_String_S3_1972 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        Set<String> strSet = new HashSet<>();
        String str;
        char[] temp = new char[2];

        while(!(str = re.readLine()).equals("*")){
            int n = str.length();
            boolean result = true;
            for (int d = 1; d < n; d++) {
                strSet.clear();
                for (int i = 0; i+d < n; i++) {
                    temp[0] = str.charAt(i);
                    temp[1] = str.charAt(i+d);
                    String s = new String(temp);
                    if(strSet.contains(s)){
                        result = false;
                        break;
                    }else{
                        strSet.add(s);
                    }
                }
                if(!result)
                    break;
            }

            ans.append(str);
            if(result){
                ans.append(" is surprising.\n");
            }else{
                ans.append(" is NOT surprising.\n");
            }
        }
        System.out.println(ans);
        re.close();
    }
}
