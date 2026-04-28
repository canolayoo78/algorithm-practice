import java.util.*;
import java.io.*;

public class Main {
	static final int MOD = 9901;
	static int [][] dp;
	static int N;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	dp = new int[N][3];
    	Arrays.fill(dp[0], 1);
    	
    	dp();
    	
    	int ans = (dp[N-1][0]+dp[N-1][1]+dp[N-1][2]) % MOD;
    	System.out.println(ans);
    }
    
    
    static void dp() {
    	for (int i = 1; i < N; i++) {
    		// 내가 0 0  일때
    		dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
    		
    		// 내가 0 1 일 때 
    		dp[i][1] = dp[i-1][0] + dp[i-1][2];
    		
    		// 내가 1 0 일 때 
    		dp[i][2] = dp[i-1][0] + dp[i-1][1];
    		
    		for (int j = 0; j < 3; j++) {
				if (dp[i][j] > MOD) {
					dp[i][j] %= MOD;
				}
			}
    	}
    }
}