package a221221;

import java.util.*;
import java.io.*;

public class Main_14499_주사위굴리기 {

	static int[][] map;
	static int[] dice;
	static int x, y;
	static int[] di = { 0, 0, 0, -1, 1 };
	static int[] dj = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dice = new int[7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int d = 0;
		for (int k = 0; k < K; k++) {
			d = Integer.parseInt(st.nextToken());
			int nx = x + di[d];
			int ny = y + dj[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			roll(d);
			if (map[nx][ny] == 0)
				map[nx][ny] = dice[6];
			else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}
			x=nx;
			y=ny;
			System.out.println(dice[1]);
		}
	}

	private static void roll(int d) {
		int[] temp = dice.clone();
		switch (d) {
		case 1:
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
			break;
		case 2:
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
			break;
		case 3:
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
			break;
		case 4:
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
			break;
		}
	}

}
