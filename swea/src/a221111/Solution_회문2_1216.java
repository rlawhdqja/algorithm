package a221111;

import java.io.*;
import java.util.*;

public class Solution_회문2_1216 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int answer;
		int K;
		char [][] words;
		boolean gb;
		boolean bb;
		Queue<Character> gq = new LinkedList<>();
		Stack<Character> gs = new Stack<>();
		Queue<Character> bq = new LinkedList<>();
		Stack<Character> bs = new Stack<>();
		for(int tc=1; tc<=10; tc++) {
			answer = 0;
 
			K = Integer.parseInt(br.readLine());
			words = new char[100][100];
			for(int i=0; i<100; i++) {
				words[i] = br.readLine().toCharArray();
			}
			for(int i=0; i<100; i++) {
				exit:for(int j=0; j<100; j++) {
					if(100-j<=answer) break;
					gb = false;
					bb = false;
					for(int d=99; d>=j; d--) {
						gq.offer(words[i][d]);
						gs.add(words[i][d]);
						bq.offer(words[i][99-d]);
						bs.add(words[i][99-d]);
					}
					for(int d=0; d<100-j; d++) {
						if(!gb && gq.poll() != gs.pop()) {
							gq.clear();
							gs.clear();
							gb = true;
						}
						if(!bb && bq.poll() != bs.pop()) {
							bq.clear();
							bs.clear();
							bb = true;
						}
						if(gb && bb) continue exit;
					}
					if(!gb || !bb) {
						answer = 100-j;
						break;
					}
				}
			}
			for(int i=0; i<100; i++) {
				exit:for(int j=0; j<100; j++) {
					if(100-j<=answer) break;
					gb = false;
					bb = false;
					for(int d=99; d>=j; d--) {
						gq.offer(words[d][i]);
						gs.add(words[d][i]);
						bq.offer(words[99-d][i]);
						bs.add(words[99-d][i]);
					}
					for(int d=0; d<100-j; d++) {
						if(!gb && gq.poll() != gs.pop()) {
							gq.clear();
							gs.clear();
							gb = true;
						}
						if(!bb && bq.poll() != bs.pop()) {
							bq.clear();
							bs.clear();
							bb = true;
						}
						if(gb && bb) continue exit;
					}
					if(!gb || !bb) {
						answer = 100-j;
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
