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
        int set_h;
        int set_m;
        if(m >= 45){
            set_h = h;
            set_m = m - 45;
        }
        else{
            if (h == 0) set_h = 23;
            else set_h = h - 1;
            set_m = m + 60 - 45;
        }
        bw.write(set_h+" "+set_m);
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}