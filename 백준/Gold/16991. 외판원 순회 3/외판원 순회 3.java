import java.util.*;
import java.io.*;

public class Main {
	static final int INF = 20_000_000;
	static int N, statusFullBit;
	static double dp[][];
	static double w[][];
	static int pos[][]; 
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	
    	// 전부 방문했을 때
    	statusFullBit = (1 << N) - 1;
    	
    	pos = new int[N][2];
    	dp = new double[N][statusFullBit+1];
    	w = new double[N][N];
    	
    	for(int i=0; i < N; i++) {
			Arrays.fill(dp[i], -1);
            Arrays.fill(w[i], -1);
		}
    	
    	for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
    	
    	System.out.println(tsp(0,1));
    	
    }
    
    static double calcDistanceBtw(int indexA, int indexB) {
    	if (w[indexA][indexB] != -1) {
    		return w[indexA][indexB];
    	}
    	
    	int x = pos[indexA][0] - pos[indexB][0];
    	int y = pos[indexA][1] - pos[indexB][1];
    	double dist = Math.sqrt(x*x+y*y);
    	
    	w[indexA][indexB] = dist;
    	w[indexB][indexA] = dist;
    	
    	return dist;
    }
    
    static double tsp(int now, int visited) {
    	// 모든 곳을 다 들렸을 때
    	if (visited == statusFullBit) {
			return calcDistanceBtw(now, 0);
    	}
    	
    	if (dp[now][visited] != -1) {
    		return dp[now][visited];
    	}
    	
    	dp[now][visited] = INF;
    	
		// 방문하지 않은 도시 탐색 
    	for (int i = 1; i < N; i++) {
			// next : i 도시 방문
            int next = (1 << i);
            
			// 도시를 이미 방문했을 경우 continue 
			if ((visited & next) != 0) continue;
			
			int updatedVisited = next | visited;
			double res = tsp(i, updatedVisited) + calcDistanceBtw(now, i);
			
			dp[now][visited] = Math.min(dp[now][visited], res);
    	}
    	return dp[now][visited];
    }
}