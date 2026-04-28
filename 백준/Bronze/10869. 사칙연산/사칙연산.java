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
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(add(a,b)));
        bw.write('\n');
        bw.write(String.valueOf(minus(a,b)));
        bw.write('\n');
        bw.write(String.valueOf(multiple(a,b)));
        bw.write('\n');
        bw.write(String.valueOf(divide(a,b)));
        bw.write('\n');
        bw.write(String.valueOf(getRemainder(a,b)));

        bw.flush();
    }

    private int add(int a, int b) {
        return a+b;
    }

    private int minus(int a, int b){
        return a-b;
    }

    private int divide(int a, int b){
        return a/b;
    }
    private int multiple(int a, int b){
        return a*b;
    }

    private int getRemainder(int a, int b){
        return a%b;
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}