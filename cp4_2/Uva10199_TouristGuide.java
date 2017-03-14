package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva10199_TouristGuide {
	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int n, counter, root, rootChildren,res;
	static boolean[] artPoints;
	
	static void findArtPointsAndBridges(){
		for(int i = 0; i < n; ++i)
			if(dfs_num[i] == 0){
				root = i;
				rootChildren = 0;
				dfs(i);
				if(rootChildren <= 1)
					artPoints[i] = false;
			}
	}
	
	static void dfs(int u){
		dfs_num[u] = dfs_low[u] = ++counter;
		for(int v: adjList[u])
			if(dfs_num[v] == 0){
				parent[v] = u;
				if(u == root)
					++rootChildren;
				dfs(v);
				if(dfs_low[v] >= dfs_num[u])
					artPoints[u] = true;
					
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			}
			else
				if(parent[u] != v)
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}
		
	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();int r=1;
		while(n!=0){
			TreeMap<String,Integer> mp=new TreeMap<String, Integer>();
			String []a=new String [n];
			int ind=0;
			while(ind<n){
				String s=in.nextLine();
				mp.put(s,ind);
				a[ind++]=s;
			}
			
			adjList=new ArrayList[n];
			for(int i=0;i<n;i++)
				adjList[i]=new ArrayList<Integer>();
			int m=in.nextInt();	
			while(m-->0){
				int u1=mp.get(in.next());
				int u2=mp.get(in.next());
				adjList[u1].add(u2);
				adjList[u2].add(u1);
				//System.out.println(u1+" "+u2);
			}
			counter=0;res=0;
			dfs_low=new int [n];dfs_num=new int [n];parent=new int [n];artPoints=new boolean [n];
			findArtPointsAndBridges();
			//System.out.println(Arrays.toString(artPoints));
			//System.out.println(res);
			ArrayList<String>as=new ArrayList<String>();
			for(int i=0;i<n;i++)
				if(artPoints[i])
					as.add(a[i]);
			Collections.sort(as);
			System.out.printf("City map #%d: %d camera(s) found\n",r++,as.size());
			for(int i=0;i<as.size();i++)
				System.out.println(as.get(i));
			n=in.nextInt();
			if(n!=0)
				System.out.println();
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
