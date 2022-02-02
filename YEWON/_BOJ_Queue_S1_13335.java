import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _BOJ_Queue_S1_13335 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		   
		   String str1 = br.readLine();
		   StringTokenizer st1 = new StringTokenizer(str1);
		         
		   int n = Integer.parseInt(st1.nextToken());             // 트럭 수
		   int W = Integer.parseInt(st1.nextToken());             // 다리 길이
		   int L = Integer.parseInt(st1.nextToken());             // 다리 최대 하중
		   
		   int time = 0;                                          // 움직이는 시간
		   int bridgeWeight = 0;                                  // 다리의 현재 총 무게
		   
		   Queue<Integer> bridge = new LinkedList<Integer>();     // 다리 큐
		   Queue<Integer> truck = new LinkedList<Integer>();      // 트럭 큐
		   
		   
		   String str = br.readLine();
		   StringTokenizer st = new StringTokenizer(str);
		   while(st.hasMoreTokens()) {                            // 트럭 큐에 트럭을 순서대로 할당
		   truck.add(Integer.parseInt(st.nextToken()));
		   }
		   
		   for(int i = 0; i<W; i++) {                             // 다리의 초기값을 0으로 설정. 
		      bridge.add(0);
		   }
		   
		   while(!(bridge.isEmpty())) {                           // 다리가 비어있지 않은 동안 반복
		      time++;                                            // 처음 시작시 시간 증가
		      bridgeWeight -= bridge.poll();                     // 다리의 총 무게에서 다리 첫번째 요소 빼기
		      if(!(truck.isEmpty())) {                           // 트럭큐에 트럭이 남아있는 경우
		         if(bridgeWeight+truck.peek() <= L) {           // 현재 다리 무게 + 트럭의 첫번째 <= 다리 최대 하중인경우
		            bridgeWeight += truck.peek();              // 다리 총 무게에 트럭의 첫번째 값 할당
		            bridge.offer(truck.poll());                // 다리에 트럭의 첫번째를 삭제하면서 추가
		         }else {
		            bridge.offer(0);
		         }
		      }
		      
		   }
		   
		   System.out.println(time);
		   
		   }

		}

	}


