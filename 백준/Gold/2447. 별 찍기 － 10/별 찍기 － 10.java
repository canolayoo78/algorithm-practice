import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static boolean isBlank(int r, int c) {
		while ((r > 0) || (c > 0)) {
			if ((r % 3 == 1) && (c % 3 == 1)) 
				return true;
			r /= 3;
			c /= 3;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n ; j++) {
				if (isBlank(i, j))
					sb.append(' ');
				else 
                    sb.append('*');
			}
			sb.append('\n');
		}
		System.out.print(sb.toString());
    }
}