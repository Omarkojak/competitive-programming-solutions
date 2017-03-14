package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva976_BridgeBuilding {
	static int [] length;
	static char[][] grid;
	static int color[][];
	static int r, c;
	static int dist;
	static final int inf = (int) 1e9;
	static int dp[][];
	 
	static int solve(int bridges, int idx)
	{
		if(idx >= c || bridges == 0)
		{
			if(bridges == 0)
				return 0;
			else
				return inf;
		}
		
		if(dp[bridges][idx] != -1)
			return dp[bridges][idx];
		
		int take = length[idx] + solve(bridges-1, idx+dist+1);
		int leave = solve(bridges, idx+1);
		return dp[bridges][idx] = Math.min(take, leave);
	}
	
	static boolean valid(int x, int y)
	{
		return x>=0 && x<r && y>=0 && y<c && color[x][y] ==-1 && grid[x][y] == '#';
	}
	
	static void dfs(int i, int j, int c)
	{
		color[i][j] = c;
		if(valid(i+1, j))
			dfs(i+1, j, c);
		
		if(valid(i-1, j))
			dfs(i-1, j, c);
		
		if(valid(i, j+1))
			dfs(i, j+1, c);
		
		if(valid(i, j-1))
			dfs(i, j-1, c);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(in.ready())
		{
			r = in.nextInt();
			c = in.nextInt();
			int bridges = in.nextInt();
			dist = in.nextInt();
			grid = new  char[r][c];
			color = new int [r][c];
			length = new int [c];
			for(int i=0;i<r;i++)
				Arrays.fill(color[i], -1);
			
			for(int i=0;i<r;i++)
			{
				String s = in.nextLine();
				for(int j=0;j<c;j++)
					grid[i][j] = s.charAt(j);
			}
		//	System.out.println(Arrays.deepToString(grid));
			dfs(0,0,1);
			dfs(r-1,0,2);
			for(int i=0;i<c;i++)
			{
				int above = 0;
				int below = r-1;
				for(int j=0;j<r;j++)
				{
					if(color[j][i] == 1)
						above = Math.max(above, j);
					if(color[j][i] == 2)
						below = Math.min(below, j);
				}
				length[i] = below - above - 1;
			}
			//System.out.println(Arrays.toString(length));
			dp = new int [bridges + 1][c];
			for(int i=0;i<bridges+1;i++)
				Arrays.fill(dp[i], -1);
			sb.append(solve(bridges, 0)).append("\n");
		
		
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
