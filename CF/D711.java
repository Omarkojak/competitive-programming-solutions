package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class D711 {
	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[], SCC_size[];
	static boolean[] inSCC;
	static Stack<Integer> stack;
	static final long mod = ((long) 1e9) + 7;
		
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
				SCC_size[SCC]++;
				if(v == u)
					break;
			}
			SCC++;
		}
		
		
	}


	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		adjList = new ArrayList[V];
		for(int i=0;i<V;i++)
			adjList[i] = new ArrayList<>();
		
		for(int i=0;i<V;i++)
			adjList[i].add(in.nextInt() - 1);
		counter = 0;
		dfs_num = new int [V];
		dfs_low = new int [V];
		SCC_size = new int [V];
		inSCC = new boolean[V];
		stack = new Stack<>();
		tarjanSCC();
		int free = 0;
		for(int i=0;i<V;i++)
			if(SCC_size[i] == 1)
				free++;
		BigInteger ans = BigInteger.valueOf(2);
		ans = ans.pow(free);
		ans = ans.mod(BigInteger.valueOf(mod));
		
		
		for(int i=0;i<V;i++)
			if(SCC_size[i] > 1)
			{
				BigInteger exp = BigInteger.valueOf(2);
				exp = exp.pow(SCC_size[i]).subtract(BigInteger.valueOf(2));
				exp = exp.mod(BigInteger.valueOf(mod));
				ans = (ans.multiply(exp)).mod(BigInteger.valueOf(mod));
			}
		System.out.println(ans);
		
		
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
	}
}
