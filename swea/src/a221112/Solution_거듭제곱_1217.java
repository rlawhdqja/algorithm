package a221112;

import java.io.*;
import java.util.*;

public class Solution_거듭제곱_1217 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N,M;
		int answer;
		for(int tc = 1; tc<=10; tc++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = pow(N,M);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	static int pow(int n, int m) {
		if(m==1)return n;
		if(m%2 == 0) return pow(n, m/2) * pow(n, m/2) ;
		else return pow(n, m/2+1) * pow(n, m/2) ;
	}
}
