package OfficialContests.Tishreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class J {
	static int r,c;
	static int V;
	static int w;
	static ArrayList<Edge> [] adjList;
	static final int inf = (int) 1e9;
	static int [][]dist;
	
	public static void dijkstra(int source)
	{
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(source, 0, 0));
		dist[source][100] = 0;
		//System.out.println(1);
		while(!pq.isEmpty())
		{
			Edge curr = pq.poll();
			if(dist[curr.node][curr.time+100] < curr.cost)
				continue;
			for(Edge e:adjList[curr.node])
				if(e.time + curr.time <= 100 && e.time + curr.time >= -100)
				{
					int t = curr.time + e.time + 100;
					if(dist[e.node][t] > curr.cost + e.cost)
					{
						dist[e.node][t] = curr.cost + e.cost;
						pq.add(new Edge(e.node,curr.cost+e.cost, curr.time + e.time));
					}
				}
			
		}
	}
	
	public static int conv(int x, int y)
	{
		return x*c+y;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		int t = in.nextInt();
		
		while(t-->0)
		{
			r = in.nextInt();
			c = in.nextInt();
			V = r*c;
			adjList = new ArrayList[V];
			for(int i=0;i<V;i++)
				adjList[i] = new ArrayList<>();
			
			int source = conv(in.nextInt()-1, in.nextInt()-1);
			int m =in.nextInt();
			while(m-->0)
			{
				int u = conv(in.nextInt()-1, in.nextInt()-1);
				int v = conv(in.nextInt()-1, in.nextInt()-1);
				int cost = in.nextInt();
				int time = in.nextInt();
				adjList[u].add(new Edge(v, cost, time));
			}
			out.printf("Case %d:\n", cse++);
			dist = new int[V][202];
			for(int i=0;i<V;i++)
				Arrays.fill(dist[i], inf);
			
			
			dijkstra(source);
			int q = in.nextInt();
			while(q-->0)
			{
				int sink = conv(in.nextInt()-1, in.nextInt()-1);
				w = in.nextInt();
				int ans = dist[sink][w+100];
				if(ans != inf)
					out.println(ans);
				else
					out.println("No");
			}
	
			
			
		}
		out.flush();
		out.close();
		
	}
	
	
	static class Edge implements Comparable<Edge>{
		int node; int cost; int time;
		Edge(int a , int b, int c)
		{
			node = a;
			cost = b;
			time = c;
		}
		@Override
		public int compareTo(Edge o) {
			if(cost != o.cost)
				return cost - o.cost;
			if(time != o.time)
				return time - o.time;
			return node - o.node;
		}
		
		
	}
	
	static class Scanner
	{
		BufferedReader bf;
		StringTokenizer ns;
		Scanner(InputStream s)
		{
			bf = new BufferedReader(new InputStreamReader(s));
		}
		
		public String next() throws IOException
		{
			while(ns ==null || !ns.hasMoreTokens())
				ns = new StringTokenizer(bf.readLine());
			return ns.nextToken();
		}
		
		public int nextInt() throws NumberFormatException, IOException 
		{
			return Integer.parseInt(next());
		}
	}

}
