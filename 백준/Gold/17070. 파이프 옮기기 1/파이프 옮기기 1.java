import java.util.*;
import java.io.*;

public class Main {
	static int[][][] dp;
	static int[][] map;
	static int N;
	static final int HOR = 0, VER = 1, DIA = 2;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	map = new int[N+1][N+1];
    	dp = new int[N+1][N+1][3];
        dp[1][2][0] = 1;
    	// 1, 2 번째 칸에 어떤 형태로 도착해 있는지
        
        for (int r = 1; r <= N; r++) {
        	st = new StringTokenizer(br.readLine());
    		for (int c = 1; c <= N; c++) {
        		map[r][c] = Integer.parseInt(st.nextToken());
        	}
    	}
        dp();
    	System.out.println(dp[N][N][HOR] + dp[N][N][VER] + dp[N][N][DIA]);
    }
    
    
    static void dp() {
    	for (int r = 1; r <= N; r++) {
    		for (int c = 3; c <= N; c++) {
        		if (map[r][c] == 1) continue;
        		
        		// 가로로 도착한 경우
        		dp[r][c][HOR] = dp[r][c-1][HOR] + dp[r][c-1][DIA];
        		
        		// 세로로 도착한 경우
        		dp[r][c][VER] = dp[r-1][c][VER] + dp[r-1][c][DIA];
        		
        		// 대각선으로 도착한 경우
        		if (map[r-1][c] == 1 || map[r][c-1] == 1) continue;
        		dp[r][c][DIA] = dp[r-1][c-1][HOR] + dp[r-1][c-1][VER] + dp[r-1][c-1][DIA];        		
        	}
    		
    	}
    }
}