import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2 * n - 1; i ++) {
			for (int j = 0; j < Math.abs(n - i - 1); j++) 
				sb.append(' ');
			for (int j = 0; j < 2 * (n - Math.abs(i - n + 1)) - 1; j++) 
				sb.append('*');
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

}