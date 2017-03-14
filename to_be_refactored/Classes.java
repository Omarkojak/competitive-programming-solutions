package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Classes {
	static int[] a;

	public static void shuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	public static int binarysearch(int x) {
		int low = 0;
		int high = a.length - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (a[mid] == x) {
				ans = mid;
				high = mid - 1;
			}
			if (a[mid] > x)
				high = mid - 1;
			if (a[mid] < x)
				low = mid + 1;
		}

		return ans;

	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		/*
		 * TreeMap<String, Integer> mp = new TreeMap<String, Integer>(); int k =
		 * 1;;
		 * 
		 * Queue<String> q = new LinkedList<String>(); for(char c = 'a'; c <=
		 * 'z'; c++) q.add(""+c); while(!q.isEmpty()){ String cur = q.remove();
		 * //mp.put(cur, k++);
		 * 
		 * if(cur.length() < 5) for(char c = (char)(cur.charAt(cur.length() - 1)
		 * + 1); c <= 'z' ; c++) q.add(cur+c); }
		 * //out.println(Integer.parseInt(bf.readLine())^1); long res=0;
		 * //out.println(res|(1<<100000)); //Arrays.sort(a); *
		 */
		// Queue<Node>qn =new LinkedList<Node>();
		/*
		 * for(int i=0;i<500*500;i++) qn.add(new Node(10000,10000,10000));
		 * out.close();
		 */

		for (int i = 9; i >= 0; i--) {
			for (int j = 9; j >= 0; j--) {
				String k = "b" + i + "" + j + "";
				String txt = i + "" + j;
				out.println("JButton " + k + "= new JButton(); " + k
						+ ".setText(" + '"' + txt + '"' + "); " + k
						+ ".addActionListener(this); worldview.addBtn(" + k
						+ "); btnsworld.add(" + k + ");");
			}
			out.println();
		}
		out.close();
	}

	static class Node {
		int bugs, idx, lines;

		Node(int a, int b, int c) {
			idx = a;
			bugs = b;
			lines = c;

		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean nxtEmpty() throws IOException {
			String line = br.readLine();
			if (line == null || line.isEmpty())
				return true;
			st = new StringTokenizer(line);
			return false;
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

	static class UnionFind {
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) {
			p = new int[numSets = N];
			rank = new int[N];
			setSize = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
		}

		public int findSet(int i) {
			return p[i] == i ? i : (p[i] = findSet(p[i]));
		}

		public boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
		}
	}

}
