import java.util.Scanner;

public class _BOJ_Simul_B3_2445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		char[] s = new char[2*n];
		
		for (int i = 0; i < s.length; i++)
			s[i] = ' ';
		
		
		for (int i = 0; i < n; i++) {
			s[i] = '*';
			s[2*n-i-1] = '*';
			System.out.println(new String(s));
		}
		
		for (int i = n-1; i >= 0; i--) {
			s[i] = ' ';
			s[2*n-i-1] = ' ';
			System.out.println(new String(s));
		}
		
		scanner.close();
	}

}
