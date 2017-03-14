package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SimilarPair {
	static ArrayList<Integer> [] adjList;
	static int n,root;
	static SegmentTree st;
	static long res;
	static int t;
	
	public static void dfs(int node,int parent)
	{
		int b = node-t;	int e = node+t;
		if(b<0)	b=0;
		if(e>n)	e=n;
		res+=st.query(b, e);
		st.update_point(node, 1);
		for(int v:adjList[node])
			if(v!=parent)
				dfs(v,node);
		st.update_point(node, -1);
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		n=in.nextInt();
		t=in.nextInt();
		adjList = new ArrayList[n+1];
		for(int i=0;i<n+1;i++)
			adjList[i] = new ArrayList<>();

		boolean isroot[] = new boolean  [n+1];
		Arrays.fill(isroot, true);
		for(int i=0;i<n-1;i++)
		{
			int u1=in.nextInt();
			int u2= in.nextInt();
			isroot[u2] =false;
			adjList[u1].add(u2);
			adjList[u2].add(u1);

		}
		for(int i=1;i<n+1;i++)
			if(isroot[i])
				root=i;
		int N =1;
		while(N<n) N <<= 1;
		int []a = new int [N+1];
		st = new SegmentTree(a);
		st.update_point(root, 1);
		res=0;
		for(int u:adjList[root])
			dfs(u,root);
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
	
	static class SegmentTree {		// 1-based DS, OOP
		int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
		int[] array, sTree, lazy;
		
		SegmentTree(int[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new int[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
			lazy = new int[N<<1];
			build(1,1,N);
		}
		
		void build(int node, int b, int e)	// O(n)
		{
			if(b == e)					
				sTree[node] = array[b];
			else						
			{
				build(node<<1,b,(b+e)/2);
				build((node<<1)+1,(b+e)/2+1,e);
				sTree[node] = sTree[node<<1]+sTree[(node<<1)+1];
			}
		}
		
		
		void update_point(int index, int val)			// O(log n)
		{
			index += N - 1;				
			sTree[index] += val;			
			while(index>1)				
			{
				index >>= 1;
				sTree[index] = sTree[index<<1] + sTree[(index<<1) + 1];		
			}
		}
		
		void propagate(int node, int b, int e)		
		{
			int mid = (b+e)/2;
			lazy[node<<1] += lazy[node];
			lazy[(node<<1)+1] += lazy[node];
			sTree[node<<1] += (mid-b+1)*lazy[node];		
			sTree[(node<<1)+1] += (e-mid)*lazy[node];		
			lazy[node] = 0;
		}
		
		int query(int i, int j)
		{
			return query(1,1,N,i,j);
		}
		
		int query(int node, int b, int e, int i, int j)	// O(log n)
		{
			if(i>e || j <b)
				return 0;		
			if(b>= i && e <= j)
				return sTree[node];
			propagate(node, b, e);
			int q1 = query(node<<1,b,(b+e)/2,i,j);
			int q2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
			return q1 + q2;	
					
		}

}
}
