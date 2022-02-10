import java.io.*;
import java.util.*;

public class _BOJ_Set_S4_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String s[] = re.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Set<String> look = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            look.add(re.readLine());
        }

        for (int i = 0; i < m; i++) {
            String name = re.readLine();
            if(look.contains(name))
                answer.add(name);
        }
        answer.sort(null);
        wr.write(Integer.toString(answer.size()));
        wr.newLine();
        for (String string : answer) {
            wr.write(string);
            wr.newLine();
        }

        re.close();
        wr.close();
    }
}
