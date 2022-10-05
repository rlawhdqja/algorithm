package a221005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_g3_16235_나무재테크 {
	
	static int N,M,K;
	static int[][] land;
	static int[][] S2D2;
	static PriorityQueue<Tree> pq;
	
	static int[] di = {0,0,1,1,1,-1,-1,-1};
	static int[] dj = {1,-1,0,-1,1,0,-1,1};
	
	static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int z;
		public Tree() {
		}
		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(Tree o) {
			return this.z <= o.z ? -1 : 1;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		land = new int [N+1][N+1];
		S2D2 = new int [N+1][N+1];
		pq = new PriorityQueue<>();
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				land[i][j] = 5;
				S2D2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int x,y,z;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			pq.offer(new Tree (x,y,z));
		}
		for(int i=0; i<K; i++) year();
		System.out.println(pq.size());
		

	}
	static void year() {
		Queue<Tree> q = new LinkedList<>();
		int [][] dies = new int[N+1][N+1];
		while(!pq.isEmpty()) {
			Tree t = pq.poll();
			if(t.z<=land[t.x][t.y]) {
				land[t.x][t.y]-=t.z;
				t.z++;
				q.offer(t);
				if(t.z%5 == 0) {
					for(int d=0; d<8; d++) {
						int ni=t.x+di[d];
						int nj=t.y+dj[d];
						if(0<ni && N>=ni && 0<nj && N>=nj) q.offer(new Tree (ni,nj,1));
					}
				}
			} else {
				dies[t.x][t.y]+=(t.z/2);
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				land[i][j] += dies[i][j];
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				land[i][j] += S2D2[i][j];
			}
		}
		while(!q.isEmpty()) {
			pq.offer(q.poll());
		}
	}
}
