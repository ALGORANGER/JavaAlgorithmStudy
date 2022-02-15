package algorithm.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _BOJ_Tree_S4_1764 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder answer = new StringBuilder();
	private static StringTokenizer st;
	private static TreeSet<String> people = new TreeSet<String>();
	private static LinkedList<String> notSee;
	
	private static int N;
	private static int M;
	private static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(_BOJ_Tree_S4_1764.class.getResourceAsStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		//delete
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		notSee = new LinkedList<String>();
		
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			people.add(name);
		}
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(people.contains(name)) {
				cnt++;
				notSee.add(name);
			}
		}
		
		Collections.sort(notSee);
		
		answer.append(cnt+"\n");
		for(int i = 0; i<notSee.size(); i++) {
			answer.append(notSee.get(i)+"\n");
		}
		System.out.println(answer);
	}

}
