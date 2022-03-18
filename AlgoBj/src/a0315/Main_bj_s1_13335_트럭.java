package a0315;

import java.util.*;
import java.io.*;

public class Main_bj_s1_13335_Æ®·° {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
//		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int bridge [] = new int [w]; 
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}

		while (!q.isEmpty() || Arrays.stream(bridge).sum()!=0) {
			for(int i=0; i<w-1; i++) {
				bridge[i] = bridge[i+1];
			}
			bridge[w-1] = 0;
			int sum = Arrays.stream(bridge).sum();
			if(!q.isEmpty() && sum+q.peek() <= L) bridge[w-1] = q.poll();
			answer++;
		}
		System.out.println(answer);
		br.close();
	}
}
