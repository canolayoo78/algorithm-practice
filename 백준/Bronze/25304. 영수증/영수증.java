import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i < Y ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sum += a*b;
        }

        if(X == sum) bw.write("Yes");
        else bw.write("No");
        
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}