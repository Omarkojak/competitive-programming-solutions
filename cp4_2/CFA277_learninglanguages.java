package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CFA277_learninglanguages {
	static ArrayList<Integer>[] adjList;
	static int n, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;

	static void tarjanSCC(){
			for(int i = 0; i < n; ++i)
				if(dfs_num[i] == 0)
					tarjanSCC(i);
		}
		
		static void tarjanSCC(int u){
			dfs_num[u] = dfs_low[u] = ++counter;
			stack.push(u);
			
			for(int v: adjList[u]){
				if(dfs_num[v] == 0)
					tarjanSCC(v);
				if(!inSCC[v])
					dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
			}
			if(dfs_num[u] == dfs_low[u]){
				while(true){
					int v = stack.pop();
					inSCC[v] = true;
					
					if(v == u)
						break;
				}
				
				SCC++;
			}
	}


	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		int m=in.nextInt();
		adjList=new ArrayList[100+m+1];
		for(int i=0;i<=100+m;i++)
			adjList[i]=new ArrayList<Integer>();
		int r=0;
		for(int i=0;i<n;i++){
			int tim=in.nextInt();
			while(tim-->0){
				int u=in.nextInt()+100;
				adjList[i].add(u);
				adjList[u].add(i);
				r++;
			}
		}
		SCC=0;counter=0;dfs_num=new int [100+m+1];dfs_low=new int [100+m+1];inSCC=new boolean [100+m+1];stack=new Stack<Integer>();
		tarjanSCC();
		System.out.println(r==0? n:SCC-1);
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
