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
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();

            if(x==y && y==z) {
                out.println("YES");
                out.println(x + " " + y + " " + z);
            } else {
                if(x==y) {
                    if(z>x) {
                        out.println("NO");
                    } else {
                        out.println("YES");
                        out.println(x + " " + z + " " + z);
                    }
                } else if(y==z) {
                    if(x>y) {
                        out.println("NO");
                    } else {
                        out.println("YES");
                        out.println(y + " " + x + " " + x);
                    }
                } else if(x==z) {
                    if(y>z) {
                        out.println("NO");
                    } else {
                        out.println("YES");
                        out.println(x + " " + y + " " + y);
                    }
                } else {
                    out.println("NO");
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