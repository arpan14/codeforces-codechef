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
public class ProblemB {
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
            long n = in.nextLong();
            if(n%2 == 0) {
                out.println(n/2 + " " + n/2);
            } else {
                int flag = 0;
                long a = 0;
                long b = 0;
                for(long i = 2; i<=Math.sqrt(n);i++) {
                    if(n%i==0) {
                        long rem = n/i;
                        a = rem;
                        b = n-rem;
                        flag = 1;
                    }
                }
                if(flag == 0) {
                    out.println(1 + " " + (n-1));
                } else {
                    out.println(a + " " + b);
                }
            }
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