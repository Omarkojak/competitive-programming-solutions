package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Uva610_StreetDirections {
	static int n;
	static int[][] edges;
	static ArrayList<Integer>[] adjmatrix;
	static int counter;
	static int[] dfs_num;
	static int[] dfs_low;
	static int[] parent;
	static boolean []vis;
	
	public static void dfs(int u){
		vis[u]=true;
		dfs_num[u] = dfs_low[u] = counter++;
		for(int i = 0; i < adjmatrix[u].size(); i++){
			int v = adjmatrix[u].get(i);
			if(!vis[v]){
				parent[v] = u;
				edges[u][v] = 1;
				dfs(v);
				if(dfs_low[v]>dfs_num[u])
					edges[v][u] = 1;
				
				dfs_low[u] = Math.min(dfs_low[u],dfs_low[v]);
			}
			else
				if(v!=parent[u]){
					dfs_low[u] = Math.min(dfs_low[u],dfs_num[v]);
					edges[u][v] = 1;
					if(adjmatrix[v].contains(u))
						adjmatrix[v].remove(adjmatrix[v].indexOf(u));
				}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		Scanner in =new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n=in.nextInt();int m=in.nextInt();
		int k = 1;
		while(n!=0){
			sb.append(k+++"\n\n");
			edges = new int[n][n];
			adjmatrix = new ArrayList[n];
			for(int i = 0; i < n; i++)
				adjmatrix[i] = new ArrayList<Integer>();
			
			while(m-->0){
				int u1= in.nextInt()- 1;
				int u2 = in.nextInt()- 1;
				adjmatrix[u1].add(u2);
				adjmatrix[u2].add(u1);
			}
			
			for(int i = 0; i < n; i++)
				Collections.sort(adjmatrix[i]);
			
			dfs_num = new int[n];
			dfs_low = new int[n];
			parent = new int[n];
			vis=new boolean [n];
			dfs(0);
			for(int i = 0; i < edges.length; i++)
				for(int j = 0; j < edges.length; j++)
					if(edges[i][j]==1)
						sb.append((i+1)+" "+(j+1)+"\n");
			sb.append("#\n");
			n=in.nextInt();
			m=in.nextInt();
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

