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
            int m = in.nextInt();

            int i,j;
            int a[] = new int[n];
            int b[] = new int[m];
            int arr[][] = new int[n][m];
            for(i=0;i<n;i++) {
                for(j=0;j<m;j++) {
                    arr[i][j] = in.nextInt();
                    if(arr[i][j]==1) {
                        // claim the row and column for claimed cells.
                        a[i] = 1;
                        b[j] = 1;
                    }
                }
            }

            int count = 0;
            for(i=0;i<n;i++) {
                for(j=0;j<m;j++) {
                    if(arr[i][j] == 0) {
                        // unclaimed cells
                        if(a[i] == 0 && b[j] == 0) {
                            // row and column not yet claimed
                            // claim the row and column and claimed cells.
                            a[i] = 1;
                            b[j] = 1;
                            count++;
                        }
                    }
                }
            }

            if(count%2==0) {
                out.println("Vivek");
            } else {
                out.println("Ashish");
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