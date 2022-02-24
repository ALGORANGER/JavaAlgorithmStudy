import java.io.*;
import java.util.regex.*;

public class BOJ_String_S5_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(s=|c=|c-|dz=|d-|lj|nj|z=|.)");
        String s = re.readLine();
        Matcher matcher = pattern.matcher(s);
        
        int ans = 0;
    
        while(matcher.find()){
            //System.out.println(matcher.group());
            ans++;
        }
        System.out.print(ans);
        re.close();
    }
}