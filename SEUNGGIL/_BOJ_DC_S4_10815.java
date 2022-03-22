// import java.util.*;
// import java.io.*;

// 1. treeSet 쓰기.
// public class _BOJ_DC_S4_10815 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
//         Set<Integer> inputData = new TreeSet<>();
        
//         int n = Integer.parseInt(re.readLine());

//         StringTokenizer token = new StringTokenizer(re.readLine());
//         for(int i = 0; i < n; i++){
//             inputData.add(Integer.parseInt(token.nextToken()));
//         }

//         int m = Integer.parseInt(re.readLine());

//         StringBuilder ans = new StringBuilder();
        
//         token = new StringTokenizer(re.readLine());
//         for(int i = 0; i < m; i++){
//             if(inputData.contains(Integer.parseInt(token.nextToken()))){
//                 ans.append(1).append(' ');
//             }
//             else{
//                 ans.append(0).append(' ');
//             }
//         }

//         System.out.print(ans);

//         re.close();
//     }
// }

// 2. 정렬하고 set에 넣기

// import java.util.*;
// import java.io.*;


// public class _BOJ_DC_S4_10815 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
//         Set<Integer> inputData = new TreeSet<>();
        
//         int n = Integer.parseInt(re.readLine());
//         List<Integer> nums = new ArrayList<>(n+1);

//         StringTokenizer token = new StringTokenizer(re.readLine());
//         for(int i = 0; i < n; i++){
//             nums.add(Integer.parseInt(token.nextToken()));
//         }

//         nums.sort(null);
//         inputData.addAll(nums);
//         int m = Integer.parseInt(re.readLine());

//         StringBuilder ans = new StringBuilder();
        
//         token = new StringTokenizer(re.readLine());
//         for(int i = 0; i < m; i++){
//             if(inputData.contains(Integer.parseInt(token.nextToken()))){
//                 ans.append(1).append(' ');
//             }
//             else{
//                 ans.append(0).append(' ');
//             }
//         }

//         System.out.print(ans);

//         re.close();
//     }
// }



// 3. hashset

// import java.util.*;
// import java.io.*;

// public class _BOJ_DC_S4_10815 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
//         Set<Integer> inputData = new HashSet<>();
        
//         int n = Integer.parseInt(re.readLine());

//         StringTokenizer token = new StringTokenizer(re.readLine());
//         for(int i = 0; i < n; i++){
//             inputData.add(Integer.parseInt(token.nextToken()));
//         }

//         int m = Integer.parseInt(re.readLine());

//         StringBuilder ans = new StringBuilder();
        
//         token = new StringTokenizer(re.readLine());
//         for(int i = 0; i < m; i++){
//             if(inputData.contains(Integer.parseInt(token.nextToken()))){
//                 ans.append(1).append(' ');
//             }
//             else{
//                 ans.append(0).append(' ');
//             }
//         }

//         System.out.print(ans);

//         re.close();
//     }
// }


// 4. 이분탐색

import java.util.*;
import java.io.*;


public class _BOJ_DC_S4_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(re.readLine());
        List<Integer> inputData = new ArrayList<>(n+1);

        StringTokenizer token = new StringTokenizer(re.readLine());
        for(int i = 0; i < n; i++){
            inputData.add(Integer.parseInt(token.nextToken()));
        }

        inputData.sort(null);

        int m = Integer.parseInt(re.readLine());
        token = new StringTokenizer(re.readLine());

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < m ; i++){
            int target = Integer.parseInt(token.nextToken());

            int start = 0;
            int end = n-1;

            while(start <= end){
                int mid = (start + end)/2;
                int num = inputData.get(mid);

                if(num == target){
                    ans.append('1').append(' ');
                    break;
                }else if(num > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            if(start > end)
                ans.append('0').append(' ');
        }
        System.out.print(ans);

        re.close();
    }
}