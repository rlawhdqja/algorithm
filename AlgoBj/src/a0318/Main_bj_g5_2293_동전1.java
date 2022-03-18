package a0318;

import java.util.*;
import java.io.*;

public class Main_bj_g5_2293_µ¿Àü1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coins[] = new int [n+1];
		int dp[] = new int [k+1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}		
		Arrays.sort(coins);
		
		for (int i = 1; i <= n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				dp[j] = dp[j] + dp[j - coins[i]];
			}
		}
		answer = dp[k];
		System.out.println(answer);
		br.close();
	}
}
