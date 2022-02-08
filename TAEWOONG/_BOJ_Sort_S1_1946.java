package com.ssafy.algo.day0202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _BOJ_Sort_S1_1946 {
	
	static class Person {
		int A;
		int B;

		public Person(int A, int B) {
			this.A = A;
			this.B = B;
		}

		@Override
		public String toString() {
			return "Person [A=" + A + ", B=" + B + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			int N = Integer.parseInt(br.readLine());
			int pass = 1;

			Person[] p = new Person[N];
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				p[i] = new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(p, new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					return o1.A - o2.A;
				}
			});
			
			
			
			Person temp = new Person(p[0].A,p[0].B);
			
			for (int i=1;i<N;i++) {
				if(temp.B>p[i].B) {
					pass++;
					temp.B=p[i].B;
				}
				
			}
			
			bw.write(String.valueOf(pass) + "\n");

		}

		bw.flush();
		bw.close();

	}

}
