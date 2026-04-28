import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = 1000000;
        int max = -1000000;
        int a;

        for(int i = 0; i < N ; i++){
            a = Integer.parseInt(st.nextToken());
            if (a > max) max = a;
            if (a < min) min = a;
        }

        bw.write(min+" "+max);
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}