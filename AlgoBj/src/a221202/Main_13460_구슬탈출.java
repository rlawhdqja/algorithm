package a221202;

import java.util.*;
import java.io.*;

public class Main_13460_구슬탈출 {

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
		
		act(1,map);
		System.out.println(answer);
	}

	static char[][] copy(char[][] map) {
		char[][] arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = map[i][j];
			}
		}
		return arr;
	}

	static void act(int cnt, char[][] map) {

		if (cnt == 10)
			return;
		if (goal) {
			answer = Math.min(cnt, answer);
			goal = false;
			return;
		}
		if (fail) {
			fail = false;
			return;
		}
		char[][] tmp = copy(map);

		for (int d = 0; d < 4; d++) {
			red(d, tmp);
			blue(d, tmp);
			act(cnt + 1, map);
		}
	}

	static void red(int d, char[][] map) {
		int ni = 0;
		int nj = 0;
		q:for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'R') {
					ni = i;
					nj = j;
					break q;
				}
			}
		}
		while (true) {
			ni = ni + di[d];
			nj = nj + dj[d];
			if (ni > 0 && ni < N - 1 && nj > 0 && nj < M - 1) {
				if (map[ni][nj] == 'B') {
					if (map[ni + di[d]][nj + dj[d]] == '.') {
						blue(d, map);
					} else
						break;
				} else if (map[ni][nj] == '.') {
					map[ni][nj] = 'R';
					continue;
				}

				else if (map[ni][nj] == 'O') {
					goal = true;
					return;
				} else
					break;
			}
		}
	}

	static void blue(int d, char[][] map) {
		int ni = 0;
		int nj = 0;
		q:for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'B') {
					ni = i;
					nj = j;
					break q;
				}
			}
		}
		while (true) {
			ni = ni + di[d];
			nj = nj + dj[d];
			if (ni > 0 && ni < N - 1 && nj > 0 && nj < M - 1) {
				if (map[ni][nj] == 'R') {
					if (map[ni + di[d]][nj + dj[d]] == '.') {
						red(d, map);
					} else
						break;
				} else if (map[ni][nj] == '.') {
					map[ni][nj] = 'B';
					continue;
				}

				else if (map[ni][nj] == 'O') {
					fail = true;
					return;
				} else
					break;
			}
		}
	}

//	static void red(int cnt, char[][] map) {
//		
//		if(cnt==10) return;
//		if(goal) answer = Math.min(cnt, answer);
//		
//		
//		for(int d=0; d<4; d++) {
//			int ni = 0;
//			int nj = 0;
//			while(true) {
//				ni=ni+di[d];
//				nj=nj+dj[d];
//				if(ni>0 && ni<N-1 && nj>0 && nj<M-1) {
//					if(map[ni][nj]=='B') {
//						if(map[ni+di[d]][nj+dj[d]]=='.') {
//							blue(cnt, map);
//						} else break;
//					}
//					else if(map[ni][nj]=='.') {
//						map[ni][nj] = 'R';
//						continue;
//					}
//						
//					else if(map[ni][nj]=='O') {
//						answer = Math.min(answer, cnt);
//						return;
//					}
//					else break;
//				}
//			}
//			red(cnt+1, map);
//		}
//		
//	}
//	
//	static void blue(int cnt, char[][] map) {
//		
//		if(cnt==10) return;
//		
//		
//		
//		for(int d=0; d<4; d++) {
//			int ni = 0;
//			int nj = 0;
//			while(true) {
//				ni=ni+di[d];
//				nj=nj+dj[d];
//				if(ni>0 && ni<N-1 && nj>0 && nj<M-1) {
//					if(map[ni][nj]=='B') {
//						if(map[ni+di[d]][nj+dj[d]]=='.') {
//							red(cnt, map);
//						} else break;
//					}
//					else if(map[ni][nj]=='.') continue;
//					else if(map[ni][nj]=='O') {
//						return;
//					}
//					else {
//						
//						break;
//					}
//				}
//			}
//			red(cnt+1, map);
//		}
//		
//	}

}
