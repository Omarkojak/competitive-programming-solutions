package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Uva12144_AlmostShortestPath {
	static int V;
	static ArrayList<Edge> adjList[];
	static final int inf=(int) 1e9;
	static ArrayList<Integer>[] parent;
	static int []dist;
	static boolean [][]ref;
	static int so;
	
	static void dijkstra(int source, int sink)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(source, 0));
		dist = new int [V];
		Arrays.fill(dist, inf);
		parent = new ArrayList [V];
		
		dist[source] = 0;
		while(!pq.isEmpty())
		{
			Edge curr = pq.poll();
			if(curr.node == sink)
				return;
			
			if(dist[curr.node] > curr.c)
				continue;
			
			
			for(Edge e:adjList[curr.node])
			{
				if(e.c + curr.c < dist[e.node] && !ref[curr.node][e.node])
				{
					dist[e.node] = e.c + curr.c;
					parent[e.node] = new ArrayList<>();
					parent[e.node].add(curr.node);
					pq.add(new Edge(e.node, dist[e.node]));
				}
				else
				{
					if(e.c + curr.c == dist[e.node] && !ref[curr.node][e.node])
						parent[e.node].add(curr.node);
				}
			}
			
		}
	}
	
	static void dfs(int node)
	{
		if(node == so)
			return;
		if(parent[node] == null)
			return;
		for(int p:parent[node])
		{
			ref[p][node] = true;
			dfs(p);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int n = in.nextInt();
			int m = in.nextInt();
			if(n == 0 && m == 0)
				break;
			V = n;
			int source = in.nextInt();so = source;
			int sink = in.nextInt();
			adjList = new ArrayList[V];
			for(int i = 0;i<V;i++)
				adjList[i] = new ArrayList<>();
			while(m-->0)
			{
				int u = in.nextInt();
				int v = in.nextInt();
				int cost = in.nextInt();
				adjList[u].add(new Edge(v, cost));
			}
			
			ref = new boolean [V][V];
			dijkstra(source, sink);
			dfs(sink);
			dijkstra(source, sink);
			sb.append((dist[sink] == inf)? -1:dist[sink]).append("\n");
		}
		System.out.print(sb);
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
