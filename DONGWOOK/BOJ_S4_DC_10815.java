package _03_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_S4_DC_10815 {
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))){
				sb.append(1+" ");
			}else{
				sb.append(0+" ");
			};
		}
		
		sb.setLength(sb.length() - 1);
		
		
		System.out.println(sb.toString());
	}

}
