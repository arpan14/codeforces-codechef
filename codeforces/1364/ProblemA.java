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
            int n = in.nextInt();
            int x = in.nextInt();
            int a[] = new int[n];
            int ans = -1;
            int i,j;
            int minIndex = n+1;
            int maxIndex = -1;
            for(i=0;i<n;i++) {
                a[i] = in.nextInt();
                if(a[i]%x !=0) {
                    if(i>maxIndex) {
                        maxIndex = i;
                    }
                    if(i<minIndex) {
                        minIndex = i;
                    }
                }
            }

            if(maxIndex==-1 || minIndex==n+1) {
                // all elements are divisible by x
                out.println(-1);
            } else {
                int totalElements = maxIndex-minIndex+1;
                totalElements = Math.max(totalElements+minIndex, totalElements+n-maxIndex-1);
                out.println(totalElements);
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