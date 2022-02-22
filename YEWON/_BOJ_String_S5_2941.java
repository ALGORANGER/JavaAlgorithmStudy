package day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _BOJ_String_S5_2941 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static String input;
	private static int cnt;
	private static int i = 0;
	
	public static void main(String[] args) throws IOException {
		input = br.readLine();
		cnt = 0;
		
		for(int i = 0; i < input.length();) {
			char temp = input.charAt(i);
			if(temp == 'c') {
				if(input.charAt(i+1) == '=' || input.charAt(i+1) == '-') {
					cnt++;
					i = i+2;
				}else {
					cnt++;
					i++;
				}
			}else if(temp == 'd') {
				if(input.charAt(i+1) == 'z' && input.charAt(i+2) == '=') {
					cnt++;
					i = i+3;
				}else if(input.charAt(i+1) == '-'){
					cnt++;
					i = i+2;
				}else {
					cnt++;
					i++;
				}
			}else if(temp == 'l') {
				if(input.charAt(i+1) == 'j') {
					cnt++;
					i = i+2;
				}else {
					cnt++;
					i++;
				}
			}else if(temp == 'n') {
				if(input.charAt(i+1) == 'j') {
					cnt++;
					i = i+2;
				}else {
					cnt++;
					i++;
				}
			}else if(temp == 's') {
				if(input.charAt(i+1) == '=') {
					cnt++;
					i = i+2;
				}else {
					cnt++;
					i++;
				}
			}else if(temp == 'z') {
				if(input.charAt(i+1) == '=') {
					cnt++;
					i++;
				}else {
					cnt++;
					i++;
				}
			}else {
				cnt++;
				i++;
			}
			if(i >= input.length()) {
				break;
			}
		}
		
		System.out.println(cnt);
		

	}

}
