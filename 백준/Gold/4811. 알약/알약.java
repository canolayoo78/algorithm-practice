import java.util.*;
import java.io.*;

public class Main {
	static long[] catalan;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
   
    	List<Integer> cases = new ArrayList<>();
    	
    	while(true) {
    		int n = Integer.parseInt(br.readLine());
    		if (n == 0) break;
    		cases.add(n);
    	}
    	
    	int maxCase = 0;
    	for (int c: cases) {
    		maxCase = Math.max(maxCase, c);
		}
    	
    	catalan = new long[maxCase + 1];
    	solution(maxCase);
    	
    	for (int c: cases) {
    		sb.append(catalan[c]).append('\n');
		}
    	
    	System.out.println(sb);
    }
    
    static void solution(int n) {
    	catalan[0] = 1;
    	
    	for(int k = 1; k <= n; k++) {
    		for(int i = 0; i < k; i++) {
    			catalan[k] += catalan[i] * catalan[k - 1 - i];
        	}
    	}
    }
}