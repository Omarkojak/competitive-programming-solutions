package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva_280_Vertex {
	static boolean []vis;
	static ArrayList<Integer>[] adjList;
	
	public static void dfs(int u){
		for(int v:adjList[u])
			if(!vis[v]){
				vis[v]=true;
				dfs(v);
			}
	}
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		int n=in.nextInt();
		while(n!=0){
			adjList=new ArrayList[n+1];
			vis=new boolean[n+1];
			for(int i=0;i<n+1;i++)
				adjList[i]=new ArrayList<Integer>();
			int k=in.nextInt();
			while(k!=0){
				int w=in.nextInt();
				while(w!=0){
					adjList[k].add(w);
					w=in.nextInt();
				}
				k=in.nextInt();
			}
			int rep=in.nextInt();
			while(rep-->0){
				int u=in.nextInt();
				dfs(u);
				String r="";int tok=0;
				for(int i=1;i<n+1;i++)
					if(!vis[i]){
						r+=" "+i;
						tok++;
					}
				r=tok+r;
				sb.append(r+"\n");
				vis=new boolean[n+1];
			}	
			n=in.nextInt();
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
