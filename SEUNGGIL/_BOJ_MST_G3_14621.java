import java.util.*;
import java.io.*;

class Street implements Comparable<Street>{
    int from;
    int to;
    int length;

    public Street(int from, int to, int length) {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    @Override
    public int compareTo(Street o) {
        return Integer.compare(length, o.length);
    }
}

public class _BOJ_MST_G3_14621 {
    static int[] parent;
    static int find(int x){
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }
    static boolean union(List<Street> str, int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB)
            return false;

        if(parentA < parentB)
            parent[parentB] =  parentA;
        else
            parent[parentA] =  parentB;

        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());
        int schoolCnt = Integer.parseInt(token.nextToken());
        int streetCnt = Integer.parseInt(token.nextToken());

        parent = new int[schoolCnt+1];
        for(int i = 0; i < schoolCnt+1; i++){
            parent[i] = i;
        }
        boolean[] maleSchool = new boolean[schoolCnt+1];

        token = new StringTokenizer(re.readLine());
        for(int i = 1; i < schoolCnt+1; i++){
            if(token.nextToken().charAt(0) == 'M')
                maleSchool[i] = true;
        }

        List<Street> streets = new ArrayList<>();
        for(int i = 0; i < streetCnt; i++){
            token = new StringTokenizer(re.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int len = Integer.parseInt(token.nextToken());

            if((maleSchool[a] ^ maleSchool[b]) == true){
                streets.add(new Street(a,b,len));
            }
        }

        streets.sort(null);
        int ans = 0;
        int usedStreet = 0;

        for(Street iter : streets){
            int a = iter.from;
            int b = iter.to;

            if(union(streets, a, b)){
                ans += iter.length;
                ++usedStreet;

                // mst는 node 갯수 - 1 == 간선 갯수 
                if(usedStreet == schoolCnt -1)
                    break;
            }

        }
        if(usedStreet == schoolCnt -1)
            System.out.println(ans);
        else
            System.out.println(-1);
        
        re.close();
    }
}
