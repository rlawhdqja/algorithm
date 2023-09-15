package a0329;

import java.util.*;
import java.io.*;

public class Main_bj_s1_16918_봄버맨 {

	static int R, C, N;
	static int[][] map;
	static int[] di = { 0, -1, 0, 1 };
	static int[] dj = { 1, 0, -1, 0 };
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		q = new LinkedList<>();

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()) - 1;
		map = new int[R][C];
		boolean flag = true;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == 'O')
					map[i][j] = 3;
			}
		}

		while (N > 0) {
			if (flag) {
				bombing();
				setBomb();
			} else {
				bombing();
			}
			N--;
			flag = !flag;

		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0)
					sb.append(".");
				else
					sb.append("O");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	static void setBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0) {
//					q.offer(new int[] {i,j,3});
					map[i][j] = 4;
				}
			}
		}
		return;
	}

	static void bombing() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					map[i][j]--;
				if (map[i][j] == 1)
					q.offer(new int[] { i, j });
			}
		}

		while (!q.isEmpty()) {
			int arr[] = q.poll();
			map[arr[0]][arr[1]] = 0;
			for (int d = 0; d < 4; d++) {
				int ni = arr[0] + di[d];
				int nj = arr[1] + dj[d];
				if (ni < 0 || ni >= R || nj < 0 || nj >= C)
					continue;
				map[ni][nj] = 0;
			}
		}
		return;
	}
}
