import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Template by Arpan Mishra (arpan_)
 */
public class ProblemA {
    public static void main(String[] args) {
        final InputStream inputStream = System.in;
        final OutputStream outputStream = System.out;
        final InputReader in = new InputReader(inputStream);
        final PrintWriter out = new PrintWriter(outputStream);
        final Solver solver = new Solver();

        solver.solve(in, out);

        out.close();
    }

    static class Solver {
        public void solve(final InputReader in, final PrintWriter out) {
            int t = in.nextInt();
            while(t-->0) {
                execute(in, out);
            }
        }

        // Contains all core logic for each test case
        public void execute(final InputReader in, final PrintWriter out) {
            long a = in.nextLong();
            long b = in.nextLong();
            if(a==b) {
                out.println(0);
            } else if(a>b) {
                int ans = getAnswer(a, b);
                out.println(ans);
            } else {
                int ans = getAnswer(b, a);
                out.println(ans);
            }
        }

        public int getAnswer(long a, long b) {
            int twoCount = 0;
            while(a%2 == 0) {
                twoCount++;
                a /= 2;
                if(a==b) break;
            }
            if(a!=b) {
                return -1;
            }
            int ans = 0;
            if(twoCount/3 > 0) {
                ans += twoCount/3;
                twoCount = twoCount%3;
            }
            if(twoCount/2 > 0) {
                ans += twoCount/2;
                twoCount = twoCount%2;
            }
            if(twoCount/1 > 0) {
                ans += twoCount/1;
            }
            return ans;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public Double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
    }
}