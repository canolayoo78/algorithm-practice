import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        int l = 0, r = 0;
        int sum = 0;
        int ans = 0;

        while (true) {
            if (sum >= M){
                if (sum == M) {
                    ans ++;
                }
                sum -= a[l];
                l++;
            }
            else{
                if (r == N) break;
                sum += a[r];
                r++;
            }
        }

        System.out.println(ans);
    }
}