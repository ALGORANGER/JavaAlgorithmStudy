import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BOJ_Brute_S2_1182 {
    static int n;
    static int s;
    static int []inputData;
    static int []cases;
    static int ans = 0;

    static void solve(int index, int sum, int count){
        if(s == sum && count != 0){
            ans++;
        }
        if(index == n)
            return;

        for (int i = index; i < n; i++) {
            solve(i + 1, sum + inputData[i], count+1);
        }
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = re.readLine().split(" ");
        n = Integer.parseInt(ss[0]);
        s = Integer.parseInt(ss[1]);

        inputData = new int[n];
        cases = new int[n];

        StringTokenizer token = new StringTokenizer(re.readLine());
        for (int i = 0; i < n; i++) {
            inputData[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(inputData);

        solve(0,0,0);

        System.out.println(ans);
        re.close();
    }
}
