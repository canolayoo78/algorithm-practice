import java.util.*;
import java.io.*;

public class Main {
	static final int INF = 1_000_000_000;
	static int N, P, statusFullBit;
	static int dp[];
	static int w[][]; 
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	N = Integer.parseInt(br.readLine());
    	
    	statusFullBit = (1<<N); // 
    	w = new int[N][N];
    	dp = new int[statusFullBit];
    	
    	Arrays.fill(dp, -1);
    	
    	for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
    	
    	String onoff = br.readLine().trim();
    	int init = 0;
    	for(int i=0; i < N; i++) {
    		if (onoff.charAt(i) == 'Y') {
    			init |= (1 << i);
    		}
		}
    	P = Integer.parseInt(br.readLine());    	
    	int ans = 0;
    	if (P == 0) {
    		ans = 0;
    	}
    	else if (Integer.bitCount(init) >= P) {
    		ans = 0;
    	}
    	else if (init == 0) {
    		ans = -1;
    	}
    	else {
    		ans = dfs(init);
    	}
    	System.out.println(ans);
    }
    
    static int dfs(int state) {
    	if(Integer.bitCount(state) >= P) {
			return 0;
		}
    	
    	if (dp[state] != -1) {
    		return dp[state];
    	}
    	
    	int ret = INF;

        for (int i = 0; i < N; i++) {
            // i가 켜져 있는 발전소인지 확인
            if ((state & (1 << i)) == 0) continue;

            for (int j = 0; j < N; j++) {
                // j가 이미 켜져 있으면 넘기기
                if ((state & (1 << j)) != 0) continue;

                int next = state | (1 << j);
                ret = Math.min(ret, w[i][j] + dfs(next));
            }
        }

        dp[state] = ret;
        return ret;
    }
}