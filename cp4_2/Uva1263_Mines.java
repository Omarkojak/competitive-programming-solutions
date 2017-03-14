package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Uva1263_Mines {
	static int V;
	static ArrayList<Integer> []adjList;
	static final double EPS = 1e-12;
	static boolean vis[];
	static int counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static int SCC_num[];
	static Stack<Integer> stack;
	static ArrayList<Integer> adjList2[];
		
	
	static void tarjanSCC()	 	//O(V + E)
	{
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
				tarjanSCC(i);
	}
	
	static void tarjanSCC(int u)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);
		
		for(int v: adjList[u])
		{
			if(dfs_num[v] == 0)
				tarjanSCC(v);
			if(!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
		}
		if(dfs_num[u] == dfs_low[u])
		{
			while(true)
			{
				int v = stack.pop();
				inSCC[v] = true;
				SCC_num[v] = SCC;
				if(v == u)
					break;
			}
			SCC++;

		}	
	}	
	
	public static void bfs(int u)
	{
		vis[u] = true;
		for(int v:adjList2[u])
			if(!vis[v])
				bfs(v);
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while(t-->0)
		{
			V = in.nextInt();
			adjList = new ArrayList[V];
			for(int i=0;i<V;i++)
				adjList[i] = new ArrayList<>();
			Mine[] arr = new Mine[V];
			for(int i=0;i<V;i++)
				arr[i] = new Mine(in.nextInt(), in.nextInt(), in.nextInt());
			
			for(int i=0;i<V;i++)
			{
				for(int j=0;j<V;j++)
				{
					if(i == j)
						continue;
					int distx = Math.abs(arr[i].x - arr[j].x) * 2;
					int disty = Math.abs(arr[i].y - arr[j].y) * 2;
					
					if(distx <= arr[i].d && disty <= arr[i].d)
					{
						adjList[i].add(j);
					}
				}
			}
			dfs_num = new int [V];dfs_low = new int [V];inSCC = new boolean [V];SCC_num = new int [V];
			counter = 0;SCC = 0;stack = new Stack<>();
			tarjanSCC();
			adjList2 = new ArrayList[SCC];
			for(int i=0;i<SCC;i++)
				adjList2[i] = new ArrayList<Integer>();
			boolean [] head = new boolean [SCC];
			Arrays.fill(head, true);
			for(int i=0;i<V;i++)
				for(int u:adjList[i])
					if(SCC_num[i] != SCC_num[u])
					{
						adjList2[SCC_num[i]].add(SCC_num[u]);
						head[SCC_num[u]] = false;
					}
			vis = new boolean[SCC];
			int ans = 0;
			
			for(int i=0;i<SCC;i++)
			{
				if(!vis[i] && head[i])
				{
					bfs(i);
					ans++;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Mine
	{
		int x; int y; int d;
		Mine(int a, int b, int c)
		{
			x = a;
			y = b;
			d = c;
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
