package OfficialContests.BAPC2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class D {
	static ArrayList<Edge> adjList[];
	static final int inf=(int) 1e9;
	static int V;
	static int dist[];
	static int [] reachable;
	static int g,h;
	
	static void dijkstra(int source)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(source, 0));
		dist[source] = 0;
		while(!pq.isEmpty())
		{
			Edge curr = pq.poll();
			if(dist[curr.node] > curr.c)
				continue;
			
			for(Edge e:adjList[curr.node])
			{
				if(e.c + curr.c < dist[e.node])
				{
					dist[e.node] = e.c + curr.c;
					pq.add(new Edge(e.node, dist[e.node]));
				}
			}
			
		}
	}

	static void dfs(int node, int r)
	{
		if(r == 1)
			reachable[node] = r;
		for(Edge e:adjList[node])
		{
			if(dist[node] + e.c == dist[e.node])
			{
				if(reachable[e.node] == -1)
				{
					if((node == g && e.node == h) || (node == h && e.node == g))
						dfs(e.node, 1);
					else
						dfs(e.node, r);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while(t-->0)
		{
			V = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int source = in.nextInt()-1;
			g = in.nextInt()-1;
			h = in.nextInt()-1;
			
			adjList = new ArrayList[V];
			for(int i=0;i<V;i++)
				adjList[i] = new ArrayList<>();
			while(m-->0)
			{
				int u = in.nextInt()-1;
				int v = in.nextInt()-1;
				int cost = in.nextInt();
				adjList[u].add(new Edge(v, cost));
				adjList[v].add(new Edge(u,cost));
			}
			TreeSet<Integer> ts = new TreeSet<>();
			while(k-->0)
				ts.add(in.nextInt());
			
			dist = new int [V];
			Arrays.fill(dist, inf);
			dijkstra(source);
			reachable = new int [V];
			Arrays.fill(reachable, -1);
			StringBuilder sb = new StringBuilder();
			boolean beg = true;
			dfs(source,0);
			while(!ts.isEmpty())
			{
				int node = ts.pollFirst();
				if(reachable[node-1] == 1)
				{
					if(beg)
						sb.append(node);
					else
						sb.append(" " + node);
					
					beg = false;
				}
			}
			out.println(sb);	
		}
		out.flush();
		out.close();
	}
	
	static class Edge implements Comparable<Edge>{
		int node,c;
		Edge(int a,int b){
			node=a;c=b;
		}
		public int compareTo(Edge o) {
			if(c!=o.c)
				return c-o.c;
			return node-o.node;
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
