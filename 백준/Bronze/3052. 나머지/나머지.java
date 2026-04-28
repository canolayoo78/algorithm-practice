import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number[] = new int[10];
        int left[] = new int[42];
        int num = 0;
        int sum = 0;

        for(int i = 0; i < 10 ; i++) {
            num = Integer.parseInt(br.readLine());
            left[num % 42] = 1;
        }

        for(int i = 0; i < 42 ; i++){
            if(left[i] == 1) sum++;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}