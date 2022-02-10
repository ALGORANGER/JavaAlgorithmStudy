import java.util.*;
import java.io.*;

public class _BOJ_Map_S5_9733 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String,Integer> inputData = new HashMap<>();
        int total = 0;
        while(sc.hasNext()){
            total++;
            String s = sc.next();
            inputData.merge(s, 1, Integer::sum);
        }
        double total2 = total;
        
        System.out.printf("Re %d %.2f\n", inputData.getOrDefault("Re", 0), inputData.getOrDefault("Re",0)/total2);
        System.out.printf("Pt %d %.2f\n", inputData.getOrDefault("Pt", 0), inputData.getOrDefault("Pt",0)/total2);
        System.out.printf("Cc %d %.2f\n", inputData.getOrDefault("Cc", 0), inputData.getOrDefault("Cc",0)/total2);
        System.out.printf("Ea %d %.2f\n", inputData.getOrDefault("Ea", 0), inputData.getOrDefault("Ea",0)/total2);
        System.out.printf("Tb %d %.2f\n", inputData.getOrDefault("Tb", 0), inputData.getOrDefault("Tb",0)/total2);
        System.out.printf("Cm %d %.2f\n", inputData.getOrDefault("Cm", 0), inputData.getOrDefault("Cm",0)/total2);
        System.out.printf("Ex %d %.2f\n", inputData.getOrDefault("Ex", 0), inputData.getOrDefault("Ex",0)/total2);
        System.out.printf("Total %d 1.00\n",total);

        sc.close();
    }
}
