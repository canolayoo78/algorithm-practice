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
        int c = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(fun1(a,b,c)));
        bw.write('\n');
        bw.write(String.valueOf(fun2(a,b,c)));
        bw.write('\n');
        bw.write(String.valueOf(fun3(a,b,c)));
        bw.write('\n');
        bw.write(String.valueOf(fun4(a,b,c)));

        bw.flush();
    }

    private int fun1(int A, int B, int C) {
        return  (A+B)%C;
    }

    private int fun2(int A, int B, int C){
        return ((A%C)+(B%C))%C;
    }

    private int fun3(int A, int B, int C){
        return (A*B)%C;
    }
    private int fun4(int A, int B, int C){
        return ((A%C)*(B%C))%C;
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}