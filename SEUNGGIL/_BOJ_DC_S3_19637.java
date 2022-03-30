// import java.util.*;
// import java.io.*;

// class Title implements Comparable<Title>{
//     String t;
//     int power;
//     public Title(String t, int power) {
//         this.t = t;
//         this.power = power;
//     }
//     @Override
//     public int compareTo(Title o) {
//         return Integer.compare(power, o.power);
//     }
// }

// public class _BOJ_DC_S3_19637 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer token = new StringTokenizer(re.readLine());
//         int titleCnt = Integer.parseInt(token.nextToken());
//         int charCnt = Integer.parseInt(token.nextToken());

//         List<Title> inputData = new ArrayList<>(titleCnt+1);

//         for(int i = 0; i < titleCnt; i++){
//             token = new StringTokenizer(re.readLine());
//             inputData.add(new Title(token.nextToken(),Integer.parseInt(token.nextToken())));
//         }
//         inputData.sort(null);

//         StringBuilder ans = new StringBuilder();
//         for(int i = 0; i < charCnt; i++){
//             int score = Integer.parseInt(re.readLine());

//             int start = 0;
//             int end = titleCnt - 1;

//             while(start <= end){
//                 int mid = (start + end) / 2;

//                 int now = inputData.get(mid).power;

//                 if(score > now){
//                     start = mid + 1;
//                 }else{
//                     if(mid == 0){
//                         ans.append(inputData.get(mid).t).append('\n');
//                         break;
//                     }else{
//                         int prePower = inputData.get(mid-1).power;
//                         if(prePower < score){
//                             ans.append(inputData.get(mid).t).append('\n');
//                             break;
//                         }else{
//                             end = mid - 1;
//                         }
//                     }
//                 }
//             }
//         }

//         System.out.print(ans);
//         re.close();
//     }
// }


import java.util.*;
import java.io.*;

public class _BOJ_DC_S3_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(re.readLine());
        int titleCnt = Integer.parseInt(token.nextToken());
        int charCnt = Integer.parseInt(token.nextToken());

        // 숫자 , 칭호
        HashMap<Integer,String> titleMap = new HashMap<>();

        // 점수
        TreeSet<Integer> inputData = new TreeSet<>();

        for(int i = 0; i < titleCnt; i++){
            token = new StringTokenizer(re.readLine());
            String title = token.nextToken();
            int power = Integer.parseInt(token.nextToken());
            
            inputData.add(power);
            if(!titleMap.containsKey(power)){
                titleMap.put(power, title);
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < charCnt; i++){
            int score = Integer.parseInt(re.readLine());
            ans.append(titleMap.get(inputData.ceiling(score))).append('\n');
        }

        System.out.print(ans);
        re.close();
    }
}
