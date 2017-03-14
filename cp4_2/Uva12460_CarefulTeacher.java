package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva12460_CarefulTeacher {
	static ArrayList<Integer> adjList[];
	static int dist[];
	static int n;
	static final int inf = (int) 1e9;
	
	public static void bfs(int source)
	{
		dist = new int [n];
		Arrays.fill(dist, inf);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		dist[source] = 0;
		while(!q.isEmpty())
		{
			int curr = q.poll();
			for(int v:adjList[curr])
			{
				if(dist[v] > dist[curr] + 1)
				{
					dist[v] = dist[curr] + 1;
					q.add(v);
				}
			}
		}
	}
	
	public static boolean diffone(String s1, String s2)
	{
		if(s1.length()!= s2.length())
			return false;
		boolean found = false;
		int l = s1.length();
		for(int i=0;i<l;i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				if(found)
					return false;
				else
					found = true;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = 0;
		TreeMap<String, Integer> mp = new TreeMap<>();
		ArrayList<String> words = new ArrayList<>();
		while(true)
		{
			String s = in.nextLine();
			if(s.equals("--"))
				break;
			words.add(s);
			mp.put(s, n++);
		}
		
		adjList = new ArrayList[n];
		for(int i=0;i<n;i++)
			adjList[i] = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				String s1 = words.get(i);
				String s2 = words.get(j);
				if(diffone(s1, s2))
				{
					int u = mp.get(s1);
					int v = mp.get(s2);
					adjList[u].add(v);
					adjList[v].add(u);
				}
			}
		}
		
		
		String s = in.nextLine();
		while(s != null && s.length()!=0)
		{	
			StringTokenizer ns = new StringTokenizer(s);
			String s1 = ns.nextToken();
			String s2 = ns.nextToken();
			bfs(mp.get(s1));
			sb.append((dist[mp.get(s2)] != inf)? "Yes\n": "No\n");
			s = in.nextLine();
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
		
	}
}
