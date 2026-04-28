import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean LEDs [];
	static int L;
	
	public static void main(String[] args) throws IOException{
		L = Integer.parseInt(br.readLine().trim());
		LEDs = new boolean[L + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= L; i++) {
			LEDs[i] = st.nextToken().equals("1") ? true: false;
		}
		
		int S =  Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int ss = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			changeTarget(ss, target);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= L; i++) {
			if (LEDs[i]) {
				sb.append("1 ");
			}
			else {
				sb.append("0 ");
			}
			if (i % 20 == 0) {
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	static void changeTarget(int ss, int target) {
		if (ss == 1) {
			changeTargetMale(target);
		}
		else {
			changeTargetFemale(target);
		}
	}
	
	static void changeTargetMale(int target) {
		int start = target;
		while(start <= L) {
			changeLED(start);
			start += target;
		}
	}
	
	static void changeTargetFemale(int target) {
		int left = target;
		int right = target;
		
		while (0 < left && right <= L) {
			if (LEDs[left] == LEDs[right]) {
				left--;
				right++;
			}
			else {
				break;
			}
		}
		
		for (int i = left + 1; i < right; i++) {
			changeLED(i);
		}
	}
	
	static void changeLED(int target) {
		LEDs[target] = !LEDs[target];
	}
}
