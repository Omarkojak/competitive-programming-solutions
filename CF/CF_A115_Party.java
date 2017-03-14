package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class CF_A115_Party {
	static boolean []vis;
	static int []dist;
	static ArrayList<Integer>[] adjList;
	
	public static int bfs(int u){
		Queue<Integer> q=new LinkedList<Integer>();
		vis[u]=true;
		dist[u]=1;int out=1;
		q.add(u);
		while(!q.isEmpty()){
			int now=q.poll();
			for(int v:adjList[now])
				if(!vis[v]){
					vis[v]=true;
					dist[v]=dist[now]+1;out=dist[v];
					q.add(v);
				}
		}
		return out;
	}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		adjList=new ArrayList[n];vis=new boolean[n];dist=new int [n];
		for(int i=0;i<n;i++)
			adjList[i]=new ArrayList<Integer>();
		
		ArrayList<Integer> exp=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			int r=sc.nextInt();
			if(r!=-1)
				adjList[r-1].add(i);
			else
				exp.add(i);
		}
		int res=0;
		for(int i:exp){
			res=Math.max(res, bfs(i));
		}
		
		System.out.println(res);
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
