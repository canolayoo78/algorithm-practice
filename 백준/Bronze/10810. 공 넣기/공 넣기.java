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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int box[] = new int[N];
        int i,j,k;
        for(int a = 0; a < M ; a++){
            StringTokenizer Reader = new StringTokenizer(br.readLine());
            i = Integer.parseInt(Reader.nextToken());
            j = Integer.parseInt(Reader.nextToken());
            k = Integer.parseInt(Reader.nextToken());

            for(int b = i-1 ; b < j ; b++){
                box[b] = k;
            }
        }

        for(int c = 0; c < N; c++){
            bw.write(box[c]+" ");
        }

        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}