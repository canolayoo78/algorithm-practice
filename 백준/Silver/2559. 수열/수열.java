import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] t;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		t= new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		int subSum = 0;
		for (int i = 0; i < K; i++) {
			subSum += t[i];
		}
        
		int max = subSum;
		for (int i = 0; i < N - K; i++) {
			subSum -= t[i];
			subSum += t[i + K];
			if (max < subSum) max = subSum;
		}
		System.out.println(max);
	}
}
