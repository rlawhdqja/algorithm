package a221112;

import java.io.*;
import java.util.*;

public class Solution_GNS_1221 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N;
		String [] arr;
		String num;
		for(int tc = 1; tc<=T; tc++) {
			arr = new String [10];
			for(int i = 0; i<10; i++) arr[i] = "";
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				num = st.nextToken();
				if(num.equals("ZRO")) {
					arr[0]+="ZRO"+" ";
				}
				else if(num.equals("ONE")) {
					arr[1]+="ONE"+" ";
				}
				else if(num.equals("TWO")) {
					arr[2]+="TWO"+" ";
				}
				else if(num.equals("THR")) {
					arr[3]+="THR"+" ";
				}
				else if(num.equals("FOR")) {
					arr[4]+="FOR"+" ";
				}
				else if(num.equals("FIV")) {
					arr[5]+="FIV"+" ";
				}
				else if(num.equals("SIX")) {
					arr[6]+="SIX"+" ";
				}
				else if(num.equals("SVN")) {
					arr[7]+="SVN"+" ";
				}
				else if(num.equals("EGT")) {
					arr[8]+="EGT"+" ";
				}
				else if(num.equals("NIN")) {
					arr[9]+="NIN"+" ";
				}
			}
			
			
			sb.append("#").append(tc).append("\n");
			for(int i = 0; i<10; i++) {
				sb.append(arr[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
}
