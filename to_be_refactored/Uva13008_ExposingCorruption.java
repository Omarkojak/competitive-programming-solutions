package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;



public class Uva13008_ExposingCorruption {
	static int SCC_num[];
	static int SCC;
	static int cost[];
	static int budget;
	static Pair [] people;
	static int V;
	static int dp[][];
	
	static int solve(int idx, int budgsofar)
	{
		if(idx == V)
			return 0;
		
		if(people[idx] == null || people[idx].budg == 0)
			return solve(idx+1, budgsofar);
		
		int take = 0;
		if(budgsofar > people[idx].budg)
			take = people[idx].num + solve(idx+1, budgsofar - people[idx].budg);
		int leave = solve(idx+1, budgsofar);
		return Math.max(take, leave);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = in.nextLine();
		while(s!=null && s.length() !=0)
		{
			StringTokenizer ns = new StringTokenizer(s);
			int DPS = Integer.parseInt(ns.nextToken());
			int PPP = Integer.parseInt(ns.nextToken());
			int R = Integer.parseInt(ns.nextToken());
			budget = Integer.parseInt(ns.nextToken());
			V = 205;
			
			cost = new int [V];
			for(int i=1;i<=DPS;i++)
				cost[i] = in.nextInt();
			
			for(int i=1;i<=PPP;i++)
				cost[i+101] = in.nextInt();
			
			SCC_num = new int [V];
			SCC = 0;
			Arrays.fill(SCC_num, -1);
			while(R-->0)
			{
				int u = in.nextInt();
				int v = in.nextInt() + 101;
				if(SCC_num[u] == -1 && SCC_num[v] == -1)
				{
					SCC_num[u] = SCC_num[v] = SCC++;
				}
				else
				{
					if(SCC_num[u] == -1)
						SCC_num[u] = SCC_num[v];
					else
						SCC_num[v] = SCC_num[u];
				}
			}
			people = new Pair[V];
			TreeMap<Integer, Integer> mp = new TreeMap<>();
			for(int i=1;i<V;i++)
			{
				if(SCC_num[i] == -1)
				{
					if(i>=102 && cost[i] != 0)
						people[i] = new Pair(1,cost[i]);
				}
				else
				{
					if(!mp.containsKey(SCC_num[i]))
					{
						mp.put(SCC_num[i], i);
						people[i]= new Pair(0, 0);
					}
						int idx = mp.get(SCC_num[i]);
						people[idx].budg+=cost[i];
						if(i<=100)
							people[idx].num --;
						if(i>=102)
							people[idx].num++;
					
				}
			}
			sb.append(solve(0, budget)+DPS);
			
			people = new Pair[V];
			mp = new TreeMap<>();
			for(int i=1;i<V;i++)
			{
				if(SCC_num[i] == -1)
				{
					if(i<=100 && cost[i] != 0)
						people[i] = new Pair(1,cost[i]);
				}
				else
				{
					if(!mp.containsKey(SCC_num[i]))
					{
						mp.put(SCC_num[i], i);
						people[i]= new Pair(0, 0);
					}
						int idx = mp.get(SCC_num[i]);
						people[idx].budg+=cost[i];
						if(i<=100)
							people[idx].num++;
						if(i>=102)
							people[idx].num--;
					
				}
			}
			sb.append(" " + solve(0,budget) + PPP).append("\n");
			System.out.println(sb);
			
			s = in.nextLine();
		}
		//System.out.print(sb);
	}
	
	static class Pair{
		int budg;
		int num;
		Pair(int x, int y)
		{
			num = x;
			budg = y;
		}
	}
	
	
	static class Scanner
	{
		StringTokenizer ns;
		BufferedReader bf;
		
		Scanner(InputStream s)
		{
			bf = new BufferedReader(new InputStreamReader(s));
		}
		
		String next() throws IOException
		{
			while(ns == null || !ns.hasMoreTokens())
				ns = new StringTokenizer(bf.readLine());
			return ns.nextToken();
		}
		
		int nextInt() throws IOException, NumberFormatException
		{
			return Integer.parseInt(next());
		}
		
		long nextLong() throws IOException, NumberFormatException
		{
			return Long.parseLong(next());
		}
		
		public String nextLine() throws IOException
		{
			return bf.readLine();
		}
	}
}
