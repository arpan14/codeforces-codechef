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
            String s = in.next();
            int n = s.length();
            int zeroCount = 0;
            int oneCount = 0;
            int i;
            for(i=0;i<n;i++) {
                if(s.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            int ans = Math.min(zeroCount, oneCount);
            int prefZeros = 0;
            int prefOnes = 0;
            for(i=0;i<n;i++) {
                prefOnes += s.charAt(i) == '1' ? 1 : 0;
                prefZeros += s.charAt(i) == '0' ? 1 : 0;

                // for each index, we can either convert it into 1111....000 or 0000....111
                // converting to 1111....000 (type1)
                int type1 = prefZeros + oneCount - prefOnes;
                // converting to 0000....111 (type2)
                int type2 = prefOnes + zeroCount - prefZeros;
                ans = Math.min(ans, type1);
                ans = Math.min(ans, type2);
            }
            out.println(ans);
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