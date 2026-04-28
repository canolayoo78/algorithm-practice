import java.util.*;
import java.io.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int dist[][], map[];
	static int N, M, R;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        map = new int[N + 1];
        dist = new int[N+1][N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
        	map[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
		}
        
        for (int r = 0; r < R; r++) {
        	st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            dist[s][e] = l;
            dist[e][s] = l;
		}
        
        for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if (dist[i][k] == INF || dist[k][j] == INF) continue;
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
        
        int max = 0;
        for (int i = 1; i < N+1; i++) {
        	int total = 0;
			for (int j = 1; j < N+1; j++) {
				if (dist[i][j] <= M) {
					total += map[j];
				}
			}
			if (max < total) {
				max = total;
			}
        }
        
        System.out.println(max);
	}
}
