package a220712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_s1_1629_곱셈 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(A, B, C));
		
	}
	
	public static long pow(int a, int b, int c) {
		
		if(b==1) return a;
		long temp = pow(a, b/2, c) % c;
		if(b%2 == 0) {
			return (temp * temp) % c;
		} else {
			return (((temp * temp) % c) * a) % c;
		}
	}
}
