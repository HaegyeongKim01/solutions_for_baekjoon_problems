import java.util.*;
import java.io.*;
public class Main {
    public static void main(String [] args) {
        FastReader rd = new FastReader();

        int N = rd.nextInt();
        int[] grapes = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            grapes[i] = rd.nextInt();
        }

        dp[1] = grapes[1];
        if (N > 1) {
            dp[2] = grapes[1] + grapes[2];
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grapes[i], dp[i - 3] + grapes[i - 1] + grapes[i]));
        }
        System.out.println(dp[N]);



    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
