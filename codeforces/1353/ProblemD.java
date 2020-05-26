import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Template by Arpan Mishra (arpan_)
 */
public class ProblemD {
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
            int ans[] = new int[n+1];
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    // if range length is equal return what comes first (left most)
                    if(a[1] == b[1]) {
                        return a[0] - b[0];
                    }
                    // return the bigger range
                    return b[1]-a[1];
                }
            });
            int base[] = new int[2];
            base[0] = 1;
            base[1] = n;

            pq.add(base);
            int action = 1;
            while(!pq.isEmpty()) {
                int current[] = pq.poll();
                int l = current[0];
                int r = current[0]+current[1]-1;
                int rangeSize = r-l+1;
                if(rangeSize%2 != 0) {
                    int key = (l+r)/2;
                    ans[key] = action;
                } else {
                    int key = (r+l-1)/2;
                    ans[key] = action;
                }
                action++;
            }
            for(int i=1;i<=n;i++) {
                out.print(ans[i]);
            }
            out.println();
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