import java.util.*;
import java.io.*;

public class Main {
	static int K, N;
	static long lines[];
	static long maxLine = 0;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	K = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	
    	lines = new long[K];
    	for (int i = 0; i < K; i++) {
    		lines[i] = Integer.parseInt(br.readLine());
    		maxLine = Math.max(maxLine, lines[i]);
		}
    	
    	System.out.println(binarySearch());
    }
    
    static long binarySearch() {
    	long left = 1;
    	long right = maxLine + 1;
    	
    	while(left <= right) {
    		long mid = (left + right) / 2;
    		
    		long cutted = 0;
    		for (long l: lines) {
    			if (l >= mid) {
    				cutted += (l / mid);
    			}
    		}
    					
			if (cutted >= N) {
				left = mid + 1;				
			}
			
			else{
				right = mid - 1;
			}
    	}
    	
    	return right;
    }
}
