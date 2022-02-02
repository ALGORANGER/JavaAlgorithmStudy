package com.ssafy.algo.day0202;

import java.util.*;

public class _BOJ_Queue_S1_13335 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();


		int[] infoN = new int[3]; // 트럭 수 , 다리 길이, 다리 하중

		int limit = 0; // 다리 하중
		int timer = 0; // 이동 시간

		for (int i = 0; i < 3; i++) {
			infoN[i] = sc.nextInt();
		}

		int[] truck = new int[infoN[0]]; // 트럭 정보

		for (int i = 0; i < truck.length; i++) {
			truck[i] = sc.nextInt();
			// System.out.println(truck[i]);
		}

		

		for (int i = 0; i < infoN[0]; i++) {
			while (1==1) {
				if (q.isEmpty()) { // 첫 트럭
					q.offer(truck[i]);
					limit += truck[i];
					timer++;
					break;
				} else if (q.size() == infoN[1]) {
					limit -= q.poll();
				} else {
					if (limit + truck[i] > infoN[2]) { // 하중 여유없음 (꽉참)
						q.offer(0); // 0을 넣어서 현재 트럭이 진행중임을 표시
						timer++;
					} else { // 두번째 트럭부터 + 하중 여유있음
						q.offer(truck[i]);
						limit += truck[i];
						timer++;
						break;
					}
				}

			}
		}
		System.out.println(timer+infoN[1]);  

	}

}
