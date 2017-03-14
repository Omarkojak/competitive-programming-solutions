package cp4_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva558_Wormholes {
	static final int INF = (int)1e9;	
	static ArrayList<Edge>[] adjList;
	static int V;
	
	static boolean bellmanFord(int S)		
	{
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean modified = true;
		for(int k = 0; modified && k < V - 1; ++k)
		{
			modified = false;
			for(int u = 0; u < V; ++u)		// these two loops run in O(E) in total
				for(Edge nxt: adjList[u])	
					if(dist[u] + nxt.cost < dist[nxt.node])
					{
						modified = true;
						dist[nxt.node] = dist[u] + nxt.cost;
					}
		}
		
		boolean negative_cycle_exists = false;
		for(int u = 0; u < V; ++u)
			for(Edge nxt: adjList[u])
				if(dist[u] + nxt.cost < dist[nxt.node])
					negative_cycle_exists = true;
		return negative_cycle_exists;
	}
	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		
		Edge(int a, int b)
		{
			node = a;
			cost = b;
		}
		
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return node - e.node;
		}
		
	}

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int t=in.nextInt();
		while(t-->0){
			int n=in.nextInt();V=n;
			int m=in.nextInt();
			adjList=new ArrayList[n];
			for(int i=0;i<V;i++)
				adjList[i]=new ArrayList<Edge>();
			for(int i=0;i<m;i++){
				int from=in.nextInt();int to=in.nextInt();int c=in.nextInt();
				adjList[from].add(new Edge(to,c));
			}
			sb.append(bellmanFord(0)?"possible":"not possible");
			sb.append("\n");
		}
		System.out.print(sb);
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
