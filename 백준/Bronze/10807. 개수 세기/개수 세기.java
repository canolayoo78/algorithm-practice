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
        int v = Integer.parseInt(br.readLine());
        int n = 0;

        for(int i = 0; i < N ; i++){
            int a = Integer.parseInt(st.nextToken());
            if (v == a) n++;
        }

        bw.write(String.valueOf(n));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}