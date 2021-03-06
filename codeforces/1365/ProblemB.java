import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
            int n = in.nextInt();
            int i,j;
            int a[] = new int[n];
            int b[] = new int[n];
            int sorted[] = new int[n];
            int zeroType = 0;
            int oneType = 0;

            for(i=0;i<n;i++) {
                a[i] = in.nextInt();
                sorted[i] = a[i];
            }

            for(i=0;i<n;i++) {
                b[i] = in.nextInt();
                if(b[i] == 0) {
                    zeroType++;
                } else {
                    oneType++;
                }
            }

            Arrays.sort(sorted);

            int count = 0;
            for(i=0;i<n;i++) {
                if(a[i] != sorted[i]) count++;
            }

            if(count==0) {
                out.println("Yes");
            } else {
                if(zeroType == n || oneType == n) {
                    // no swaps possible
                    out.println("No");
                } else {
                    out.println("Yes");
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