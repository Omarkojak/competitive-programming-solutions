package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PPATH_PrimePath {
	static boolean isPrime [];
	static ArrayList<Integer> primes;
	static ArrayList<Integer> []adjList;
	static int dist[];	
	static final int inf = (int) 1e9;
	
	public static void sieve (int max){
		isPrime = new boolean [max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		primes = new ArrayList<>();
		for(int i = 2;i <= max;i++){
			if(isPrime[i]){
	    		if(1l * i * i <= max)
	    			for(int j = i * i;j < max + 1 ;j += i)
	    			{
	    				isPrime[(int)j] = false;
	    			}
					primes.add(i);
			}
		}
	}

	public static boolean diffonedig(int x, int y)
	{
		boolean f = false;
		while(x>0 && y>0)
		{
			int d1 = x%10;
			int d2 = y%10;
			if(d1 != d2)
			{
				if(f)
					return false;
				else
					f = true;
			}
			x/=10;
			y/=10;
		}
		return x == 0 && y == 0;
	}

	
	public static void bfs(int source)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		dist = new int [10001];
		Arrays.fill(dist, inf);
		dist[source] = 0;
		q.add(source);
		while(!q.isEmpty())
		{
			int curr = q.poll();
			for(int v:adjList[curr])
				if(dist[v] > dist[curr] + 1)
				{
					dist[v] = dist[curr] + 1;
					q.add(v);
				}
				
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sieve(10000);
		adjList = new ArrayList[10001];
		for(int i=0;i<10001;i++)
			adjList[i] = new ArrayList<>();
		int size = primes.size();
		for(int i=0;i<size;i++)
			for(int j=i+1;j<size;j++)
			{		
				int x = primes.get(i);
				int y = primes.get(j);
				if(x<1000 || y<1000)
					continue;
				if(diffonedig(x, y))
				{
					adjList[x].add(y);
					adjList[y].add(x);
				}
			}
		int t = in.nextInt();
		while(t-->0)
		{
			int source = in.nextInt();
			int dest = in.nextInt();
			bfs(source);
			sb.append(dist[dest]).append("\n");
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
