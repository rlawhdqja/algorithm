package a220607;

import java.util.*;
import java.io.*;

public class Main_1655_가운데를말해요 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minpq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(i%2 == 0) {
				minpq.offer(num);
			} else {
				maxpq.offer(num);
			}
			if(!maxpq.isEmpty() && !minpq.isEmpty()) {
				if(maxpq.peek() > minpq.peek()) {
					int tmp = minpq.poll();
					minpq.offer(maxpq.poll());
					maxpq.offer(tmp);
				}
			}
			sb.append(maxpq.peek()).append("\n");
			
		}
		System.out.println(sb.toString());
		br.close();
	}
}
