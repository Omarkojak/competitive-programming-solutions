package OfficialContest.Romania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class H {
	static final int max = ((int) 1e5) + 6;

	public static void main(String[] args) throws IOException {
	//	Scanner in = new Scanner(new FileInputStream("meciul.in"));
		Scanner in = new Scanner(System.in);
	//	PrintWriter out = new PrintWriter("meciul.out");
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			Unionfind uf = new Unionfind(n);
			while(m-->0)
			{
				if(uf.unionSet(in.nextInt(), in.nextInt()))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
			
		}
		out.print(sb);
		out.flush();
		out.close();
	}

	static class Unionfind
	{
		int []p, rank, size;
		Unionfind(int n)
		{
			p = new int [n+1];
			rank = new int [n+1];
			size = new int [n+1];
			for(int i=1;i<n;i++)
			{
				p[i] = i;
				size[i] = 1; 
			}
		}
		
		public int findset(int i)
		{
			if(p[i] == i)
				return i;
			else
				return p[i] = findset(p[i]);
		}
		
		public boolean unionSet(int i, int j)
		{
			int  i1 = findset(i);
			int j1 = findset(j);
			if(i1 == j1)
				return false;
			if(rank[i1] > rank[j1])
			{
				p[j1] = i1;
			}
			else
			{
				p[i1] = j1;
				if(rank[i1] == rank[j1])
					rank[j1]++;
			}
			return true;
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

}
