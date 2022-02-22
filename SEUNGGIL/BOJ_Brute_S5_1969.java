import java.util.*;
import java.io.*;

public class BOJ_Brute_S5_1969 {
    // 문자열 길이 , 4
    static int[][] inputData;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());

        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());

        inputData = new int[m][4];
        for (int i = 0; i < n; i++) {
            String s = re.readLine();
            for (int j = 0; j < m; j++) {
                switch(s.charAt(j)){
                    case 'A':
                        inputData[j][0]++;
                        break;
                    case 'C':
                        inputData[j][1]++;
                        break;
                    case 'G':
                        inputData[j][2]++;
                        break;
                    case 'T':
                        inputData[j][3]++;
                        break;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int ans2 = 0;
        for (int i = 0; i < m; i++) {
            int cnt = inputData[i][0];
            int index = 0;

            for (int j = 1; j < 4; j++) {
                if(cnt < inputData[i][j]){
                    cnt = inputData[i][j];
                    index = j;
                }
            }
            ans2 += n-cnt;
            switch(index){
                case 0:
                    ans.append('A');
                    break;
                case 1:
                    ans.append('C');
                    break;
                case 2:
                    ans.append('G');
                    break;
                case 3:
                    ans.append('T');
                    break;
            }
        }
        System.out.println(ans);
        System.out.print(ans2);

        re.close();
    }
}
