package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class applicant implements Comparable<applicant>{
	int doc;
	int inter;
	public applicant(int doc, int inter) {
		this.doc = doc;
		this.inter = inter;
	}
	@Override
	public int compareTo(applicant o) {
		return Integer.compare(this.doc, o.doc);
	}
	
}

public class _BOJ_Sort_S1_1946 {
	static List<applicant> Apply = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			for (int n = 0; n < N; n++) {
				String[] arr = br.readLine().split(" ");
				Apply.add(new applicant(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
			}
			Collections.sort(Apply);
			
			for(applicant ap : Apply) {
				
				System.out.println(ap.doc+" "+ap.inter);
			}

			
			int Inter = Apply.get(0).inter;
			int answer = 1;
			for(applicant ap : Apply) {
				
				if(ap.inter<Inter) {
					Inter = ap.inter;
					answer++;
				}
			}
			bw.write(answer+"\n");
			Apply.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
