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
public class ProblemE {
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
            String a[] = new String[n];
            int i,j;
            for(i=0;i<n;i++) {
                a[i] = in.next();
            }
            int flag = 1;
            // start validating from second last row from the end.
            for(i=n-2;i>=0;i--) {
                for(j=n-2;j>=0;j--) {
                    if(a[i].charAt(j) == '1') {
                        // out.println("x->" + i + " y->" + j);
                        if(a[i].charAt(j+1) == '1' || a[i+1].charAt(j) == '1') {
                            // out.println("x->" + i + " y->" + j);
                            continue;
                        } else {
                            flag = 0;
                            break;
                        }
                    }
                }
                if(flag == 0) break;
            }

            if(flag == 0) {
                out.println("NO");
            } else {
                out.println("YES");
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