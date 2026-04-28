import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            for(byte val: st.nextToken().getBytes()){
                for(int j = 0; j < R ; j++){
                    sb.append((char)val);
                }
            }
            sb.append('\n');
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}