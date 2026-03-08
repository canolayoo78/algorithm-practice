import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] graph;
	static boolean[] visited;
	static boolean[] team;
	static int[] ppl;
	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{	
		N = Integer.parseInt(br.readLine());
		ppl = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ppl[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new int[N+1][];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int adjCnt = Integer.parseInt(st.nextToken());
			graph[i] = new int[adjCnt];
			for (int j = 0; j < adjCnt; j++) {
				int adj = Integer.parseInt(st.nextToken());
				graph[i][j] = adj;
			}
		}
		
		team = new boolean[N+1];
		team[1] = true;
		subset(2, ppl[1], 0);
		
		System.out.println(min == Integer.MAX_VALUE? -1: min);
	}
	
	static void subset(int cnt, int sumA, int sumB) {
		if (cnt == N + 1) {
			if (conn(team)) {
				int temp = Math.abs(sumA - sumB);
				if (temp < min)
					min = temp;
			}
			return;
		}
		team[cnt] = true;
		subset(cnt + 1, sumA + ppl[cnt], sumB);
		team[cnt] = false;
		subset(cnt + 1, sumA, sumB + ppl[cnt]);
	}
	
	static boolean conn(boolean [] team) {
		visited = new boolean[N+1];
		for (int i = 1; i <= N ; i++) {
			if(team[i]) {
				bfs(i, true); break;
			}
		}
		
		for (int i = 1; i <= N ; i++) {
			if(!team[i]) {
				bfs(i, false); break;
			}
		}
		
		boolean AllVisited = true;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				AllVisited = false; break;
			}
		} 
		if (AllVisited) {
			return true;
		}
		else
			return false;
	}
	
	static void bfs(int s, boolean t) {		
		Deque<Integer> q = new ArrayDeque<>();
		q.add(s);
		visited[s] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int next : graph[now]) {
				if (visited[next]) continue;
				if (team[next] != t) continue; 
				visited[next] = true;
				q.add(next);				
			}
		}
	}
}
