package OfficialContest.Romania;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new FileInputStream("algoritm.in"));
		PrintWriter out = new PrintWriter("algoritm.out");

		int t = in.nextInt();
		while(t-->0)
		{
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<Edge> [] adjList = new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i] = new ArrayList<>();
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=1;i<=m;i++)
				adjList[in.nextInt()-1].add(new Edge(in.nextInt()-1, in.nextInt(), i));
			
			boolean [] vis = new boolean [n];
			boolean [] visedge = new boolean [m+1];
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			pq.add(new Pair(0,0));
			boolean start = false;
			while(!pq.isEmpty())
			{
				//System.out.println(1);
				
				Pair curr = pq.poll();
				vis[curr.node] = true;
				for(Edge e:adjList[curr.node])
				{
					if(!vis[e.node] && !visedge[e.idx])
					{
						visedge[e.idx] = true;
						if(start)
							sb.append(" " + e.idx);
						else
							sb.append(e.idx);
						pq.add(new Pair(e.node, adjList[e.node].size()));
						start = true;	
					}
				}
			}
			for(int i=1;i<m;i++)
			{
				if(!visedge[i])
				{
					if(start)
						sb.append(" " + i);
					else
						sb.append(i);
				}
			}
			out.println(sb);
			
			
		}
	}
	
	static class Edge
	{
		int node; int cost; int idx;
		Edge(int a, int b, int c)
		{
			node = a;
			cost = b;
			idx = c;
		}
	}
	
	
	static class Pair implements Comparable<Pair>
	{
		int node; int edges;
		Pair(int a, int b)
		{
			node = a;
			edges = b;
		}
		@Override
		public int compareTo(Pair o) {
			if(edges != o.edges)
				return edges - o.edges;
			return node - o.node;
		}
		
		
		
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}
