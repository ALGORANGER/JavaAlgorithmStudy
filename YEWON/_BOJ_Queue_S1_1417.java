
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _BOJ_Queue_S1_1417 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int t = Integer.parseInt(br.readLine()); // 후보자 수
	      // 다솜이 외 후보자들 투표수 큐를 역순으로 (큰->작)
	      PriorityQueue<Integer> candidate = new PriorityQueue<>(Collections.reverseOrder()); 
	      int d = Integer.parseInt(br.readLine()); // 다솜 표
	      int cand = 0; // 다른 후보자 표
	      int best = 0; // 최고 순위 표
	      int cnt = 0; // 매수 수

	      for (int i = 0; i < t - 1; i++) { // 다솜이를 제외한 후보자수 만큼 반복문을 통해 후보자들 투표수 큐에
	         candidate.add(Integer.parseInt(br.readLine()));
	      }
	      
	      // 후보자가 다솜이 뿐이면 매수할 필요가 없으므로 후보자 수가 1이 아닌 경우를 확인.
	      if (t != 1) {                    
	         while (d <= candidate.peek()) { // 다솜 <= 가장 투표수가 많은 후보자 라면    
	            best = candidate.poll();    // 최고 투표수에 큐의 우선순위1을 빼서 할당     
	            best--;                     // 최고 투표수에서 다솜이가 1 매수한다.          
	            cnt++;                      // -> 매수 카운트 1 증가                       
	            d++;                        // -> 다솜이 표 1 증가                          
	            candidate.add(best);        // 1감소한 최고 투표수를 다시 후보자 큐에 추가   
	         }
	         System.out.println(cnt);        // 최종 매수 수를 출력
	      }else {                            // 후보자가 다솜이 혼자인 경우는 매수 0 출력
	         System.out.println(0);
	      }
	      
	   }

	}

}

}
