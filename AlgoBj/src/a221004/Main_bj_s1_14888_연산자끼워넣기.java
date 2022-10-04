package a221004;

import java.util.*;
import java.io.*;

public class Main_bj_s1_14888_연산자끼워넣기 {
	
	static int N, maxA, minA;
	static int[] nums;
	static int[] op;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		maxA=Integer.MIN_VALUE+1;
		minA=Integer.MAX_VALUE-1;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		nums = new int [N];
		op = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < op.length; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		sub(0, nums[0]);
		
		System.out.println(maxA+"\n"+minA);
		
	}
	
	
	static void sub(int C, int result) {
		if(C==N-1) {
			maxA = Math.max(maxA, result);
			minA = Math.min(minA, result);
			return;
		}
		

		if(op[0]>0) {
			op[0]--;
			sub(C+1, result+nums[C+1]);
			op[0]++;
		}
		if(op[1]>0) {
			op[1]--;
			sub(C+1, result-nums[C+1]);
			op[1]++;
		}
		if(op[2]>0) { 
			op[2]--;
			sub(C+1, result*nums[C+1]);
			op[2]++;
		}
		if(op[3]>0) {
			op[3]--;
			sub(C+1, result/nums[C+1]);
			op[3]++;
		}
	}
}
