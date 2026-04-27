import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main{

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0;
        boolean equal = false;
        char answer = 0;
        String input = br.readLine();
        input = input.toUpperCase();

        for(int i = 'A'; i <= (int)'Z'; i++){
            int num = countChar(input,(char)i);
            if(num > max){
                max = num;
                equal = false;
                answer = (char)i;
            }
            else if (num == max){
                equal = true;
            }
        }

        if (equal) bw.write("?");
        else bw.write(String.valueOf(answer));

        bw.flush();
    }
    public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}