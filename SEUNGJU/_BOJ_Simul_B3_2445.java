import java.util.Scanner;

public class _BOJ_Simul_B3_2445 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			for(int j = 0; j < 8 - i * 2; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < N - 1; i++) {
			for(int j = 0; j < 4 - i; j++) {
				System.out.print("*");
			}
			for(int j = 0; j < 2 + i * 2; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < 4 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
