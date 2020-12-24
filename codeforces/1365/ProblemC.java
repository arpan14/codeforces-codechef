import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
            execute(in, out);
        }

        // Contains all core logic for each test case
        public void execute(final InputReader in, final PrintWriter out) {
            int n = in.nextInt();
            int a[] = new int[n];
            int b[] = new int[n];
            int i;
            Map<Integer, Integer> hash = new HashMap<>();
            Map<Integer, Integer> count = new HashMap<>();
            for(i=0;i<n;i++) {
                a[i] = in.nextInt();
                hash.put(a[i], i+1);

            }

            int max = 0;
            for(i=0;i<n;i++) {
                b[i] = in.nextInt();
                int currentIndex = i+1;
                int previousIndex = hash.get(b[i]);
                if(previousIndex<currentIndex) {
                    previousIndex+=n;
                }
                count.put(currentIndex-previousIndex, count.getOrDefault(currentIndex-previousIndex, 0) + 1);
                if(count.get(currentIndex-previousIndex)>max) {
                    max = count.get(currentIndex-previousIndex);
                }
            }

            out.println(max);
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