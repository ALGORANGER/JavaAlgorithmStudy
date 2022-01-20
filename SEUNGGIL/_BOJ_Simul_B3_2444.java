import java.util.Scanner;
public class _BOJ_Simul_B3_2444 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n-i; j++) {
				System.out.print(' ');
			}
			for (int j = 0; j < 2*i-1; j++)
				System.out.print('*');
			System.out.println();
		}
		
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < n-i; j++) {
				System.out.print(' ');
			}
			for (int j = 0; j < 2*i-1; j++)
				System.out.print('*');
			System.out.println();
		}
		
		scanner.close();
	}

}