package _03_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_DC_19637 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] grade = new String[N];
		int[] points = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			grade[i] = st.nextToken();
			points[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(br.readLine());
			int index = binarySearch(target, points);
			sb.append(grade[index] + "\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	static int binarySearch(int target, int[] points) {
		int right = N - 1;
		int left = 0;

		while (left <= right) {
			int mid = right - (right - left) / 2;
			if(mid == right && mid == left) {
				return mid;
			}
			if(points[mid] < target) {
				if(points[mid+1]>=target) {
					return mid+1;
				}
				left = mid+1;
			}else if(points[mid] >= target) {
				if(points[mid-1] <target) {
					return mid;
				}
				right = mid-1;
			}
		}
		return -1;
	}

}
