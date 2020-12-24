import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
            long k = in.nextLong();
            long a[] = new long[n];
            int i;

            long maxKey = -1;
            long maxCount = -1;

            Map<Long, Integer> hash = new HashMap<>();
            for(i=0;i<n;i++) {
                a[i] = in.nextLong();
                long hashkey = (a[i]%k) == 0 ? 0 : k-(a[i]%k);
                hash.put(hashkey, hash.getOrDefault(hashkey, 0) + 1);

                if(hashkey == 0) continue;

                if(hash.get(hashkey) > maxCount) {
                    maxKey = hashkey;
                    maxCount = hash.get(hashkey);
                } else if(hash.get(hashkey) == maxCount && hashkey> maxKey) {
                    maxKey = hashkey;
                }
            }
            if(maxCount == 1) {
                out.println(maxKey+1);
            } else if(maxCount==-1) {
                out.println(0);
            } else {
                long ans = (maxCount-1)*k;
                ans += maxKey+1;
                out.println(ans);
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