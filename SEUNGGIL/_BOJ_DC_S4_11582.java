import java.util.*;
import java.io.*;

public class _BOJ_DC_S4_11582 {
    static void mergeSort(int[] inputData, int n){
        for(int i = 0; i < inputData.length; i += n){
            int[] a = new int[n/2];
            int[] b = new int[n/2];

            for(int j = i; j < i + n/2; j++){
                a[j-i] = inputData[j];
            }
            for(int j = i + n/2; j < i + n; j++){
                b[j-(i+n/2)] = inputData[j];
            }

            int aIdx = 0;
            int bIdx = 0;

            for(int j = i; j < i + n; j++){
                if(aIdx >= n/2){
                    inputData[j] = b[bIdx++];
                }else if(bIdx >= n/2){
                    inputData[j] = a[aIdx++];
                }
                else if(a[aIdx] < b[bIdx]){
                    inputData[j] = a[aIdx++];
                }else{
                    inputData[j] = b[bIdx++];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(re.readLine());
        
        int[] inputData = new int[n];
        
        StringTokenizer token = new StringTokenizer(re.readLine());
        for(int i = 0; i < n; i++){
            inputData[i] = Integer.parseInt(token.nextToken());
        }

        int m = Integer.parseInt(re.readLine());
        for(int i = n / 2; i >= m; i /= 2){
            mergeSort(inputData, n/i);
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < inputData.length; i++){
            ans.append(inputData[i]).append(' ');
        }
        System.out.print(ans);
        re.close();
    }
}
