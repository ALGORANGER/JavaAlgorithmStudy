package algorithm.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.HashMap;

public class _BOJ_Tree_S3_20920 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder answer = new StringBuilder();
	
	private static HashMap<String, Integer> wordList = new HashMap<String,Integer>();
	private static ArrayList<String> words = new ArrayList<String>();
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		//delete
		System.setIn(_BOJ_Tree_S3_20920.class.getResourceAsStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		//delete
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		wordList = new HashMap<String, Integer>();
		words = new ArrayList<String>();
		
		for(int i = 0; i <N; i++){
			String temp = br.readLine();
			if(temp.length() < M) {
				continue;
			}
			if(wordList.get(temp) == null) { // 처음 보는 단어인 경우
				words.add(temp);                         // 단어배열에 추가
				wordList.put(temp, 1);
			}else if(temp.length() >= M) {
				wordList.put(temp, wordList.get(temp)+1);
			}
		}
		
		Collections.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				int c1 = wordList.get(o1);  // o1 빈도수
				int c2 = wordList.get(o2);  // o2 빈도수
				// 빈도가 같은 경우
				if(c1 == c2) { 
					if(o1.length() == o2.length()) { // 길이가 같은 경우
						return o1.compareTo(o2);     // 사전 순 정렬
					}
					if(o1.length() > o2.length()){
						return -1;
					}else {
						return 1;
					}
				}
				if( c1 > c2) {   // o1 빈도수 > o2
					return -1;
				}else {                // o1 빈도수 < o2
					return 1;
				}
			}
			
		});
		
		for(int i = 0; i < words.size(); i++) {
			answer.append(words.get(i)+"\n");
		}
		System.out.print(answer);
	}

}
