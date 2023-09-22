package a221227;

import java.util.*;
import java.io.*;

public class Main_14501_퇴사3 {
	
	
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]= Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < N; i++) {
//			schedule(i, n);
		}
	}

	private static void schedule(int i, int n) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(i);
		int money=0;
		int t=0;
		while(!q.isEmpty()) {
			t = q.poll();
			n=-arr[t][0];
			money += arr[t][1];
			q.offer(t+arr[t][0]);
			
		}
		
	}
	

}
