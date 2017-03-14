package OfficialContests.BAPC2013;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G {

	static final int oo = 1 << 30;
	static final double EPS = 1e-9;

	static class Circle {
		double x, y, r;

		Circle(int a, int b, int c) {
			x = a;
			y = b;
			r = c;
		}

		double dist(double x1, double y1, double x2, double y2) {
			return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		}

		double dist(Circle c) {
			return dist(x, y, c.x, c.y) - (r + c.r);
		}

		public String toString() {
			return x + " " + y + " " + r;
		}
	}

	static class DisjointSets {
		int[] rep, rank, setSize;

		DisjointSets(int n) {
			rep = new int[n];
			rank = new int[n];
			setSize = new int[n];
			for (int i = 0; i < n; i++) {
				rep[i] = i;
				setSize[i] = 1;
			}
		}

		boolean isSameSet(int x, int y) {
			return findSet(x) == findSet(y);
		}

		int findSet(int x) {
			if (rep[x] == x)
				return x;
			return rep[x] = findSet(rep[x]);
		}

		void Union(int x, int y) {
			int x1 = findSet(x), y1 = findSet(y);
			if (x1 == y1)
				return;
			if (rank[x1] > rank[y1]) {
				setSize[x1] += setSize[y1];
				rep[y1] = x1;
			} else {
				setSize[y1] += setSize[x1];
				rep[x1] = y1;
				if (rank[y1] == rank[x1])
					rank[y1]++;
			}
		}
	}

	static boolean check(Circle[] c, double width, double mid) {
		int n = c.length;
		DisjointSets ds = new DisjointSets(n + 2);
		mid *= 2;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (c[i].dist(c[j]) <= mid) {
					ds.Union(i, j);
				}
			}
			if (c[i].dist(c[i].x, c[i].y, 0, c[i].y) - c[i].r <= mid)
				ds.Union(i, n);
			if (c[i].dist(c[i].x, c[i].y, width, c[i].y) - c[i].r <= mid)
				ds.Union(i, n + 1);
			if(ds.isSameSet(n, n + 1))
				return false;
		}
		return !ds.isSameSet(n, n + 1);
	}

	static double BinarySearch(Circle[] c, double width) {
		double low = 0.0, high = width / 2;
		int cnt = 0;
		while (Math.abs(high - low) > EPS) {
			double mid = (low + high) / 2.0;
			if (check(c, width, mid)) {
				low = mid;
			} else
				high = mid;
		}
		return low;
	}

 	public static void main(String[] args) throws IOException {
		MyScanner sc = new MyScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			int width = sc.nextInt();
			int n = sc.nextInt();
			Circle[] c = new Circle[n];
			for (int i = 0; i < n; i++)
				c[i] = new Circle(sc.nextInt(), sc.nextInt(), sc.nextInt());
			out.printf("%.6f\n", BinarySearch(c, width));
		}
		out.close();
	}

	static class MyScanner {

		BufferedReader br;
		StringTokenizer st;

		public MyScanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}