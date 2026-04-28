import java.io.*;
import java.util.*;

public class Main{

    public void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 20;
        double creditSum = 0;
        double gradeSum = 0;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if(Objects.equals(grade,"P"))
                continue;
            creditSum += credit;
            gradeSum += credit*toNumeric(grade);
        }

        bw.write(String.valueOf(gradeSum/creditSum));
        bw.flush();
    }

    private double toNumeric(String grade){
        if (Objects.equals(grade, "A+")) return 4.5;
        else if (Objects.equals(grade, "A0")) return 4.0;
        else if (Objects.equals(grade, "B+")) return 3.5;
        else if (Objects.equals(grade, "B0")) return 3.0;
        else if (Objects.equals(grade, "C+")) return 2.5;
        else if (Objects.equals(grade, "C0")) return 2.0;
        else if (Objects.equals(grade, "D+")) return 1.5;
        else if (Objects.equals(grade, "D0")) return 1.0;
        else return 0.0;
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }
}