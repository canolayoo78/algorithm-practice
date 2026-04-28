import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final int SIZE = 8, COUNT = 4;
	static int T;
	static Wheel[] wheels = new Wheel[COUNT];
	static int spinFlag[] = new int[COUNT];
	
	public static void main(String[] args) throws IOException{	
		for (int i = 0; i < COUNT; i++) {
			String s = br.readLine();
			boolean[] magnetic = new boolean[SIZE];
			for (int j = 0; j < SIZE; j++) {
				magnetic[j] = s.charAt(j) == '1'? true: false;
			}
			wheels[i] = new Wheel(magnetic);
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			Arrays.fill(spinFlag, 0);
			spinFlag[n - 1] = d;
			
			spinSpread(new int[]{1, -1}, n - 1, d);
			for (int j = 0; j < COUNT; j++) {
				if (spinFlag[j] != 0) spin(j);
			}
		}
		
		System.out.print(calcScore());
	}
	
	
	static int calcScore() {
		int tot = 0;
		for (int i = 0; i < COUNT; i++) {
			int top = wheels[i].top;
			if (wheels[i].magnetic[top]) tot += 1 << (i);
		}
		return tot;
	}
	
	static void spinSpread(int[] spread, int cur, int d){
		for(int s: spread) {
			int next = cur + s;
			if (0 > next || next >= COUNT) continue;
			
			int jointA, jointB;
			if (s == -1) {
				jointA = (wheels[cur].top + 6) % SIZE;
				jointB= (wheels[next].top+ 2) % SIZE;
			}
			else {
				jointA = (wheels[cur].top + 2) % SIZE;
				jointB = (wheels[next].top+ 6) % SIZE;
			}
			if(wheels[cur].magnetic[jointA] == wheels[next].magnetic[jointB]) continue;

			spinFlag[next] = -d;
			spinSpread(new int[] {s}, next, -d);
		}
	}
	
	static void spin(int n) {
		int d = spinFlag[n];
		wheels[n].top = (wheels[n].top - d + SIZE) % SIZE;
	}
}

class Wheel{
	int top;
	boolean [] magnetic;
	
	public Wheel(boolean [] magnetic) {
		this.top = 0;
		this.magnetic = magnetic;
	}
}
