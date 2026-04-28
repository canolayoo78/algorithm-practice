import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        int set_h;
        int set_m;
        if((m + time) / 60 >= 1){
            set_h = (h + (m + time) / 60 + 24) % 24;
            set_m = (m + time) % 60;
        }
        else{
            set_h = h;
            set_m = m + time;
        }
        bw.write(set_h+" "+set_m);
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}