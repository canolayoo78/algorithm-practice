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
        int year = Integer.parseInt(st.nextToken());
        if(year % 4 == 0 & year % 100 != 0) bw.write("1");
        else if(year % 400 == 0) bw.write("1");
        else bw.write("0");

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}