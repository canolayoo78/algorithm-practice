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

        if(a == b & b == c & a == c){
            bw.write(String.valueOf(10000 + a * 1000));
        }
        else if( a == b || b == c || a == c ){
            if(a == b) bw.write(String.valueOf(1000 + a * 100));
            else if(b == c) bw.write(String.valueOf(1000 + b * 100));
            else if(a == c) bw.write(String.valueOf(1000 + c * 100));
        }
        else bw.write(String.valueOf(getMax(a,b,c) * 100));
        bw.flush();
    }

    private int getMax(int a, int b, int c){
        if (a > b){
            if (a > c) return a;
            else return c;
        }
        else{
            if (b > c) return b;
            else return c;
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}