package a221202;

import java.util.*;
import java.io.*;

public class Main_13460_구슬탈출2 {

//	구슬을 움직이는 방법은 4방향으로 기울이기.
//	즉 4가지 경우의 수 말고는 없다.
//	또한 10번이하로만 움직일 것이기 때문에 
//	4의 10승 번의 반복 이하로 문제 해결 가능
//	그렇다면 어떻게 4방향으로 움직이게 하며 
//	어떻게 모든 경우의 수를 해볼것인가.
//	
//	1. 재귀함수 사용 하기. 
//	4방향움직임을 만들고 10번의 한계를 정할 변수 설정
//	성공하면 횟수를 최소값과 비교해서 반환
//	모두 실패시 -1 출력
	
	

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int N, M;
	static char[][] map;
	static int answer;
	static boolean goal, fail;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 10;
		map = new char[N][M];
		goal = false;
		fail = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			map[i] = st.nextToken().toCharArray();
		
		}
		

		System.out.println(answer);
	}

}
