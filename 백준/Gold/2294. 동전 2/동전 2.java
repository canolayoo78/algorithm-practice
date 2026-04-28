import java.util.*;
import java.io.*;

public class Main {
	static int INF = Integer.MAX_VALUE;
	static Set<Integer> coins = new HashSet<>();
	static int[] dp;
	static int N, K;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	for (int i = 0; i < N; i++) {
    		coins.add(Integer.parseInt(br.readLine()));
		}
    	
    	dp = new int[K+1];
    	dp[0] = 0;
    	dp();
    	
    	System.out.println(dp[K] == INF? -1: dp[K]);
    }
    
    
    static void dp() {
    	for (int i = 1; i <= K; i++) {    		
    		int min = INF;
            
    		for (int coinCost: coins) {
    			if (i-coinCost < 0) continue;
    			min = Math.min(dp[i-coinCost], min);
    		}
    		
    		if (min != INF) {
    			min = min + 1;
    		}
            
    		dp[i] = min;
		}
    }
}
