package a221111;

import java.io.*;
import java.util.*;

public class Solution_회문1_1215 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int answer;
		int K;
		char [][] words;
		Queue<Character> q = new LinkedList<>();
		Stack<Character> s = new Stack<>();
		for(int tc=1; tc<=10; tc++) {
			answer = 0;
			K = Integer.parseInt(br.readLine());
			words = new char[8][8];
			for(int i=0; i<8; i++) {
				words[i] = br.readLine().toCharArray();
			}
			for(int i=0; i<8; i++) {
				exit:for(int j=0; j<8-K+1; j++) {
					for(int d=j; d<j+K; d++) {
						q.offer(words[i][d]);
						s.add(words[i][d]);
					}
					for(int d=0; d<K; d++) {
						if(q.poll() != s.pop()) {
							q.clear();
							s.clear();
							continue exit;
						}
					}
					answer++;
				}
			}			
			for(int i=0; i<8; i++) {
				exit:for(int j=0; j<8-K+1; j++) {
					for(int d=j; d<j+K; d++) {
						q.offer(words[d][i]);
						s.add(words[d][i]);
					}
					for(int d=0; d<K; d++) {
						if(q.poll() != s.pop()) {
							q.clear();
							s.clear();
							continue exit;
						}
					}
					answer++;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
