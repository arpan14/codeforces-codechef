import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Template by Arpan Mishra (arpan_)
 */
public class ProblemF {
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
            while (t-- > 0) {
                execute(in, out);
            }
        }

        // Contains all core logic for each test case
        public void execute(final InputReader in, final PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int i;
            Map<Integer, Integer> indegree = new HashMap<>();
            Map<Integer, Set<Integer>> graph = new HashMap<>();

            for(i=0;i<n-1;i++) {
                int x, y;
                x = in.nextInt();
                y = in.nextInt();
                indegree.put(x, indegree.getOrDefault(x, 0) + 1);
                indegree.put(y, indegree.getOrDefault(y, 0) + 1);
                graph.putIfAbsent(x, new HashSet<>());
                graph.putIfAbsent(y, new HashSet<>());
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            Queue<Integer> q = new LinkedList<>();
            for(Map.Entry<Integer, Integer> entry:indegree.entrySet()) {
                if(entry.getValue() == 1) {
                    q.add(entry.getKey());
                }
            }
            int ans = 0;
            while(q.size()>=k) {
                for(i=0;i<k;i++) {
                    int current = q.poll();
                    for(int ele:graph.get(current)) {
                        indegree.put(ele, indegree.get(ele) - 1);
                        if(indegree.get(ele) == 1) {
                            out.println("Added to queue =>" + ele);
                            q.add(ele);
                        }
                    }
                }
                ans++;
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