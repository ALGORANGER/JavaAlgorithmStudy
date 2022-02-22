import java.util.*;
import java.io.*;

public class BOJ_String_S2_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(re.readLine());
        int m = Integer.parseInt(re.readLine());
        
        char[] inputData = re.readLine().toCharArray();

        int answer = 0;
        boolean isI = true;
        int count = 0;
        for (int i = 0; i < m; i++) { // inputData
            if(isI){
                if(inputData[i] =='I'){
                    count++;
                    isI = !isI;
                }else{
                    if(count >= 2*n+1)
                        answer += 1 + (count - (2*n+1))/2;
                    count = 0;
                    isI = true;
                }
            }else{
                if(inputData[i] =='O'){
                    count++;
                    isI = !isI;
                }else{
                    if(count >= 2*n+1)
                        answer += 1 + (count - (2*n+1))/2;
                    count = 1;
                    isI = false;
                }
            }
        }
        if(count >= 2*n+1)
            answer += 1 + (count - (2*n+1))/2;

        System.out.print(answer);
        re.close();
    }
}
