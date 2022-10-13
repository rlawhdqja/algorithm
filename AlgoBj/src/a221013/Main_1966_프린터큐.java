package a221013;

import java.util.*;
import java.io.*;

public class Main_1966_프린터큐 {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			
			int answer = 0;
			int [] idx = new int [10];
			Queue<int[]> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
	        
	        for(int i=0; i<N; i++){
	        	int x = Integer.parseInt(st.nextToken());
	            q.offer(new int[]{i,x});
	            idx[x]++;
	        }
	        
	        label:while(!q.isEmpty()){
	            for(int i=q.peek()[1]+1; i<10; i++){
	                if(idx[i]>0){
	                    q.offer(q.poll());
	                    continue label;
	                }
	            }
	            answer++;
	            idx[q.peek()[1]]--;
	            if(q.poll()[0]==M) {
	            	sb.append(answer).append("\n");
	            	break label; 
	            }
	        }
			
		}
		System.out.println(sb.toString());
		br.close();
	}

}
