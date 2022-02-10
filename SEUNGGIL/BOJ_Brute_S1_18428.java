import java.util.*;
import java.io.*;

public class BOJ_Brute_S1_18428 {
    // Student : 1, Teacher : 2, Object : 3
    // None : 0
    static final int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
    static int n;
    static int[][] map;
    static ArrayList<Pos[]> cases = new ArrayList<Pos[]>();
    static ArrayList<Pos> teacherLocation = new ArrayList<>();
    
    static Pos[] tempCase = new Pos[3];

    // 범위가 지도랑 안 맞는지 확인
    static boolean isValid(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;

        return true;
    }

    // Object 놓을 수 있는 빈칸 찾기.
    static void findCases(int x, int y, int caseCnt){
        if(caseCnt == 3){
            cases.add(Arrays.copyOf(tempCase, 3));
            return;
        }

        if(!isValid(x, y))
            return;

        for (int i = x; i < n; i++) {
            int j;
            if(i == x)
                j = y;
            else
                j = 0;
            for (; j < n; j++) {
                // 지도에서 해당 칸이 빈칸이면 장애물을 놓을 수 있음.
                if(isValid(i, j) && map[i][j] == 0){
                    tempCase[caseCnt] = new Pos(i,j);
                    if(j != n-1)
                        findCases(i, j+1, caseCnt + 1);
                    else
                        findCases(i+1, 0, caseCnt + 1);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(re.readLine());
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer token = new StringTokenizer(re.readLine());
            for (int j = 0; j < n; j++) {
                char c = token.nextToken().charAt(0);
                switch (c) {
                    case 'S':
                        map[i][j] = 1;
                        break;
                    case 'T':
                        map[i][j] = 2;
                        teacherLocation.add(new Pos(i,j));
                        break;
                    case 'X':
                        map[i][j] = 0;
                        break;
                    default:
                        break;
                }
            }
        }

        // 0,0부터 n,n까지 3가지 장애물 놓을 수 있는 모든 경우 찾기.
        findCases(0,0,0);

        for (int i = 0; i < cases.size(); i++) {
            for (Pos pos : cases.get(i)) {
                map[pos.x][pos.y] = 3;
            }

            boolean pass = true;
            for (int j = 0; j < teacherLocation.size(); j++) {
                Pos now = teacherLocation.get(j);

                for(int d = 0; d <4; d++){
                    int x = now.x;
                    int y = now.y;
                    while(isValid(x,y) && map[x][y] != 3 && map[x][y] != 1){
                        x += delta[d][0];
                        y += delta[d][1];
                    }
                    if(isValid(x,y) && map[x][y] == 1){
                        pass = false;
                        break;
                    }
                }

                if(!pass)
                    break;
            }

            if(pass){
                wr.write("YES");
                re.close();
                wr.close();
                return;
            }

            for (Pos pos : cases.get(i)) {
                map[pos.x][pos.y] = 0;
            }

        }

        wr.write("NO");

        // for (int i = 0; i < cases.size(); i++) {
        //     for (Pos pos : cases.get(i)) {
        //         wr.write(String.format("(%d,%d) ",pos.x, pos.y));
        //     }wr.newLine();
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         wr.write(map[i][j] + '0');
        //         wr.write(' ');
        //     }
        //     wr.newLine();
        // }
        
        re.close();
        wr.close();
    }
}

class Pos{
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}
