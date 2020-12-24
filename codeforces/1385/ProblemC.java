import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Template by Arpan Mishra (arpan_)
 */
public class ProblemC {
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
            int a[] = new int[n];
            int i;
            int flag = 0;
            for(i=0;i<n;i++) {
                a[i] = in.nextInt();
            }

            if(n<=2) {
                out.println(0);
                return;
            }
            for(i=1;i<n;i++) {
                if(a[i]>=a[i-1]) {
                    // strictly increasing
                    flag = 1;
                } else {
                    flag = 0;
                    break;
                }
            }
            int index = -1;
            if(flag == 0) {
                for(i=n-1;i>0;i--) {
                    if(a[i]<=a[i-1]) {
                        // strictly decreasing
                        flag = 2;
                    } else {
                        flag = 0;
                        index = i;
                        break;
                    }
                }
                if(flag == 0) {
                    for(i=index;i>0;i--) {
                        if(a[i]>=a[i-1]) {
                            continue;
                        } else {
                            break;
                        }
                    }
                }
            }

            if(flag!=0) {
                // strictly increasing or decreasing
                out.println(0);
            } else {
                if(i==0) {
                    //single peak
                    out.println(0);
                } else {
                    out.println(i);
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