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
        float score[] = new float[N];
        float max = 0, sum = 0;

        for(int i = 0; i < N ; i++){
            score[i] = Integer.parseInt(st.nextToken());
            if (score[i] > max) max = score[i];
        }

        for(int i = 0; i < N; i++){
            score[i] = score[i]/max*100;
            sum += score[i];
        }

        bw.write(String.valueOf(sum/N));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}