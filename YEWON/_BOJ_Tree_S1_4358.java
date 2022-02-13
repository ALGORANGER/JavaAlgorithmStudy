package algorithm.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _BOJ_Tree_S1_4358 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static StringBuilder answer = new StringBuilder();

	private static HashMap<String, Integer> treeList = new HashMap<String, Integer>();
	private static ArrayList<String> trees = new ArrayList<String>();
	private static int treeCnt;

	public static void main(String[] args) throws IOException {
		// delete
		System.setIn(_BOJ_Tree_S3_20920.class.getResourceAsStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		// delete
		treeList = new HashMap<String, Integer>();
		trees = new ArrayList<String>();
		treeCnt = 0;

		while (br.ready()) {
			String temp = br.readLine();
			if (treeList.get(temp) == null) { // 처음 보는 나무인 경우
				trees.add(temp);
				treeList.put(temp, 1);
				treeCnt++;
			} else {
				treeList.put(temp, treeList.get(temp) + 1);
				treeCnt++;
			}
		}

		Collections.sort(trees);
		for (int i = 0; i < trees.size(); i++) {
			System.out.printf("%s %.4f%n", trees.get(i), (float) treeList.get(trees.get(i))*100 / treeCnt);
		}

	}
}
