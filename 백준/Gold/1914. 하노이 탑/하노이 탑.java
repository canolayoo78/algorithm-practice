import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		BigInteger t = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
		
		System.out.println(t);
		if (n <= 20) {
			hanoi(n, 1, 3);
			System.out.println(sb.toString());
		}
	}
	
	static void hanoi(int n, int start, int target) {
		if (n == 0) return;
		hanoi(n-1, start, 6 - (start + target));
		sb.append(start+" "+target+"\n");
		hanoi(n-1, 6 - (start + target), target);
	}
	
}
