import java.util.Scanner;

public class BOJ_Recursive_S5_16395 {
	
	public static int combination(int n, int k) {
		if(n == k || k == 0)
			return 1;
		if(k == 1)
			return n;
		
		return combination(n-1, k-1) + combination(n-1,k);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(combination(n-1,k-1));
		
		sc.close();
	}
}